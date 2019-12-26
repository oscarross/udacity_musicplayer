package com.example.android.musicplayer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.musicplayer.R;

public class PlayerActivity extends AppCompatActivity {

    public static final String SONG= "com.example.android.musicplayer.currentsong";
    public static final String SONGS= "com.example.android.musicplayer.songs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        if (getSupportActionBar() == null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
