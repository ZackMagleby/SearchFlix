package com.example.maglebyz.searchflix.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maglebyz.searchflix.FinalRecycler.SubAdapter;
import com.example.maglebyz.searchflix.FinalResult.Movie;
import com.example.maglebyz.searchflix.FinalResult.PurchaseAndroidSource;
import com.example.maglebyz.searchflix.FinalResult.PurchaseWebSource;
import com.example.maglebyz.searchflix.FinalResult.SubscriptionWebSource;
import com.example.maglebyz.searchflix.R;
import com.example.maglebyz.searchflix.SearchRecycler.ClickListener;
import com.example.maglebyz.searchflix.SearchRecycler.DividerItemDecoration;
import com.example.maglebyz.searchflix.SearchRecycler.RecyclerTouchListener;
import com.example.maglebyz.searchflix.SearchRecycler.SearchAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FinalActivity extends AppCompatActivity {

    private SubAdapter nAdapter;
    private RecyclerView recyclerView2;
    List<String> services = new ArrayList<>();
    List<String> prices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        Movie currentMovie = (Movie) i.getSerializableExtra("passObject2");

        setMovieTitle(currentMovie);
        setMoviePoster(currentMovie);
        setMovieYear(currentMovie);
        setMovieRating(currentMovie);
        setMovieLength(currentMovie);

        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view_final);

        nAdapter = new SubAdapter(services, prices);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                //Result movie = results.get(position);
//                buttonClicked(position);
//                //Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
        recyclerView2.setAdapter(nAdapter);
        setSubscriptions(currentMovie);
        setPayment(currentMovie);
        recyclerView2.setItemViewCacheSize(services.size());
        nAdapter.notifyDataSetChanged();
    }

    private void setPayment(Movie currentMovie) {
        List<PurchaseWebSource> buySources = currentMovie.getPurchaseWebSources();
        services.add("Rent/Purchase: ");
        if(buySources.size() == 0){
            prices.add("None");
        }
        else{
            prices.add(" ");
        }
        for(int i = 0; i<buySources.size(); i++){
            services.add(buySources.get(i).getDisplayName());
            String totalPrices = "";
            for(int j = 0; j<buySources.get(i).getFormats().size(); j++){
                totalPrices += buySources.get(i).getFormats().get(j).getType().substring(0,1).toUpperCase() + buySources.get(i).getFormats().get(j).getType().substring(1) + "("+ buySources.get(i).getFormats().get(j).getFormat() +"): " + buySources.get(i).getFormats().get(j).getPrice() + "\n";
            }
            prices.add(totalPrices);
        }
    }


    private void setSubscriptions(Movie currentMovie) {
        List<SubscriptionWebSource> subSources = currentMovie.getSubscriptionWebSources();
        services.add("Subscriptions: ");
        if(subSources.size() == 0){
            prices.add("None");
        }
        else{
            prices.add(" ");
        }
        for(int i = 0; i<subSources.size(); i++){
            services.add(subSources.get(i).getDisplayName());
            prices.add("Subscription to: " + subSources.get(i).getDisplayName());
        }
    }

    private void setMovieTitle(Movie currentMovie){
        String movieTitle = "Unknown";
        if(currentMovie.getTitle() != null){
            movieTitle = currentMovie.getTitle();
        }
        TextView title = (TextView)findViewById(R.id.movieTitle);
        title.setText(movieTitle);
    }

    private void setMoviePoster(Movie currentMovie){
        String moviePosterURL = "Unknown";
        if(currentMovie.getRating() != null) {
            moviePosterURL = currentMovie.getPoster120x171();
            ImageView poster = (ImageView) findViewById(R.id.poster);
            new DownloadImageTask(poster).execute(moviePosterURL);
        }
    }

    private void setMovieRating(Movie currentMovie){
        String movieRating = "Unknown";
        if(currentMovie.getRating() != null){
            movieRating = currentMovie.getRating();
        }
        TextView rating = (TextView)findViewById(R.id.rating);
        rating.setText("Rated: "+movieRating);
    }

    private void setMovieYear(Movie currentMovie){
        int movieYear = -1;
        if(currentMovie.getDuration() != null){
            movieYear = currentMovie.getReleaseYear();
        }
        String yearString = Integer.toString(movieYear);
        if(movieYear == -1){
            yearString = "Unknown";
        }
        TextView year = (TextView)findViewById(R.id.year);
        year.setText("Released: "+Integer.toString(movieYear));
    }

    private void setMovieLength(Movie currentMovie){
        int movieLength = -1;
        if(currentMovie.getDuration() != null){
            movieLength = currentMovie.getDuration();
            movieLength /= 60;
        }
        String lengthString = Integer.toString(movieLength);
        if(movieLength == -1){
            lengthString = "Unknown";
        }
        TextView length = (TextView)findViewById(R.id.length);
        length.setText("Length: "+movieLength+" mins");
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
