package com.example.maglebyz.searchflix.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.maglebyz.searchflix.FinalResult.Movie;
import com.example.maglebyz.searchflix.FinalResult.NewMovie;
import com.example.maglebyz.searchflix.R;
import com.example.maglebyz.searchflix.SearchRecycler.ClickListener;
import com.example.maglebyz.searchflix.SearchRecycler.DividerItemDecoration;
import com.example.maglebyz.searchflix.SearchRecycler.RecyclerTouchListener;
import com.example.maglebyz.searchflix.SearchRecycler.SearchAdapter;
import com.example.maglebyz.searchflix.SearchResult.Result;
import com.example.maglebyz.searchflix.SearchResult.SearchResults;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.maglebyz.searchflix.Activities.MainActivity.getHTML;

public class SearchActivity extends AppCompatActivity {

    String api_key = "87ed38f4be1ea577e1f8903bc35d958150373d7d";
    Gson gson = new Gson();
    Movie currentMovie;
    private SearchAdapter mAdapter;
    private RecyclerView recyclerView;
    SearchResults currentResults;
    List<Result> results = new ArrayList<>();
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Intent i = getIntent();
        currentResults = (SearchResults) i.getSerializableExtra("passObject");

        mAdapter = new SearchAdapter(results);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemViewCacheSize(currentResults.getResults().size());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Result movie = results.get(position);
                buttonClicked(position);
                //Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
        mAdapter.notifyDataSetChanged();
    }

    private void prepareMovieData() {
        for(int i = 0; i<currentResults.getResults().size();i++){
            results.add(i, currentResults.getResults().get(i));
        }
    }

    private void buttonClicked(int posistion){
        selectedIndex = posistion;
        new Thread() {
            @Override
            public void run() {
                if(selectedIndex >= 0){
                    searchMovie(currentResults.getResults().get(selectedIndex).getId());
                    if(currentMovie != null){
                        Intent i2 = new Intent(SearchActivity.this, FinalActivity.class);
                        i2.putExtra("passObject2", currentMovie);
                        startActivity(i2);
                    }
                }
            }
        }.start();
    }

    protected void searchMovie(int idNum){
        String startURL = "http://api-public.guidebox.com/v2/movies";
        String idURL = "/" + Integer.toString(idNum);
        String apikeyURL = "?api_key=" + api_key;
        String wholeURL = startURL + idURL + apikeyURL;
        String results = "";
        try{
            results = getHTML(wholeURL);
        }
        catch(Exception e){
            e.printStackTrace();
            results = "error";
        }
        if(results != "error") {
            try {
                currentMovie = gson.fromJson(results, Movie.class);
            }
            catch (Exception e){
                currentMovie = null;
                runOnUiThread(new Runnable() {
                    public void run()
                    {
                        Toast.makeText(SearchActivity.this, "Movie too new.  Not enough info on database.  Try checking your local theaters?", Toast.LENGTH_SHORT).show();
                    }
                });
                this.finish();
            }
        }
        else{
            runOnUiThread(new Runnable() {
                public void run()
                {
                    Toast.makeText(SearchActivity.this, "There was an error. Try again.", Toast.LENGTH_SHORT).show();
                }
            });
            this.finish();
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
