package com.gaadi.app.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import com.gaadi.app.activity.VehicleDetailActivity;


/**
 * Created by mushareb on 1/4/16.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class ActivitytTransitionAnimation {

    public static void scaleupAnimation(View view, Context context, Class<?> secondActivity) {
        ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(view, 0, 0,
                view.getWidth(), view.getHeight());

        context.startActivity(new Intent(context, secondActivity),
                opts.toBundle());
    }

    public static void scaleupAnimationWithOutIntent(View view, Context context, Class<?> secondActivity) {
        ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(view, 0, 0,
                view.getWidth(), view.getHeight());

        context.startActivity(new Intent(context, secondActivity),
                opts.toBundle());
    }

    public static void translateAnimationBottomUp(Activity context, Class<?> secondActivity) {
        if (secondActivity != null) {
            context.startActivity(new Intent(context, secondActivity));
        }
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void translateAnimationUpBottom(Activity context, Class<?> secondActivity) {
        if (secondActivity != null) {
            context.startActivity(new Intent(context, secondActivity));
        }
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void startActivityWithSharedView(Activity activity,View view,String transitionName,Class<?> secondActivity){
        if(Build.VERSION.SDK_INT>= 21){
            Intent intent = new Intent(activity, secondActivity);
            activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, view, "car").toBundle());
        } else {
            activity.startActivity(new Intent(activity,secondActivity));
        }
    }


}
