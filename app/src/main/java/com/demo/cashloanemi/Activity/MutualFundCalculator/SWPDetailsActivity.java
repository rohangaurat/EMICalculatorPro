package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.MutualFundAndSIPAdapter;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;

import java.util.ArrayList;

public class SWPDetailsActivity extends AppCompatActivity {
    MutualFundAndSIPAdapter adapter;
    ArrayList<Double> balanceBeginList;
    ArrayList<Double> balanceEndList;
    ArrayList<Double> interestList;
    PrefManager prefManager;
    RecyclerView rcvSWPDetails;
    Toolbar toolbar;
    ArrayList<Double> withdrawalList;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_swpdetails);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        this.rcvSWPDetails = (RecyclerView) findViewById(R.id.rcvSWPDetails);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.prefManager = new PrefManager(this);
        this.interestList = (ArrayList) getIntent().getSerializableExtra("interestList");
        this.balanceBeginList = (ArrayList) getIntent().getSerializableExtra("balanceBeginList");
        this.balanceEndList = (ArrayList) getIntent().getSerializableExtra("balanceEndList");
        this.withdrawalList = (ArrayList) getIntent().getSerializableExtra("withdrawalList");
        this.adapter = new MutualFundAndSIPAdapter(this.balanceBeginList, this.balanceEndList, this.interestList, this.withdrawalList);
        this.rcvSWPDetails.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.rcvSWPDetails.setAdapter(this.adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
