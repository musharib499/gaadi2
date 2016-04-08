package com.gaadi.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.gaadi.app.R;
import com.gaadi.app.activity.FilterActivity;
import com.gaadi.app.adapter.BaseRecyclerAdapter;
import com.gaadi.app.holder.SearchMakeHolder;
import com.gaadi.app.models.SearchMakeModel;
import com.gaadi.app.utils.CommanUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchMakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchMakeFragment extends Fragment implements BaseRecyclerAdapter.BindAdapterListener<SearchMakeHolder> {


    Context context = getActivity();
    private ArrayList<SearchMakeModel> searchMakeModels = new ArrayList<>();
    private boolean check = true;
    private int lastPosition = 0;

    public SearchMakeFragment() {
        // Required empty public constructor
    }


    public static SearchMakeFragment newInstance() {
        SearchMakeFragment fragment = new SearchMakeFragment();


        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_make_model, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_list);
        AutoCompleteTextView search = (AutoCompleteTextView) view.findViewById(R.id.atv_search);

        for (int i = 0; i < 10; i++) {
            SearchMakeModel searchMakeModel = new SearchMakeModel();
            searchMakeModel.setMake("Hundai (" + i + ")");
            searchMakeModel.setModel("I " + i + "");
            ArrayList<String> strings = new ArrayList<>();
            if (i == 2) {
                for (int k = 0; k < 60; k++) {

                    strings.add("K10  (" + i + ")");

                }
            } else if (i == 3) {
                for (int k = 0; k < 10; k++) {

                    strings.add("I20  (" + i + ")");

                }
            } else if (i == 7) {
                for (int k = 0; k < 30; k++) {

                    strings.add("ZLX  (" + i + ")");

                }
            }
            searchMakeModel.setArrayListModel(strings);
            searchMakeModels.add(searchMakeModel);
        }

        BaseRecyclerAdapter<SearchMakeModel, SearchMakeHolder> serchMakeBRA = new BaseRecyclerAdapter<>(getActivity(), searchMakeModels, this, SearchMakeHolder.class, R.layout.item_filter_make_layout);
        CommanUtils.recyclerView(recyclerView, getActivity(), true).setAdapter(serchMakeBRA);
        return view;
    }

    @Override
    public void onBind(final SearchMakeHolder holder, final int position) {
        holder.tv_make.setText(searchMakeModels.get(position).getMake());
        holder.tv_model.setText(searchMakeModels.get(position).getModel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!searchMakeModels.get(position).getArrayListModel().isEmpty()) {
                    ((FilterActivity) getActivity()).modelFragment.updateView(searchMakeModels.get(position).getArrayListModel());

                }
                ((FilterActivity) getActivity()).openDrawar();

                if (check) {
                    check = false;
                    lastPosition = position;
                    holder.tv_make.setSelected(true);
                    // holder.tv_make.setTextColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(getActivity(), "click on item", Toast.LENGTH_SHORT).show();
                } else {

                    if (position != lastPosition) {
                        holder.tv_make.setSelected(true);
                        lastPosition = position;
                        check = false;

                    } else {
                        check = true;
                        holder.tv_make.setSelected(false);
                    }

                    //  this.onListFragmentInteraction(position);
                    // holder.tv_make.setTextColor(getResources().getColor(R.color.textColor));
                    // Toast.makeText(getActivity(), "click on item", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }





   /* @Override
    public void onBind(final SearchNavigationHolder holder, final int position) {
        holder.cb_item.setText(searchMakeModels.get(position).getMake());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               *//* ((FilterActivity)getActivity()).openDrawar();
                if (check) {
                    check = false;
                    lastPosition=position;
                    holder.tv_make.setSelected(true);
                    // holder.tv_make.setTextColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(getActivity(), "click on item", Toast.LENGTH_SHORT).show();
                } else {

                    if (position!=lastPosition) {
                        holder.tv_make.setSelected(true);
                        lastPosition=position;
                        check = false;

                    }
                    else {
                        check = true;
                        holder.tv_make.setSelected(false);
                    }*//*
                    // holder.tv_make.setTextColor(getResources().getColor(R.color.textColor));
                    // Toast.makeText(getActivity(), "click on item", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }*/
}
