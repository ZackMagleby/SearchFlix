package com.example.maglebyz.searchflix.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.maglebyz.searchflix.R;
import com.example.maglebyz.searchflix.SearchResult.SearchResults;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText searchWord;
    String currentSearch;
    String api_key = "87ed38f4be1ea577e1f8903bc35d958150373d7d";
    SearchResults currentResults;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchWord = (EditText) findViewById(R.id.searchName);
        searchWord.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            /* When focus is lost check that the text field
            * has valid values.
            */
            //hasFocus = false;
                if (!hasFocus) {
                    currentSearch = searchWord.getText().toString();
                    new Thread() {
                        @Override
                        public void run() {
                            searchQuery(currentSearch);
                            if(currentResults.getResults().size()>0){
                                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                                i.putExtra("passObject", currentResults);
                                startActivity(i);
                            }
                            else{
                                //ERROR
                            }
                        }
                    }.start();
                }
            }
        });

        searchWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Clear focus here from edittext
                    searchWord.clearFocus();
                }
                return false;
            }
        });
    }

    protected void searchQuery(String search) {
        String startURL = "http://api-public.guidebox.com/v2/search";
        String apikeyURL = "?api_key=" + api_key;
        String searchType = "&type=movie";
        String searchField = "&field=title";
        String searchNoSpace = search.replace(" ", "%20");
        String searchQuery = "&query=" + searchNoSpace;
        String wholeURL = startURL + apikeyURL + searchType + searchField + searchQuery;
        String results = "";
        try {
            results = getHTML(wholeURL);
        } catch (Exception e) {
            e.printStackTrace();
            results = "error";
        }
        if (results != "error") {
            currentResults = gson.fromJson(results, SearchResults.class);
        }
    }

    public static String getHTML(String urlToRead) throws Exception {
        //FetchItemsTask().execute();
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
