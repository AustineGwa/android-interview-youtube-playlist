package com.aliesaassadi.youtube.services;

import com.aliesaassadi.youtube.MainActivity.models.PlaylistsResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ali Esa Assadi
 */

public class PlaylistsService {

    private static final String URL = "http://demo6483760.mockable.io/";
    private PlaylistApi mPlaylistApi;

    public PlaylistsService() {
        Retrofit mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();
        mPlaylistApi = mRetrofit.create(PlaylistApi.class);
    }

    public PlaylistApi getPlaylistApi() {
        return mPlaylistApi;
    }

    public interface PlaylistApi {
        @GET("json.json") Call<PlaylistsResponse> getAllPlaylists();
    }

}


