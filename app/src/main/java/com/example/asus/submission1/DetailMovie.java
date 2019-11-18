package com.example.asus.submission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_PERSON);

        TextView title = findViewById(R.id.detail_title);
        title.setText(movie.getMovie());

        TextView desc = findViewById(R.id.detail_desc);
        desc.setText(movie.getDesc());

        ImageView img = findViewById(R.id.detail_photo);
        Glide.with(this).load(movie.getPhoto()).into(img);
    }
}
