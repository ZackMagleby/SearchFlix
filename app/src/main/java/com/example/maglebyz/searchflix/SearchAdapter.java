package com.example.maglebyz.searchflix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maglebyz.searchflix.SearchResult.Result;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<Result> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, poster;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            poster = (TextView) view.findViewById(R.id.poster);
        }
    }


    public SearchAdapter(List<Result> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.poster.setText(movie.getPoster120x171());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}