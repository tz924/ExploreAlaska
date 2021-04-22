package com.example.explorealaska;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set the content of the activity to use the activity_main.xml layout file
    setContentView(R.layout.activity_main);

    // Find the view pager that will allow the user to swipe between fragments
    ViewPager viewPager = findViewById(R.id.viewpager);

    // Create an adapter that knows which fragment should be shown on each page
    CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

    viewPager.setAdapter(adapter);
    viewPager.setCurrentItem(0);

    TabLayout tabLayout = findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
  }
}