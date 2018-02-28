package com.aliesaassadi.youtube.MainActivity.models.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Ali Esa Assadi
 */

public class Playlists extends ExpandableGroup<Video> {

    public Playlists(String title, List<Video> items) {
        super(title, items);
    }
}
