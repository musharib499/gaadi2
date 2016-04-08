package com.gaadi.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gaadi.app.R;
import com.gaadi.app.models.CarsDetails;

import java.util.List;

/**
 * Created by kanishroshan on 29/3/16.
 */
public class RecommendedCarsAdapter extends RecyclerView.Adapter<RecommendedCarsAdapter.ViewHolder> {

    private Context mContext;
    private List<CarsDetails> carsDetailsList;

    public RecommendedCarsAdapter(Context context,List<CarsDetails> carsDetailsList) {
        this.carsDetailsList = carsDetailsList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_recycler_recommendedcars,parent,false);
        return new ViewHolder(itemview);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CarsDetails carsDetails=carsDetailsList.get(position);
        Log.e("KANSIH", carsDetails.getCarName());
        Glide.with(mContext).load("https://www.dropbox.com/home/Images?preview=cc.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img_rec_car);
        holder.tv_rec_car_name.setText(carsDetails.getCarName());
        holder.tv_rec_car_address.setText(carsDetails.getCarAddress());
        holder.tv_rec__price.setText(carsDetails.getCarPrice());

    }

    @Override
    public int getItemCount() {
        return carsDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rec_car_name, tv_rec_car_address, tv_rec__price;
        ImageView img_rec_car;

        public ViewHolder(View view) {
            super(view);
            tv_rec_car_name = (TextView) view.findViewById(R.id.tv_car_name);
            tv_rec_car_address = (TextView) view.findViewById(R.id.tv_car_address);
            tv_rec__price = (TextView) view.findViewById(R.id.tv_car_price);
            img_rec_car = (ImageView) view.findViewById(R.id.img_car);

        }
    }
}
