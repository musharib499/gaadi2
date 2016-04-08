package com.gaadi.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdvanceFilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvanceFilterFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static AdvanceFilterFragment newInstance(String param1) {
        AdvanceFilterFragment fragment = new AdvanceFilterFragment();
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
        View view = inflater.inflate(R.layout.fragment_advance_filter, container, false);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_color, SelectColorFragment.newInstance("")).commit();
        return view;
    }

}
