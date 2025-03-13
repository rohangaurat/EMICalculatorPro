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

public class OperatingMarginCalculatorActivity extends AppCompatActivity {
    Button btnOMCCalculator;
    Button btnOMCOperatingIncome;
    Button btnOMCProfit;
    EditText edtOMCCostOfGoodsSold;
    EditText edtOMCOperatingExpenses;
    EditText edtOMCOperatingIncome;
    EditText edtOMCRevenue;
    ImageView imgClearOMCCostOfGoodsSold;
    ImageView imgClearOMCOperatingExpenses;
    ImageView imgClearOMCOperatingIncome;
    ImageView imgClearOMCRevenue;
    boolean isOperatingIncome = true;
    LinearLayout llCostOfGoodsSold;
    LinearLayout llOMCCostOfGoodsSold;
    LinearLayout llOMCOperatingExpenses;
    LinearLayout llOMCOperatingIncome;
    LinearLayout llOMCOperatingIncomeOutPut;
    LinearLayout llOMCOperatingMarginOutPut;
    LinearLayout llOMCRevenue;
    LinearLayout llOperatingExpenses;
    LinearLayout llOperatingIncome;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtOMCOperatingIncome;
    TextView txtOMCOperatingMargin;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_operating_margin_calculator);


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
        this.edtOMCRevenue = (EditText) findViewById(R.id.edtOMCRevenue);
        this.imgClearOMCRevenue = (ImageView) findViewById(R.id.imgClearOMCRevenue);
        this.llOMCRevenue = (LinearLayout) findViewById(R.id.llOMCRevenue);
        this.edtOMCCostOfGoodsSold = (EditText) findViewById(R.id.edtOMCCostOfGoodsSold);
        this.imgClearOMCCostOfGoodsSold = (ImageView) findViewById(R.id.imgClearOMCCostOfGoodsSold);
        this.llOMCCostOfGoodsSold = (LinearLayout) findViewById(R.id.llOMCCostOfGoodsSold);
        this.edtOMCOperatingExpenses = (EditText) findViewById(R.id.edtOMCOperatingExpenses);
        this.imgClearOMCOperatingExpenses = (ImageView) findViewById(R.id.imgClearOMCOperatingExpenses);
        this.llOMCOperatingExpenses = (LinearLayout) findViewById(R.id.llOMCOperatingExpenses);
        this.edtOMCOperatingIncome = (EditText) findViewById(R.id.edtOMCOperatingIncome);
        this.imgClearOMCOperatingIncome = (ImageView) findViewById(R.id.imgClearOMCOperatingIncome);
        this.llOMCOperatingIncome = (LinearLayout) findViewById(R.id.llOMCOperatingIncome);
        this.btnOMCOperatingIncome = (Button) findViewById(R.id.btnOMCOperatingIncome);
        this.btnOMCProfit = (Button) findViewById(R.id.btnOMCProfit);
        this.btnOMCCalculator = (Button) findViewById(R.id.btnOMCCalculator);
        this.txtOMCOperatingIncome = (TextView) findViewById(R.id.txtOMCOperatingIncome);
        this.txtOMCOperatingMargin = (TextView) findViewById(R.id.txtOMCOperatingMargin);
        this.llCostOfGoodsSold = (LinearLayout) findViewById(R.id.llCostOfGoodsSold);
        this.llOperatingExpenses = (LinearLayout) findViewById(R.id.llOperatingExpenses);
        this.llOperatingIncome = (LinearLayout) findViewById(R.id.llOperatingIncome);
        this.llOMCOperatingMarginOutPut = (LinearLayout) findViewById(R.id.llOMCOperatingMarginOutPut);
        this.llOMCOperatingIncomeOutPut = (LinearLayout) findViewById(R.id.llOMCOperatingIncomeOutPut);
        Util.textChangedListener(this.edtOMCRevenue, this.imgClearOMCRevenue, this.llOMCRevenue);
        Util.textChangedListener(this.edtOMCCostOfGoodsSold, this.imgClearOMCCostOfGoodsSold, this.llOMCCostOfGoodsSold);
        Util.textChangedListener(this.edtOMCOperatingExpenses, this.imgClearOMCOperatingExpenses, this.llOMCOperatingExpenses);
        Util.textChangedListener(this.edtOMCOperatingIncome, this.imgClearOMCOperatingIncome, this.llOMCOperatingIncome);
        this.btnOMCProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OperatingMarginCalculatorActivity.this.isOperatingIncome = false;
                OperatingMarginCalculatorActivity.this.btnOMCOperatingIncome.setBackgroundResource(R.drawable.background_basic_cal_gray);
                OperatingMarginCalculatorActivity.this.btnOMCProfit.setBackgroundResource(R.drawable.borders_green);
                OperatingMarginCalculatorActivity.this.llCostOfGoodsSold.setVisibility(View.GONE);
                OperatingMarginCalculatorActivity.this.llOperatingExpenses.setVisibility(View.GONE);
                OperatingMarginCalculatorActivity.this.llOperatingIncome.setVisibility(View.VISIBLE);
                OperatingMarginCalculatorActivity.this.llOMCOperatingIncomeOutPut.setVisibility(View.GONE);
                OperatingMarginCalculatorActivity.this.llOMCOperatingMarginOutPut.setVisibility(View.VISIBLE);
            }
        });
        this.btnOMCOperatingIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OperatingMarginCalculatorActivity.this.isOperatingIncome = true;
                OperatingMarginCalculatorActivity.this.btnOMCOperatingIncome.setBackgroundResource(R.drawable.borders_green);
                OperatingMarginCalculatorActivity.this.btnOMCProfit.setBackgroundResource(R.drawable.background_basic_cal_gray);
                OperatingMarginCalculatorActivity.this.llCostOfGoodsSold.setVisibility(View.VISIBLE);
                OperatingMarginCalculatorActivity.this.llOperatingExpenses.setVisibility(View.VISIBLE);
                OperatingMarginCalculatorActivity.this.llOperatingIncome.setVisibility(View.GONE);
                OperatingMarginCalculatorActivity.this.llOMCOperatingIncomeOutPut.setVisibility(View.VISIBLE);
                OperatingMarginCalculatorActivity.this.llOMCOperatingMarginOutPut.setVisibility(View.GONE);
            }
        });
        this.btnOMCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OperatingMarginCalculatorActivity.this.operatingMarginCalculator();
            }
        });
    }

    
    public void operatingMarginCalculator() {
        String obj = this.edtOMCCostOfGoodsSold.getText().toString();
        String obj2 = this.edtOMCRevenue.getText().toString();
        String obj3 = this.edtOMCOperatingExpenses.getText().toString();
        String obj4 = this.edtOMCOperatingIncome.getText().toString();
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
        if (this.isOperatingIncome) {
            if (!((!Util.checkAmount(obj, this.edtOMCCostOfGoodsSold)) | (!Util.checkAmount(obj2, this.edtOMCRevenue))) && !(!Util.checkAmount(obj3, this.edtOMCOperatingExpenses))) {
                double parseDouble = Double.parseDouble(obj);
                double parseDouble2 = Double.parseDouble(obj2);
                double parseDouble3 = Double.parseDouble(obj3);
                if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d) {
                    this.txtOMCOperatingIncome.setText("");
                    return;
                }
                TextView textView = this.txtOMCOperatingIncome;
                textView.setText(Util.round((parseDouble2 - parseDouble) - parseDouble3, 2) + "");
            }
        } else if (!(!Util.checkAmount(obj2, this.edtOMCRevenue)) && !(!Util.checkAmount(obj4, this.edtOMCOperatingIncome))) {
            double parseDouble4 = Double.parseDouble(obj2);
            double parseDouble5 = Double.parseDouble(obj4);
            if (parseDouble4 == 0.0d || parseDouble5 == 0.0d) {
                this.txtOMCOperatingMargin.setText("");
                return;
            }
            double d = (parseDouble5 * 100.0d) / parseDouble4;
            TextView textView2 = this.txtOMCOperatingMargin;
            textView2.setText(Util.round(d, 2) + "%");
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
