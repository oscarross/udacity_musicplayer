package com.example.android.musicplayer.Data;

import java.io.Serializable;

public final class Song implements Serializable {
    private String name;
    private String imageName;
    private String artistName;

    Song(String name, String imageName, String artistName) {
        this.name = name;
        this.imageName = imageName;
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }

    public String getArtistName() {
        return artistName;
    }
}
