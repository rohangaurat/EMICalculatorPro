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

public class MarginCalculatorActivity extends AppCompatActivity {
    Button btnMRCCalculator;
    EditText edtMRCCost;
    EditText edtMRCRevenue;
    ImageView imgClearMRCCost;
    ImageView imgClearMRCRevenue;
    LinearLayout llMRCCost;
    LinearLayout llMRCRevenue;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtMRCMargin;
    TextView txtMRCProfit;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_margin_calculator);


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
        this.edtMRCCost = (EditText) findViewById(R.id.edtMRCCost);
        this.imgClearMRCCost = (ImageView) findViewById(R.id.imgClearMRCCost);
        this.llMRCCost = (LinearLayout) findViewById(R.id.llMRCCost);
        this.edtMRCRevenue = (EditText) findViewById(R.id.edtMRCRevenue);
        this.imgClearMRCRevenue = (ImageView) findViewById(R.id.imgClearMRCRevenue);
        this.llMRCRevenue = (LinearLayout) findViewById(R.id.llMRCRevenue);
        this.btnMRCCalculator = (Button) findViewById(R.id.btnMRCCalculator);
        this.txtMRCMargin = (TextView) findViewById(R.id.txtMRCMargin);
        this.txtMRCProfit = (TextView) findViewById(R.id.txtMRCProfit);
        Util.textChangedListener(this.edtMRCCost, this.imgClearMRCCost, this.llMRCCost);
        Util.textChangedListener(this.edtMRCRevenue, this.imgClearMRCRevenue, this.llMRCRevenue);
        this.btnMRCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MarginCalculatorActivity.this.marginCalculator();
            }
        });
    }

    
    public void marginCalculator() {
        String obj = this.edtMRCCost.getText().toString();
        String obj2 = this.edtMRCRevenue.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!(!Util.checkAmount(obj, this.edtMRCCost)) && !(!Util.checkAmount(obj2, this.edtMRCRevenue))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d) {
                this.txtMRCMargin.setText("");
                this.txtMRCProfit.setText("");
                return;
            }
            double d = parseDouble2 - parseDouble;
            TextView textView = this.txtMRCMargin;
            textView.setText(Util.round((d / parseDouble2) * 100.0d, 2) + "%");
            TextView textView2 = this.txtMRCProfit;
            textView2.setText(d + "");
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
