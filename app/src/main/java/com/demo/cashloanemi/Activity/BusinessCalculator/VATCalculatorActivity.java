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

public class VATCalculatorActivity extends AppCompatActivity {
    Button btnVATCalculator;
    Button btnVATExcluding;
    Button btnVATIncluding;
    EditText edtVATNetPrice;
    EditText edtVATRate;
    ImageView imgClearVATNetPrice;
    ImageView imgClearVATRate;
    boolean isVATIncluding = true;
    LinearLayout llVATNetPrice;
    LinearLayout llVATRate;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtVATGrossPrice;
    TextView txtVATTaxAmount;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vatcalculator);


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
        this.edtVATNetPrice = (EditText) findViewById(R.id.edtVATNetPrice);
        this.imgClearVATNetPrice = (ImageView) findViewById(R.id.imgClearVATNetPrice);
        this.llVATNetPrice = (LinearLayout) findViewById(R.id.llVATNetPrice);
        this.edtVATRate = (EditText) findViewById(R.id.edtVATRate);
        this.imgClearVATRate = (ImageView) findViewById(R.id.imgClearVATRate);
        this.llVATRate = (LinearLayout) findViewById(R.id.llVATRate);
        this.btnVATIncluding = (Button) findViewById(R.id.btnVATIncluding);
        this.btnVATExcluding = (Button) findViewById(R.id.btnVATExcluding);
        this.btnVATCalculator = (Button) findViewById(R.id.btnVATCalculator);
        this.txtVATTaxAmount = (TextView) findViewById(R.id.txtVATTaxAmount);
        this.txtVATGrossPrice = (TextView) findViewById(R.id.txtVATGrossPrice);
        Util.textChangedListener(this.edtVATNetPrice, this.imgClearVATNetPrice, this.llVATNetPrice);
        Util.textChangedListener(this.edtVATRate, this.imgClearVATRate, this.llVATRate);
        this.btnVATExcluding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VATCalculatorActivity.this.isVATIncluding = false;
                VATCalculatorActivity.this.btnVATExcluding.setBackgroundResource(R.drawable.borders_green);
                VATCalculatorActivity.this.btnVATIncluding.setBackgroundResource(R.drawable.background_basic_cal_gray);
                VATCalculatorActivity.this.VATCalculator();
            }
        });
        this.btnVATIncluding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VATCalculatorActivity.this.isVATIncluding = true;
                VATCalculatorActivity.this.btnVATExcluding.setBackgroundResource(R.drawable.background_basic_cal_gray);
                VATCalculatorActivity.this.btnVATIncluding.setBackgroundResource(R.drawable.borders_green);
                VATCalculatorActivity.this.VATCalculator();
            }
        });
        this.btnVATCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VATCalculatorActivity.this.VATCalculator();
            }
        });
    }

    
    public void VATCalculator() {
        String obj = this.edtVATRate.getText().toString();
        String obj2 = this.edtVATNetPrice.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!(!Util.checkPercentage100(obj, this.edtVATRate)) && !(!Util.checkAmount(obj2, this.edtVATNetPrice))) {
            double parseDouble = Double.parseDouble(obj2);
            double parseDouble2 = Double.parseDouble(obj);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtVATGrossPrice.setText("");
                this.txtVATTaxAmount.setText("");
            } else if (this.isVATIncluding) {
                double d = (parseDouble2 / 100.0d) * parseDouble;
                TextView textView = this.txtVATGrossPrice;
                textView.setText("" + Util.round(parseDouble + d, 2));
                TextView textView2 = this.txtVATTaxAmount;
                textView2.setText("" + Util.round(d, 2));
            } else {
                double d2 = parseDouble - ((100.0d / (parseDouble2 + 100.0d)) * parseDouble);
                TextView textView3 = this.txtVATTaxAmount;
                textView3.setText("" + Util.round(d2, 2));
                TextView textView4 = this.txtVATGrossPrice;
                textView4.setText("" + Util.round(parseDouble - d2, 2));
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
