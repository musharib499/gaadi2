package com.gaadi.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.app.R;

/**
 * Created by lakshaygirdhar on 1/4/16.
 */
public class BaseFragment extends Fragment  {

    protected Context mContext;
    protected FragmentActivity mActivity;
    private int mLayout;
    private FragmentListener mFragmentListener;
    public static String LAYOUT = "layout";
    int layoutId;

    public interface FragmentListener{
        public void inflateFragment();
        public void actionCompletedListener(Object object);
    }

    public BaseFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = getActivity();
    }

    public static BaseFragment newInstance(int layout,FragmentListener listener){
        Bundle args = new Bundle();
        args.putInt(LAYOUT, layout);
        BaseFragment fragment = new BaseFragment();
        fragment.mFragmentListener = listener;
        fragment.setArguments(args);
        return fragment;
    }

    public  void init(){

    }

    private void createFragment(int layout,FragmentListener listener){
        layoutId = layout;
        mFragmentListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = LayoutInflater.from(mContext).inflate(layoutId,container,false);
//        return view;
        return null;
    }
}
