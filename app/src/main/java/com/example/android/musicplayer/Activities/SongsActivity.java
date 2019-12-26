package com.example.android.musicplayer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.Adapters.SongAdapter;
import com.example.android.musicplayer.Data.Song;
import com.example.android.musicplayer.R;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    public static final String SONGS= "com.example.android.musicplayer.songs";
    public static final String PLAYLIST= "com.example.android.musicplayer.playlist";

    private ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Intent intent = getIntent();
        songs = (ArrayList<Song>) intent.getSerializableExtra(SongsActivity.SONGS);
        String title = intent.getStringExtra(SongsActivity.PLAYLIST);
        setTitle(title);

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.songs_list);
        listView.setAdapter(adapter);
    }
}
