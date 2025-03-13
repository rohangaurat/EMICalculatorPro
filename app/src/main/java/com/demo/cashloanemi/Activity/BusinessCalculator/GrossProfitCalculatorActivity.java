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

public class GrossProfitCalculatorActivity extends AppCompatActivity {
    Button btnGPCCalculator;
    EditText edtGPCCostPrice;
    EditText edtGPCSellingPrice;
    ImageView imgClearGPCCostPrice;
    ImageView imgClearGPCSellingPrice;
    LinearLayout llGPCCostPrice;
    LinearLayout llGPCSellingPrice;

    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtGPCGrossMargin;
    TextView txtGPCGrossProfit;
    TextView txtGPCMarkUp;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gross_profit_calculator);


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
        this.edtGPCCostPrice = (EditText) findViewById(R.id.edtGPCCostPrice);
        this.imgClearGPCCostPrice = (ImageView) findViewById(R.id.imgClearGPCCostPrice);
        this.llGPCCostPrice = (LinearLayout) findViewById(R.id.llGPCCostPrice);
        this.edtGPCSellingPrice = (EditText) findViewById(R.id.edtGPCSellingPrice);
        this.imgClearGPCSellingPrice = (ImageView) findViewById(R.id.imgClearGPCSellingPrice);
        this.llGPCSellingPrice = (LinearLayout) findViewById(R.id.llGPCSellingPrice);
        this.txtGPCGrossMargin = (TextView) findViewById(R.id.txtGPCGrossMargin);
        this.txtGPCGrossProfit = (TextView) findViewById(R.id.txtGPCGrossProfit);
        this.txtGPCMarkUp = (TextView) findViewById(R.id.txtGPCMarkUp);
        this.btnGPCCalculator = (Button) findViewById(R.id.btnGPCCalculator);
        Util.textChangedListener(this.edtGPCCostPrice, this.imgClearGPCCostPrice, this.llGPCCostPrice);
        Util.textChangedListener(this.edtGPCSellingPrice, this.imgClearGPCSellingPrice, this.llGPCSellingPrice);
        this.btnGPCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GrossProfitCalculatorActivity.this.grossProfitCalculator();
            }
        });
    }

    
    public void grossProfitCalculator() {
        String obj = this.edtGPCSellingPrice.getText().toString();
        String obj2 = this.edtGPCCostPrice.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (Util.checkAmount(obj, this.edtGPCSellingPrice) || Util.checkAmount(obj2, this.edtGPCCostPrice)) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtGPCGrossMargin.setText("");
                this.txtGPCMarkUp.setText("");
                this.txtGPCGrossProfit.setText("");
                return;
            }
            double d = parseDouble - parseDouble2;
            double d2 = (d * 100.0d) / parseDouble;
            double d3 = d2 / 100.0d;
            double d4 = ((parseDouble2 / (1.0d - d3)) * d3) / parseDouble2;
            TextView textView = this.txtGPCGrossMargin;
            textView.setText("" + Util.round(d2, 2) + "%");
            TextView textView2 = this.txtGPCMarkUp;
            textView2.setText("" + Util.round(d4 * 100.0d, 2) + "%");
            TextView textView3 = this.txtGPCGrossProfit;
            textView3.setText("" + Util.round(d, 2));
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
