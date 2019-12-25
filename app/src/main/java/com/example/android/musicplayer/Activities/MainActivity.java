package com.example.android.musicplayer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android.musicplayer.Data.DatabaseStore;
import com.example.android.musicplayer.R;

public class MainActivity extends AppCompatActivity {

    private DatabaseStore databaseStore = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseStore = new DatabaseStore(getApplicationContext());
        Log.d("LOG",databaseStore.getPlaylists().toString());
    }
}
