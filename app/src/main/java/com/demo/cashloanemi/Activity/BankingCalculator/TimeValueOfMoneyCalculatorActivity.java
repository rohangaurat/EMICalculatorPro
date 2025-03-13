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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

public class TimeValueOfMoneyCalculatorActivity extends AppCompatActivity {
    Button btnDialogSave;
    Button btnTVMCalculator;
    Button btnTVMFutureValue;
    Button btnTVMHalfYearly;
    Button btnTVMMonthly;
    Button btnTVMPayments;
    Button btnTVMPeriods;
    Button btnTVMPresentValue;
    Button btnTVMQuarterly;
    Button btnTVMRate;
    Button btnTVMSave;
    Button btnTVMYearly;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtTVMFutureValue;
    EditText edtTVMInterestRate;
    EditText edtTVMPayments;
    EditText edtTVMPresentValue;
    EditText edtTVMTimePeriod;
    EditText edtTitleName;
    double futureValue;
    ImageView imgClearTVMFutureValue;
    ImageView imgClearTVMInterestRate;
    ImageView imgClearTVMPayments;
    ImageView imgClearTVMPresentValue;
    ImageView imgClearTVMTimePeriod;
    double installment = 1.0d;
    boolean isFV = false;
    boolean isPMT = false;
    boolean isPV = true;
    boolean isPeriod = false;
    boolean isRate = false;
    LinearLayout llFutureValue;
    LinearLayout llInterestRate;
    LinearLayout llOutputFutureValue;
    LinearLayout llOutputPaymentValue;
    LinearLayout llOutputPeriod;
    LinearLayout llOutputPresentsValue;
    LinearLayout llOutputRate;
    LinearLayout llPayments;
    LinearLayout llPresentValue;
    LinearLayout llTVMFutureValue;
    LinearLayout llTVMInterestRate;
    LinearLayout llTVMPayments;
    LinearLayout llTVMPresentValue;
    LinearLayout llTVMTimePeriod;
    LinearLayout llTimePeriod;
    int mode = 0;
    double payment;
    PrefManager prefManager;
    double presentValue;
    double rate;
    RadioButton rbBeginning;
    RadioButton rbEnd;
    int select = 1;
    Toolbar toolbar;
    TextView txtTVMFutureValue;
    TextView txtTVMPaymentValue;
    TextView txtTVMPeriod;
    TextView txtTVMPresentsValue;
    TextView txtTVMRate;
    TextView txtTVMSaveDetils;
    double year;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_time_value_of_money_calculator);


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
        this.db = new DatabaseHelper(this);
        Dialog dialog2 = new Dialog(this);
        this.dialog = dialog2;
        dialog2.setContentView(R.layout.save_dialog);
        this.dialog.getWindow().setLayout(1000, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.edtTitleName = (EditText) this.dialog.findViewById(R.id.edtTitleName);
        this.btnDialogSave = (Button) this.dialog.findViewById(R.id.btnDialogSave);
        this.edtTVMPresentValue = (EditText) findViewById(R.id.edtTVMPresentValue);
        this.imgClearTVMPresentValue = (ImageView) findViewById(R.id.imgClearTVMPresentValue);
        this.llTVMPresentValue = (LinearLayout) findViewById(R.id.llTVMPresentValue);
        this.edtTVMPayments = (EditText) findViewById(R.id.edtTVMPayments);
        this.imgClearTVMPayments = (ImageView) findViewById(R.id.imgClearTVMPayments);
        this.llTVMPayments = (LinearLayout) findViewById(R.id.llTVMPayments);
        this.edtTVMFutureValue = (EditText) findViewById(R.id.edtTVMFutureValue);
        this.imgClearTVMFutureValue = (ImageView) findViewById(R.id.imgClearTVMFutureValue);
        this.llTVMFutureValue = (LinearLayout) findViewById(R.id.llTVMFutureValue);
        this.edtTVMInterestRate = (EditText) findViewById(R.id.edtTVMInterestRate);
        this.imgClearTVMInterestRate = (ImageView) findViewById(R.id.imgClearTVMInterestRate);
        this.llTVMInterestRate = (LinearLayout) findViewById(R.id.llTVMInterestRate);
        this.edtTVMTimePeriod = (EditText) findViewById(R.id.edtTVMTimePeriod);
        this.imgClearTVMTimePeriod = (ImageView) findViewById(R.id.imgClearTVMTimePeriod);
        this.llTVMTimePeriod = (LinearLayout) findViewById(R.id.llTVMTimePeriod);
        this.llPresentValue = (LinearLayout) findViewById(R.id.llPresentValue);
        this.llPayments = (LinearLayout) findViewById(R.id.llPayments);
        this.llFutureValue = (LinearLayout) findViewById(R.id.llFutureValue);
        this.llInterestRate = (LinearLayout) findViewById(R.id.llInterestRate);
        this.llTimePeriod = (LinearLayout) findViewById(R.id.llTimePeriod);
        this.llOutputPresentsValue = (LinearLayout) findViewById(R.id.llOutputPresentsValue);
        this.llOutputPaymentValue = (LinearLayout) findViewById(R.id.llOutputPaymentValue);
        this.llOutputFutureValue = (LinearLayout) findViewById(R.id.llOutputFutureValue);
        this.llOutputRate = (LinearLayout) findViewById(R.id.llOutputRate);
        this.llOutputPeriod = (LinearLayout) findViewById(R.id.llOutputPeriod);
        this.btnTVMPresentValue = (Button) findViewById(R.id.btnTVMPresentValue);
        this.btnTVMPayments = (Button) findViewById(R.id.btnTVMPayments);
        this.btnTVMFutureValue = (Button) findViewById(R.id.btnTVMFutureValue);
        this.btnTVMRate = (Button) findViewById(R.id.btnTVMRate);
        this.btnTVMPeriods = (Button) findViewById(R.id.btnTVMPeriods);
        this.btnTVMQuarterly = (Button) findViewById(R.id.btnTVMQuarterly);
        this.btnTVMMonthly = (Button) findViewById(R.id.btnTVMMonthly);
        this.btnTVMYearly = (Button) findViewById(R.id.btnTVMYearly);
        this.btnTVMHalfYearly = (Button) findViewById(R.id.btnTVMHalfYearly);
        this.btnTVMCalculator = (Button) findViewById(R.id.btnTVMCalculator);
        this.btnTVMSave = (Button) findViewById(R.id.btnTVMSave);
        this.txtTVMPresentsValue = (TextView) findViewById(R.id.txtTVMPresentsValue);
        this.txtTVMPaymentValue = (TextView) findViewById(R.id.txtTVMPaymentValue);
        this.txtTVMFutureValue = (TextView) findViewById(R.id.txtTVMFutureValue);
        this.txtTVMRate = (TextView) findViewById(R.id.txtTVMRate);
        this.txtTVMPeriod = (TextView) findViewById(R.id.txtTVMPeriod);
        this.txtTVMSaveDetils = (TextView) findViewById(R.id.txtTVMSaveDetils);
        this.rbBeginning = (RadioButton) findViewById(R.id.rbBeginning);
        this.rbEnd = (RadioButton) findViewById(R.id.rbEnd);
        Util.textChangedListener(this.edtTVMPresentValue, this.imgClearTVMPresentValue, this.llTVMPresentValue);
        Util.textChangedListener(this.edtTVMPayments, this.imgClearTVMPayments, this.llTVMPayments);
        Util.textChangedListener(this.edtTVMFutureValue, this.imgClearTVMFutureValue, this.llTVMFutureValue);
        Util.textChangedListener(this.edtTVMInterestRate, this.imgClearTVMInterestRate, this.llTVMInterestRate);
        Util.textChangedListener(this.edtTVMTimePeriod, this.imgClearTVMTimePeriod, this.llTVMTimePeriod);
        this.llOutputPresentsValue.setVisibility(View.VISIBLE);
        this.llOutputPaymentValue.setVisibility(View.GONE);
        this.llOutputFutureValue.setVisibility(View.GONE);
        this.llOutputRate.setVisibility(View.GONE);
        this.llOutputPeriod.setVisibility(View.GONE);
        this.btnTVMQuarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.installment = 4.0d;
                TimeValueOfMoneyCalculatorActivity.this.btnTVMYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMQuarterly.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.installment = 12.0d;
                TimeValueOfMoneyCalculatorActivity.this.btnTVMYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMMonthly.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.installment = 1.0d;
                TimeValueOfMoneyCalculatorActivity.this.btnTVMYearly.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMHalfYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.installment = 2.0d;
                TimeValueOfMoneyCalculatorActivity.this.btnTVMYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMHalfYearly.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMPresentValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.select = 1;
                TimeValueOfMoneyCalculatorActivity.this.isPV = true;
                TimeValueOfMoneyCalculatorActivity.this.isFV = false;
                TimeValueOfMoneyCalculatorActivity.this.isPMT = false;
                TimeValueOfMoneyCalculatorActivity.this.isRate = false;
                TimeValueOfMoneyCalculatorActivity.this.isPeriod = false;
                TimeValueOfMoneyCalculatorActivity.this.llOutputPresentsValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPaymentValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputFutureValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputRate.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPeriod.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPayments.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMFutureValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMRate.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPeriods.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPresentValue.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.llFutureValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPresentValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llTimePeriod.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llInterestRate.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPayments.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.rbBeginning.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbEnd.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.select = 2;
                TimeValueOfMoneyCalculatorActivity.this.isPV = false;
                TimeValueOfMoneyCalculatorActivity.this.isFV = false;
                TimeValueOfMoneyCalculatorActivity.this.isPMT = true;
                TimeValueOfMoneyCalculatorActivity.this.isRate = false;
                TimeValueOfMoneyCalculatorActivity.this.isPeriod = false;
                TimeValueOfMoneyCalculatorActivity.this.llOutputPresentsValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPaymentValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputFutureValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputRate.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPeriod.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPresentValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMFutureValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMRate.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPeriods.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPayments.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.llFutureValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPresentValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llTimePeriod.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llInterestRate.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPayments.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbBeginning.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.rbEnd.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMFutureValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.select = 3;
                TimeValueOfMoneyCalculatorActivity.this.isPV = false;
                TimeValueOfMoneyCalculatorActivity.this.isFV = true;
                TimeValueOfMoneyCalculatorActivity.this.isPMT = false;
                TimeValueOfMoneyCalculatorActivity.this.isRate = false;
                TimeValueOfMoneyCalculatorActivity.this.isPeriod = false;
                TimeValueOfMoneyCalculatorActivity.this.llOutputPresentsValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPaymentValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputFutureValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputRate.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPeriod.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPresentValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPayments.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMRate.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPeriods.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMFutureValue.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.llFutureValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llPresentValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llTimePeriod.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llInterestRate.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPayments.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.rbBeginning.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbEnd.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.select = 4;
                TimeValueOfMoneyCalculatorActivity.this.isPV = false;
                TimeValueOfMoneyCalculatorActivity.this.isFV = false;
                TimeValueOfMoneyCalculatorActivity.this.isPMT = false;
                TimeValueOfMoneyCalculatorActivity.this.isRate = true;
                TimeValueOfMoneyCalculatorActivity.this.isPeriod = false;
                TimeValueOfMoneyCalculatorActivity.this.llOutputPresentsValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPaymentValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputFutureValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputRate.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPeriod.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPresentValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPayments.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMFutureValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPeriods.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMRate.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.llFutureValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPresentValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llTimePeriod.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llInterestRate.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llPayments.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbBeginning.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbEnd.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMPeriods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.select = 5;
                TimeValueOfMoneyCalculatorActivity.this.isPV = false;
                TimeValueOfMoneyCalculatorActivity.this.isFV = false;
                TimeValueOfMoneyCalculatorActivity.this.isPMT = false;
                TimeValueOfMoneyCalculatorActivity.this.isRate = false;
                TimeValueOfMoneyCalculatorActivity.this.isPeriod = true;
                TimeValueOfMoneyCalculatorActivity.this.llOutputPresentsValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPaymentValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputFutureValue.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputRate.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llOutputPeriod.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPresentValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPayments.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMFutureValue.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMRate.setBackgroundResource(R.drawable.background_basic_cal_gray);
                TimeValueOfMoneyCalculatorActivity.this.btnTVMPeriods.setBackgroundResource(R.drawable.borders_green);
                TimeValueOfMoneyCalculatorActivity.this.llFutureValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPresentValue.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llTimePeriod.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.llInterestRate.setVisibility(View.VISIBLE);
                TimeValueOfMoneyCalculatorActivity.this.llPayments.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbBeginning.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.rbEnd.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
            }
        });
        this.btnTVMSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeValueOfMoneyCalculatorActivity.this.tvmCalculator();
                TimeValueOfMoneyCalculatorActivity.this.edtTitleName.setText("");
                TimeValueOfMoneyCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = TimeValueOfMoneyCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, TimeValueOfMoneyCalculatorActivity.this.edtTitleName)) {
                            if (TimeValueOfMoneyCalculatorActivity.this.rbEnd.isChecked()) {
                                TimeValueOfMoneyCalculatorActivity.this.mode = 0;
                            } else {
                                TimeValueOfMoneyCalculatorActivity.this.mode = 1;
                            }
                            TimeValueOfMoneyCalculatorActivity.this.db.addTVMColumn(obj, TimeValueOfMoneyCalculatorActivity.this.futureValue, TimeValueOfMoneyCalculatorActivity.this.presentValue, TimeValueOfMoneyCalculatorActivity.this.payment, TimeValueOfMoneyCalculatorActivity.this.rate, TimeValueOfMoneyCalculatorActivity.this.year, TimeValueOfMoneyCalculatorActivity.this.installment, (double) TimeValueOfMoneyCalculatorActivity.this.mode, (double) TimeValueOfMoneyCalculatorActivity.this.select);
                            TimeValueOfMoneyCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                TimeValueOfMoneyCalculatorActivity.this.btnTVMSave.setVisibility(View.GONE);
                TimeValueOfMoneyCalculatorActivity.this.dialog.show();
            }
        });
        this.txtTVMSaveDetils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeValueOfMoneyCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "TVM");
                TimeValueOfMoneyCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    

    public void tvmCalculator() {
        String obj = this.edtTVMPresentValue.getText().toString();
        String obj2 = this.edtTVMFutureValue.getText().toString();
        String obj3 = this.edtTVMPayments.getText().toString();
        String obj4 = this.edtTVMInterestRate.getText().toString();
        String obj5 = this.edtTVMTimePeriod.getText().toString();
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (obj5.isEmpty()) {
            obj5 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (this.isFV) {
            if (((!Util.checkPercentage50(obj4, this.edtTVMInterestRate)) | (!Util.checkPeriod30(Double.parseDouble(obj5), this.edtTVMTimePeriod)) | (!Util.checkAmount(obj, this.edtTVMPresentValue))) || (!Util.checkAmount(obj3, this.edtTVMPayments))) {
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            this.futureValue = 0.0d;
            this.rate = Double.parseDouble(obj4);
            this.year = Double.parseDouble(obj5);
            this.payment = Double.parseDouble(obj3);
            double parseDouble = Double.parseDouble(obj);
            this.presentValue = parseDouble;
            double d = this.rate;
            if (d != 0.0d) {
                double d2 = this.year;
                if (d2 != 0.0d) {
                    double d3 = this.payment;
                    if ((d3 != 0.0d) || (parseDouble != 0.0d)) {
                        this.futureValue = fvCalculationUsePMT(d3, d, d2, this.installment) + fvCalculation(this.presentValue, this.rate, this.year, this.installment);
                        TextView textView = this.txtTVMFutureValue;
                        textView.setText(Util.round(this.futureValue, 2) + "");
                        this.btnTVMSave.setVisibility(View.VISIBLE);
                        return;
                    }
                    this.btnTVMSave.setVisibility(View.GONE);
                    return;
                }
            }
            this.txtTVMFutureValue.setText("");
            this.btnTVMSave.setVisibility(View.GONE);
        } else if (this.isPV) {
            if (((!Util.checkPercentage50(obj4, this.edtTVMInterestRate)) | (!Util.checkPeriod30(Double.parseDouble(obj5), this.edtTVMTimePeriod)) | (!Util.checkAmount(obj2, this.edtTVMFutureValue))) || (!Util.checkAmount(obj3, this.edtTVMPayments))) {
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            this.presentValue = 0.0d;
            this.payment = Double.parseDouble(obj3);
            this.futureValue = Double.parseDouble(obj2);
            this.rate = Double.parseDouble(obj4);
            double parseDouble2 = Double.parseDouble(obj5);
            this.year = parseDouble2;
            double d4 = this.rate;
            if (d4 == 0.0d || parseDouble2 == 0.0d) {
                this.txtTVMPresentsValue.setText("");
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            boolean z = this.payment != 0.0d;
            double d5 = this.futureValue;
            if (z || (d5 != 0.0d)) {
                this.presentValue = pvCalculation(d5, d4, parseDouble2, this.installment) + pvCalculationUsePMT(this.payment, this.rate, this.year, this.installment);
                TextView textView2 = this.txtTVMPresentsValue;
                textView2.setText("" + Util.round(this.presentValue, 2));
                this.btnTVMSave.setVisibility(View.VISIBLE);
                return;
            }
            this.btnTVMSave.setVisibility(View.GONE);
        } else if (this.isPMT) {
            if (((!Util.checkPercentage50(obj4, this.edtTVMInterestRate)) | (!Util.checkPeriod30(Double.parseDouble(obj5), this.edtTVMTimePeriod)) | (!Util.checkAmount(obj2, this.edtTVMFutureValue))) || (!Util.checkAmount(obj, this.edtTVMPresentValue))) {
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            this.payment = 0.0d;
            this.rate = Double.parseDouble(obj4);
            this.year = Double.parseDouble(obj5);
            this.presentValue = Double.parseDouble(obj);
            double parseDouble3 = Double.parseDouble(obj2);
            this.futureValue = parseDouble3;
            double d6 = this.rate;
            if (d6 != 0.0d) {
                double d7 = this.year;
                if (d7 != 0.0d) {
                    double d8 = this.presentValue;
                    if ((d8 != 0.0d) || (parseDouble3 != 0.0d)) {
                        this.payment = paymentCalculationUsePV(d8, d6, d7, this.installment) + paymentCalculationUseFV(this.futureValue, this.rate, this.year, this.installment);
                        TextView textView3 = this.txtTVMPaymentValue;
                        textView3.setText("" + Util.round(this.payment, 2));
                        this.btnTVMSave.setVisibility(View.VISIBLE);
                        return;
                    }
                    this.btnTVMSave.setVisibility(View.GONE);
                    return;
                }
            }
            this.txtTVMPaymentValue.setText("");
            this.btnTVMSave.setVisibility(View.GONE);
        } else if (this.isRate) {
            if (((!Util.checkAmount(obj2, this.edtTVMFutureValue)) | (!Util.checkAmount(obj, this.edtTVMPresentValue))) || (true ^ Util.checkPeriod30(Double.parseDouble(obj5), this.edtTVMTimePeriod))) {
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            this.rate = 0.0d;
            this.presentValue = Double.parseDouble(obj);
            this.futureValue = Double.parseDouble(obj2);
            double parseDouble4 = Double.parseDouble(obj5);
            this.year = parseDouble4;
            double d9 = this.presentValue;
            if (d9 != 0.0d) {
                double d10 = this.futureValue;
                if (!(d10 == 0.0d || parseDouble4 == 0.0d)) {
                    this.rate = rateCalculationUseFVAndPV(d9, d10, parseDouble4, this.installment);
                    TextView textView4 = this.txtTVMRate;
                    textView4.setText("" + Util.round(this.rate, 2));
                    this.btnTVMSave.setVisibility(View.VISIBLE);
                    return;
                }
            }
            this.txtTVMRate.setText("");
            this.btnTVMSave.setVisibility(View.GONE);
        } else if (!this.isPeriod) {
        } else {
            if (((!Util.checkPercentage50(obj4, this.edtTVMInterestRate)) | (!Util.checkAmount(obj2, this.edtTVMFutureValue))) || (true ^ Util.checkAmount(obj, this.edtTVMPresentValue))) {
                this.btnTVMSave.setVisibility(View.GONE);
                return;
            }
            this.year = 0.0d;
            this.presentValue = Double.parseDouble(obj);
            this.futureValue = Double.parseDouble(obj2);
            double parseDouble5 = Double.parseDouble(obj4);
            this.rate = parseDouble5;
            double d11 = this.presentValue;
            if (d11 != 0.0d) {
                double d12 = this.futureValue;
                if (!(d12 == 0.0d || parseDouble5 == 0.0d)) {
                    this.year = timeCalculationUseFVAndPV(d11, d12, parseDouble5, this.installment);
                    TextView textView5 = this.txtTVMPeriod;
                    textView5.setText("" + Util.round(this.year, 2));
                    this.btnTVMSave.setVisibility(View.VISIBLE);
                    return;
                }
            }
            this.txtTVMPeriod.setText("");
            this.btnTVMSave.setVisibility(View.GONE);
        }
    }

    private double timeCalculationUseFVAndPV(double d, double d2, double d3, double d4) {
        return Math.log(d2 / d) / Math.log((d3 / (d4 * 100.0d)) + 1.0d);
    }

    private double rateCalculationUseFVAndPV(double d, double d2, double d3, double d4) {
        return (Math.pow(d2 / d, 1.0d / d3) - 1.0d) * d4 * 100.0d;
    }

    private double fvCalculationUsePMT(double d, double d2, double d3, double d4) {
        double d5 = d2 / (d4 * 100.0d);
        return d * ((Math.pow(d5 + 1.0d, d3) - 1.0d) / d5);
    }

    private double pvCalculationUsePMT(double d, double d2, double d3, double d4) {
        double d5 = d2 / (d4 * 100.0d);
        double pow = Math.pow(d5 + 1.0d, d3);
        return (d / pow) * ((pow - 1.0d) / d5);
    }

    private double paymentCalculationUsePV(double d, double d2, double d3, double d4) {
        double d5 = d2 / (d4 * 100.0d);
        double d6 = d5 + 1.0d;
        double pow = (Math.pow(d6, d3) - 1.0d) / d5;
        if (!this.rbEnd.isChecked()) {
            pow *= d6;
        }
        return (d * Math.pow(d6, d3)) / pow;
    }

    private double paymentCalculationUseFV(double d, double d2, double d3, double d4) {
        double d5 = d2 / (d4 * 100.0d);
        double d6 = d5 + 1.0d;
        double pow = (Math.pow(d6, d3) - 1.0d) / d5;
        if (!this.rbEnd.isChecked()) {
            pow *= d6;
        }
        return d / pow;
    }

    private double fvCalculation(double d, double d2, double d3, double d4) {
        return d * Math.pow((d2 / (d4 * 100.0d)) + 1.0d, d3);
    }

    private double pvCalculation(double d, double d2, double d3, double d4) {
        return d / Math.pow((d2 / (d4 * 100.0d)) + 1.0d, 10.0d);
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
