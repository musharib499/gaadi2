package com.gaadi.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by lakshaygirdhar on 2/4/16.
 */
public class ApplicationController extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
