package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.content.Intent;
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

import java.util.ArrayList;

public class SWPCalculatorActivity extends AppCompatActivity {
    ArrayList<Long> balanceBeginList;
    ArrayList<Long> balanceEndList;
    Button btnSWPCalculator;
    Button btnSWPMonth;
    Button btnSWPYear;
    EditText edtSWPInitialInvestmentAmount;
    EditText edtSWPRateOfReturn;
    EditText edtSWPTenure;
    EditText edtSWPWithdrawalParMonth;
    ImageView imgClearSWPInitialInvestmentAmount;
    ImageView imgClearSWPRateOfReturn;
    ImageView imgClearSWPTenure;
    ImageView imgClearSWPWithdrawalParMonth;
    ArrayList<Long> interestList;
    boolean isYear = true;
    LinearLayout llSWPInitialInvestmentAmount;
    LinearLayout llSWPRateOfReturn;
    LinearLayout llSWPTenure;
    LinearLayout llSWPWithdrawalParMonth;
    PrefManager prefManager;
    Double time = Double.valueOf(0.0d);
    Toolbar toolbar;
    TextView txtSWPEndBalance;
    TextView txtSWPMoreDetail;
    TextView txtSWPNoOfWithdrawal;
    TextView txtSWPTotalProfit;
    TextView txtSWPWithdrawal;
    ArrayList<Long> withdrawalList;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_swpcalculator);


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
        this.interestList = new ArrayList<>();
        this.balanceBeginList = new ArrayList<>();
        this.balanceEndList = new ArrayList<>();
        this.withdrawalList = new ArrayList<>();
        this.edtSWPInitialInvestmentAmount = (EditText) findViewById(R.id.edtSWPInitialInvestmentAmount);
        this.imgClearSWPInitialInvestmentAmount = (ImageView) findViewById(R.id.imgClearSWPInitialInvestmentAmount);
        this.llSWPInitialInvestmentAmount = (LinearLayout) findViewById(R.id.llSWPInitialInvestmentAmount);
        this.edtSWPWithdrawalParMonth = (EditText) findViewById(R.id.edtSWPWithdrawalParMonth);
        this.imgClearSWPWithdrawalParMonth = (ImageView) findViewById(R.id.imgClearSWPWithdrawalParMonth);
        this.llSWPWithdrawalParMonth = (LinearLayout) findViewById(R.id.llSWPWithdrawalParMonth);
        this.edtSWPRateOfReturn = (EditText) findViewById(R.id.edtSWPRateOfReturn);
        this.imgClearSWPRateOfReturn = (ImageView) findViewById(R.id.imgClearSWPRateOfReturn);
        this.llSWPRateOfReturn = (LinearLayout) findViewById(R.id.llSWPRateOfReturn);
        this.edtSWPTenure = (EditText) findViewById(R.id.edtSWPTenure);
        this.imgClearSWPTenure = (ImageView) findViewById(R.id.imgClearSWPTenure);
        this.llSWPTenure = (LinearLayout) findViewById(R.id.llSWPTenure);
        this.edtSWPTenure = (EditText) findViewById(R.id.edtSWPTenure);
        this.imgClearSWPTenure = (ImageView) findViewById(R.id.imgClearSWPTenure);
        this.llSWPTenure = (LinearLayout) findViewById(R.id.llSWPTenure);
        this.btnSWPCalculator = (Button) findViewById(R.id.btnSWPCalculator);
        this.txtSWPWithdrawal = (TextView) findViewById(R.id.txtSWPWithdrawal);
        this.txtSWPTotalProfit = (TextView) findViewById(R.id.txtSWPTotalProfit);
        this.txtSWPEndBalance = (TextView) findViewById(R.id.txtSWPEndBalance);
        this.txtSWPNoOfWithdrawal = (TextView) findViewById(R.id.txtSWPNoOfWithdrawal);
        this.txtSWPMoreDetail = (TextView) findViewById(R.id.txtSWPMoreDetail);
        this.btnSWPYear = (Button) findViewById(R.id.btnSWPYear);
        this.btnSWPMonth = (Button) findViewById(R.id.btnSWPMonth);
        Util.textChangedListener(this.edtSWPInitialInvestmentAmount, this.imgClearSWPInitialInvestmentAmount, this.llSWPInitialInvestmentAmount);
        Util.textChangedListener(this.edtSWPWithdrawalParMonth, this.imgClearSWPWithdrawalParMonth, this.llSWPWithdrawalParMonth);
        Util.textChangedListener(this.edtSWPRateOfReturn, this.imgClearSWPRateOfReturn, this.llSWPRateOfReturn);
        Util.textChangedListener(this.edtSWPTenure, this.imgClearSWPTenure, this.llSWPTenure);
        Util.textChangedListener(this.edtSWPTenure, this.imgClearSWPTenure, this.llSWPTenure);
        this.btnSWPYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SWPCalculatorActivity.this.isYear = true;
                SWPCalculatorActivity.this.btnSWPYear.setBackgroundResource(R.drawable.borders_green);
                SWPCalculatorActivity.this.btnSWPMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SWPCalculatorActivity.this.swpCalculator();
            }
        });
        this.btnSWPMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SWPCalculatorActivity.this.isYear = false;
                SWPCalculatorActivity.this.btnSWPMonth.setBackgroundResource(R.drawable.borders_green);
                SWPCalculatorActivity.this.btnSWPYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SWPCalculatorActivity.this.swpCalculator();
            }
        });
        this.btnSWPCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SWPCalculatorActivity.this.swpCalculator();
            }
        });
        this.txtSWPMoreDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SWPCalculatorActivity.this.swpCalculator();
                Intent intent = new Intent(SWPCalculatorActivity.this, SWPDetailsActivity.class);
                intent.putExtra("interestList", SWPCalculatorActivity.this.interestList);
                intent.putExtra("withdrawalList", SWPCalculatorActivity.this.withdrawalList);
                intent.putExtra("balanceEndList", SWPCalculatorActivity.this.balanceEndList);
                intent.putExtra("balanceBeginList", SWPCalculatorActivity.this.balanceBeginList);
                SWPCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    
    public void swpCalculator() {
        double d;
        String obj = this.edtSWPWithdrawalParMonth.getText().toString();
        String obj2 = this.edtSWPInitialInvestmentAmount.getText().toString();
        String obj3 = this.edtSWPTenure.getText().toString();
        String obj4 = this.edtSWPRateOfReturn.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty()) {
            Toast.makeText(this, "Enter the Value", Toast.LENGTH_SHORT).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        double d2 = 0.0d;
        if (obj3.isEmpty()) {
            this.time = Double.valueOf(0.0d);
        } else if (this.isYear) {
            this.time = Double.valueOf(Double.parseDouble(obj3) * 12.0d);
        } else {
            this.time = Double.valueOf(Double.parseDouble(obj3));
        }
        int i = 1;
        if (((!Util.checkAmount(obj, this.edtSWPWithdrawalParMonth)) | (!Util.checkAmount(obj2, this.edtSWPInitialInvestmentAmount)) | (!Util.checkPercentage50(obj4, this.edtSWPRateOfReturn))) || (!Util.checkPeriod360(this.time.doubleValue(), this.edtSWPTenure))) {
            this.txtSWPMoreDetail.setVisibility(View.GONE);
            return;
        }
        double parseDouble = Double.parseDouble(obj4);
        double parseDouble2 = Double.parseDouble(obj2);
        double parseDouble3 = Double.parseDouble(obj);
        if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d || this.time.doubleValue() == 0.0d) {
            this.txtSWPEndBalance.setText("");
            this.txtSWPNoOfWithdrawal.setText("");
            this.txtSWPTotalProfit.setText("");
            this.txtSWPWithdrawal.setText("");
            this.txtSWPMoreDetail.setVisibility(View.GONE);
            return;
        }
        double d3 = parseDouble / 1200.0d;
        this.interestList.clear();
        this.balanceBeginList.clear();
        this.balanceEndList.clear();
        this.withdrawalList.clear();
        int i2 = 0;
        while (true) {
            if (((double) i) > this.time.doubleValue()) {
                d = d2;
                break;
            }
            this.balanceBeginList.add(Long.valueOf((long) Util.round(parseDouble2, 2)));
            double d4 = (parseDouble2 * d3) - (parseDouble3 * d3);
            parseDouble2 = (parseDouble2 + d4) - parseDouble3;
            d = 0.0d;
            if (parseDouble2 < 0.0d) {
                break;
            }
            this.balanceEndList.add(Long.valueOf((long) Util.round(parseDouble2, 2)));
            this.interestList.add(Long.valueOf((long) Util.round(d4, 2)));
            i2 = i;
            d2 = 0.0d;
            i++;
            d3 = d3;
        }
        double d5 = d;
        for (int i3 = 0; i3 < i2; i3++) {
            d5 += (double) this.interestList.get(i3).longValue();
            this.withdrawalList.add(Long.valueOf((long) parseDouble3));
        }
        this.txtSWPEndBalance.setText(this.balanceEndList.get(i2 - 1) + "");
        this.txtSWPNoOfWithdrawal.setText(i2 + "");
        this.txtSWPTotalProfit.setText(d5 + "");
        this.txtSWPWithdrawal.setText((((double) i2) * parseDouble3) + "");
        this.txtSWPMoreDetail.setVisibility(View.VISIBLE);
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
