package com.example.explorealaska;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ParkActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_park);

    // set up views
    setImageView("HEADER", R.id.header_image);
    setTextView("INTRO_TITLE", R.id.intro_title);
    setTextView("INTRO_TEXT", R.id.intro_text);
    setImageView("DIRECTION_MAP", R.id.direction_map);
    setTextView("DIRECTION_LOCATION_TITLE", R.id.direction_location_title);
    setTextView("DIRECTION_LOCATION_TEXT", R.id.direction_location_text);
    setTextView("DIRECTION_ADDRESS_TITLE", R.id.direction_address_title);
    setTextView("DIRECTION_ADDRESS_TEXT", R.id.direction_address_text);

    ImageButton backButton = findViewById(R.id.back_button);
    backButton.setOnClickListener(view -> onBackPressed());
  }

  // helper functions
  private void setImageView(String key, int id) {
    int imageResourceId = getIntent().getExtras().getInt(key);
    ImageView imageView = findViewById(id);
    imageView.setImageResource(imageResourceId);
  }

  private void setTextView(String key, int id) {
    String text = getIntent().getExtras().getString(key);
    TextView textView = findViewById(id);
    textView.setText(text);
  }

}