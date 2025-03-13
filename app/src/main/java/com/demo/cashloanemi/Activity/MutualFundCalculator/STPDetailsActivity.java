package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
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

public class STPDetailsActivity extends AppCompatActivity {
    ArrayList<Double> beginTransfereeList;
    ArrayList<Double> beginTransferorList;
    Button btnSTPTransferee;
    Button btnSTPTransferor;
    ArrayList<Double> endTransfereeList;
    ArrayList<Double> endTransferorList;
    ArrayList<Double> interestTransfereeList;
    ArrayList<Double> interestTransferorList;
    PrefManager prefManager;
    RecyclerView rcvTransferee;
    RecyclerView rcvTransferor;
    Toolbar toolbar;
    MutualFundAndSIPAdapter transfereeAdapter;
    MutualFundAndSIPAdapter transferorAdapter;
    ArrayList<Double> transferredInOrOutList;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_stpdetails);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.prefManager = new PrefManager(this);
        this.rcvTransferor = (RecyclerView) findViewById(R.id.rcvTransferor);
        this.rcvTransferee = (RecyclerView) findViewById(R.id.rcvTransferee);
        this.btnSTPTransferee = (Button) findViewById(R.id.btnSTPTransferee);
        this.btnSTPTransferor = (Button) findViewById(R.id.btnSTPTransferor);
        this.beginTransferorList = (ArrayList) getIntent().getSerializableExtra("beginTransferorList");
        this.endTransferorList = (ArrayList) getIntent().getSerializableExtra("endTransferorList");
        this.interestTransferorList = (ArrayList) getIntent().getSerializableExtra("interestTransferorList");
        this.transferredInOrOutList = (ArrayList) getIntent().getSerializableExtra("transferredInOrOutList");
        this.beginTransfereeList = (ArrayList) getIntent().getSerializableExtra("beginTransfereeList");
        this.endTransfereeList = (ArrayList) getIntent().getSerializableExtra("endTransfereeList");
        this.interestTransfereeList = (ArrayList) getIntent().getSerializableExtra("interestTransfereeList");
        this.rcvTransferee.setVisibility(View.GONE);
        this.rcvTransferor.setVisibility(View.VISIBLE);
        this.btnSTPTransferor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STPDetailsActivity.this.rcvTransferee.setVisibility(View.GONE);
                STPDetailsActivity.this.rcvTransferor.setVisibility(View.VISIBLE);
                STPDetailsActivity.this.btnSTPTransferor.setBackgroundResource(R.drawable.borders_green);
                STPDetailsActivity.this.btnSTPTransferee.setBackgroundResource(R.drawable.background_basic_cal_gray);
            }
        });
        this.btnSTPTransferee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STPDetailsActivity.this.rcvTransferee.setVisibility(View.VISIBLE);
                STPDetailsActivity.this.rcvTransferor.setVisibility(View.GONE);
                STPDetailsActivity.this.btnSTPTransferee.setBackgroundResource(R.drawable.borders_green);
                STPDetailsActivity.this.btnSTPTransferor.setBackgroundResource(R.drawable.background_basic_cal_gray);
            }
        });
        this.transfereeAdapter = new MutualFundAndSIPAdapter(this.beginTransfereeList, this.endTransfereeList, this.interestTransfereeList, this.transferredInOrOutList);
        this.rcvTransferee.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.rcvTransferee.setAdapter(this.transfereeAdapter);
        this.transferorAdapter = new MutualFundAndSIPAdapter(this.beginTransferorList, this.endTransferorList, this.interestTransferorList, this.transferredInOrOutList);
        this.rcvTransferor.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.rcvTransferor.setAdapter(this.transferorAdapter);
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
