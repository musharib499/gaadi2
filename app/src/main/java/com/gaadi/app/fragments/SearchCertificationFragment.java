package com.gaadi.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;
import com.gaadi.app.adapter.BaseRecyclerAdapter;
import com.gaadi.app.holder.SearchNavigationHolder;
import com.gaadi.app.utils.CommanUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchCertificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchCertificationFragment extends Fragment implements BaseRecyclerAdapter.BindAdapterListener<SearchNavigationHolder> {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private ArrayList<String> arrayList = new ArrayList<>();


    public static SearchCertificationFragment newInstance(String param1) {
        SearchCertificationFragment fragment = new SearchCertificationFragment();
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
        View view = inflater.inflate(R.layout.fragment_search_certification, container, false);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                arrayList.add("TrustMark  Certified");
            } else {
                arrayList.add("Dealer Certified");
            }
        }
        // Inflate the layout for this fragment
        BaseRecyclerAdapter<String, SearchNavigationHolder> serchNavigation = new BaseRecyclerAdapter<>(getActivity(), arrayList, this, SearchNavigationHolder.class, R.layout.item_navigation_right);
        CommanUtils.recyclerView((RecyclerView) view.findViewById(R.id.recycle_list), getActivity(), true).setAdapter(serchNavigation);

        return view;
    }

    @Override
    public void onBind(SearchNavigationHolder holder, int position) {
        holder.cb_item.setText(arrayList.get(position).toString());
    }
}
