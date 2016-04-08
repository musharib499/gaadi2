package com.gaadi.app.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.gaadi.app.R;
import com.gaadi.app.fragments.AdvanceFilterFragment;
import com.gaadi.app.fragments.FilterLeftItemFragment;
import com.gaadi.app.fragments.SearchCertificationFragment;
import com.gaadi.app.fragments.SearchMakeFragment;
import com.gaadi.app.fragments.SearchModelFragment;
import com.gaadi.app.utils.CommanUtils;


public class FilterActivity extends BaseNavigationViewActivity implements FilterLeftItemFragment.OnListFragmentInteractionListener {

    public SearchModelFragment modelFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_filter, frameLayout);
        drawerGravity = Gravity.RIGHT;

        modelFragment = SearchModelFragment.newInstance("");
        getSupportFragmentManager().beginTransaction().replace(navigationView.getId(), modelFragment).commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        drawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void openDrawar() {
        mDrawerLayout.openDrawer(drawerGravity);
    }

    public void closeDrawer() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        }
    }

    @Override
    public void onListFragmentInteraction(int position) {
        switch (position) {
            //  SearchModelFragment fragment = (SearchModelFragment) getSupportFragmentManager().findFragmentById(frameNavigationView.getId());

            case 0:
                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_right, SearchMakeFragment.newInstance()).commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_right, SearchCertificationFragment.newInstance("Search")).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_right, AdvanceFilterFragment.newInstance("Search")).commit();
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        CommanUtils.OverFlowMenuText(this, "Reset", 18, menu);


        CommanUtils.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FilterActivity.this, "Reset", Toast.LENGTH_SHORT).show();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}