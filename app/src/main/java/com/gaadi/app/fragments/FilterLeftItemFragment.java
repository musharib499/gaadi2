package com.gaadi.app.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;
import com.gaadi.app.adapter.BaseRecyclerAdapter;
import com.gaadi.app.holder.SearchLeftViewHolder;
import com.gaadi.app.utils.CommanUtils;

import java.util.ArrayList;


/*musharib Ali*/
public class FilterLeftItemFragment extends Fragment implements BaseRecyclerAdapter.BindAdapterListener<SearchLeftViewHolder> {
    private static final String ARG_FILTER_ITEM = "filter-item";
    private OnListFragmentInteractionListener mListener;
    private ArrayList<String> filter_item = new ArrayList<String>();
    private SparseBooleanArray selectedItems = new SparseBooleanArray();


    public FilterLeftItemFragment() {
    }

    public static FilterLeftItemFragment newInstance(ArrayList<String> columnCount) {
        FilterLeftItemFragment fragment = new FilterLeftItemFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_FILTER_ITEM, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            filter_item = getArguments().getStringArrayList(ARG_FILTER_ITEM);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_left_item_list, container, false);
        String[] st = getResources().getStringArray(R.array.filter_left_item);

        for (int i = 0; i < st.length; i++) {
            filter_item.add(st[i]);

        }
        BaseRecyclerAdapter<String, SearchLeftViewHolder> serchNavigation = new BaseRecyclerAdapter<>(getActivity(), filter_item, this, SearchLeftViewHolder.class, R.layout.fragment_filter_left_item);
        CommanUtils.recyclerView((RecyclerView) view.findViewById(R.id.recycle_list), getActivity(), true).setAdapter(serchNavigation);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onBind(final SearchLeftViewHolder holder, final int position) {
        holder.tv_type.setText(filter_item.get(position).toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    if (selectedItems.get(position, false)) {
                        selectedItems.delete(position);
                        holder.parant_layout.setSelected(false);
                        holder.tv_type.setSelected(false);
                        holder.tv_type.setTextColor(getActivity().getResources().getColor(R.color.textColor));
                        ColorStateList rippleColor = ContextCompat.getColorStateList(getActivity(), R.color.light_gray);
                        holder.itemView.setBackgroundTintList(rippleColor);
                    } else {

                        selectedItems.put(position, true);
                        holder.parant_layout.setSelected(true);
                        holder.tv_type.setSelected(true);
                        holder.tv_type.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
                        ColorStateList rippleColor = ContextCompat.getColorStateList(getActivity(), R.color.light_gray);
                        holder.itemView.setBackgroundTintList(rippleColor);
                    }
                    mListener.onListFragmentInteraction(position);
                }
            }
        });

    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(int position);
    }
}
