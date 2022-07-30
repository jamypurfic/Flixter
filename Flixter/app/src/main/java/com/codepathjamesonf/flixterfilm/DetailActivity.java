package com.codepathjamesonf.flixterfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepathjamesonf.flixterfilm.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class DetailActivity extends YouTubeBaseActivity {

    private static final String YOUTUBE_API_KEY = "AIzaSyB0Mz5RECfIfH0Dhpw8zyRzV396_AAHQ9U";

    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;
    TextView popularity;
    TextView release_date;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        ratingBar = findViewById(R.id.ratingBar);
        popularity = findViewById(R.id.popularity);
        release_date = findViewById(R.id.release_date);
        youTubePlayerView = findViewById(R.id.player);

        // ActivityTwo.java (subactivity) can access any extras passed in
            Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            ratingBar.setRating((float) movie.getRatingBar());
            popularity.setText("Popularity: " + movie.getPopularity());
            release_date.setText("Release date: " + movie.getRelease_date());

            youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    Log.d("DetailActivity", "onSuccess");
                //anything we want to do with the video goes here
                    youTubePlayer.cueVideo("5xVh-7ywKpE");

                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.d("DetailActivity", "onFailure");

                }
            });

        }
     }


