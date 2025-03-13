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

public class MarkupCalculatorActivity extends AppCompatActivity {
    Button btnMCCalculator;
    EditText edtMCCostPrice;
    EditText edtMCSellingPrice;
    ImageView imgClearMCCostPrice;
    ImageView imgClearMCSellingPrice;
    LinearLayout llMCCostPrice;
    LinearLayout llMCSellingPrice;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtMCGrossMargin;
    TextView txtMCMarkUp;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_markup_calculator);


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
        this.edtMCCostPrice = (EditText) findViewById(R.id.edtMCCostPrice);
        this.imgClearMCCostPrice = (ImageView) findViewById(R.id.imgClearMCCostPrice);
        this.llMCCostPrice = (LinearLayout) findViewById(R.id.llMCCostPrice);
        this.edtMCSellingPrice = (EditText) findViewById(R.id.edtMCSellingPrice);
        this.imgClearMCSellingPrice = (ImageView) findViewById(R.id.imgClearMCSellingPrice);
        this.llMCSellingPrice = (LinearLayout) findViewById(R.id.llMCSellingPrice);
        this.txtMCGrossMargin = (TextView) findViewById(R.id.txtMCGrossMargin);
        this.txtMCMarkUp = (TextView) findViewById(R.id.txtMCMarkUp);
        this.btnMCCalculator = (Button) findViewById(R.id.btnMCCalculator);
        Util.textChangedListener(this.edtMCCostPrice, this.imgClearMCCostPrice, this.llMCCostPrice);
        Util.textChangedListener(this.edtMCSellingPrice, this.imgClearMCSellingPrice, this.llMCSellingPrice);
        this.btnMCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MarkupCalculatorActivity.this.MarkupCalculator();
            }
        });
    }

    
    public void MarkupCalculator() {
        String obj = this.edtMCSellingPrice.getText().toString();
        String obj2 = this.edtMCCostPrice.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (!(!Util.checkAmount(obj, this.edtMCSellingPrice)) && !(!Util.checkAmount(obj2, this.edtMCCostPrice))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtMCGrossMargin.setText("");
                this.txtMCMarkUp.setText("");
                return;
            }
            double d = ((parseDouble - parseDouble2) * 100.0d) / parseDouble;
            double d2 = d / 100.0d;
            double d3 = ((parseDouble2 / (1.0d - d2)) * d2) / parseDouble2;
            TextView textView = this.txtMCGrossMargin;
            textView.setText("" + Util.round(d, 2) + "%");
            TextView textView2 = this.txtMCMarkUp;
            textView2.setText("" + Util.round(d3 * 100.0d, 2) + "%");
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
