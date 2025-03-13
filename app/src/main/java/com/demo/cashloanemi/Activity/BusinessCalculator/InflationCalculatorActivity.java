package com.demo.cashloanemi.Activity.BusinessCalculator;

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

public class InflationCalculatorActivity extends AppCompatActivity {
    Button btnICCalculator;
    Button btnICHalfYearly;
    Button btnICMonthly;
    Button btnICQuarterly;
    Button btnICYearly;
    EditText edtICCurrentCost;
    EditText edtICInflationOfRate;
    EditText edtICTenure;
    ImageView imgClearICCurrentCost;
    ImageView imgClearICInflationOfRate;
    ImageView imgClearICTenure;
    double installment = 1.0d;
    LinearLayout llICCurrentCost;
    LinearLayout llICInflationOfRate;
    LinearLayout llICTenure;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtICFutureCost;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_inflation_calculator);


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
        this.edtICCurrentCost = (EditText) findViewById(R.id.edtICCurrentCost);
        this.imgClearICCurrentCost = (ImageView) findViewById(R.id.imgClearICCurrentCost);
        this.llICCurrentCost = (LinearLayout) findViewById(R.id.llICCurrentCost);
        this.edtICInflationOfRate = (EditText) findViewById(R.id.edtICInflationOfRate);
        this.imgClearICInflationOfRate = (ImageView) findViewById(R.id.imgClearICInflationOfRate);
        this.llICInflationOfRate = (LinearLayout) findViewById(R.id.llICInflationOfRate);
        this.edtICTenure = (EditText) findViewById(R.id.edtICTenure);
        this.imgClearICTenure = (ImageView) findViewById(R.id.imgClearICTenure);
        this.llICTenure = (LinearLayout) findViewById(R.id.llICTenure);
        this.btnICCalculator = (Button) findViewById(R.id.btnICCalculator);
        this.btnICQuarterly = (Button) findViewById(R.id.btnICQuarterly);
        this.btnICMonthly = (Button) findViewById(R.id.btnICMonthly);
        this.btnICYearly = (Button) findViewById(R.id.btnICYearly);
        this.btnICHalfYearly = (Button) findViewById(R.id.btnICHalfYearly);
        this.txtICFutureCost = (TextView) findViewById(R.id.txtICFutureCost);
        Util.textChangedListener(this.edtICCurrentCost, this.imgClearICCurrentCost, this.llICCurrentCost);
        Util.textChangedListener(this.edtICInflationOfRate, this.imgClearICInflationOfRate, this.llICInflationOfRate);
        Util.textChangedListener(this.edtICTenure, this.imgClearICTenure, this.llICTenure);
        this.btnICQuarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InflationCalculatorActivity.this.installment = 4.0d;
                InflationCalculatorActivity.this.btnICYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICQuarterly.setBackgroundResource(R.drawable.borders_green);
                InflationCalculatorActivity.this.btnICMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.inflationCalculator();
            }
        });
        this.btnICMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InflationCalculatorActivity.this.installment = 12.0d;
                InflationCalculatorActivity.this.btnICYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICMonthly.setBackgroundResource(R.drawable.borders_green);
                InflationCalculatorActivity.this.inflationCalculator();
            }
        });
        this.btnICYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InflationCalculatorActivity.this.installment = 1.0d;
                InflationCalculatorActivity.this.btnICYearly.setBackgroundResource(R.drawable.borders_green);
                InflationCalculatorActivity.this.btnICHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.inflationCalculator();
            }
        });
        this.btnICHalfYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InflationCalculatorActivity.this.installment = 2.0d;
                InflationCalculatorActivity.this.btnICYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICHalfYearly.setBackgroundResource(R.drawable.borders_green);
                InflationCalculatorActivity.this.btnICMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.btnICQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                InflationCalculatorActivity.this.inflationCalculator();
            }
        });
        this.btnICCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InflationCalculatorActivity.this.inflationCalculator();
            }
        });
    }


    public void inflationCalculator() {
        String obj = this.edtICTenure.getText().toString();
        String obj2 = this.edtICInflationOfRate.getText().toString();
        String obj3 = this.edtICCurrentCost.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (!((!Util.checkAmount(obj3, this.edtICCurrentCost)) | (!Util.checkPeriod30(Double.parseDouble(obj), this.edtICTenure))) && !(!Util.checkPercentage100(obj2, this.edtICInflationOfRate))) {
            double parseDouble = Double.parseDouble(obj2) / (this.installment * 100.0d);
            double parseDouble2 = Double.parseDouble(obj) * this.installment;
            double parseDouble3 = Double.parseDouble(obj3);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d) {
                this.txtICFutureCost.setText("");
                return;
            }
            double pow = parseDouble3 * Math.pow(parseDouble + 1.0d, parseDouble2);
            TextView textView = this.txtICFutureCost;
            textView.setText("" + Util.round(pow, 2));
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
