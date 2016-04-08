package com.gaadi.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;


public class VehicleBasicDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";


    private String mParam1;



    public static VehicleBasicDetailsFragment newInstance(String param1) {
        VehicleBasicDetailsFragment fragment = new VehicleBasicDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_model_info, null);

        return view;
    }

}
