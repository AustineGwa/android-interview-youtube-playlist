package com.aliesaassadi.youtube.MainActivity.view;

import com.aliesaassadi.youtube.MainActivity.models.model.Playlists;

import java.util.List;

/**
 * Created by Ali Esa Assadi
 */
public interface MainActivityView {
    //on get data done update the adapter
    void onGetDataDoneUpdateView(List<Playlists> body);
}
