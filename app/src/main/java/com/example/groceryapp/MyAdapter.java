package com.example.groceryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Items> itemsList;

    public MyAdapter(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent,false);

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Items items=itemsList.get(position);

        holder.imageView.setImageResource(items.getItemImage());
        holder.itemName.setText(items.getItemName());
        holder.itemDescription.setText(items.getItemDescription());

    }

    @Override
    public int getItemCount() {
        return itemsList.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView itemName,itemDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            itemName=itemView.findViewById(R.id.itemName);
            itemDescription=itemView.findViewById(R.id.description);

        }
    }
}
