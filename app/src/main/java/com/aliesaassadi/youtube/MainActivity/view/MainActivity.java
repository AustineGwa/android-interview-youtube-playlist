package com.aliesaassadi.youtube.MainActivity.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.aliesaassadi.youtube.MainActivity.models.model.Playlists;
import com.aliesaassadi.youtube.MainActivity.presenter.MainActivityPresenter;
import com.aliesaassadi.youtube.YoutubeActivity.YoutubePlayerActivity;
import com.aliesaassadi.youtube.R;
import com.aliesaassadi.youtube.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali Esa Assadi
 */
public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView, MoviesAdapter.OnMoviesAdapter {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        mPresenter.getData();
    }

    //MainActivity presenter initialize
    @NonNull @Override
    protected MainActivityPresenter createPresenter(@NonNull Context context) {
        return new MainActivityPresenter(this);
    }

    @Override
    public void onGetDataDoneUpdateView(List<Playlists> results) {
        MoviesAdapter adapter = new MoviesAdapter(results,this);
        mRecyclerView.setAdapter(adapter);
    }

    // on item clicked
    @Override
    public void onMoviesAdapterClicked(String videoUrl) {
        String videoId = mPresenter.getVideoIdFromUrl(videoUrl);
        Intent intent = new Intent(this, YoutubePlayerActivity.class);
        intent.putExtra(YoutubePlayerActivity.KEY_VIDEO_ID_INTENT,videoId);
        startActivity(intent);
    }
}





