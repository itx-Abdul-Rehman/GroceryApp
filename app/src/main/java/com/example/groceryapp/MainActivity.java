package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView recyclerView;

    List<Items> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        Items item1=new Items(R.drawable.beverage,"Beverage",
                "This is a Beverage");
        Items item2=new Items(R.drawable.fruit,"Fruit",
                "This is a Fruit");
        Items item3=new Items(R.drawable.milk,"Milk",
                "This is a Milk");
        Items item4=new Items(R.drawable.popcorn,"Popcorn",
                "This is a Popcorn");
        Items item5=new Items(R.drawable.vegitables,"Vegetable",
                "This is a Vegetable");
        Items item6=new Items(R.drawable.bread,"Bread",
                "This is a Bread");

        itemsList=new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        itemsList.add(item6);

        MyAdapter myAdapter=new MyAdapter(itemsList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.onItemClickListener(this);

    }


    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(MainActivity.this,"Clicked "+itemsList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();
    }
}