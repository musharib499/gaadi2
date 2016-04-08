package com.gaadi.app.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gaadi.app.R;
import com.gaadi.app.adapter.BaseRecyclerAdapter;

import java.util.ArrayList;

public class FilterRigthItemFragment extends Fragment {

    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    private static final String ARG_COLUMN_COUNT = "column-count";
    ArrayList<String> arrayList;
    private int pYear;
    private int pMonth;
    private int pDay;
    private int hour;
    private int minute;
    private int seconds = 0;
    private int mColumnCount = 0;
    private FilterLeftItemFragment.OnListFragmentInteractionListener mListener;
    private AutoCompleteTextView auto_serach;
    private LinearLayout lay_calander;
    private RelativeLayout lay_apply;
    /* private MaterialEditText mev_from_date;
     private MaterialEditText mev_to_date;*/
    private RecyclerView recyclerView;
    // private FilterRightItemRecyclerViewAdapter filterRecyclerViewAdapter;
    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            pYear = selectedYear;
            pMonth = selectedMonth;
            pDay = selectedDay;


        }
    };

    public FilterRigthItemFragment() {
    }

    public static FilterRigthItemFragment newInstance(int columnCount) {
        FilterRigthItemFragment fragment = new FilterRigthItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_rigth_fragment_item_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       /* String[] strings = getResources().getStringArray(R.array.filter_right_visit_item);
        arrayList = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++) {
            arrayList.add(strings[i]);
        }*/


        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_right_list);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        //recyclerView.setAdapter(filterRecyclerViewAdapter);
    }

    public void updateView(int postion) {


        switch (postion) {
            case 0:
             /*   String[] strings = getResources().getStringArray(R.array.filter_right_visit_item);

                if (auto_serach.getVisibility() == View.GONE) {
                    auto_serach.setVisibility(View.VISIBLE);
                    lay_calander.setVisibility(View.GONE);
                }
                filterRecyclerViewAdapter.updateAdapter(new ArrayList(Arrays.asList(strings)));
          */
                break;
            case 1:
               /* String[] strings1 = getResources().getStringArray(R.array.filter_right_visit_city);
                if (lay_calander.getVisibility() == View.GONE) {
                    auto_serach.setVisibility(View.GONE);
                    lay_calander.setVisibility(View.VISIBLE);

                }


                filterRecyclerViewAdapter.updateAdapter(new ArrayList(Arrays.asList(strings1)));
           */
                break;

        }
    }


}
