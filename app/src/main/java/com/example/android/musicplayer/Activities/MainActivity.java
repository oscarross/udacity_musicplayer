package com.example.android.musicplayer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.android.musicplayer.Adapters.PlaylistAdapter;
import com.example.android.musicplayer.Data.DatabaseStore;
import com.example.android.musicplayer.R;

public class MainActivity extends AppCompatActivity {

    private DatabaseStore databaseStore = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseStore = new DatabaseStore(getApplicationContext());
        PlaylistAdapter adapter = new PlaylistAdapter(this, databaseStore.getPlaylists());
        ListView listView = (ListView) findViewById(R.id.playlist_list);
        listView.setAdapter(adapter);
    }
}
