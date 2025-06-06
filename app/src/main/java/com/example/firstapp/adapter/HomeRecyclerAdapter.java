package com.example.firstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.core.OnItemClickListener;
import com.example.firstapp.viewmodel.HomeGridList;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final List<HomeGridList> gridList;
    private OnItemClickListener listener;

    public HomeRecyclerAdapter(Context context, List<HomeGridList> gridList) {
        this.context = context;
        this.gridList = gridList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = (OnItemClickListener) onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription;
        ImageView imgGrid;
        LinearLayout card;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgGrid = itemView.findViewById(R.id.imgGrid);
            card = itemView.findViewById(R.id.card);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemView,getAdapterPosition(), String.valueOf(txtDescription));
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerAdapter.ViewHolder holder, int position) {
        HomeGridList item = gridList.get(position);
        holder.txtDescription.setText(item.getDescription());
        holder.imgGrid.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
