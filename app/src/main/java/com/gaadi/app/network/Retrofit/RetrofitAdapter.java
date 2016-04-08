package com.gaadi.app.network.Retrofit;

import com.gaadi.app.network.NetworkManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by lakshaygirdhar on 2/4/16.
 */
public class RetrofitAdapter {

    private static final String TAG = "RetrofitAdapter";
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static RestAdapter getRestAdapter() {
        final Gson gson = new GsonBuilder().create();
        final GsonConverter converter = new GsonConverter(gson);
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(NetworkManager.CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(NetworkManager.WRITE_TIMEOUT_SECS, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(NetworkManager.READ_TIMEOUT_SECS, TimeUnit.SECONDS);
        okHttpClient.setConnectionPool(new ConnectionPool(NetworkManager.CONNECTION_POOL_SIZE, NetworkManager.CONNECTION_MAX_IDLE_TIME_MS));
        okHttpClient.setRetryOnConnectionFailure(true);


        return new RestAdapter.Builder()
                .setEndpoint(NetworkManager.REST_HOST)
                .setExecutors(Executors.newFixedThreadPool(NetworkManager.CONNECTION_POOL_SIZE), new MainThreadExecutor())
                .setConverter(converter)
                .setLogLevel(NetworkManager.ENVIRONMENT.equals("PROD") ? RestAdapter.LogLevel.NONE : RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .build();
    }
}
