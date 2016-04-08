package com.gaadi.app.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaadi.app.R;

/**
 * Created by Mushareb Ali on 8/4/16.
 */
public class CommanUtils {
    public static TextView tv;

    public static void OverFlowMenuText(Context context, String st, int testSize, Menu menu) {
        int testsize1 = 16;
        testsize1 = testSize;
        tv = new TextView(context);
        tv.setText(st);
        tv.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        tv.setTextColor(context.getResources().getColor(R.color.white));
        tv.setPadding(0, 0, 20, 0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 10, 0);

        tv.setLayoutParams(params);
        tv.setTypeface(null, Typeface.NORMAL);
        tv.setTextSize(testsize1);
        menu.add(0, 0, 1, st).setActionView(tv).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);


    }

    public static RecyclerView recyclerView(RecyclerView recyclerView, Context context, boolean orientation) {
        LinearLayoutManager recycler_layout = new LinearLayoutManager(context);
        if (orientation)
            recycler_layout.setOrientation(LinearLayout.VERTICAL);
        else
            recycler_layout.setOrientation(LinearLayout.HORIZONTAL);

        recyclerView.setLayoutManager(recycler_layout);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }

}
