package com.example.android.musicplayer.Data;

import java.io.Serializable;

public final class Song implements Serializable {
    private String name;
    private String imageName;

    Song(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }
}
