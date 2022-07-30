package com.codepathjamesonf.flixterfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepathjamesonf.flixterfilm.models.Movie;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;
    TextView popularity;
    TextView release_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        ratingBar = findViewById(R.id.ratingBar);
        popularity = findViewById(R.id.popularity);
        release_date = findViewById(R.id.release_date);

        // ActivityTwo.java (subactivity) can access any extras passed in
            Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            ratingBar.setRating((float) movie.getRatingBar());
            popularity.setText("Popularity: " + movie.getPopularity());
            release_date.setText("Release date: " + movie.getRelease_date());



        }
     }


