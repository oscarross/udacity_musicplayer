package com.example.android.musicplayer.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.musicplayer.Data.Song;
import com.example.android.musicplayer.R;

import java.util.ArrayList;
import java.util.List;

public final class SongAdapter extends ArrayAdapter<Song> {
    private List<Song> songs;

    public SongAdapter(@NonNull Context context, ArrayList<Song> list) {
        super(context, 0 , list);

        songs = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.song_item_list, parent,false);

        Song current = songs.get(position);

        changeTitle(listItem, current);
        changeDetail(listItem, current);
        changeImage(listItem, current);

        return listItem;
    }

    private void changeImage(View listItem, Song current) {
        Resources resources = getContext().getResources();
        String packageName = getContext().getPackageName();

        ImageView imageView = listItem.findViewById(R.id.song_item_image);
        imageView.setImageDrawable(resources.getDrawable(resources.getIdentifier("drawable/" + current.getImageName(), "drawable", packageName)));
    }

    private void changeDetail(View listItem, Song current) {
        TextView detail = listItem.findViewById(R.id.song_item_list_detail);
        detail.setText(current.getArtistName());
    }

    private void changeTitle(View listItem, Song current) {
        TextView title = listItem.findViewById(R.id.song_item_list_title);
        title.setText(current.getName());
    }
}
