package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.YearWiseAdapter;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;

import java.util.ArrayList;

public class AddInvestmentDetailsActivity extends AppCompatActivity {
    YearWiseAdapter adapter;
    ArrayList<Long> balanceList;
    ArrayList<Long> interestList;
    ArrayList<Long> investmentList;
    PrefManager prefManager;
    RecyclerView rcvAddInvestment;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_investment_details);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        this.prefManager = new PrefManager(this);
        this.rcvAddInvestment = (RecyclerView) findViewById(R.id.rcvAddInvestment);
        this.interestList = (ArrayList) getIntent().getSerializableExtra("interestList");
        this.balanceList = (ArrayList) getIntent().getSerializableExtra("balanceList");
        this.investmentList = (ArrayList) getIntent().getSerializableExtra("investmentList");
        this.adapter = new YearWiseAdapter(this.investmentList, this.interestList, this.balanceList);
        this.rcvAddInvestment.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.rcvAddInvestment.setAdapter(this.adapter);
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
