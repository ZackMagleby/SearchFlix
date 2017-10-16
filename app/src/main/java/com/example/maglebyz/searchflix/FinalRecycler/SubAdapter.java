package com.example.maglebyz.searchflix.FinalRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maglebyz.searchflix.R;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.MyViewHolder> {

    private List<String> serviceList;
    private List<String> priceList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
        }
    }


    public SubAdapter(List<String> serviceList, List<String> priceList) {
        this.serviceList = serviceList;
        this.priceList = priceList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(serviceList.get(position));
        holder.price.setText(priceList.get(position));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }
}