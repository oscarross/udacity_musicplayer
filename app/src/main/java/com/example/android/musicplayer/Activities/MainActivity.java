package com.example.android.musicplayer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.Adapters.PlaylistAdapter;
import com.example.android.musicplayer.Data.DatabaseStore;
import com.example.android.musicplayer.Data.Playlist;
import com.example.android.musicplayer.Data.Song;
import com.example.android.musicplayer.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseStore databaseStore = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.playlist_activity_title);

        databaseStore = new DatabaseStore(getApplicationContext());
        PlaylistAdapter adapter = new PlaylistAdapter(this, databaseStore.getPlaylists());
        ListView listView = findViewById(R.id.playlist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Playlist playlist = databaseStore.getPlaylists().get(position);
                ArrayList<Song> songs = playlist.getSongs();

                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);

                songsIntent.putExtra(SongsActivity.SONGS, songs);
                songsIntent.putExtra(SongsActivity.PLAYLIST, playlist.getName());

                startActivity(songsIntent );
            }
        });
    }
}
