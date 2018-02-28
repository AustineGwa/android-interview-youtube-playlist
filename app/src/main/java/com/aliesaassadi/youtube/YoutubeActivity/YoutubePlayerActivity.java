package com.aliesaassadi.youtube.YoutubeActivity;

import android.os.Bundle;

import com.aliesaassadi.youtube.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali Esa Assadi
 */

public class YoutubePlayerActivity extends YouTubeBaseActivity {

    @BindView(R.id.youtube_view) YouTubePlayerView mYouTubePlayerView;
    private String mVideoID;

    // I know I know but it's just a test app so ...
    public static final String API_KEY = "AIzaSyAYqgmkodjrwmchnF-p6ZCzX3l3lYkcVEc";
    public static final String KEY_VIDEO_ID_INTENT = "VIDEO_ID_INTENT";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
        ButterKnife.bind(this,this);

        mVideoID = getIntent().getStringExtra(KEY_VIDEO_ID_INTENT);
    }

    @Override
    protected void onStart() {super.onStart();
        mYouTubePlayerView.initialize(API_KEY, new OnInitializeListener());
    }

    public class OnInitializeListener implements YouTubePlayer.OnInitializedListener {

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            /** after onStart initialize - Listener **/

            //load video
            youTubePlayer.loadVideo(mVideoID);

            //If you wish to only load the video but not play, use cueVideo() -> youTubePlayer.cueVideo("a4NT5iBFuZs");
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            //do nothing
        }
    }

}
