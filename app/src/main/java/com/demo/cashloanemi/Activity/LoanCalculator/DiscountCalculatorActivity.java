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

import java.text.DecimalFormat;

public class DiscountCalculatorActivity extends AppCompatActivity {
    Button btnDCCalculator;
    EditText edtDCAdditionalDiscount;
    EditText edtDCDiscount;
    EditText edtDCPrice;
    EditText edtDCTax;
    ImageView imgClearDCAdditionalDiscount;
    ImageView imgClearDCDiscount;
    ImageView imgClearDCPrice;
    ImageView imgClearDCTax;
    LinearLayout llDCAdditionalDiscount;
    LinearLayout llDCDiscount;
    LinearLayout llDCPrice;
    LinearLayout llDCTax;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtDCAdditionalDiscount;
    TextView txtDCDiscount;
    TextView txtDCSavingPrice;
    TextView txtDCTotalPrice;
    TextView txtDCTotalTaxAmount;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_discount_calculator);


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
        this.edtDCPrice = (EditText) findViewById(R.id.edtDCPrice);
        this.imgClearDCPrice = (ImageView) findViewById(R.id.imgClearDCPrice);
        this.llDCPrice = (LinearLayout) findViewById(R.id.llDCPrice);
        this.edtDCTax = (EditText) findViewById(R.id.edtDCTax);
        this.imgClearDCTax = (ImageView) findViewById(R.id.imgClearDCTax);
        this.llDCTax = (LinearLayout) findViewById(R.id.llDCTax);
        this.edtDCDiscount = (EditText) findViewById(R.id.edtDCDiscount);
        this.imgClearDCDiscount = (ImageView) findViewById(R.id.imgClearDCDiscount);
        this.llDCDiscount = (LinearLayout) findViewById(R.id.llDCDiscount);
        this.edtDCAdditionalDiscount = (EditText) findViewById(R.id.edtDCAdditionalDiscount);
        this.imgClearDCAdditionalDiscount = (ImageView) findViewById(R.id.imgClearDCAdditionalDiscount);
        this.llDCAdditionalDiscount = (LinearLayout) findViewById(R.id.llDCAdditionalDiscount);
        this.btnDCCalculator = (Button) findViewById(R.id.btnDCCalculator);
        this.txtDCTotalTaxAmount = (TextView) findViewById(R.id.txtDCTotalTaxAmount);
        this.txtDCDiscount = (TextView) findViewById(R.id.txtDCDiscount);
        this.txtDCAdditionalDiscount = (TextView) findViewById(R.id.txtDCAdditionalDiscount);
        this.txtDCSavingPrice = (TextView) findViewById(R.id.txtDCSavingPrice);
        this.txtDCTotalPrice = (TextView) findViewById(R.id.txtDCTotalPrice);
        Util.textChangedListener(this.edtDCPrice, this.imgClearDCPrice, this.llDCPrice);
        Util.textChangedListener(this.edtDCTax, this.imgClearDCTax, this.llDCTax);
        Util.textChangedListener(this.edtDCDiscount, this.imgClearDCDiscount, this.llDCDiscount);
        Util.textChangedListener(this.edtDCAdditionalDiscount, this.imgClearDCAdditionalDiscount, this.llDCAdditionalDiscount);
        this.btnDCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscountCalculatorActivity.this.discountCalculator();
            }
        });
    }

    
    public void discountCalculator() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        String obj = this.edtDCPrice.getText().toString();
        String obj2 = this.edtDCTax.getText().toString();
        String obj3 = this.edtDCAdditionalDiscount.getText().toString();
        String obj4 = this.edtDCDiscount.getText().toString();
        if (obj.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!((!Util.checkAmount(obj, this.edtDCPrice)) | (!Util.checkPercentage100(obj2, this.edtDCTax)) | (!Util.checkPercentage100(obj3, this.edtDCAdditionalDiscount))) && !(!Util.checkPercentage100(obj4, this.edtDCDiscount))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            double parseDouble3 = Double.parseDouble(obj3);
            double parseDouble4 = Double.parseDouble(obj4);
            new DecimalFormat("####0");
            int i = (parseDouble > 0.0d ? 1 : (parseDouble == 0.0d ? 0 : -1));
            double d6 = (i != 0 && parseDouble2 == 0.0d && parseDouble3 == 0.0d && parseDouble4 == 0.0d) ? parseDouble : 0.0d;
            double d7 = d6;
            if (i == 0 || parseDouble2 == 0.0d || parseDouble3 != 0.0d || parseDouble4 != 0.0d) {
                this.txtDCTotalTaxAmount.setText("");
                this.txtDCTotalPrice.setText("");
            } else {
                d6 = ((parseDouble2 / 100.0d) * parseDouble) + parseDouble;
                d7 = d6;
            }
            if (i == 0 || parseDouble4 == 0.0d || parseDouble2 != 0.0d || parseDouble3 != 0.0d) {
                this.txtDCDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
                d = 0.0d;
            } else {
                d = (parseDouble4 / 100.0d) * parseDouble;
                d7 = parseDouble - d;
            }
            if (i == 0 || parseDouble3 == 0.0d || parseDouble4 != 0.0d || parseDouble2 != 0.0d) {
                this.txtDCAdditionalDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
                d2 = d;
            } else {
                d2 = (parseDouble3 / 100.0d) * parseDouble;
                d7 = parseDouble - d2;
            }
            if (i == 0 || parseDouble3 == 0.0d || parseDouble4 == 0.0d || parseDouble2 != 0.0d) {
                this.txtDCDiscount.setText("");
                this.txtDCAdditionalDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
                d3 = d2;
            } else {
                double d8 = (parseDouble4 / 100.0d) * parseDouble;
                d3 = d8 + ((parseDouble - d8) * (parseDouble3 / 100.0d));
                d7 = parseDouble - d3;
            }
            if (i == 0 || parseDouble4 == 0.0d || parseDouble2 == 0.0d || parseDouble3 != 0.0d) {
                this.txtDCTotalTaxAmount.setText("");
                this.txtDCDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
                d4 = d3;
            } else {
                d6 = ((parseDouble2 / 100.0d) * parseDouble) + parseDouble;
                d4 = (parseDouble4 / 100.0d) * d6;
                d7 = d6 - d4;
            }
            if (i == 0 || parseDouble3 == 0.0d || parseDouble2 == 0.0d || parseDouble4 != 0.0d) {
                this.txtDCTotalTaxAmount.setText("");
                this.txtDCDiscount.setText("");
                this.txtDCAdditionalDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
                d5 = d4;
            } else {
                d6 = ((parseDouble2 / 100.0d) * parseDouble) + parseDouble;
                d5 = (parseDouble3 / 100.0d) * d6;
                d7 = d6 - d5;
            }
            if (i == 0 || parseDouble3 == 0.0d || parseDouble4 == 0.0d || parseDouble2 == 0.0d) {
                this.txtDCTotalTaxAmount.setText("");
                this.txtDCDiscount.setText("");
                this.txtDCAdditionalDiscount.setText("");
                this.txtDCSavingPrice.setText("");
                this.txtDCTotalPrice.setText("");
            } else {
                d6 = ((parseDouble2 / 100.0d) * parseDouble) + parseDouble;
                double d9 = (parseDouble4 / 100.0d) * d6;
                d5 = d9 + ((d6 - d9) * (parseDouble3 / 100.0d));
                d7 = d6 - d5;
            }
            TextView textView = this.txtDCTotalTaxAmount;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            TextView textView2 = this.txtDCTotalTaxAmount;
            textView2.setText("" + Util.round(d6, 1));
            TextView textView3 = this.txtDCDiscount;
            textView3.setText("-" + Util.round(parseDouble4, 2) + "%");
            TextView textView4 = this.txtDCAdditionalDiscount;
            textView4.setText("-" + Util.round(parseDouble3, 2) + "%");
            TextView textView5 = this.txtDCSavingPrice;
            textView5.setText("" + Util.round(d5, 2));
            TextView textView6 = this.txtDCTotalPrice;
            textView6.setText("" + Util.round(d7, 2));
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
