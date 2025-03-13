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

public class BreakEventPointCalculatorActivity extends AppCompatActivity {
    Button btnBEPCalculator;
    Button btnBEPPrice;
    Button btnBEPUnit;
    EditText edtBEPFixedCost;
    EditText edtBEPSellingPrice;
    EditText edtBEPUnit;
    EditText edtBEPVariableCost;
    ImageView imgClearBEPFixedCost;
    ImageView imgClearBEPSellingPrice;
    ImageView imgClearBEPUnit;
    ImageView imgClearBEPVariableCost;
    boolean isUnits = true;
    LinearLayout llBEPFixedCost;
    LinearLayout llBEPPriceOutPut;
    LinearLayout llBEPSellingPrice;
    LinearLayout llBEPUnit;
    LinearLayout llBEPUnitOutPut;
    LinearLayout llBEPVariableCost;
    LinearLayout llSellingPrice;
    LinearLayout llUnit;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtBEPPrice;
    TextView txtBEPUnit;




    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_break_event_point_calculator);


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
        this.edtBEPFixedCost = (EditText) findViewById(R.id.edtBEPFixedCost);
        this.imgClearBEPFixedCost = (ImageView) findViewById(R.id.imgClearBEPFixedCost);
        this.llBEPFixedCost = (LinearLayout) findViewById(R.id.llBEPFixedCost);
        this.edtBEPSellingPrice = (EditText) findViewById(R.id.edtBEPSellingPrice);
        this.imgClearBEPSellingPrice = (ImageView) findViewById(R.id.imgClearBEPSellingPrice);
        this.llBEPSellingPrice = (LinearLayout) findViewById(R.id.llBEPSellingPrice);
        this.edtBEPUnit = (EditText) findViewById(R.id.edtBEPUnit);
        this.imgClearBEPUnit = (ImageView) findViewById(R.id.imgClearBEPUnit);
        this.llBEPUnit = (LinearLayout) findViewById(R.id.llBEPUnit);
        this.edtBEPVariableCost = (EditText) findViewById(R.id.edtBEPVariableCost);
        this.imgClearBEPVariableCost = (ImageView) findViewById(R.id.imgClearBEPVariableCost);
        this.llBEPVariableCost = (LinearLayout) findViewById(R.id.llBEPVariableCost);
        this.btnBEPUnit = (Button) findViewById(R.id.btnBEPUnit);
        this.btnBEPPrice = (Button) findViewById(R.id.btnBEPPrice);
        this.btnBEPCalculator = (Button) findViewById(R.id.btnBEPCalculator);
        this.txtBEPUnit = (TextView) findViewById(R.id.txtBEPUnit);
        this.txtBEPPrice = (TextView) findViewById(R.id.txtBEPPrice);
        this.llBEPPriceOutPut = (LinearLayout) findViewById(R.id.llBEPPriceOutPut);
        this.llSellingPrice = (LinearLayout) findViewById(R.id.llSellingPrice);
        this.llUnit = (LinearLayout) findViewById(R.id.llUnit);
        this.llBEPUnitOutPut = (LinearLayout) findViewById(R.id.llBEPUnitOutPut);
        Util.textChangedListener(this.edtBEPFixedCost, this.imgClearBEPFixedCost, this.llBEPFixedCost);
        Util.textChangedListener(this.edtBEPSellingPrice, this.imgClearBEPSellingPrice, this.llBEPSellingPrice);
        Util.textChangedListener(this.edtBEPUnit, this.imgClearBEPUnit, this.llBEPUnit);
        Util.textChangedListener(this.edtBEPVariableCost, this.imgClearBEPVariableCost, this.llBEPVariableCost);
        this.btnBEPPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreakEventPointCalculatorActivity.this.isUnits = false;
                BreakEventPointCalculatorActivity.this.btnBEPPrice.setBackgroundResource(R.drawable.borders_green);
                BreakEventPointCalculatorActivity.this.btnBEPUnit.setBackgroundResource(R.drawable.background_basic_cal_gray);
                BreakEventPointCalculatorActivity.this.llSellingPrice.setVisibility(View.GONE);
                BreakEventPointCalculatorActivity.this.llUnit.setVisibility(View.VISIBLE);
                BreakEventPointCalculatorActivity.this.llBEPUnitOutPut.setVisibility(View.GONE);
                BreakEventPointCalculatorActivity.this.llBEPPriceOutPut.setVisibility(View.VISIBLE);
                BreakEventPointCalculatorActivity.this.BEPCalculator();
            }
        });
        this.btnBEPUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreakEventPointCalculatorActivity.this.isUnits = true;
                BreakEventPointCalculatorActivity.this.btnBEPUnit.setBackgroundResource(R.drawable.borders_green);
                BreakEventPointCalculatorActivity.this.btnBEPPrice.setBackgroundResource(R.drawable.background_basic_cal_gray);
                BreakEventPointCalculatorActivity.this.llSellingPrice.setVisibility(View.VISIBLE);
                BreakEventPointCalculatorActivity.this.llUnit.setVisibility(View.GONE);
                BreakEventPointCalculatorActivity.this.llBEPUnitOutPut.setVisibility(View.VISIBLE);
                BreakEventPointCalculatorActivity.this.llBEPPriceOutPut.setVisibility(View.GONE);
                BreakEventPointCalculatorActivity.this.BEPCalculator();
            }
        });
        this.btnBEPCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreakEventPointCalculatorActivity.this.BEPCalculator();
            }
        });
    }

    
    public void BEPCalculator() {
        String obj = this.edtBEPFixedCost.getText().toString();
        String obj2 = this.edtBEPSellingPrice.getText().toString();
        String obj3 = this.edtBEPVariableCost.getText().toString();
        String obj4 = this.edtBEPUnit.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty()) {
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
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (this.isUnits) {
            if (!((!Util.checkAmount(obj, this.edtBEPFixedCost)) | (!Util.checkAmount(obj2, this.edtBEPSellingPrice))) && !(!Util.checkAmount(obj3, this.edtBEPVariableCost))) {
                double parseDouble = Double.parseDouble(obj);
                double parseDouble2 = Double.parseDouble(obj2);
                double parseDouble3 = Double.parseDouble(obj3);
                if (parseDouble == 0.0d || parseDouble3 == 0.0d || parseDouble2 == 0.0d) {
                    this.txtBEPUnit.setText("");
                    return;
                }
                double d = parseDouble / (parseDouble2 - parseDouble3);
                TextView textView = this.txtBEPUnit;
                textView.setText("" + Util.round(Math.abs(d), 2));
            }
        } else if (!((!Util.checkAmount(obj, this.edtBEPFixedCost)) | (!Util.checkAmount(obj4, this.edtBEPUnit))) && !(!Util.checkAmount(obj3, this.edtBEPVariableCost))) {
            double parseDouble4 = Double.parseDouble(obj);
            double parseDouble5 = Double.parseDouble(obj3);
            double parseDouble6 = Double.parseDouble(obj4);
            if (parseDouble4 == 0.0d || parseDouble5 == 0.0d || parseDouble6 == 0.0d) {
                this.txtBEPPrice.setText("");
                return;
            }
            TextView textView2 = this.txtBEPPrice;
            textView2.setText("" + Util.round((-(parseDouble4 / parseDouble6)) + parseDouble5, 2));
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
