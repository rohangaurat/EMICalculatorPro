package com.demo.cashloanemi.Activity.BankingCalculator;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Activity.SaveAndHistoryDetails.SaveDetailsActivity;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.YearWiseAdapter;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

import java.util.ArrayList;

public class FixDepositCalculatorActivity extends AppCompatActivity {
    YearWiseAdapter adapter;
    ArrayList<Long> balanceList;
    Button btnBFDCalculator;
    Button btnBFDHalfYearly;
    Button btnBFDMonth;
    Button btnBFDMonthly;
    Button btnBFDQuarterly;
    Button btnBFDSave;
    Button btnBFDYear;
    Button btnBFDYearly;
    Button btnDialogSave;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtBFDInterestRate;
    EditText edtBFDInvestmentAmount;
    EditText edtBFDTimePeriod;
    EditText edtTitleName;
    double fdAmount;
    ImageView imgClearBFDInterestRate;
    ImageView imgClearBFDInvestmentAmount;
    ImageView imgClearBFDTimePeriod;
    int installment = 1;
    ArrayList<Long> interestList;
    boolean isYear = true;
    LinearLayout llBFDInterestRate;
    LinearLayout llBFDInvestmentAmount;
    LinearLayout llBFDTimePeriod;
    LinearLayout llBFDTitle;
    PrefManager prefManager;
    double rate;
    RecyclerView rcvBFD;
    Toolbar toolbar;
    ArrayList<Long> totalInterestList;
    TextView txtBFDInvestmentAmount;
    TextView txtBFDSaveDetils;
    TextView txtBFDTotalAmount;
    TextView txtBFDTotalInterest;
    Double year = Double.valueOf(0.0d);


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fix_deposit_calculator);


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
        this.balanceList = new ArrayList<>();
        this.interestList = new ArrayList<>();
        this.totalInterestList = new ArrayList<>();
        this.db = new DatabaseHelper(this);
        Dialog dialog2 = new Dialog(this);
        this.dialog = dialog2;
        dialog2.setContentView(R.layout.save_dialog);
        this.dialog.getWindow().setLayout(1000, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.edtTitleName = (EditText) this.dialog.findViewById(R.id.edtTitleName);
        this.btnDialogSave = (Button) this.dialog.findViewById(R.id.btnDialogSave);
        this.llBFDInvestmentAmount = (LinearLayout) findViewById(R.id.llBFDInvestmentAmount);
        this.llBFDInterestRate = (LinearLayout) findViewById(R.id.llBFDInterestRate);
        this.llBFDTimePeriod = (LinearLayout) findViewById(R.id.llBFDTimePeriod);
        this.edtBFDInvestmentAmount = (EditText) findViewById(R.id.edtBFDInvestmentAmount);
        this.edtBFDInterestRate = (EditText) findViewById(R.id.edtBFDInterestRate);
        this.edtBFDTimePeriod = (EditText) findViewById(R.id.edtBFDTimePeriod);
        this.imgClearBFDInvestmentAmount = (ImageView) findViewById(R.id.imgClearBFDInvestmentAmount);
        this.imgClearBFDInterestRate = (ImageView) findViewById(R.id.imgClearBFDInterestRate);
        this.imgClearBFDTimePeriod = (ImageView) findViewById(R.id.imgClearBFDTimePeriod);
        this.btnBFDCalculator = (Button) findViewById(R.id.btnBFDCalculator);
        this.btnBFDSave = (Button) findViewById(R.id.btnBFDSave);
        this.btnBFDQuarterly = (Button) findViewById(R.id.btnBFDQuarterly);
        this.btnBFDMonthly = (Button) findViewById(R.id.btnBFDMonthly);
        this.btnBFDYearly = (Button) findViewById(R.id.btnBFDYearly);
        this.btnBFDHalfYearly = (Button) findViewById(R.id.btnBFDHalfYearly);
        this.btnBFDYear = (Button) findViewById(R.id.btnBFDYear);
        this.btnBFDMonth = (Button) findViewById(R.id.btnBFDMonth);
        this.txtBFDTotalInterest = (TextView) findViewById(R.id.txtBFDTotalInterest);
        this.txtBFDInvestmentAmount = (TextView) findViewById(R.id.txtBFDInvestmentAmount);
        this.txtBFDTotalAmount = (TextView) findViewById(R.id.txtBFDTotalAmount);
        this.txtBFDSaveDetils = (TextView) findViewById(R.id.txtBFDSaveDetils);
        this.llBFDTitle = (LinearLayout) findViewById(R.id.llBFDTitle);
        this.rcvBFD = (RecyclerView) findViewById(R.id.rcvBFD);
        Util.textChangedListener(this.edtBFDInvestmentAmount, this.imgClearBFDInvestmentAmount, this.llBFDInvestmentAmount);
        Util.textChangedListener(this.edtBFDInterestRate, this.imgClearBFDInterestRate, this.llBFDInterestRate);
        Util.textChangedListener(this.edtBFDTimePeriod, this.imgClearBFDTimePeriod, this.llBFDTimePeriod);
        this.btnBFDYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.isYear = true;
                FixDepositCalculatorActivity.this.btnBFDYear.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.isYear = false;
                FixDepositCalculatorActivity.this.btnBFDMonth.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.installment = 1;
                FixDepositCalculatorActivity.this.btnBFDYearly.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDMonth.setVisibility(View.GONE);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDHalfYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.installment = 2;
                FixDepositCalculatorActivity.this.btnBFDYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDHalfYearly.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDMonth.setVisibility(View.GONE);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDQuarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.installment = 4;
                FixDepositCalculatorActivity.this.btnBFDYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDQuarterly.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDMonth.setVisibility(View.GONE);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.installment = 12;
                FixDepositCalculatorActivity.this.btnBFDYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                FixDepositCalculatorActivity.this.btnBFDMonthly.setBackgroundResource(R.drawable.borders_green);
                FixDepositCalculatorActivity.this.btnBFDMonth.setVisibility(View.VISIBLE);
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.FixDepositCalculator();
            }
        });
        this.btnBFDSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDepositCalculatorActivity.this.FixDepositCalculator();
                FixDepositCalculatorActivity.this.edtTitleName.setText("");
                FixDepositCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = FixDepositCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, FixDepositCalculatorActivity.this.edtTitleName)) {
                            FixDepositCalculatorActivity.this.db.addFDColumn(obj, FixDepositCalculatorActivity.this.fdAmount, FixDepositCalculatorActivity.this.rate, FixDepositCalculatorActivity.this.year.doubleValue(), (double) FixDepositCalculatorActivity.this.installment);
                            FixDepositCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                FixDepositCalculatorActivity.this.btnBFDSave.setVisibility(View.GONE);
                FixDepositCalculatorActivity.this.dialog.show();
            }
        });
        this.txtBFDSaveDetils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FixDepositCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "FD");
                FixDepositCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    
    public void FixDepositCalculator() {
        String obj = this.edtBFDInvestmentAmount.getText().toString();
        String obj2 = this.edtBFDInterestRate.getText().toString();
        String obj3 = this.edtBFDTimePeriod.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
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
        if (this.isYear) {
            this.year = Double.valueOf(Double.parseDouble(obj3));
        } else {
            this.year = Double.valueOf(Double.parseDouble(obj3) / 12.0d);
        }
        if (((!Util.checkAmount(obj, this.edtBFDInvestmentAmount)) | (!Util.checkPercentage50(obj2, this.edtBFDInterestRate))) || (!Util.checkPeriod30(this.year.doubleValue(), this.edtBFDTimePeriod))) {
            this.btnBFDSave.setVisibility(View.GONE);
            return;
        }
        this.llBFDTitle.setVisibility(View.VISIBLE);
        this.rcvBFD.setVisibility(View.VISIBLE);
        this.fdAmount = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.rate = parseDouble;
        double d = 0.0d;
        if (this.fdAmount == 0.0d || parseDouble == 0.0d || this.year.doubleValue() == 0.0d) {
            this.btnBFDSave.setVisibility(View.GONE);
            return;
        }
        double d2 = this.fdAmount;
        this.interestList.clear();
        this.balanceList.clear();
        this.totalInterestList.clear();
        double doubleValue = this.year.doubleValue();
        int i = this.installment;
        double d3 = doubleValue * ((double) i);
        double d4 = this.rate / ((double) (i * 100));
        for (int i2 = 0; ((double) i2) < d3; i2++) {
            double d5 = d2 * d4;
            d2 += d5;
            d += d5;
            this.interestList.add(Long.valueOf((long) Util.round(d5, 2)));
            this.balanceList.add(Long.valueOf((long) Util.round(d2, 2)));
            this.totalInterestList.add(Long.valueOf((long) Util.round(d, 2)));
        }
        this.txtBFDTotalAmount.setText("" + Util.round(this.fdAmount + d, 2));
        this.txtBFDInvestmentAmount.setText("" + Util.round(this.fdAmount, 2));
        this.txtBFDTotalInterest.setText("" + Util.round(d, 2));
        YearWiseAdapter yearWiseAdapter = new YearWiseAdapter(this.interestList, this.balanceList, this.totalInterestList);
        this.adapter = yearWiseAdapter;
        this.rcvBFD.setAdapter(yearWiseAdapter);
        this.rcvBFD.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.btnBFDSave.setVisibility(View.VISIBLE);
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
