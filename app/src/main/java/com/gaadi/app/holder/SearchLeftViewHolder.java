package com.gaadi.app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaadi.app.R;

/**
 * Created by Mushareb Ali on 7/4/16.
 */
public class SearchLeftViewHolder extends RecyclerView.ViewHolder {

    public final TextView tv_type;
    public RelativeLayout parant_layout;


    public SearchLeftViewHolder(View view) {
        super(view);

        parant_layout = (RelativeLayout) view.findViewById(R.id.parent_layout);
        tv_type = (TextView) view.findViewById(R.id.tv_type);

    }

}