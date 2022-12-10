package com.example.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        String name = getIntent().getStringExtra("name");
        String details = getIntent().getStringExtra("details");
        int image = getIntent().getIntExtra("image", 0);

        TextView textViewName = findViewById(R.id.HeroLayoutName);
        TextView textViewDetails = findViewById(R.id.HeroLayoutDetails);
        ImageView imageView = findViewById(R.id.HeroLayoutImage);

        textViewName.setText(name);
        textViewDetails.setText(details);
        imageView.setImageResource(image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}