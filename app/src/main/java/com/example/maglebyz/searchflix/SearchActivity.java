package com.example.maglebyz.searchflix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.maglebyz.searchflix.FinalResult.Movie;
import com.example.maglebyz.searchflix.SearchResult.Result;
import com.example.maglebyz.searchflix.SearchResult.SearchResults;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.example.maglebyz.searchflix.MainActivity.getHTML;

public class SearchActivity extends AppCompatActivity {

    String api_key = "87ed38f4be1ea577e1f8903bc35d958150373d7d";
    Gson gson = new Gson();
    Movie currentMovie;
    private SearchAdapter mAdapter;
    private RecyclerView recyclerView;
    SearchResults currentResults;
    List<Result> results = new ArrayList<>();

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
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        for(int i = 0; i<currentResults.getResults().size();i++){
            results.add(i, currentResults.getResults().get(i));
        }
    }

    private void buttonClicked(){
        //STILL SELECTS FIRST ONE, CHANGE TO SELECTED MOVIE
        searchMovie(currentResults.getResults().get(0).getId());
        Intent i2 = new Intent(SearchActivity.this, FinalActivity.class);
        i2.putExtra("passObject2", currentMovie);
        startActivity(i2);
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
        if(results != "error"){
            currentMovie = gson.fromJson(results, Movie.class);
        }
    }
}
