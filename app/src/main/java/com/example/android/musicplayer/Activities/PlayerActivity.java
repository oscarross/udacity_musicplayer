package com.example.android.musicplayer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicplayer.Data.Song;
import com.example.android.musicplayer.R;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    public static final String CURRENT_SONG_POSITION= "com.example.android.musicplayer.current_song_position";
    public static final String SONGS= "com.example.android.musicplayer.songs";

    private ArrayList<Song> songs = new ArrayList<>();
    private int position = -1;
    private boolean isPlaying = false;

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
            setupButtons();
        }
    }

    private void setupButtons() {
        ImageButton backButton = findViewById(R.id.player_back_button);
        backButton.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Song song = previousSong();
                setupWithSong(song);
            }
        });

        ImageButton nextButton = findViewById(R.id.player_next_button);
        nextButton.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Song song = nextSong();
                setupWithSong(song);
            }
        });

        ImageButton playButton = findViewById(R.id.player_play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                if (isPlaying) {
                    stopPlaying();
                } else {
                    startPlaying();
                }
            }
        });
    }

    private void setupWithSong(Song song) {
        ImageView imageView = findViewById(R.id.player_image);
        imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("drawable/" + song.getImageName(), "drawable", getPackageName())));

        TextView title = findViewById(R.id.player_song_title);
        title.setText(song.getName());

        TextView detail = findViewById(R.id.player_song_detail);
        detail.setText(song.getArtistName());
    }

    private void startPlaying() {
        isPlaying = true;
        ImageButton playButton = findViewById(R.id.player_play_button);
        playButton.setBackgroundResource(R.drawable.ic_pause);
        showToast(getString(R.string.start_message));
    }

    private void stopPlaying() {
        isPlaying = false;
        ImageButton playButton = findViewById(R.id.player_play_button);
        playButton.setBackgroundResource(R.drawable.ic_play);
        showToast(getString(R.string.stop_message));
    }

    private Song nextSong() {
        if (position < 0) {
            return null;
        }

        position++;

        if (position >= songs.size()) {
            position = position % songs.size();
        }

        return songs.get(position);
    }

    private Song previousSong() {
        if (position < 0) {
            return null;
        }

        position--;

        if (position < 0) {
            position = songs.size() - 1;
        }

        return songs.get(position);
    }

    private void showToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
