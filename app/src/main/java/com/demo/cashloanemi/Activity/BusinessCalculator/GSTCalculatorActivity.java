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

public class GSTCalculatorActivity extends AppCompatActivity {
    Button btnGST025;
    Button btnGST12;
    Button btnGST18;
    Button btnGST28;
    Button btnGST3;
    Button btnGST5;
    Button btnGSTCalculator;
    Button btnGSTExcluding;
    Button btnGSTIncluding;
    EditText edtGSTCost;
    ImageView imgClearGSTCost;
    boolean isGSTIncluding = true;
    LinearLayout llGSTCost;
    PrefManager prefManager;
    double rate = 0.25d;
    Toolbar toolbar;
    TextView txtGSTAmount;
    TextView txtGSTNetAmount;
    TextView txtGSTTotalAmount;




    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gstcalculator);


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
        this.edtGSTCost = (EditText) findViewById(R.id.edtGSTCost);
        this.imgClearGSTCost = (ImageView) findViewById(R.id.imgClearGSTCost);
        this.llGSTCost = (LinearLayout) findViewById(R.id.llGSTCost);
        this.btnGSTCalculator = (Button) findViewById(R.id.btnGSTCalculator);
        this.btnGST025 = (Button) findViewById(R.id.btnGST025);
        this.btnGST3 = (Button) findViewById(R.id.btnGST3);
        this.btnGST5 = (Button) findViewById(R.id.btnGST5);
        this.btnGST12 = (Button) findViewById(R.id.btnGST12);
        this.btnGST18 = (Button) findViewById(R.id.btnGST18);
        this.btnGST28 = (Button) findViewById(R.id.btnGST28);
        this.btnGSTIncluding = (Button) findViewById(R.id.btnGSTIncluding);
        this.btnGSTExcluding = (Button) findViewById(R.id.btnGSTExcluding);
        this.txtGSTNetAmount = (TextView) findViewById(R.id.txtGSTNetAmount);
        this.txtGSTAmount = (TextView) findViewById(R.id.txtGSTAmount);
        this.txtGSTTotalAmount = (TextView) findViewById(R.id.txtGSTTotalAmount);
        Util.textChangedListener(this.edtGSTCost, this.imgClearGSTCost, this.llGSTCost);
        this.btnGSTExcluding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.isGSTIncluding = false;
                GSTCalculatorActivity.this.btnGSTExcluding.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGSTIncluding.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGSTIncluding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.isGSTIncluding = true;
                GSTCalculatorActivity.this.btnGSTIncluding.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGSTExcluding.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST025.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 0.25d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 3.0d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 5.0d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 12.0d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 18.0d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.rate = 28.0d;
                GSTCalculatorActivity.this.btnGST025.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST3.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST5.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST12.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST18.setBackgroundResource(R.drawable.background_basic_cal_gray);
                GSTCalculatorActivity.this.btnGST28.setBackgroundResource(R.drawable.borders_green);
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
        this.btnGST025.setBackgroundResource(R.drawable.borders_green);
        this.btnGSTCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSTCalculatorActivity.this.GSTTaxCalculator();
            }
        });
    }


    public void GSTTaxCalculator() {
        String obj = this.edtGSTCost.getText().toString();
        if (obj.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (Util.checkAmount(obj, this.edtGSTCost)) {
            double parseDouble = Double.parseDouble(obj);
            if (this.isGSTIncluding) {
                double d = (this.rate / 100.0d) * parseDouble;
                TextView textView = this.txtGSTAmount;
                textView.setText(Util.round(d, 2) + "");
                TextView textView2 = this.txtGSTNetAmount;
                textView2.setText("" + Util.round(parseDouble, 2));
                TextView textView3 = this.txtGSTTotalAmount;
                textView3.setText("" + Util.round(parseDouble + d, 2));
                return;
            }
            double d2 = parseDouble - ((100.0d / (this.rate + 100.0d)) * parseDouble);
            TextView textView4 = this.txtGSTAmount;
            textView4.setText(Util.round(d2, 2) + "");
            TextView textView5 = this.txtGSTNetAmount;
            textView5.setText("" + Util.round(parseDouble - d2, 2));
            TextView textView6 = this.txtGSTTotalAmount;
            textView6.setText("" + Util.round(parseDouble, 2));
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
