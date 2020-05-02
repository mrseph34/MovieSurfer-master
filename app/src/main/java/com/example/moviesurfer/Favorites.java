package com.example.moviesurfer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.sql.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Favorites extends AppCompatActivity {
    SharedPref sharedPref;
    ImageView post;
    ListView listView;
    String favorites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list_item);
        sharedPref = new SharedPref(this);
        post = findViewById(R.id.fav_movie_poster);
        listView = findViewById(R.id.lv);

        favorites = sharedPref.mySharedPref.getString("favorites", "");

        if (favorites != ""){

            Pattern pattern = Pattern.compile(",");
            String[] favArray = pattern.split(favorites);
            FavoritesAdapter adapter = new FavoritesAdapter(Favorites.this, favArray);
            listView.setAdapter(adapter);

    } else {

            String defaultUrl = "https://via.placeholder.com/300x400.png?text=No+Poster+Found";

        }


        //SharedPref FavoritesAdapter = new SharedPref(this);

        /*
        String defaultUrl =  "https://via.placeholder.com/300x400.png?text=No+Poster+Found";
        //listView.add
        String favorites = sharedPref.mySharedPref.getString("favorites", "");
        if (favorites != null) {
            Log.d("mode", "onCreate: " + favorites);
            Picasso.get().load(favorites).into(post);
        } else {Picasso.get().load(defaultUrl).into(post); Log.d("mode", "onCreate: " + favorites);}
*/

        /*
        ListView artistListview = findViewById(R.id.artist_listview);
        CategoryAdapter artistAdapter = new CategoryAdapter(this, artists);
        artistListview.setAdapter(artistAdapter);
        */

    }

    public class FavoritesAdapter extends ArrayAdapter<String> {

        public FavoritesAdapter(Context context, String[] favoritesArray) {
            super(context, 0, favoritesArray);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.favorite_list_item, parent, false);
            String currentMoviePosterUrl = getItem(position);
            ImageView moviePosterImageView = convertView.findViewById(R.id.fav_movie_poster);
            Picasso.get().load(currentMoviePosterUrl).into(moviePosterImageView);
            return convertView;
        }
    }


}
