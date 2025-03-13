package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

public class SIPPlanCalculatorActivity extends AppCompatActivity {
    Button btnSIPPCalculator;
    EditText edtSIPPGoalAmount;
    EditText edtSIPPReturnRate;
    EditText edtSIPPTenure;
    ImageView imgClearSIPPGoalAmount;
    ImageView imgClearSIPPReturnRate;
    ImageView imgClearSIPPTenure;
    LinearLayout llSIPPGoalAmount;
    LinearLayout llSIPPReturnRate;
    LinearLayout llSIPPTenure;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtSIPPInvestedAmount;
    TextView txtSIPPSIPAmount;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sip_plan_calculator);


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
        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.edtSIPPGoalAmount = (EditText) findViewById(R.id.edtSIPPGoalAmount);
        this.imgClearSIPPGoalAmount = (ImageView) findViewById(R.id.imgClearSIPPGoalAmount);
        this.llSIPPGoalAmount = (LinearLayout) findViewById(R.id.llSIPPGoalAmount);
        this.edtSIPPReturnRate = (EditText) findViewById(R.id.edtSIPPReturnRate);
        this.imgClearSIPPReturnRate = (ImageView) findViewById(R.id.imgClearSIPPReturnRate);
        this.llSIPPReturnRate = (LinearLayout) findViewById(R.id.llSIPPReturnRate);
        this.edtSIPPTenure = (EditText) findViewById(R.id.edtSIPPTenure);
        this.imgClearSIPPTenure = (ImageView) findViewById(R.id.imgClearSIPPTenure);
        this.llSIPPTenure = (LinearLayout) findViewById(R.id.llSIPPTenure);
        this.btnSIPPCalculator = (Button) findViewById(R.id.btnSIPPCalculator);
        this.txtSIPPInvestedAmount = (TextView) findViewById(R.id.txtSIPPInvestedAmount);
        this.txtSIPPSIPAmount = (TextView) findViewById(R.id.txtSIPPSIPAmount);
        Util.textChangedListener(this.edtSIPPGoalAmount, this.imgClearSIPPGoalAmount, this.llSIPPGoalAmount);
        Util.textChangedListener(this.edtSIPPReturnRate, this.imgClearSIPPReturnRate, this.llSIPPReturnRate);
        Util.textChangedListener(this.edtSIPPTenure, this.imgClearSIPPTenure, this.llSIPPTenure);
        this.btnSIPPCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SIPPlanCalculatorActivity.this.SIPCalculator();
            }
        });
    }

    
    public void SIPCalculator() {
        String obj = this.edtSIPPGoalAmount.getText().toString();
        String obj2 = this.edtSIPPReturnRate.getText().toString();
        String obj3 = this.edtSIPPTenure.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", Toast.LENGTH_SHORT).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (!((!Util.checkAmount(obj, this.edtSIPPGoalAmount)) | (!Util.checkPercentage100(obj2, this.edtSIPPReturnRate))) && !(!Util.checkPeriod30(Double.parseDouble(obj3), this.edtSIPPTenure))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            double parseDouble3 = Double.parseDouble(obj3);
            if (parseDouble2 == 0.0d || parseDouble3 == 0.0d || parseDouble == 0.0d) {
                this.txtSIPPSIPAmount.setText("");
                this.txtSIPPInvestedAmount.setText("");
                return;
            }
            double d = parseDouble2 / 1200.0d;
            double d2 = parseDouble3 * 12.0d;
            double d3 = d + 1.0d;
            double pow = parseDouble / (((Math.pow(d3, d2) - 1.0d) / d) * d3);
            TextView textView = this.txtSIPPSIPAmount;
            textView.setText(Util.round(pow, 2) + "");
            TextView textView2 = this.txtSIPPInvestedAmount;
            textView2.setText(Util.round(d2 * pow, 2) + "");
        }
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
