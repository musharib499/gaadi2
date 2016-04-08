package com.gaadi.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;

/**
 * Created by lakshaygirdhar on 1/4/16.
 */
public class VehicleOverviewFragment extends Fragment {

    private Context mContext;
    private FragmentActivity mActivity;

    public static VehicleOverviewFragment newInstance() {
        Bundle args = new Bundle();
        VehicleOverviewFragment fragment = new VehicleOverviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.overview_layout, null);
        return view;
    }
}
