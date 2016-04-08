package com.gaadi.app.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gaadi.app.R;
import com.gaadi.app.adapter.BaseRecyclerAdapter;
import com.gaadi.app.models.SearchcarModel;
import com.gaadi.app.utils.SortComaparator;
import com.gaadi.app.models.SearchResult;
import com.gaadi.app.utils.ActivitytTransitionAnimation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kanishroshan on 1/4/16.
 */
public class SearchResultsActivity extends BaseActivity implements BaseRecyclerAdapter.BindAdapterListener<SearchResultsActivity.SearchViewHolder>, View.OnClickListener {

    LinearLayout sort_layout;
    ScrollView sort_menu_layout;
    RadioButton radbut_relevance, radbut_recent, radbut_price_low, radbut_price_high, radbut_km_low, radbut_year_newer;
    Boolean isClicked = true;
    private static final String TAG = "SearchResultsActivity";
    private RecyclerView recyclerView;
    private ArrayList<SearchcarModel> searchcarList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setActivityTransition();
        getLayoutInflater().inflate(R.layout.activity_search_result, frameLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_search_list);
        setinitialization();
    }

    private void setinitialization() {
        LinearLayoutManager recycler_layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recycler_layout);
        prepareData();
        BaseRecyclerAdapter<SearchcarModel, SearchViewHolder> adapter = new BaseRecyclerAdapter<>(this, searchcarList, this,
                SearchViewHolder.class, R.layout.item_search_result_recycle);
        recyclerView.setAdapter(adapter);
        sort_layout = (LinearLayout) findViewById(R.id.sort_layout);
        sort_layout.setOnClickListener(this);
        sort_menu_layout = (ScrollView) findViewById(R.id.sort_menu_container_scroll);
        radbut_relevance = (RadioButton) findViewById(R.id.sort_by_relevance);
        radbut_recent = (RadioButton) findViewById(R.id.sort_by_recent_isted);
        radbut_price_low = (RadioButton) findViewById(R.id.sort_by_price_asc);
        radbut_price_low.setOnClickListener(this);
        radbut_price_high = (RadioButton) findViewById(R.id.sort_by_price_desc);
        radbut_price_high.setOnClickListener(this);
        radbut_km_low = (RadioButton) findViewById(R.id.sort_by_km_low);
        radbut_km_low.setOnClickListener(this);
        radbut_year_newer = (RadioButton) findViewById(R.id.sort_by_new);
        radbut_year_newer.setOnClickListener(this);
    }

    @Override
    public void onBind(final SearchViewHolder holder, int position) {
//        Log.d(TAG, "onBind: http://192.168.1.21/Images/cc.png");
        String imageUrl = "http://images.cardekho.com/images/carNewsimages/carnews/Renualt/Dacia-10th-anniversary-special-limited-editions-02.jpg";
        Glide.with(SearchResultsActivity.this).load(imageUrl).into(holder.ivCar);
//        Glide.with(this).load("http://i.haymarketindia.net/Utils/ImageResizerWM.ashx?n=http%3A%2F%2Fi.haymarketindia.net%2FExtraImages%2F20150312044628_dusterz.png&w=355").diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivCar);
        holder.ivCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitytTransitionAnimation.startActivityWithSharedView(SearchResultsActivity.this, holder.ivCar, "car", VehicleDetailActivity.class);
            }
        });
        SearchcarModel carsDetails = searchcarList.get(position);
        holder.tv_car_price.setText(" " + carsDetails.getPrice());
        holder.tv_km.setText(" " + carsDetails.getKiloMeter());
        holder.tv_modelyear.setText(" " + carsDetails.getYear());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort_layout:
                sort_menu_layout.setVisibility(View.VISIBLE);
                animateMenu();
                break;
            case R.id.sort_by_price_asc:
                Collections.sort(searchcarList, new SortComaparator(1));
                break;
            case R.id.sort_by_price_desc:
                break;
            case R.id.sort_by_km_low:
                break;
            case R.id.sort_by_new:
                break;

        }
    }

    private void prepareData() {
        SearchcarModel carModel = new SearchcarModel(22000, 222000, 1991);
        searchcarList.add(carModel);

        SearchcarModel carModel2 = new SearchcarModel(10100, 222200, 1992);
        searchcarList.add(carModel2);

        SearchcarModel carModel3 = new SearchcarModel(10300, 222200, 1993);
        searchcarList.add(carModel3);

        SearchcarModel carModel4 = new SearchcarModel(10400, 322200, 1994);
        searchcarList.add(carModel4);

        SearchcarModel carModel5 = new SearchcarModel(13000, 422200, 1995);
        searchcarList.add(carModel5);

        SearchcarModel carModel6 = new SearchcarModel(100300, 522200, 2000);
        searchcarList.add(carModel6);

        SearchcarModel carModel7 = new SearchcarModel(100300, 622200, 2015);
        searchcarList.add(carModel7);

        SearchcarModel carModel8 = new SearchcarModel(10000, 722200, 2016);
        searchcarList.add(carModel8);
        SearchcarModel carModel9 = new SearchcarModel(111100, 822200, 2017);
        searchcarList.add(carModel7);

        SearchcarModel carModel10 = new SearchcarModel(100200, 922200, 2018);
        searchcarList.add(carModel8);
    }

    private void animateMenu() {
        if (isClicked == true) {
            ObjectAnimator translate_pane = ObjectAnimator.ofFloat(sort_menu_layout, "y",
                    -20, 20);
            ObjectAnimator translate_paneX = ObjectAnimator.ofFloat(sort_menu_layout, "x",
                    120, 0);
            sort_menu_layout.setVisibility(View.VISIBLE);

            AnimatorSet set = new AnimatorSet();
            set.playTogether(translate_pane, translate_paneX);
            set.setDuration(1000);
            set.play(translate_pane);

            set.start();

            isClicked = false;
        } else {
            ObjectAnimator translate_pane = ObjectAnimator.ofFloat(sort_menu_layout, "y",
                    sort_menu_layout.getY(), -sort_menu_layout.getY() * 2);

            AnimatorSet set = new AnimatorSet();
            set.setDuration(1000);
            set.play(translate_pane);
            set.start();
            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {


                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            isClicked = true;
        }

    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout car_image_layout;
        private TextView tv_car_price, tv_car_emi, tv_modelyear, tv_km, tv_fueltype;
        private Button seller_details;
        private ImageView ivCar;

        public SearchViewHolder(View itemView) {
            super(itemView);
            car_image_layout = (FrameLayout) itemView.findViewById(R.id.search_car_tupple);
            ivCar = (ImageView) itemView.findViewById(R.id.ivCar);
            tv_car_price = (TextView) itemView.findViewById(R.id.tv_search_carPrice);
            tv_car_emi = (TextView) itemView.findViewById(R.id.tv_search_car_emi);
            tv_modelyear = (TextView) itemView.findViewById(R.id.tv_model_year);
            tv_km = (TextView) itemView.findViewById(R.id.tv_total_distance);
            tv_fueltype = (TextView) itemView.findViewById(R.id.tv_fuel_type);
            seller_details = (Button) itemView.findViewById(R.id.button_get_seller_details);
        }
    }
}
