package com.gaadi.app.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaadi.app.R;


public class BaseNavigationViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public RecyclerView baseRecyclerView;
    public FrameLayout frameNavigationView;
    protected NavigationView navigationView;
    protected Toolbar toolbar;
    protected FrameLayout frameLayout;
    protected DrawerLayout mDrawerLayout;
    protected TextView fab_text;
    protected FloatingActionButton fab;
    protected ImageView profile_image_view;
    protected int drawerGravity = Gravity.LEFT;
    protected ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_navigation_view);
        // final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_24dp);
        //  upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        frameNavigationView = (FrameLayout) findViewById(R.id.frame_layout_navigationview);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        baseRecyclerView = (RecyclerView) findViewById(R.id.recycle_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       /* profile_image_view = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.profile_image);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab_text = (TextView) findViewById(R.id.fab_text);*/
        setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeAsUpIndicator(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(false);
        //drawerToggle.setHomeAsUpIndicator();
        mDrawerLayout.setDrawerListener(drawerToggle);


      /*  if(AppPrefrences.getLoginResponseModel(this)!=null && AppPrefrences.getLoginResponseModel(this).getLoginData()!=null) {
            ((TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_name)).setText(AppPrefrences.getLoginResponseModel(this).getLoginData().getName());
            ((TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_email)).setText(AppPrefrences.getLoginResponseModel(this).getLoginData().getEmail());
        }

        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_version)).setText(Utils.getReplacementText(R.string.version_name, BuildConfig.VERSION_NAME));

    */
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mDrawerLayout.isDrawerOpen(drawerGravity)) {
                    mDrawerLayout.closeDrawer(drawerGravity);
                } else {
                    mDrawerLayout.openDrawer(drawerGravity);
                }
            }
        });


        //ViewServer.get(this).addWindow(this);

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
    }


    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    /*protected void setCircularImageView(String url) {
        Glide.with(this).load(url).asBitmap()
                .into(new BitmapImageViewTarget(profile_image_view) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circular = RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circular.setCircular(true);
                        profile_image_view.setImageDrawable(circular);
                    }
                });
    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                mDrawerLayout.openDrawer(drawerGravity);
                return true;

          /*  case R.id.action_settings:
                return true;*/
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public boolean isNavDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(drawerGravity);
    }

    protected void closeNavDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ViewServer.get(this).removeWindow(this);
    }
}
