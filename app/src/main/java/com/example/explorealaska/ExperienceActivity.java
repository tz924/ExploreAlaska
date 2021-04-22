package com.example.explorealaska;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_experience);

    // set up views
    setImageView("HEADER", R.id.header_image);
    setTextView("INTRO_TITLE", R.id.intro_title);
    setTextView("INTRO_TEXT", R.id.intro_text);
    setTextView("EXPERIENCE_TITLE", R.id.experience_title);
    setTextView("EXPERIENCE_TEXT_1", R.id.experience_text_1);
    setTextView("EXPERIENCE_TEXT_2", R.id.experience_text_2);
    setImageView("EXPERIENCE_IMAGE", R.id.experience_image);

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