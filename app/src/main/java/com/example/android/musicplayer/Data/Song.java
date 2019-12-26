package com.example.android.musicplayer.Data;

import java.io.Serializable;

public final class Song implements Serializable {
    private String name;

    Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
