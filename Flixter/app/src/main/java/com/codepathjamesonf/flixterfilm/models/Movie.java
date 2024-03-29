package com.codepathjamesonf.flixterfilm.models;

import androidx.constraintlayout.widget.Placeholder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {
    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double ratingBar;
    String popularity;
    String release_date;

    //Empty constructor that parcel requires
    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        ratingBar = jsonObject.getDouble("vote_average");
        popularity = jsonObject.getString("popularity");
        release_date = jsonObject.getString("release_date");
        movieId = jsonObject.getInt("id");
    }


    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i <movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;

    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRatingBar() {
        return ratingBar;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getMovieId() {
        return movieId;
    }
}



