package com.gaadi.app.network;

import android.content.Context;

import com.gaadi.app.BuildConfig;

/**
 * Created by lakshaygirdhar on 2/4/16.
 */
public class NetworkManager {

    public static final String REST_HOST = BuildConfig.REST_HOST;
    public static final long CONNECT_TIMEOUT_SECS = 50;
    public static final long WRITE_TIMEOUT_SECS = 50;
    public static final long READ_TIMEOUT_SECS = 50;
    public static final int CONNECTION_POOL_SIZE = 4;
    public static final int CONNECTION_MAX_IDLE_TIME_MS = 3000;
    public static final String ENVIRONMENT = BuildConfig.ENVIRONMENT;
    private Context mContext;
    private NetworkCallback mCallback;

    public interface NetworkCallback {
        public void onNetworkResponse();
    }


    public void getSearchResults(){

    }



}
