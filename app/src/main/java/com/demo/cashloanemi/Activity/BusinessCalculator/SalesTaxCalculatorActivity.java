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

public class SalesTaxCalculatorActivity extends AppCompatActivity {
    Button btnSTCCalculator;
    EditText edtSTCNetAmount;
    EditText edtSTCSalesTax;
    ImageView imgClearSTCNetAmount;
    ImageView imgClearSTCSalesTax;
    LinearLayout llSTCNetAmount;
    LinearLayout llSTCSalesTax;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtSTCGrossPrice;
    TextView txtSTCTaxAmount;




    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sales_tax_calculator);


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
        this.edtSTCNetAmount = (EditText) findViewById(R.id.edtSTCNetAmount);
        this.imgClearSTCNetAmount = (ImageView) findViewById(R.id.imgClearSTCNetAmount);
        this.llSTCNetAmount = (LinearLayout) findViewById(R.id.llSTCNetAmount);
        this.edtSTCSalesTax = (EditText) findViewById(R.id.edtSTCSalesTax);
        this.imgClearSTCSalesTax = (ImageView) findViewById(R.id.imgClearSTCSalesTax);
        this.llSTCSalesTax = (LinearLayout) findViewById(R.id.llSTCSalesTax);
        this.btnSTCCalculator = (Button) findViewById(R.id.btnSTCCalculator);
        this.txtSTCGrossPrice = (TextView) findViewById(R.id.txtSTCGrossPrice);
        this.txtSTCTaxAmount = (TextView) findViewById(R.id.txtSTCTaxAmount);
        Util.textChangedListener(this.edtSTCNetAmount, this.imgClearSTCNetAmount, this.llSTCNetAmount);
        Util.textChangedListener(this.edtSTCSalesTax, this.imgClearSTCSalesTax, this.llSTCSalesTax);
        this.btnSTCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalesTaxCalculatorActivity.this.salesTaxCalculator();
            }
        });
    }

    
    public void salesTaxCalculator() {
        String obj = this.edtSTCNetAmount.getText().toString();
        String obj2 = this.edtSTCSalesTax.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (!(!Util.checkPercentage100(obj2, this.edtSTCSalesTax)) && !(!Util.checkAmount(obj, this.edtSTCNetAmount))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtSTCTaxAmount.setText("");
                this.txtSTCGrossPrice.setText("");
                return;
            }
            double d = (parseDouble2 * parseDouble) / 100.0d;
            double d2 = parseDouble + d;
            TextView textView = this.txtSTCTaxAmount;
            textView.setText("" + Util.round(d, 2));
            TextView textView2 = this.txtSTCGrossPrice;
            textView2.setText("" + Util.round(d2, 2));
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
