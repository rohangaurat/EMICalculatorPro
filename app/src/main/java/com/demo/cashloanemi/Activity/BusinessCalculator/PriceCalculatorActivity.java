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

public class PriceCalculatorActivity extends AppCompatActivity {
    Button btnPCCalculator;
    EditText edtPCCost;
    EditText edtPCGrossMargin;
    ImageView imgClearPCCost;
    ImageView imgClearPCGrossMargin;
    LinearLayout llPCCost;
    LinearLayout llPCGrossMargin;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtPCGrossProfit;
    TextView txtPCMarkUp;
    TextView txtPCPrice;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_price_calculator);


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
        this.edtPCCost = (EditText) findViewById(R.id.edtPCCost);
        this.imgClearPCCost = (ImageView) findViewById(R.id.imgClearPCCost);
        this.llPCCost = (LinearLayout) findViewById(R.id.llPCCost);
        this.edtPCGrossMargin = (EditText) findViewById(R.id.edtPCGrossMargin);
        this.imgClearPCGrossMargin = (ImageView) findViewById(R.id.imgClearPCGrossMargin);
        this.llPCGrossMargin = (LinearLayout) findViewById(R.id.llPCGrossMargin);
        this.txtPCPrice = (TextView) findViewById(R.id.txtPCPrice);
        this.txtPCGrossProfit = (TextView) findViewById(R.id.txtPCGrossProfit);
        this.txtPCMarkUp = (TextView) findViewById(R.id.txtPCMarkUp);
        this.btnPCCalculator = (Button) findViewById(R.id.btnPCCalculator);
        Util.textChangedListener(this.edtPCCost, this.imgClearPCCost, this.llPCCost);
        Util.textChangedListener(this.edtPCGrossMargin, this.imgClearPCGrossMargin, this.llPCGrossMargin);
        this.btnPCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PriceCalculatorActivity.this.priceCalculator();
            }
        });
    }

    
    public void priceCalculator() {
        String obj = this.edtPCCost.getText().toString();
        String obj2 = this.edtPCGrossMargin.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (!(!Util.checkPercentage100(obj2, this.edtPCGrossMargin)) && !(!Util.checkAmount(obj, this.edtPCCost))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtPCPrice.setText("");
                this.txtPCGrossProfit.setText("");
                this.txtPCMarkUp.setText("");
                return;
            }
            double d = parseDouble2 / 100.0d;
            double d2 = parseDouble / (1.0d - d);
            double d3 = d * d2;
            TextView textView = this.txtPCPrice;
            textView.setText("" + Util.round(d2, 2));
            TextView textView2 = this.txtPCGrossProfit;
            textView2.setText("" + Util.round(d3, 2));
            TextView textView3 = this.txtPCMarkUp;
            textView3.setText("" + Util.round((d3 / parseDouble) * 100.0d, 2) + "%");
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
