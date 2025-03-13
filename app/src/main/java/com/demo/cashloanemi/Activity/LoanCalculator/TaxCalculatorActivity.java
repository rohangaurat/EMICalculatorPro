package com.demo.cashloanemi.Activity.LoanCalculator;

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

public class TaxCalculatorActivity extends AppCompatActivity {
    Button btnTAXAdd;
    Button btnTAXCalculator;
    Button btnTAXRemoved;
    EditText edtTAXCost;
    EditText edtTAXRate;
    ImageView imgClearTAXCost;
    ImageView imgClearTAXRate;
    boolean isTAXAdd = true;
    LinearLayout llTAXCost;
    LinearLayout llTAXRate;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtTAXAmount;
    TextView txtTAXNetAmount;
    TextView txtTAXTotalAmount;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tax_calculator);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.edtTAXCost = (EditText) findViewById(R.id.edtTAXCost);
        this.imgClearTAXCost = (ImageView) findViewById(R.id.imgClearTAXCost);
        this.llTAXCost = (LinearLayout) findViewById(R.id.llTAXCost);
        this.edtTAXRate = (EditText) findViewById(R.id.edtTAXRate);
        this.imgClearTAXRate = (ImageView) findViewById(R.id.imgClearTAXRate);
        this.llTAXRate = (LinearLayout) findViewById(R.id.llTAXRate);
        this.btnTAXAdd = (Button) findViewById(R.id.btnTAXAdd);
        this.btnTAXRemoved = (Button) findViewById(R.id.btnTAXRemoved);
        this.btnTAXCalculator = (Button) findViewById(R.id.btnTAXCalculator);
        this.txtTAXNetAmount = (TextView) findViewById(R.id.txtTAXNetAmount);
        this.txtTAXAmount = (TextView) findViewById(R.id.txtTAXAmount);
        this.txtTAXTotalAmount = (TextView) findViewById(R.id.txtTAXTotalAmount);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Util.textChangedListener(this.edtTAXCost, this.imgClearTAXCost, this.llTAXCost);
        Util.textChangedListener(this.edtTAXRate, this.imgClearTAXRate, this.llTAXRate);
        this.btnTAXRemoved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaxCalculatorActivity.this.isTAXAdd = false;
                TaxCalculatorActivity.this.btnTAXRemoved.setBackgroundResource(R.drawable.borders_green);
                TaxCalculatorActivity.this.btnTAXAdd.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TaxCalculatorActivity.this.TAXCalculator();
            }
        });
        this.btnTAXAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaxCalculatorActivity.this.isTAXAdd = true;
                TaxCalculatorActivity.this.btnTAXRemoved.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TaxCalculatorActivity.this.btnTAXAdd.setBackgroundResource(R.drawable.borders_green);
                TaxCalculatorActivity.this.TAXCalculator();
            }
        });
        this.btnTAXCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaxCalculatorActivity.this.TAXCalculator();
            }
        });
    }

    
    public void TAXCalculator() {
        String obj = this.edtTAXCost.getText().toString();
        String obj2 = this.edtTAXRate.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!(!Util.checkPercentage100(obj2, this.edtTAXRate)) && !(!Util.checkAmount(obj, this.edtTAXCost))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtTAXNetAmount.setText("");
                this.txtTAXAmount.setText("");
                this.txtTAXTotalAmount.setText("");
            } else if (this.isTAXAdd) {
                double d = (parseDouble2 / 100.0d) * parseDouble;
                TextView textView = this.txtTAXNetAmount;
                textView.setText("" + Util.round(parseDouble, 2));
                TextView textView2 = this.txtTAXAmount;
                textView2.setText("" + Util.round(d, 2));
                TextView textView3 = this.txtTAXTotalAmount;
                textView3.setText("" + Util.round(parseDouble + d, 2));
            } else {
                double d2 = parseDouble - ((100.0d / (parseDouble2 + 100.0d)) * parseDouble);
                TextView textView4 = this.txtTAXNetAmount;
                textView4.setText("" + Util.round(parseDouble - d2, 2));
                TextView textView5 = this.txtTAXAmount;
                textView5.setText("" + Util.round(d2, 2));
                TextView textView6 = this.txtTAXTotalAmount;
                textView6.setText("" + Util.round(parseDouble, 2));
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
