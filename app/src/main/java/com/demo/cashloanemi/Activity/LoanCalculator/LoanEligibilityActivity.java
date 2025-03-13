package com.demo.cashloanemi.Activity.LoanCalculator;

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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

public class LoanEligibilityActivity extends AppCompatActivity {
    Button btnLECCalculator;
    Button btnLECMonth;
    Button btnLECYear;
    EditText edtLECInterestRate;
    EditText edtLECLoanAmount;
    EditText edtLECMonthlyIncome;
    EditText edtLECOtherEMIs;
    EditText edtLECTenure;
    ImageView imgLECClearInterestRate;
    ImageView imgLECClearLoanAmount;
    ImageView imgLECClearMonthlyIncome;
    ImageView imgLECClearOtherEMIs;
    ImageView imgLECClearTenure;
    boolean isYear = true;
    LinearLayout llLECInterestRate;
    LinearLayout llLECLoanAmount;
    LinearLayout llLECMonthlyIncome;
    LinearLayout llLECOtherEMIs;
    LinearLayout llLECTenure;
    PrefManager prefManager;
    Double time = Double.valueOf(0.0d);
    Toolbar toolbar;
    TextView txtLECEligibleLoan;
    TextView txtLECEmiEligible;
    TextView txtLECEmiOfLoan;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_loan_eligibility);


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
        this.llLECMonthlyIncome = (LinearLayout) findViewById(R.id.llLECMonthlyIncome);
        this.llLECOtherEMIs = (LinearLayout) findViewById(R.id.llLECOtherEMIs);
        this.llLECLoanAmount = (LinearLayout) findViewById(R.id.llLECLoanAmount);
        this.llLECInterestRate = (LinearLayout) findViewById(R.id.llLECInterestRate);
        this.llLECTenure = (LinearLayout) findViewById(R.id.llLECTenure);
        this.edtLECMonthlyIncome = (EditText) findViewById(R.id.edtLECMonthlyIncome);
        this.edtLECOtherEMIs = (EditText) findViewById(R.id.edtLECOtherEMIs);
        this.edtLECLoanAmount = (EditText) findViewById(R.id.edtLECLoanAmount);
        this.edtLECInterestRate = (EditText) findViewById(R.id.edtLECInterestRate);
        this.edtLECTenure = (EditText) findViewById(R.id.edtLECTenure);
        this.imgLECClearOtherEMIs = (ImageView) findViewById(R.id.imgLECClearOtherEMIs);
        this.imgLECClearMonthlyIncome = (ImageView) findViewById(R.id.imgLECClearMonthlyIncome);
        this.imgLECClearLoanAmount = (ImageView) findViewById(R.id.imgLECClearLoanAmount);
        this.imgLECClearInterestRate = (ImageView) findViewById(R.id.imgLECClearInterestRate);
        this.imgLECClearTenure = (ImageView) findViewById(R.id.imgLECClearTenure);
        this.btnLECCalculator = (Button) findViewById(R.id.btnLECCalculator);
        this.btnLECMonth = (Button) findViewById(R.id.btnLECMonth);
        this.btnLECYear = (Button) findViewById(R.id.btnLECYear);
        this.txtLECEmiOfLoan = (TextView) findViewById(R.id.txtLECEmiOfLoan);
        this.txtLECEmiEligible = (TextView) findViewById(R.id.txtLECEmiEligible);
        this.txtLECEligibleLoan = (TextView) findViewById(R.id.txtLECEligibleLoan);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((CharSequence) "Loan Eligibility Calculator");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        Util.textChangedListener(this.edtLECMonthlyIncome, this.imgLECClearMonthlyIncome, this.llLECMonthlyIncome);
        Util.textChangedListener(this.edtLECOtherEMIs, this.imgLECClearOtherEMIs, this.llLECOtherEMIs);
        Util.textChangedListener(this.edtLECLoanAmount, this.imgLECClearLoanAmount, this.llLECLoanAmount);
        Util.textChangedListener(this.edtLECInterestRate, this.imgLECClearInterestRate, this.llLECInterestRate);
        Util.textChangedListener(this.edtLECTenure, this.imgLECClearTenure, this.llLECTenure);
        this.btnLECCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoanEligibilityActivity.this.loanEligibilityCalculator();
            }
        });
        this.btnLECMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoanEligibilityActivity.this.btnLECMonth.setBackgroundResource(R.drawable.borders_green);
                LoanEligibilityActivity.this.btnLECYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                LoanEligibilityActivity.this.isYear = false;
                LoanEligibilityActivity.this.loanEligibilityCalculator();
            }
        });
        this.btnLECYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoanEligibilityActivity.this.btnLECMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                LoanEligibilityActivity.this.btnLECYear.setBackgroundResource(R.drawable.borders_green);
                LoanEligibilityActivity.this.isYear = true;
                LoanEligibilityActivity.this.loanEligibilityCalculator();
            }
        });
    }

    
    public void loanEligibilityCalculator() {
        double d;
        double d2;
        double d3;
        String str;
        int i;
        String obj = this.edtLECLoanAmount.getText().toString();
        String obj2 = this.edtLECInterestRate.getText().toString();
        String obj3 = this.edtLECTenure.getText().toString();
        String obj4 = this.edtLECMonthlyIncome.getText().toString();
        String obj5 = this.edtLECOtherEMIs.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty() || obj5.isEmpty()) {
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
        if (obj5.isEmpty()) {
            obj5 = "0";
        }
        if (this.isYear) {
            this.time = Double.valueOf(Double.parseDouble(obj3) * 12.0d);
        } else {
            this.time = Double.valueOf(Double.parseDouble(obj3));
        }
        if (!((!Util.checkAmount(obj, this.edtLECLoanAmount, this.llLECLoanAmount)) | (!Util.checkAmount(obj4, this.edtLECMonthlyIncome, this.llLECMonthlyIncome)) | (!Util.checkPercentage50(obj2, this.edtLECInterestRate, this.llLECInterestRate)) | (!Util.checkPeriod360(this.time.doubleValue(), this.edtLECTenure, this.llLECTenure))) && !(!Util.checkAmount(obj5, this.edtLECOtherEMIs, this.llLECOtherEMIs))) {
            double parseDouble = Double.parseDouble(obj4);
            double parseDouble2 = Double.parseDouble(obj5);
            double parseDouble3 = Double.parseDouble(obj);
            double parseDouble4 = Double.parseDouble(obj2);
            int i2 = (parseDouble > 0.0d ? 1 : (parseDouble == 0.0d ? 0 : -1));
            if (i2 == 0 || parseDouble2 < 0.0d) {
                this.txtLECEmiEligible.setText("");
                d2 = 0.0d;
                d = 0.0d;
            } else {
                d = emiEligible(parseDouble, parseDouble2).doubleValue();
                this.txtLECEmiEligible.setText("" + Util.round(d, 2));
                d2 = 0.0d;
            }
            if (parseDouble3 == d2 || parseDouble4 == d2 || this.time.doubleValue() == d2) {
                d3 = d;
                i = 2;
                str = "";
                this.txtLECEmiOfLoan.setText(str);
            } else {
                d3 = d;
                i = 2;
                str = "";
                double emiOfLoan = Util.emiOfLoan(parseDouble3, parseDouble4, this.time.doubleValue());
                this.txtLECEmiOfLoan.setText(str + Util.round(emiOfLoan, 2));
            }
            if (i2 == 0 || parseDouble2 < 0.0d || parseDouble4 == 0.0d || this.time.doubleValue() == 0.0d) {
                this.txtLECEligibleLoan.setText(str);
                return;
            }
            int i3 = i;
            double eligibleLoan = eligibleLoan(Double.valueOf(d3), parseDouble4, this.time.doubleValue());
            this.txtLECEligibleLoan.setText(str + Util.round(eligibleLoan, i3));
        }
    }

    private double eligibleLoan(Double d, double d2, double d3) {
        double d4 = d2 / 1200.0d;
        double d5 = d4 + 1.0d;
        return Util.round(d.doubleValue() / ((d4 * Math.pow(d5, d3)) / (Math.pow(d5, d3) - 1.0d)), 2);
    }

    private Double emiEligible(double d, double d2) {
        return Double.valueOf((d * 0.5d) - d2);
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
