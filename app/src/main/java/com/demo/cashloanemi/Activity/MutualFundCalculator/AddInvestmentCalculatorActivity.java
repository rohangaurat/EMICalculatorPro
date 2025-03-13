package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import com.demo.cashloanemi.Activity.SaveAndHistoryDetails.SaveDetailsActivity;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

import java.util.ArrayList;

public class AddInvestmentCalculatorActivity extends AppCompatActivity {
    double balance;
    ArrayList<Long> balanceList;
    Button btnAICCalculator;
    Button btnAICMonth;
    Button btnAICSave;
    Button btnAICYear;
    Button btnDialogSave;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtAICMonthlyAmount;
    EditText edtAICRateOfReturn;
    EditText edtAICStartingInvestmentAmount;
    EditText edtAICTenure;
    EditText edtTitleName;
    ImageView imgClearAICMonthlyAmount;
    ImageView imgClearAICRateOfReturn;
    ImageView imgClearAICStartingInvestmentAmount;
    ImageView imgClearAICTenure;
    ArrayList<Long> interestList;
    ArrayList<Long> investmentList;
    boolean isYear = true;
    LinearLayout llAICMonthlyAmount;
    LinearLayout llAICRateOfReturn;
    LinearLayout llAICStartingInvestmentAmount;
    LinearLayout llAICTenure;
    int month = 0;
    double monthly;
    PrefManager prefManager;
    double rate;
    double starting;
    Toolbar toolbar;
    TextView txtAICEndingBalance;
    TextView txtAICInvestmentAmount;
    TextView txtAICMoreDetail;
    TextView txtAICSaveDetails;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_investment_calculator);


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
        this.investmentList = new ArrayList<>();
        this.interestList = new ArrayList<>();
        this.balanceList = new ArrayList<>();
        this.db = new DatabaseHelper(this);
        Dialog dialog2 = new Dialog(this);
        this.dialog = dialog2;
        dialog2.setContentView(R.layout.save_dialog);
        this.dialog.getWindow().setLayout(1000, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.edtTitleName = (EditText) this.dialog.findViewById(R.id.edtTitleName);
        this.btnDialogSave = (Button) this.dialog.findViewById(R.id.btnDialogSave);
        this.edtAICStartingInvestmentAmount = (EditText) findViewById(R.id.edtAICStartingInvestmentAmount);
        this.imgClearAICStartingInvestmentAmount = (ImageView) findViewById(R.id.imgClearAICStartingInvestmentAmount);
        this.llAICStartingInvestmentAmount = (LinearLayout) findViewById(R.id.llAICStartingInvestmentAmount);
        this.edtAICMonthlyAmount = (EditText) findViewById(R.id.edtAICMonthlyAmount);
        this.imgClearAICMonthlyAmount = (ImageView) findViewById(R.id.imgClearAICMonthlyAmount);
        this.llAICMonthlyAmount = (LinearLayout) findViewById(R.id.llAICMonthlyAmount);
        this.edtAICRateOfReturn = (EditText) findViewById(R.id.edtAICRateOfReturn);
        this.imgClearAICRateOfReturn = (ImageView) findViewById(R.id.imgClearAICRateOfReturn);
        this.llAICRateOfReturn = (LinearLayout) findViewById(R.id.llAICRateOfReturn);
        this.edtAICTenure = (EditText) findViewById(R.id.edtAICTenure);
        this.imgClearAICTenure = (ImageView) findViewById(R.id.imgClearAICTenure);
        this.llAICTenure = (LinearLayout) findViewById(R.id.llAICTenure);
        this.btnAICCalculator = (Button) findViewById(R.id.btnAICCalculator);
        this.btnAICMonth = (Button) findViewById(R.id.btnAICMonth);
        this.btnAICYear = (Button) findViewById(R.id.btnAICYear);
        this.txtAICInvestmentAmount = (TextView) findViewById(R.id.txtAICInvestmentAmount);
        this.txtAICEndingBalance = (TextView) findViewById(R.id.txtAICEndingBalance);
        this.txtAICSaveDetails = (TextView) findViewById(R.id.txtAICSaveDetails);
        this.txtAICMoreDetail = (TextView) findViewById(R.id.txtAICMoreDetail);
        this.btnAICSave = (Button) findViewById(R.id.btnAICSave);
        Util.textChangedListener(this.edtAICStartingInvestmentAmount, this.imgClearAICStartingInvestmentAmount, this.llAICStartingInvestmentAmount);
        Util.textChangedListener(this.edtAICMonthlyAmount, this.imgClearAICMonthlyAmount, this.llAICMonthlyAmount);
        Util.textChangedListener(this.edtAICRateOfReturn, this.imgClearAICRateOfReturn, this.llAICRateOfReturn);
        Util.textChangedListener(this.edtAICTenure, this.imgClearAICTenure, this.llAICTenure);
        this.btnAICMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInvestmentCalculatorActivity.this.isYear = false;
                AddInvestmentCalculatorActivity.this.btnAICYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                AddInvestmentCalculatorActivity.this.btnAICMonth.setBackgroundResource(R.drawable.borders_green);
            }
        });
        this.btnAICYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInvestmentCalculatorActivity.this.isYear = true;
                AddInvestmentCalculatorActivity.this.btnAICMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                AddInvestmentCalculatorActivity.this.btnAICYear.setBackgroundResource(R.drawable.borders_green);
            }
        });
        this.btnAICCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInvestmentCalculatorActivity.this.addInvestmentCalculator();
            }
        });
        this.txtAICMoreDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInvestmentCalculatorActivity.this.addInvestmentCalculator();
                Intent intent = new Intent(AddInvestmentCalculatorActivity.this, AddInvestmentDetailsActivity.class);
                intent.putExtra("investmentList", AddInvestmentCalculatorActivity.this.investmentList);
                intent.putExtra("interestList", AddInvestmentCalculatorActivity.this.interestList);
                intent.putExtra("balanceList", AddInvestmentCalculatorActivity.this.balanceList);
                AddInvestmentCalculatorActivity.this.startActivity(intent);
            }
        });
        this.btnAICSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInvestmentCalculatorActivity.this.addInvestmentCalculator();
                AddInvestmentCalculatorActivity.this.edtTitleName.setText("");
                AddInvestmentCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = AddInvestmentCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, AddInvestmentCalculatorActivity.this.edtTitleName)) {
                            AddInvestmentCalculatorActivity.this.db.addAddIColumn(obj, AddInvestmentCalculatorActivity.this.starting, AddInvestmentCalculatorActivity.this.monthly, AddInvestmentCalculatorActivity.this.rate, (double) AddInvestmentCalculatorActivity.this.month, (AddInvestmentCalculatorActivity.this.monthly * ((double) AddInvestmentCalculatorActivity.this.month)) + AddInvestmentCalculatorActivity.this.starting, Util.round(AddInvestmentCalculatorActivity.this.balance - AddInvestmentCalculatorActivity.this.monthly, 2));
                            AddInvestmentCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                AddInvestmentCalculatorActivity.this.btnAICSave.setVisibility(View.GONE);
                AddInvestmentCalculatorActivity.this.dialog.show();
            }
        });
        this.txtAICSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddInvestmentCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "Add Investment");
                AddInvestmentCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    

    public void addInvestmentCalculator() {
        String obj = this.edtAICMonthlyAmount.getText().toString();
        String obj2 = this.edtAICStartingInvestmentAmount.getText().toString();
        String obj3 = this.edtAICTenure.getText().toString();
        String obj4 = this.edtAICRateOfReturn.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (this.isYear) {
            this.month = Integer.parseInt(obj3) * 12;
        } else {
            this.month = Integer.parseInt(obj3);
        }
        if (((!Util.checkAmount(obj, this.edtAICMonthlyAmount)) | (!Util.checkAmount(obj2, this.edtAICStartingInvestmentAmount)) | (!Util.checkPercentage50(obj4, this.edtAICRateOfReturn))) || (!Util.checkPeriod360((double) this.month, this.edtAICTenure))) {
            this.btnAICSave.setVisibility(View.GONE);
            return;
        }
        this.rate = Double.parseDouble(obj4);
        this.monthly = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.starting = parseDouble;
        this.balance = 0.0d;
        double d = this.rate;
        if (d == 0.0d || this.monthly == 0.0d || parseDouble == 0.0d || this.month == 0) {
            this.txtAICEndingBalance.setText("");
            this.txtAICInvestmentAmount.setText("");
            this.btnAICSave.setVisibility(View.GONE);
            return;
        }
        this.investmentList.clear();
        this.interestList.clear();
        this.balanceList.clear();
        double d2 = d / 1200.0d;
        double d3 = this.monthly + this.starting;
        this.balance = d3;
        this.investmentList.add(Long.valueOf((long) d3));
        for (int i = 0; i < this.month; i++) {
            double d4 = this.balance;
            double d5 = d4 * d2;
            double d6 = this.monthly;
            this.balance = d4 + d5 + d6;
            this.investmentList.add(Long.valueOf((long) d6));
            this.interestList.add(Long.valueOf((long) d5));
            this.balanceList.add(Long.valueOf((long) this.balance));
        }
        this.txtAICEndingBalance.setText("" + Util.round(this.balance - this.monthly, 2));
        this.txtAICInvestmentAmount.setText("" + ((this.monthly * ((double) this.month)) + this.starting));
        this.btnAICSave.setVisibility(View.VISIBLE);
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
