package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.models.HomeGridList;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<HomeGridList> gridList;
    private ViewGroup parent;
    private LayoutInflater inflater;

    public HomeRecyclerAdapter(Context context, List<HomeGridList> gridList) {
        this.context = context;
        this.gridList = gridList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription;
        ImageView imgGrid;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgGrid = itemView.findViewById(R.id.imgGrid);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_grid, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.ViewHolder holder, int position) {
        HomeGridList item = gridList.get(position);
        holder.txtDescription.setText(item.getDescription());
        holder.imgGrid.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }
}
