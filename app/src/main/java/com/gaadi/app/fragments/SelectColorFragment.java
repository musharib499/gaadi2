package com.gaadi.app.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;
import com.gaadi.app.adapter.BaseRecyclerAdapter;
import com.gaadi.app.holder.SelectColorViewHolder;
import com.gaadi.app.utils.CommanUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectColorFragment extends Fragment implements BaseRecyclerAdapter.BindAdapterListener<SelectColorViewHolder> {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private ArrayList<String> arrayList = new ArrayList<>();
    private SparseBooleanArray selectedItems = new SparseBooleanArray();


    public static SelectColorFragment newInstance(String param1) {
        SelectColorFragment fragment = new SelectColorFragment();
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
        View view = inflater.inflate(R.layout.fragment_select_color, container, false);
        String[] allColors = getResources().getStringArray(R.array.colors);
        for (int i = 0; i < allColors.length; i++) {
            arrayList.add(allColors[i]);
        }
        BaseRecyclerAdapter<String, SelectColorViewHolder> adapter = new BaseRecyclerAdapter<>(getActivity(), arrayList, this, SelectColorViewHolder.class, R.layout.item_select_color_type);
        CommanUtils.recyclerView((RecyclerView) view.findViewById(R.id.recycle_list), getActivity(), false).setAdapter(adapter);
        return view;
    }

    @Override
    public void onBind(final SelectColorViewHolder holder, final int position) {
        // int invalue=arrayList.get(position).toString();

        holder.view_color.setBackgroundColor(Color.parseColor(arrayList.get(position).toString()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItems.get(position, false)) {
                    selectedItems.delete(position);
                    holder.view_check.setVisibility(View.GONE);
                } else {
                    selectedItems.put(position, true);

                    holder.view_check.setVisibility(View.VISIBLE);
                }


            }
        });


    }
}
