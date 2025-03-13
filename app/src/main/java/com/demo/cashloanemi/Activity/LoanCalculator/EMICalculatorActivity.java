package com.demo.cashloanemi.Activity.LoanCalculator;

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

public class EMICalculatorActivity extends AppCompatActivity {
    Button btnDialogSave;
    Button btnEMICalculator;
    Button btnEMIMonth;
    Button btnEMISave;
    Button btnEMIYear;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtEMIInterestRate;
    EditText edtEMILoanAmount;
    EditText edtEMITenure;
    EditText edtTitleName;
    double emiLoanAmount;
    double emiLoanInterestRate;
    ImageView imgClearEMIInterestRate;
    ImageView imgClearEMILoanAmount;
    ImageView imgClearEMITenure;
    boolean isYear = true;
    LinearLayout llEMIInterestRate;
    LinearLayout llEMILoanAmount;
    LinearLayout llEMITenure;
    PrefManager prefManager;
    Double time = Double.valueOf(0.0d);
    Toolbar toolbar;
    TextView txtEMIMonthlyEMI;
    TextView txtEMISavaDetail;
    TextView txtEMITotalInterest;
    TextView txtEMITotalPayment;
    TextView txtEMITotalPrinciple;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emicalculator);


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
        this.llEMILoanAmount = (LinearLayout) findViewById(R.id.llEMILoanAmount);
        this.llEMIInterestRate = (LinearLayout) findViewById(R.id.llEMIInterestRate);
        this.llEMITenure = (LinearLayout) findViewById(R.id.llEMITenure);
        this.edtEMILoanAmount = (EditText) findViewById(R.id.edtEMILoanAmount);
        this.edtEMIInterestRate = (EditText) findViewById(R.id.edtEMIInterestRate);
        this.edtEMITenure = (EditText) findViewById(R.id.edtEMITenure);
        this.imgClearEMILoanAmount = (ImageView) findViewById(R.id.imgClearEMILoanAmount);
        this.imgClearEMIInterestRate = (ImageView) findViewById(R.id.imgClearEMIInterestRate);
        this.imgClearEMITenure = (ImageView) findViewById(R.id.imgClearEMITenure);
        this.btnEMICalculator = (Button) findViewById(R.id.btnEMICalculator);
        this.btnEMIMonth = (Button) findViewById(R.id.btnEMIMonth);
        this.btnEMIYear = (Button) findViewById(R.id.btnEMIYear);
        this.btnEMISave = (Button) findViewById(R.id.btnEMISave);
        this.txtEMIMonthlyEMI = (TextView) findViewById(R.id.txtEMIMonthlyEMI);
        this.txtEMITotalPrinciple = (TextView) findViewById(R.id.txtEMITotalPrinciple);
        this.txtEMITotalInterest = (TextView) findViewById(R.id.txtEMITotalInterest);
        this.txtEMITotalPayment = (TextView) findViewById(R.id.txtEMITotalPayment);
        this.txtEMISavaDetail = (TextView) findViewById(R.id.txtEMISavaDetail);
        Util.textChangedListener(this.edtEMILoanAmount, this.imgClearEMILoanAmount, this.llEMILoanAmount);
        Util.textChangedListener(this.edtEMIInterestRate, this.imgClearEMIInterestRate, this.llEMIInterestRate);
        Util.textChangedListener(this.edtEMITenure, this.imgClearEMITenure, this.llEMITenure);
        this.btnEMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMICalculatorActivity.this.emiCalculator();
            }
        });
        this.btnEMIMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMICalculatorActivity.this.btnEMIMonth.setBackgroundResource(R.drawable.borders_green);
                EMICalculatorActivity.this.btnEMIYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                EMICalculatorActivity.this.isYear = false;
                EMICalculatorActivity.this.emiCalculator();
            }
        });
        this.btnEMIYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMICalculatorActivity.this.btnEMIMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                EMICalculatorActivity.this.btnEMIYear.setBackgroundResource(R.drawable.borders_green);
                EMICalculatorActivity.this.isYear = true;
                EMICalculatorActivity.this.emiCalculator();
            }
        });
        this.btnEMISave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMICalculatorActivity.this.emiCalculator();
                EMICalculatorActivity.this.edtTitleName.setText("");
                EMICalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = EMICalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, EMICalculatorActivity.this.edtTitleName)) {
                            EMICalculatorActivity.this.db.addEMILoanColumn(obj, EMICalculatorActivity.this.emiLoanAmount, EMICalculatorActivity.this.emiLoanInterestRate, EMICalculatorActivity.this.time.doubleValue());
                            EMICalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                EMICalculatorActivity.this.btnEMISave.setVisibility(View.GONE);
                EMICalculatorActivity.this.dialog.show();
            }
        });
        this.txtEMISavaDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EMICalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "EMI Loan");
                EMICalculatorActivity.this.startActivity(intent);
            }
        });
    }

    

    public void emiCalculator() {
        String obj = this.edtEMITenure.getText().toString();
        String obj2 = this.edtEMIInterestRate.getText().toString();
        String obj3 = this.edtEMILoanAmount.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        this.emiLoanInterestRate = 0.0d;
        this.emiLoanAmount = 0.0d;
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
            this.time = Double.valueOf(Double.parseDouble(obj) * 12.0d);
        } else {
            this.time = Double.valueOf(Double.parseDouble(obj));
        }
        if (((!Util.checkPeriod360(this.time.doubleValue(), this.edtEMITenure)) | (!Util.checkPercentage50(obj2, this.edtEMIInterestRate))) || (!Util.checkAmount(obj3, this.edtEMILoanAmount))) {
            this.btnEMISave.setVisibility(View.GONE);
            return;
        }
        this.emiLoanInterestRate = Double.parseDouble(obj2);
        this.emiLoanAmount = Double.parseDouble(obj3);
        if (this.time.doubleValue() != 0.0d) {
            double d = this.emiLoanInterestRate;
            if (d != 0.0d) {
                double d2 = this.emiLoanAmount;
                if (d2 != 0.0d) {
                    double emiOfLoan = Util.emiOfLoan(d2, d, this.time.doubleValue());
                    double doubleValue = this.time.doubleValue() * emiOfLoan;
                    double d3 = this.emiLoanAmount;
                    TextView textView = this.txtEMIMonthlyEMI;
                    textView.setText(Util.round(emiOfLoan, 2) + "");
                    TextView textView2 = this.txtEMITotalInterest;
                    textView2.setText(Util.round(doubleValue - d3, 2) + "");
                    TextView textView3 = this.txtEMITotalPayment;
                    textView3.setText(Util.round(doubleValue, 2) + "");
                    TextView textView4 = this.txtEMITotalPrinciple;
                    textView4.setText(Util.round(d3, 2) + "");
                    this.btnEMISave.setVisibility(View.VISIBLE);
                    return;
                }
            }
        }
        this.txtEMIMonthlyEMI.setText("");
        this.txtEMITotalInterest.setText("");
        this.txtEMITotalPayment.setText("");
        this.txtEMITotalPrinciple.setText("");
        this.btnEMISave.setVisibility(View.GONE);
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
