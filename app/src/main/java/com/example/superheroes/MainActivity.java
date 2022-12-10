package com.example.superheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<SuperHeroModel> superHeroesList = new ArrayList<>();

    int[] superHeroImages = {
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.ironman,
            R.drawable.batman,
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.ironman,
            R.drawable.batman,
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.ironman,
            R.drawable.batman
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        setUpSuperHeroModels();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, superHeroesList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpSuperHeroModels() {
        String[] superHeroNames = getResources().getStringArray(R.array.super_hero_names);
        String[] superHeroDetails = getResources().getStringArray(R.array.super_hero_details);

        for (int i = 0; i < superHeroNames.length; i++) {
            superHeroesList.add(
                    new SuperHeroModel(superHeroNames[i], superHeroDetails[i], superHeroImages[i])
            );
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, HeroActivity.class);

        intent.putExtra("name", superHeroesList.get(position).getName());
        intent.putExtra("details", superHeroesList.get(position).getDetails());
        intent.putExtra("image", superHeroesList.get(position).getImage());

        startActivity(intent);
    }
}