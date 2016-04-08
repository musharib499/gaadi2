package com.gaadi.app.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gaadi.app.R;

public class BaseCollapsingActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TabLayout tabLayout;
    protected AppBarLayout appBarLayout;
    protected FloatingActionButton fab;
    protected NestedScrollView frameLayout;
    protected CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_collapsing);

        ImageView ivCar = (ImageView) findViewById(R.id.main_backdrop);
        Glide.with(this).load("http://images.cardekho.com/images/carNewsimages/carnews/Renualt/Dacia-10th-anniversary-special-limited-editions-02.jpg").diskCacheStrategy(DiskCacheStrategy.ALL).into(ivCar);
        frameLayout = (NestedScrollView) findViewById(R.id.main_container);
        // framelayout_collapsing = (FrameLayout) findViewById(R.id.framelayout_collapsing);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
//        frameLayout.setFillViewport(true);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.main_appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void setActivityTransition() {
        getWindow().setExitTransition(new Fade());
        getWindow().setEnterTransition(new Fade());
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        getSupportActionBar().setTitle(title);
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
