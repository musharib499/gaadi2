package com.gaadi.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gaadi.app.R;
import com.gaadi.app.adapter.RecommendedCarsAdapter;
import com.gaadi.app.models.CarsDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lakshaygirdhar on 1/4/16.
 */
public class RecommendedVehicleFragment extends Fragment {

    private Context mContext;
    private RecyclerView recyclerView;
    private RecommendedCarsAdapter mAdapter;
    private List<CarsDetails> carlist = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public static RecommendedVehicleFragment newInstance() {
        Bundle args = new Bundle();
        RecommendedVehicleFragment fragment = new RecommendedVehicleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recommended_cars,null);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_recomended_cars);

        LinearLayoutManager recycler_layout=new LinearLayoutManager(mContext);
        recycler_layout.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(recycler_layout);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();
        mAdapter=new RecommendedCarsAdapter(mContext,carlist);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private void prepareData() {
        CarsDetails carsDetails=new CarsDetails("WAGON R","cannaughtPlace,Delhi","320000");
        carlist.add(carsDetails);

        carsDetails=new CarsDetails("Ferrari R","samaypurBadli,Delhi","320000");
        carlist.add(carsDetails);

        carsDetails=new CarsDetails("Fortuner","cannaughtPlace,Delhi","320000");
        carlist.add(carsDetails);

        carsDetails=new CarsDetails("Beat","malviya nagar,saket","320000");
        carlist.add(carsDetails);
    }
}
