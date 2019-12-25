package com.example.android.musicplayer.Data;

import android.content.Context;

import com.example.android.musicplayer.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseStore {
    private ArrayList<Playlist> playlists = null;

    public DatabaseStore(Context context) {
        loadData(context);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    private void loadData(Context context) {
        ArrayList<Playlist> items = new ArrayList<>();

        try {
            JSONObject databaseJSON = new JSONObject(loadJSONFile(context));
            JSONArray databaseJSONArray= databaseJSON.getJSONArray("playlist_array");

            for(int index=0; index<databaseJSONArray.length(); index++) {
                JSONObject itemJSON = databaseJSONArray.getJSONObject(index);

                String name = itemJSON.get("name").toString();

                Playlist playlist = new Playlist(name);

                items.add(playlist);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            playlists = null;
            return;
        }

        playlists = items;
    }

    private String loadJSONFile(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.database);

            int size = inputStream.available();

            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
