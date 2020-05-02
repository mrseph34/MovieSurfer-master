package com.example.moviesurfer;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

public class SharedPref {
    SharedPreferences mySharedPref;
    SharedPreferences.Editor editor;
    String favorites;

    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
        editor = mySharedPref.edit();
    }

    public void addFav (String url) {
        favorites = mySharedPref.getString("favorites", "");

        if(favorites.length() > 0) {
            editor.putString("favorites", favorites + "," + url);
        } else {
            editor.putString("favorites", url);
        }

        editor.apply();

        Log.d("mode", "addFav: "+url+"ADDED");
    }

}
