package com.example.android.musicplayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.musicplayer.Data.Playlist;
import com.example.android.musicplayer.R;

import java.util.ArrayList;
import java.util.List;

public final class PlaylistAdapter extends ArrayAdapter<Playlist> {
    private List<Playlist> playlists = new ArrayList<>();

    public PlaylistAdapter(@NonNull Context context, ArrayList<Playlist> list) {
        super(context, 0 , list);

        playlists = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.playlist_item_list, parent,false);

        Playlist current = playlists.get(position);

        TextView title= (TextView)listItem.findViewById(R.id.playlist_item_list_title);
        title.setText(current.getName());

        TextView detail = (TextView) listItem.findViewById(R.id.playlist_item_list_detail);
        detail.setText(current.getName());

        return listItem;
    }
}
