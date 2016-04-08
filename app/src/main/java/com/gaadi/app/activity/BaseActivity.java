package com.gaadi.app.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaadi.app.R;


/**
 * Created by kanishroshan on 3/2/16.
 */
public class BaseActivity extends AppCompatActivity {

    protected FrameLayout frameLayout;
    protected Toolbar toolbar;
    protected TabLayout tabLayout;
    protected LinearLayout lay_sub_tital, lay_coll_sub_title;
    protected TextView sub_tital, coll_title, coll_sub_title, tv_next_cheack;
    protected ImageView make_logo;
    protected TextView fab_text;

    protected FloatingActionButton fab;

    protected ViewPager viewPager;
    protected RelativeLayout btn_bottom_next;
    LinearLayout parentLayout;


//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    protected void setActivityTransition() {
//
//        getWindow().setExitTransition(new Fade());
//        getWindow().setEnterTransition(new Fade());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        // getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        FragmentFeatures obj= (FragmentFeatures) FragmentFeatures.newInstance(R.layout.fragment_features,null);

    }


    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        getSupportActionBar().setTitle(title);
    }


    protected void setTitleMsg(String msg) {
        toolbar.setTitle(msg);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    protected void setSubTittle(String tittle, String subtittle) {
        lay_coll_sub_title.setVisibility(View.VISIBLE);
        coll_title.setText(tittle);
        coll_sub_title.setText(subtittle);
        //collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}