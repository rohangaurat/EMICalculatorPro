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
import androidx.lifecycle.Lifecycle;
import com.demo.cashloanemi.Activity.SaveAndHistoryDetails.SaveDetailsActivity;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

public class RecurringDepositCalculatorActivity extends AppCompatActivity {
    Button btnBRDCalculator;
    Button btnBRDMonth;
    Button btnBRDSave;
    Button btnBRDYear;
    Button btnDialogSave;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtBRDInterestRate;
    EditText edtBRDPrincipalAmount;
    EditText edtBRDTimePeriod;
    EditText edtTitleName;
    ImageView imgClearBRDInterestRate;
    ImageView imgClearBRDPrincipalAmount;
    ImageView imgClearBRDTimePeriod;
    boolean isYear = true;
    LinearLayout llBRDInterestRate;
    LinearLayout llBRDPrincipalAmount;
    LinearLayout llBRDTimePeriod;

    PrefManager prefManager;
    double rdAmount;
    double rdInterestRate;
    Toolbar toolbar;
    TextView txtBRDInterestEarned;
    TextView txtBRDPrincipalAmount;
    TextView txtBRDSaveDetils;
    TextView txtBRDTotalValue;
    Double year = Double.valueOf(0.0d);


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recurring_deposit_calculator);


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
        this.edtBRDPrincipalAmount = (EditText) findViewById(R.id.edtBRDPrincipalAmount);
        this.imgClearBRDPrincipalAmount = (ImageView) findViewById(R.id.imgClearBRDPrincipalAmount);
        this.llBRDPrincipalAmount = (LinearLayout) findViewById(R.id.llBRDPrincipalAmount);
        this.edtBRDInterestRate = (EditText) findViewById(R.id.edtBRDInterestRate);
        this.imgClearBRDInterestRate = (ImageView) findViewById(R.id.imgClearBRDInterestRate);
        this.llBRDInterestRate = (LinearLayout) findViewById(R.id.llBRDInterestRate);
        this.edtBRDTimePeriod = (EditText) findViewById(R.id.edtBRDTimePeriod);
        this.imgClearBRDTimePeriod = (ImageView) findViewById(R.id.imgClearBRDTimePeriod);
        this.llBRDTimePeriod = (LinearLayout) findViewById(R.id.llBRDTimePeriod);
        this.btnBRDCalculator = (Button) findViewById(R.id.btnBRDCalculator);
        this.btnBRDSave = (Button) findViewById(R.id.btnBRDSave);
        this.btnBRDMonth = (Button) findViewById(R.id.btnBRDMonth);
        this.btnBRDYear = (Button) findViewById(R.id.btnBRDYear);
        this.txtBRDInterestEarned = (TextView) findViewById(R.id.txtBRDInterestEarned);
        this.txtBRDTotalValue = (TextView) findViewById(R.id.txtBRDTotalValue);
        this.txtBRDPrincipalAmount = (TextView) findViewById(R.id.txtBRDPrincipalAmount);
        this.txtBRDSaveDetils = (TextView) findViewById(R.id.txtBRDSaveDetils);
        Util.textChangedListener(this.edtBRDPrincipalAmount, this.imgClearBRDPrincipalAmount, this.llBRDPrincipalAmount);
        Util.textChangedListener(this.edtBRDInterestRate, this.imgClearBRDInterestRate, this.llBRDInterestRate);
        Util.textChangedListener(this.edtBRDTimePeriod, this.imgClearBRDTimePeriod, this.llBRDTimePeriod);
        this.btnBRDYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecurringDepositCalculatorActivity.this.isYear = true;
                RecurringDepositCalculatorActivity.this.btnBRDMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                RecurringDepositCalculatorActivity.this.btnBRDYear.setBackgroundResource(R.drawable.borders_green);
                RecurringDepositCalculatorActivity.this.RecurringDepositCalculator();
            }
        });
        this.btnBRDMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecurringDepositCalculatorActivity.this.isYear = false;
                RecurringDepositCalculatorActivity.this.btnBRDYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                RecurringDepositCalculatorActivity.this.btnBRDMonth.setBackgroundResource(R.drawable.borders_green);
                RecurringDepositCalculatorActivity.this.RecurringDepositCalculator();
            }
        });
        this.btnBRDCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecurringDepositCalculatorActivity.this.RecurringDepositCalculator();
            }
        });
        this.btnBRDSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecurringDepositCalculatorActivity.this.RecurringDepositCalculator();
                RecurringDepositCalculatorActivity.this.edtTitleName.setText("");
                RecurringDepositCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = RecurringDepositCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, RecurringDepositCalculatorActivity.this.edtTitleName)) {
                            RecurringDepositCalculatorActivity.this.db.addRDColumn(obj, RecurringDepositCalculatorActivity.this.rdAmount, RecurringDepositCalculatorActivity.this.rdInterestRate, RecurringDepositCalculatorActivity.this.year.doubleValue(), 4.0d);
                            RecurringDepositCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                RecurringDepositCalculatorActivity.this.btnBRDSave.setVisibility(View.GONE);
                RecurringDepositCalculatorActivity.this.dialog.show();
            }
        });
        this.txtBRDSaveDetils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecurringDepositCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "RD");
                RecurringDepositCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    

    public void RecurringDepositCalculator() {
        String obj = this.edtBRDPrincipalAmount.getText().toString();
        String obj2 = this.edtBRDInterestRate.getText().toString();
        String obj3 = this.edtBRDTimePeriod.getText().toString();
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
        if (((!Util.checkAmount(obj, this.edtBRDPrincipalAmount)) | (!Util.checkPercentage50(obj2, this.edtBRDInterestRate))) || (!Util.checkPeriod360(this.year.doubleValue(), this.edtBRDTimePeriod))) {
            this.btnBRDSave.setVisibility(View.GONE);
            return;
        }
        this.rdAmount = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.rdInterestRate = parseDouble;
        if (this.rdAmount == 0.0d || parseDouble == 0.0d || this.year.doubleValue() == 0.0d) {
            this.txtBRDTotalValue.setText("");
            this.txtBRDPrincipalAmount.setText("");
            this.txtBRDInterestEarned.setText("");
            this.btnBRDSave.setVisibility(View.GONE);
            return;
        }
        double d = this.rdAmount;
        double d2 = (this.rdInterestRate / 400.0d) + 1.0d;
        double pow = ((Math.pow(d2, this.year.doubleValue() * 4.0d) - 1.0d) * d) / (1.0d - Math.pow(d2, -0.3333333333333333d));
        TextView textView = this.txtBRDTotalValue;
        textView.setText("" + Util.round(pow, 2));
        TextView textView2 = this.txtBRDPrincipalAmount;
        StringBuilder sb = new StringBuilder("");
        double d3 = d * 12.0d;
        sb.append(Util.round(this.year.doubleValue() * d3, 2));
        textView2.setText(sb.toString());
        TextView textView3 = this.txtBRDInterestEarned;
        textView3.setText("" + Util.round(pow - (d3 * this.year.doubleValue()), 2));
        this.btnBRDSave.setVisibility(View.VISIBLE);
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
