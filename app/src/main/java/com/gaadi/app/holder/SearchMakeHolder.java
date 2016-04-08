package com.gaadi.app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gaadi.app.R;

/**
 * Created by mushareb on 4/4/16.
 */
public class SearchMakeHolder extends RecyclerView.ViewHolder {
    public TextView tv_make, tv_model;
    View view;


    public SearchMakeHolder(View itemView) {
        super(itemView);
        tv_make = (TextView) itemView.findViewById(R.id.tv_make);
        tv_model = (TextView) itemView.findViewById(R.id.tv_model);


    }
}

