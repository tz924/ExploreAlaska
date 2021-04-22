package com.example.explorealaska;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WildlifeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wildlife);

    // set up views
    setImageView("HEADER", R.id.header_image);
    setTextView("INTRO_TITLE", R.id.intro_title);
    setTextView("INTRO_TEXT", R.id.intro_text);
    setTextView("WHERE_TITLE", R.id.where_title);
    setImageView("WHERE_IMAGE_1", R.id.where_image_1);
    setTextView("WHERE_TEXT_1", R.id.where_text_1);
    setImageView("WHERE_IMAGE_2", R.id.where_image_2);
    setTextView("WHERE_TEXT_2", R.id.where_text_2);
    setImageView("WHERE_IMAGE_3", R.id.where_image_3);
    setTextView("WHERE_TEXT_3", R.id.where_text_3);
    setTextView("TIPS_TITLE", R.id.experience_title);
    setTextView("TIPS_TEXT_1", R.id.experience_text_1);
    setTextView("TIPS_TEXT_2", R.id.tips_text_2);
    setTextView("TIPS_TEXT_3", R.id.tips_text_3);

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