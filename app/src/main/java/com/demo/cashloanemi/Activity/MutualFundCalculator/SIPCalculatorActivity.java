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

public class SIPCalculatorActivity extends AppCompatActivity {
    Button btnSIPCCalculator;
    Button btnSIPCLumpSum;
    Button btnSIPCMonthly;
    EditText edtSIPCGrowthRate;
    EditText edtSIPCInitialValue;
    EditText edtSIPCTenure;
    ImageView imgClearSIPCGrowthRate;
    ImageView imgClearSIPCInitialValue;
    ImageView imgClearSIPCTenure;
    boolean isSIP = true;
    LinearLayout llSIPCGrowthRate;
    LinearLayout llSIPCInitialValue;
    LinearLayout llSIPCTenure;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtSIPCEstReturns;
    TextView txtSIPCInvestedAmount;
    TextView txtSIPCTotalValue;




    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sipcalculator);


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
        this.edtSIPCInitialValue = (EditText) findViewById(R.id.edtSIPCInitialValue);
        this.imgClearSIPCInitialValue = (ImageView) findViewById(R.id.imgClearSIPCInitialValue);
        this.llSIPCInitialValue = (LinearLayout) findViewById(R.id.llSIPCInitialValue);
        this.edtSIPCGrowthRate = (EditText) findViewById(R.id.edtSIPCGrowthRate);
        this.imgClearSIPCGrowthRate = (ImageView) findViewById(R.id.imgClearSIPCGrowthRate);
        this.llSIPCGrowthRate = (LinearLayout) findViewById(R.id.llSIPCGrowthRate);
        this.edtSIPCTenure = (EditText) findViewById(R.id.edtSIPCTenure);
        this.imgClearSIPCTenure = (ImageView) findViewById(R.id.imgClearSIPCTenure);
        this.llSIPCTenure = (LinearLayout) findViewById(R.id.llSIPCTenure);
        this.btnSIPCCalculator = (Button) findViewById(R.id.btnSIPCCalculator);
        this.btnSIPCMonthly = (Button) findViewById(R.id.btnSIPCMonthly);
        this.btnSIPCLumpSum = (Button) findViewById(R.id.btnSIPCLumpSum);
        this.txtSIPCTotalValue = (TextView) findViewById(R.id.txtSIPCTotalValue);
        this.txtSIPCEstReturns = (TextView) findViewById(R.id.txtSIPCEstReturns);
        this.txtSIPCInvestedAmount = (TextView) findViewById(R.id.txtSIPCInvestedAmount);
        Util.textChangedListener(this.edtSIPCInitialValue, this.imgClearSIPCInitialValue, this.llSIPCInitialValue);
        Util.textChangedListener(this.edtSIPCGrowthRate, this.imgClearSIPCGrowthRate, this.llSIPCGrowthRate);
        Util.textChangedListener(this.edtSIPCTenure, this.imgClearSIPCTenure, this.llSIPCTenure);
        this.btnSIPCMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SIPCalculatorActivity.this.isSIP = true;
                SIPCalculatorActivity.this.btnSIPCLumpSum.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SIPCalculatorActivity.this.btnSIPCMonthly.setBackgroundResource(R.drawable.borders_green);
                SIPCalculatorActivity.this.SIPCalculator();
            }
        });
        this.btnSIPCLumpSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SIPCalculatorActivity.this.isSIP = false;
                SIPCalculatorActivity.this.btnSIPCMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SIPCalculatorActivity.this.btnSIPCLumpSum.setBackgroundResource(R.drawable.borders_green);
                SIPCalculatorActivity.this.SIPCalculator();
            }
        });
        this.btnSIPCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SIPCalculatorActivity.this.SIPCalculator();
            }
        });
    }

    
    public void SIPCalculator() {
        String obj = this.edtSIPCInitialValue.getText().toString();
        String obj2 = this.edtSIPCGrowthRate.getText().toString();
        String obj3 = this.edtSIPCTenure.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
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
        if (!((!Util.checkAmount(obj, this.edtSIPCInitialValue)) | (!Util.checkPercentage100(obj2, this.edtSIPCGrowthRate))) && !(!Util.checkPeriod30(Double.parseDouble(obj3), this.edtSIPCTenure))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            double parseDouble3 = Double.parseDouble(obj3);
            if (parseDouble == 0.0d || parseDouble3 == 0.0d || parseDouble2 == 0.0d) {
                this.txtSIPCEstReturns.setText("");
                this.txtSIPCTotalValue.setText("");
                this.txtSIPCInvestedAmount.setText("");
            } else if (this.isSIP) {
                double d = parseDouble2 / 1200.0d;
                double d2 = parseDouble3 * 12.0d;
                double d3 = parseDouble * d2;
                double d4 = d + 1.0d;
                double pow = parseDouble * ((Math.pow(d4, d2) - 1.0d) / d) * d4;
                TextView textView = this.txtSIPCEstReturns;
                textView.setText(Util.round(Math.abs(d3 - pow), 2) + "");
                TextView textView2 = this.txtSIPCTotalValue;
                textView2.setText(Util.round(pow, 2) + "");
                TextView textView3 = this.txtSIPCInvestedAmount;
                textView3.setText(Util.round(d3, 2) + "");
            } else {
                double pow2 = Math.pow((parseDouble2 / 100.0d) + 1.0d, parseDouble3) * parseDouble;
                TextView textView4 = this.txtSIPCEstReturns;
                textView4.setText(Util.round(Math.abs(pow2 - parseDouble), 2) + "");
                TextView textView5 = this.txtSIPCTotalValue;
                textView5.setText(Util.round(pow2, 2) + "");
                TextView textView6 = this.txtSIPCInvestedAmount;
                textView6.setText(Util.round(parseDouble, 2) + "");
            }
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
