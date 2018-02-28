package com.aliesaassadi.youtube.MainActivity.presenter;

import com.aliesaassadi.youtube.MainActivity.models.PlaylistsResponse;
import com.aliesaassadi.youtube.services.PlaylistsService;
import com.aliesaassadi.youtube.MainActivity.view.MainActivityView;
import com.aliesaassadi.youtube.base.BasePresenter;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ali Esa Assadi
 */

public class MainActivityPresenter extends BasePresenter  {

    private MainActivityView mView;
    private PlaylistsService mPlaylistsService;


    public MainActivityPresenter(MainActivityView view) {
        mView = view;
        mPlaylistsService = new PlaylistsService();
    }

    public void getData() {
        Call<PlaylistsResponse> mPlaylistsCall = mPlaylistsService.getPlaylistApi().getAllPlaylists();
        mPlaylistsCall.enqueue(new PlaylistsCallListener(mView));
    }

    public String getVideoIdFromUrl(String url) {

        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(url); //url is youtube url for which you want to extract the id.
        if (matcher.find())

        {
            return matcher.group();
        }

        return matcher.group();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //avoid leak
        mView = null;
    }

    private static class PlaylistsCallListener implements Callback<PlaylistsResponse> {

        private WeakReference<MainActivityView> mView;

        private PlaylistsCallListener(MainActivityView view) {
            mView = new WeakReference<>(view);
        }

        @Override
        public void onResponse(Call<PlaylistsResponse> call, Response<PlaylistsResponse> response) {
            if (mView.get()!=null){
                mView.get().onGetDataDoneUpdateView(response.body().getPlaylists());
            }
        }

        @Override
        public void onFailure(Call<PlaylistsResponse> call, Throwable t) {
            t.fillInStackTrace();
        }
    }

}
