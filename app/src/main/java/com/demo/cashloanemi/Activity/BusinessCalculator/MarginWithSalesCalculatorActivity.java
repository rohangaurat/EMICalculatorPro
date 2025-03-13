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

public class MarginWithSalesCalculatorActivity extends AppCompatActivity {
    Button btnMWSCalculator;
    EditText edtMWSCostPrice;
    EditText edtMWSRate;
    EditText edtMWSSellingPrice;
    ImageView imgClearMWSCostPrice;
    ImageView imgClearMWSRate;
    ImageView imgClearMWSSellingPrice;
    LinearLayout llMWSCostPrice;
    LinearLayout llMWSRate;
    LinearLayout llMWSSellingPrice;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtMWSMargin;
    TextView txtMWSMarkup;
    TextView txtMWSNetPrice;
    TextView txtMWSProfit;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_margin_with_sales_calculator);


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
        this.edtMWSCostPrice = (EditText) findViewById(R.id.edtMWSCostPrice);
        this.imgClearMWSCostPrice = (ImageView) findViewById(R.id.imgClearMWSCostPrice);
        this.llMWSCostPrice = (LinearLayout) findViewById(R.id.llMWSCostPrice);
        this.edtMWSSellingPrice = (EditText) findViewById(R.id.edtMWSSellingPrice);
        this.imgClearMWSSellingPrice = (ImageView) findViewById(R.id.imgClearMWSSellingPrice);
        this.llMWSSellingPrice = (LinearLayout) findViewById(R.id.llMWSSellingPrice);
        this.edtMWSRate = (EditText) findViewById(R.id.edtMWSRate);
        this.imgClearMWSRate = (ImageView) findViewById(R.id.imgClearMWSRate);
        this.llMWSRate = (LinearLayout) findViewById(R.id.llMWSRate);
        this.btnMWSCalculator = (Button) findViewById(R.id.btnMWSCalculator);
        this.txtMWSNetPrice = (TextView) findViewById(R.id.txtMWSNetPrice);
        this.txtMWSProfit = (TextView) findViewById(R.id.txtMWSProfit);
        this.txtMWSMargin = (TextView) findViewById(R.id.txtMWSMargin);
        this.txtMWSMarkup = (TextView) findViewById(R.id.txtMWSMarkup);
        Util.textChangedListener(this.edtMWSCostPrice, this.imgClearMWSCostPrice, this.llMWSCostPrice);
        Util.textChangedListener(this.edtMWSSellingPrice, this.imgClearMWSSellingPrice, this.llMWSSellingPrice);
        Util.textChangedListener(this.edtMWSRate, this.imgClearMWSRate, this.llMWSRate);
        this.btnMWSCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MarginWithSalesCalculatorActivity.this.mwsCalculator();
            }
        });
    }

    
    public void mwsCalculator() {
        String obj = this.edtMWSSellingPrice.getText().toString();
        String obj2 = this.edtMWSCostPrice.getText().toString();
        String obj3 = this.edtMWSRate.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!((!Util.checkAmount(obj2, this.edtMWSCostPrice)) | (!Util.checkAmount(obj, this.edtMWSSellingPrice))) && !(!Util.checkPercentage100(obj3, this.edtMWSRate))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            double parseDouble3 = Double.parseDouble(obj3);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d) {
                this.txtMWSMargin.setText("");
                this.txtMWSMarkup.setText("");
                this.txtMWSProfit.setText("");
                this.txtMWSNetPrice.setText("");
                return;
            }
            double d = parseDouble - parseDouble2;
            double d2 = (d * 100.0d) / parseDouble;
            double d3 = d2 / 100.0d;
            double d4 = ((parseDouble2 / (1.0d - d3)) * d3) / parseDouble2;
            double d5 = ((parseDouble2 * parseDouble3) / 100.0d) + parseDouble;
            TextView textView = this.txtMWSMargin;
            textView.setText("" + Util.round(d2, 2) + "%");
            TextView textView2 = this.txtMWSMarkup;
            textView2.setText("" + Util.round(100.0d * d4, 2) + "%");
            TextView textView3 = this.txtMWSProfit;
            textView3.setText("" + Util.round(d, 2));
            TextView textView4 = this.txtMWSNetPrice;
            textView4.setText("" + Util.round(d5, 2));
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
