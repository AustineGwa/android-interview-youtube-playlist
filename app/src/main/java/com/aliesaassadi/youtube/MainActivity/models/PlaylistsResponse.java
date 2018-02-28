package com.aliesaassadi.youtube.MainActivity.models;

import com.aliesaassadi.youtube.MainActivity.models.model.Playlists;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali Esa Assadi
 */

public class PlaylistsResponse {

    @SerializedName("Playlists") private List<Playlists> Playlists;

    public List<Playlists> getPlaylists() {
        return Playlists;
    }

}
