package com.example.android.musicplayer.Data;

import java.io.Serializable;
import java.util.ArrayList;

public final class Playlist implements Serializable {
    private String name;
    private ArrayList<Song> songs;

    Playlist(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
