package com.example.maglebyz.searchflix;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maglebyz.searchflix.FinalResult.Movie;

import java.io.InputStream;

public class FinalActivity extends AppCompatActivity {

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
        //setSubscriptions(currentMovie);
    }

//    private void setSubscriptions(Movie currentMovie) {
//        List<SubscriptionWebSource> subs = currentMovie.getSubscriptionWebSources();
//        //RecyclerView sources = (RecyclerView)findViewById(R.id.sources);
//        List<String> sourceTitles = new ArrayList<>();
//        for(int i = 0; i<subs.size(); i++){
//            sourceTitles.add(i, subs.get(i).getDisplayName());
//        }
//
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//        //sources.setLayoutManager(mLayoutManager);
//
//        RecyclerView.Adapter a = new RecyclerView.Adapter<>() {
//            @Override
//            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                return null;
//            }
//
//            @Override
//            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//            }
//
//            @Override
//            public int getItemCount() {
//                return 0;
//            }
//        };
//        //sources.setAdapter(adapt);
//    }

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
