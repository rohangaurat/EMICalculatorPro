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

public class PublicProvidentFundCalculatorActivity extends AppCompatActivity {
    double PPFAmount;
    double PPFInterestRate;
    Button btnDialogSave;
    Button btnPPFCalculator;
    Button btnPPFHalfYearly;
    Button btnPPFMonth;
    Button btnPPFMonthly;
    Button btnPPFQuarterly;
    Button btnPPFSave;
    Button btnPPFYear;
    Button btnPPFYearly;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtPPFInterestRate;
    EditText edtPPFInvestmentAmount;
    EditText edtPPFTimePeriod;
    EditText edtTitleName;
    ImageView imgClearPPFInterestRate;
    ImageView imgClearPPFInvestmentAmount;
    ImageView imgClearPPFTimePeriod;
    int installment = 1;
    boolean isYear = true;
    LinearLayout llPPFInterestRate;
    LinearLayout llPPFInvestmentAmount;
    LinearLayout llPPFTimePeriod;
    Double month = Double.valueOf(0.0d);
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtPPFInvestmentAmount;
    TextView txtPPFSaveDetils;
    TextView txtPPFTotalAmount;
    TextView txtPPFTotalInterest;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_public_provident_fund_calculator);


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
        this.llPPFInvestmentAmount = (LinearLayout) findViewById(R.id.llPPFInvestmentAmount);
        this.llPPFInterestRate = (LinearLayout) findViewById(R.id.llPPFInterestRate);
        this.llPPFTimePeriod = (LinearLayout) findViewById(R.id.llPPFTimePeriod);
        this.edtPPFInvestmentAmount = (EditText) findViewById(R.id.edtPPFInvestmentAmount);
        this.edtPPFInterestRate = (EditText) findViewById(R.id.edtPPFInterestRate);
        this.edtPPFTimePeriod = (EditText) findViewById(R.id.edtPPFTimePeriod);
        this.imgClearPPFInvestmentAmount = (ImageView) findViewById(R.id.imgClearPPFInvestmentAmount);
        this.imgClearPPFInterestRate = (ImageView) findViewById(R.id.imgClearPPFInterestRate);
        this.imgClearPPFTimePeriod = (ImageView) findViewById(R.id.imgClearPPFTimePeriod);
        this.btnPPFCalculator = (Button) findViewById(R.id.btnPPFCalculator);
        this.btnPPFSave = (Button) findViewById(R.id.btnPPFSave);
        this.btnPPFQuarterly = (Button) findViewById(R.id.btnPPFQuarterly);
        this.btnPPFMonthly = (Button) findViewById(R.id.btnPPFMonthly);
        this.btnPPFYearly = (Button) findViewById(R.id.btnPPFYearly);
        this.btnPPFHalfYearly = (Button) findViewById(R.id.btnPPFHalfYearly);
        this.btnPPFYear = (Button) findViewById(R.id.btnPPFYear);
        this.btnPPFMonth = (Button) findViewById(R.id.btnPPFMonth);
        this.txtPPFTotalInterest = (TextView) findViewById(R.id.txtPPFTotalInterest);
        this.txtPPFInvestmentAmount = (TextView) findViewById(R.id.txtPPFInvestmentAmount);
        this.txtPPFTotalAmount = (TextView) findViewById(R.id.txtPPFTotalAmount);
        this.txtPPFSaveDetils = (TextView) findViewById(R.id.txtPPFSaveDetils);
        Util.textChangedListener(this.edtPPFInvestmentAmount, this.imgClearPPFInvestmentAmount, this.llPPFInvestmentAmount);
        Util.textChangedListener(this.edtPPFInterestRate, this.imgClearPPFInterestRate, this.llPPFInterestRate);
        Util.textChangedListener(this.edtPPFTimePeriod, this.imgClearPPFTimePeriod, this.llPPFTimePeriod);
        this.btnPPFYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.isYear = true;
                PublicProvidentFundCalculatorActivity.this.btnPPFYear.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.isYear = false;
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.installment = 1;
                PublicProvidentFundCalculatorActivity.this.btnPPFYearly.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setVisibility(View.GONE);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFHalfYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.installment = 2;
                PublicProvidentFundCalculatorActivity.this.btnPPFYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFHalfYearly.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setVisibility(View.GONE);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFQuarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.installment = 4;
                PublicProvidentFundCalculatorActivity.this.btnPPFYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFQuarterly.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonthly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setVisibility(View.GONE);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.installment = 12;
                PublicProvidentFundCalculatorActivity.this.btnPPFYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFHalfYearly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFQuarterly.setBackgroundResource(R.drawable.background_basic_cal_gray);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonthly.setBackgroundResource(R.drawable.borders_green);
                PublicProvidentFundCalculatorActivity.this.btnPPFMonth.setVisibility(View.VISIBLE);
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
            }
        });
        this.btnPPFSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicProvidentFundCalculatorActivity.this.PPFCalculator();
                PublicProvidentFundCalculatorActivity.this.edtTitleName.setText("");
                PublicProvidentFundCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = PublicProvidentFundCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, PublicProvidentFundCalculatorActivity.this.edtTitleName)) {
                            PublicProvidentFundCalculatorActivity.this.db.addPPFColumn(obj, PublicProvidentFundCalculatorActivity.this.PPFAmount, PublicProvidentFundCalculatorActivity.this.PPFInterestRate, PublicProvidentFundCalculatorActivity.this.month, PublicProvidentFundCalculatorActivity.this.installment);
                            PublicProvidentFundCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                PublicProvidentFundCalculatorActivity.this.btnPPFSave.setVisibility(View.GONE);
                PublicProvidentFundCalculatorActivity.this.dialog.show();
            }
        });
        this.txtPPFSaveDetils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PublicProvidentFundCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "PPF");
                PublicProvidentFundCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    
    public void PPFCalculator() {
        double d;
        double doubleValue = 0;
        double d2;
        String obj = this.edtPPFInvestmentAmount.getText().toString();
        String obj2 = this.edtPPFInterestRate.getText().toString();
        String obj3 = this.edtPPFTimePeriod.getText().toString();
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
        double d3 = 12.0d;
        if (this.isYear) {
            this.month = Double.valueOf(Double.parseDouble(obj3) * 12.0d);
        } else {
            this.month = Double.valueOf(Double.parseDouble(obj3));
        }
        if (((!Util.checkAmount(obj, this.edtPPFInvestmentAmount)) | (!Util.checkPercentage50(obj2, this.edtPPFInterestRate))) || (!Util.checkPeriod360(this.month.doubleValue(), this.edtPPFTimePeriod))) {
            this.btnPPFSave.setVisibility(View.GONE);
            return;
        }
        this.PPFAmount = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.PPFInterestRate = parseDouble;
        double d4 = 0.0d;
        if (this.PPFAmount == 0.0d || parseDouble == 0.0d || this.month.doubleValue() == 0.0d) {
            this.txtPPFTotalInterest.setText("");
            this.txtPPFInvestmentAmount.setText("");
            this.txtPPFTotalAmount.setText("");
            this.btnPPFSave.setVisibility(View.GONE);
            return;
        }
        double d5 = this.PPFAmount;
        int i = 1;
        while (((double) i) <= this.month.doubleValue()) {
            if (i % 12 == 0) {
                d2 = d4;
                for (int i2 = 1; i2 <= this.installment; i2++) {
                    double round = (Util.round(d5, 0) * this.PPFInterestRate) / ((double) (this.installment * 100));
                    d5 = Util.round(d5, 0) + this.PPFAmount;
                    d2 += round;
                }
            } else {
                d2 = 0.0d;
            }
            d5 = Util.round(d5, 2) + d2;
            i++;
            d4 = 0.0d;
        }
        int i3 = this.installment;
        if (i3 == 1) {
            doubleValue = this.PPFAmount * this.month.doubleValue();
        } else if (i3 == 2) {
            doubleValue = this.PPFAmount * this.month.doubleValue();
            d3 = 6.0d;
        } else if (i3 == 4) {
            doubleValue = this.PPFAmount * this.month.doubleValue();
            d3 = 3.0d;
        } else {
            d = i3 == 12 ? this.PPFAmount * this.month.doubleValue() : 0.0d;
            double round2 = Util.round(d5, 0) - this.PPFAmount;
            this.txtPPFTotalInterest.setText("" + Util.round(round2 - d, 2));
            this.txtPPFInvestmentAmount.setText("" + Util.round(d, 2));
            this.txtPPFTotalAmount.setText("" + Util.round(round2, 2));
            this.btnPPFSave.setVisibility(View.VISIBLE);
        }
        d = doubleValue / d3;
        double round22 = Util.round(d5, 0) - this.PPFAmount;
        this.txtPPFTotalInterest.setText("" + Util.round(round22 - d, 2));
        this.txtPPFInvestmentAmount.setText("" + Util.round(d, 2));
        this.txtPPFTotalAmount.setText("" + Util.round(round22, 2));
        this.btnPPFSave.setVisibility(View.VISIBLE);
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
