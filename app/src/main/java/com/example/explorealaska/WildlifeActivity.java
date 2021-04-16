package com.example.explorealaska;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WildlifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife);

        int imageResourceId = getIntent().getExtras().getInt("IMAGE");

    }
}