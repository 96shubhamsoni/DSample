package com.example.dsample.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dsample.R;

import java.util.List;

public class GroceryAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public List<Grocery> mList;
    Context mContext;


    public GroceryAdapter(Context context, List<Grocery> list){
        mContext = context;
        mList = list;
    }



    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView item_imageView;
        TextView item_title;
        TextView item_quantity;
        TextView item_price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            item_imageView = itemView.findViewById(R.id.item_image);
            item_title = itemView.findViewById(R.id.item_title);
            item_quantity = itemView.findViewById(R.id.item_quantity);
            item_price = itemView.findViewById(R.id.item_price);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Grocery var = mList.get(position);
        String url = var.imageUrl;
            Glide
                .with(mContext)
                .load(url)
                .centerCrop()
                .into(((ItemViewHolder)holder).item_imageView);

        ((ItemViewHolder)holder).item_title.setText(var.title);
        ((ItemViewHolder)holder).item_price.setText(var.original_price);
        ((ItemViewHolder)holder).item_quantity.setText(var.quantity);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
