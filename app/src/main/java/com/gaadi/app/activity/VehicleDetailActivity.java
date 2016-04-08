package com.gaadi.app.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Window;

import com.gaadi.app.R;
import com.gaadi.app.fragments.CertificationDetailFragment;
import com.gaadi.app.fragments.FeaturesSpecificationFragment;
import com.gaadi.app.fragments.RecommendedVehicleFragment;
import com.gaadi.app.fragments.VehicleBasicDetailsFragment;
import com.gaadi.app.fragments.VehicleDescriptionFragment;
import com.gaadi.app.fragments.VehicleOverviewFragment;

public class VehicleDetailActivity extends BaseCollapsingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setActivityTransition();

        getLayoutInflater().inflate(R.layout.activity_detail_page, frameLayout);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_model, VehicleBasicDetailsFragment.newInstance("hello")).commit();
        collapsingToolbarLayout.setTitle("Hyundai");
        getSupportFragmentManager().beginTransaction().replace(R.id.flRecommededCars, RecommendedVehicleFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFeaturesSpecifications, FeaturesSpecificationFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flVehicleOverview, VehicleOverviewFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flDescriptionCars, VehicleDescriptionFragment.newInstance("Hello")).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flVehicleCertified, CertificationDetailFragment.newInstance("Hello")).commit();
    }
}
