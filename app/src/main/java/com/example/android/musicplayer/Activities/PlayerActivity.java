package com.example.android.musicplayer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.Data.Song;
import com.example.android.musicplayer.R;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    public static final String CURRENT_SONG_POSITION= "com.example.android.musicplayer.current_song_position";
    public static final String SONGS= "com.example.android.musicplayer.songs";

    private ArrayList<Song> songs = new ArrayList<>();
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player);

        if (getSupportActionBar() == null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        songs = (ArrayList<Song>) intent.getSerializableExtra(PlayerActivity.SONGS);
        position = intent.getIntExtra(PlayerActivity.CURRENT_SONG_POSITION, -1);

        if (position >= 0) {
            Song currentSong = songs.get(position);
            setupWithSong(currentSong);
        }
    }

    private void setupWithSong(Song song) {
        ImageView imageView = findViewById(R.id.player_image);
        imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("drawable/" + song.getImageName(), "drawable", getPackageName())));

        TextView title = findViewById(R.id.player_song_title);
        title.setText(song.getName());

        TextView detail = findViewById(R.id.player_song_detail);
        detail.setText(song.getArtistName());
    }
}
