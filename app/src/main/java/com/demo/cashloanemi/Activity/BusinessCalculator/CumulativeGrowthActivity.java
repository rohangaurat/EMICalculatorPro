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

public class CumulativeGrowthActivity extends AppCompatActivity {
    Button btnCGCCalculator;
    Button btnCGCFinalValue;
    Button btnCGCHalfYearly;
    Button btnCGCMonthly;
    Button btnCGCQuarterly;
    Button btnCGCRate;
    Button btnCGCYearly;
    EditText edtCGCFinalValue;
    EditText edtCGCGrowthRate;
    EditText edtCGCInitialValue;
    EditText edtCGCTenure;
    ImageView imgClearCGCFinalValue;
    ImageView imgClearCGCGrowthRate;
    ImageView imgClearCGCInitialValue;
    ImageView imgClearCGCTenure;
    double installment = 1.0d;
    boolean isFinalValue = true;
    LinearLayout llCGCFinalValue;
    LinearLayout llCGCFinalValueOutPut;
    LinearLayout llCGCGrowthRate;
    LinearLayout llCGCGrowthRateOutPut;
    LinearLayout llCGCInitialValue;
    LinearLayout llCGCTenure;
    LinearLayout llFinalValue;
    LinearLayout llGrowthRate;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtCGCFinalValue;
    TextView txtCGCRate;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cumulative_growth);


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
        this.edtCGCInitialValue = (EditText) findViewById(R.id.edtCGCInitialValue);
        this.imgClearCGCInitialValue = (ImageView) findViewById(R.id.imgClearCGCInitialValue);
        this.llCGCInitialValue = (LinearLayout) findViewById(R.id.llCGCInitialValue);
        this.edtCGCGrowthRate = (EditText) findViewById(R.id.edtCGCGrowthRate);
        this.imgClearCGCGrowthRate = (ImageView) findViewById(R.id.imgClearCGCGrowthRate);
        this.llCGCGrowthRate = (LinearLayout) findViewById(R.id.llCGCGrowthRate);
        this.edtCGCFinalValue = (EditText) findViewById(R.id.edtCGCFinalValue);
        this.imgClearCGCFinalValue = (ImageView) findViewById(R.id.imgClearCGCFinalValue);
        this.llCGCFinalValue = (LinearLayout) findViewById(R.id.llCGCFinalValue);
        this.edtCGCTenure = (EditText) findViewById(R.id.edtCGCTenure);
        this.imgClearCGCTenure = (ImageView) findViewById(R.id.imgClearCGCTenure);
        this.llCGCTenure = (LinearLayout) findViewById(R.id.llCGCTenure);
        this.btnCGCFinalValue = (Button) findViewById(R.id.btnCGCFinalValue);
        this.btnCGCRate = (Button) findViewById(R.id.btnCGCRate);
        this.btnCGCCalculator = (Button) findViewById(R.id.btnCGCCalculator);
        this.txtCGCFinalValue = (TextView) findViewById(R.id.txtCGCFinalValue);
        this.txtCGCRate = (TextView) findViewById(R.id.txtCGCRate);
        this.llCGCGrowthRateOutPut = (LinearLayout) findViewById(R.id.llCGCGrowthRateOutPut);
        this.llGrowthRate = (LinearLayout) findViewById(R.id.llGrowthRate);
        this.llFinalValue = (LinearLayout) findViewById(R.id.llFinalValue);
        this.llCGCFinalValueOutPut = (LinearLayout) findViewById(R.id.llCGCFinalValueOutPut);
        this.btnCGCQuarterly = (Button) findViewById(R.id.btnCGCQuarterly);
        this.btnCGCMonthly = (Button) findViewById(R.id.btnCGCMonthly);
        this.btnCGCYearly = (Button) findViewById(R.id.btnCGCYearly);
        this.btnCGCHalfYearly = (Button) findViewById(R.id.btnCGCHalfYearly);
        Util.textChangedListener(this.edtCGCInitialValue, this.imgClearCGCInitialValue, this.llCGCInitialValue);
        Util.textChangedListener(this.edtCGCGrowthRate, this.imgClearCGCGrowthRate, this.llCGCGrowthRate);
        Util.textChangedListener(this.edtCGCFinalValue, this.imgClearCGCFinalValue, this.llCGCFinalValue);
        Util.textChangedListener(this.edtCGCTenure, this.imgClearCGCTenure, this.llCGCTenure);
        this.btnCGCRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.isFinalValue = false;
                CumulativeGrowthActivity.this.btnCGCRate.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCFinalValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.llGrowthRate.setVisibility(View.GONE);
                CumulativeGrowthActivity.this.llFinalValue.setVisibility(View.VISIBLE);
                CumulativeGrowthActivity.this.llCGCFinalValueOutPut.setVisibility(View.GONE);
                CumulativeGrowthActivity.this.llCGCGrowthRateOutPut.setVisibility(View.VISIBLE);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCFinalValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.isFinalValue = true;
                CumulativeGrowthActivity.this.btnCGCFinalValue.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCRate.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.llGrowthRate.setVisibility(View.VISIBLE);
                CumulativeGrowthActivity.this.llFinalValue.setVisibility(View.GONE);
                CumulativeGrowthActivity.this.llCGCFinalValueOutPut.setVisibility(View.VISIBLE);
                CumulativeGrowthActivity.this.llCGCGrowthRateOutPut.setVisibility(View.GONE);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCQuarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.installment = 4.0d;
                CumulativeGrowthActivity.this.btnCGCQuarterly.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.installment = 12.0d;
                CumulativeGrowthActivity.this.btnCGCMonthly.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.installment = 1.0d;
                CumulativeGrowthActivity.this.btnCGCYearly.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
        this.btnCGCHalfYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CumulativeGrowthActivity.this.installment = 6.0d;
                CumulativeGrowthActivity.this.btnCGCHalfYearly.setBackgroundResource(R.drawable.borders_green);
                CumulativeGrowthActivity.this.btnCGCMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.btnCGCYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CumulativeGrowthActivity.this.CAGRCalculator();
            }
        });
    }


    public void CAGRCalculator() {
        String obj = this.edtCGCFinalValue.getText().toString();
        String obj2 = this.edtCGCGrowthRate.getText().toString();
        String obj3 = this.edtCGCInitialValue.getText().toString();
        String obj4 = this.edtCGCTenure.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (this.isFinalValue) {
            if (!((!Util.checkAmount(obj3, this.edtCGCInitialValue)) | (!Util.checkPeriod30(Double.parseDouble(obj4), this.edtCGCTenure))) && !(!Util.checkPercentage50(obj2, this.edtCGCGrowthRate))) {
                double parseDouble = Double.parseDouble(obj2);
                double parseDouble2 = Double.parseDouble(obj4);
                double parseDouble3 = Double.parseDouble(obj3);
                if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d) {
                    this.txtCGCFinalValue.setText("");
                    return;
                }
                double d = this.installment;
                double pow = parseDouble3 * Math.pow((parseDouble / (100.0d * d)) + 1.0d, parseDouble2 * d);
                TextView textView = this.txtCGCFinalValue;
                textView.setText("" + Util.round(pow, 2));
            }
        } else if (!((!Util.checkAmount(obj3, this.edtCGCInitialValue)) | (!Util.checkPeriod30(Double.parseDouble(obj4), this.edtCGCTenure))) && !(!Util.checkEmpty(obj, this.edtCGCFinalValue))) {
            double parseDouble4 = Double.parseDouble(obj);
            double parseDouble5 = Double.parseDouble(obj4);
            double parseDouble6 = Double.parseDouble(obj3);
            if (parseDouble4 == 0.0d || parseDouble5 == 0.0d || parseDouble6 == 0.0d) {
                this.txtCGCRate.setText("");
                return;
            }
            double d2 = this.installment;
            TextView textView2 = this.txtCGCRate;
            textView2.setText("" + Util.round(Math.pow(parseDouble4 / parseDouble6, 1.0d / ((parseDouble5 * d2) * d2)) - 1.0d, 2));
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
