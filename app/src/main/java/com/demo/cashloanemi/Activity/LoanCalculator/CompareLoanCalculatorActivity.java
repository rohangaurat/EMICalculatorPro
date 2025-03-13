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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

public class CompareLoanCalculatorActivity extends AppCompatActivity {
    Button btnLCCCalculator;
    Button btnLCCMonth;
    Button btnLCCYear;
    double differenceEMI;
    double differenceTotalAmount;
    EditText edtLCCInterest1;
    EditText edtLCCInterest2;
    EditText edtLCCPrincipleAmount1;
    EditText edtLCCPrincipleAmount2;
    EditText edtLCCTenure1;
    EditText edtLCCTenure2;
    ImageView imgClearLCCInterest1;
    ImageView imgClearLCCInterest2;
    ImageView imgClearLCCPrincipleAmount1;
    ImageView imgClearLCCPrincipleAmount2;
    ImageView imgClearLCCTenure1;
    ImageView imgClearLCCTenure2;
    boolean isYear = true;
    LinearLayout llLCCInterest1;
    LinearLayout llLCCInterest2;
    LinearLayout llLCCPrincipleAmount1;
    LinearLayout llLCCPrincipleAmount2;
    LinearLayout llLCCTenure1;
    LinearLayout llLCCTenure2;
    PrefManager prefManager;
    Double time1;
    Double time2;
    Toolbar toolbar;
    TextView txtLCCAmountCompareL1;
    TextView txtLCCAmountCompareL1Text;
    TextView txtLCCAmountCompareL2;
    TextView txtLCCAmountCompareL2Text;
    TextView txtLCCAmountDifference;
    TextView txtLCCEMICompareL1;
    TextView txtLCCEMICompareL1Text;
    TextView txtLCCEMICompareL2;
    TextView txtLCCEMICompareL2Text;
    TextView txtLCCEMIDifference;

    public CompareLoanCalculatorActivity() {
        Double valueOf = Double.valueOf(0.0d);
        this.time1 = valueOf;
        this.time2 = valueOf;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_compare_loan_calculator);


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
        this.edtLCCPrincipleAmount1 = (EditText) findViewById(R.id.edtLCCPrincipleAmount1);
        this.edtLCCPrincipleAmount2 = (EditText) findViewById(R.id.edtLCCPrincipleAmount2);
        this.edtLCCInterest1 = (EditText) findViewById(R.id.edtLCCInterest1);
        this.edtLCCInterest2 = (EditText) findViewById(R.id.edtLCCInterest2);
        this.edtLCCTenure1 = (EditText) findViewById(R.id.edtLCCTenure1);
        this.edtLCCTenure2 = (EditText) findViewById(R.id.edtLCCTenure2);
        this.imgClearLCCPrincipleAmount1 = (ImageView) findViewById(R.id.imgClearLCCPrincipleAmount1);
        this.imgClearLCCPrincipleAmount2 = (ImageView) findViewById(R.id.imgClearLCCPrincipleAmount2);
        this.imgClearLCCInterest1 = (ImageView) findViewById(R.id.imgClearLCCInterest1);
        this.imgClearLCCInterest2 = (ImageView) findViewById(R.id.imgClearLCCInterest2);
        this.imgClearLCCTenure1 = (ImageView) findViewById(R.id.imgClearLCCTenure1);
        this.imgClearLCCTenure2 = (ImageView) findViewById(R.id.imgClearLCCTenure2);
        this.llLCCPrincipleAmount1 = (LinearLayout) findViewById(R.id.llLCCPrincipleAmount1);
        this.llLCCPrincipleAmount2 = (LinearLayout) findViewById(R.id.llLCCPrincipleAmount2);
        this.llLCCInterest1 = (LinearLayout) findViewById(R.id.llLCCInterest1);
        this.llLCCInterest2 = (LinearLayout) findViewById(R.id.llLCCInterest2);
        this.llLCCTenure1 = (LinearLayout) findViewById(R.id.llLCCTenure1);
        this.llLCCTenure2 = (LinearLayout) findViewById(R.id.llLCCTenure2);
        this.btnLCCCalculator = (Button) findViewById(R.id.btnLCCCalculator);
        this.btnLCCMonth = (Button) findViewById(R.id.btnLCCMonth);
        this.btnLCCYear = (Button) findViewById(R.id.btnLCCYear);
        this.txtLCCEMICompareL1Text = (TextView) findViewById(R.id.txtLCCEMICompareL1Text);
        this.txtLCCEMICompareL1 = (TextView) findViewById(R.id.txtLCCEMICompareL1);
        this.txtLCCEMICompareL2Text = (TextView) findViewById(R.id.txtLCCEMICompareL2Text);
        this.txtLCCEMICompareL2 = (TextView) findViewById(R.id.txtLCCEMICompareL2);
        this.txtLCCEMIDifference = (TextView) findViewById(R.id.txtLCCEMIDifference);
        this.txtLCCAmountCompareL1Text = (TextView) findViewById(R.id.txtLCCAmountCompareL1Text);
        this.txtLCCAmountCompareL1 = (TextView) findViewById(R.id.txtLCCAmountCompareL1);
        this.txtLCCAmountCompareL2Text = (TextView) findViewById(R.id.txtLCCAmountCompareL2Text);
        this.txtLCCAmountCompareL2 = (TextView) findViewById(R.id.txtLCCAmountCompareL2);
        this.txtLCCAmountDifference = (TextView) findViewById(R.id.txtLCCAmountDifference);
        Util.textChangedListener(this.edtLCCPrincipleAmount1, this.imgClearLCCPrincipleAmount1, this.llLCCPrincipleAmount1);
        Util.textChangedListener(this.edtLCCPrincipleAmount2, this.imgClearLCCPrincipleAmount2, this.llLCCPrincipleAmount2);
        Util.textChangedListener(this.edtLCCInterest1, this.imgClearLCCInterest1, this.llLCCInterest1);
        Util.textChangedListener(this.edtLCCInterest2, this.imgClearLCCInterest2, this.llLCCInterest2);
        Util.textChangedListener(this.edtLCCTenure1, this.imgClearLCCTenure1, this.llLCCTenure1);
        Util.textChangedListener(this.edtLCCTenure2, this.imgClearLCCTenure2, this.llLCCTenure2);
        this.btnLCCCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompareLoanCalculatorActivity.this.EMICalculator();
            }
        });
        this.btnLCCMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompareLoanCalculatorActivity.this.btnLCCMonth.setBackgroundResource(R.drawable.borders_green);
                CompareLoanCalculatorActivity.this.btnLCCYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CompareLoanCalculatorActivity.this.isYear = false;
                CompareLoanCalculatorActivity.this.EMICalculator();
            }
        });
        this.btnLCCYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompareLoanCalculatorActivity.this.btnLCCMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CompareLoanCalculatorActivity.this.btnLCCYear.setBackgroundResource(R.drawable.borders_green);
                CompareLoanCalculatorActivity.this.isYear = true;
                CompareLoanCalculatorActivity.this.EMICalculator();
            }
        });
    }

    
    public void EMICalculator() {
        String obj = this.edtLCCPrincipleAmount1.getText().toString();
        String obj2 = this.edtLCCInterest1.getText().toString();
        String obj3 = this.edtLCCTenure1.getText().toString();
        String obj4 = this.edtLCCPrincipleAmount2.getText().toString();
        String obj5 = this.edtLCCInterest2.getText().toString();
        String obj6 = this.edtLCCTenure2.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty() || obj5.isEmpty() || obj6.isEmpty()) {
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
        if (obj6.isEmpty()) {
            obj6 = "0";
        }
        if (this.isYear) {
            this.time1 = Double.valueOf(Double.parseDouble(obj3) * 12.0d);
            this.time2 = Double.valueOf(Double.parseDouble(obj6) * 12.0d);
        } else {
            this.time1 = Double.valueOf(Double.parseDouble(obj3));
            this.time2 = Double.valueOf(Double.parseDouble(obj6));
        }
        if (!((!Util.checkAmount(obj, this.edtLCCPrincipleAmount1, this.llLCCPrincipleAmount1)) | (!Util.checkPeriod360(this.time1.doubleValue(), this.edtLCCTenure1, this.llLCCTenure1)) | (!Util.checkPercentage50(obj2, this.edtLCCInterest1, this.llLCCInterest1)) | (!Util.checkAmount(obj4, this.edtLCCPrincipleAmount2, this.llLCCPrincipleAmount2)) | (!Util.checkPeriod360(this.time2.doubleValue(), this.edtLCCTenure2, this.llLCCTenure2))) && !(!Util.checkPercentage50(obj5, this.edtLCCInterest2, this.llLCCInterest2))) {
            double parseDouble = Double.parseDouble(obj);
            double parseDouble2 = Double.parseDouble(obj2);
            double parseDouble3 = Double.parseDouble(obj4);
            double parseDouble4 = Double.parseDouble(obj5);
            if (parseDouble == 0.0d || parseDouble2 == 0.0d || this.time1.doubleValue() == 0.0d || parseDouble3 == 0.0d || parseDouble4 == 0.0d || this.time2.doubleValue() == 0.0d) {
                CharSequence charSequence = "";
                this.txtLCCEMIDifference.setText(charSequence);
                this.txtLCCAmountCompareL1.setText(charSequence);
                this.txtLCCAmountCompareL2.setText(charSequence);
                this.txtLCCEMICompareL1.setText(charSequence);
                this.txtLCCEMICompareL2.setText(charSequence);
                this.txtLCCAmountDifference.setText(charSequence);
                return;
            }
            double emiOfLoan = Util.emiOfLoan(parseDouble, parseDouble2, this.time1.doubleValue());
            String str = "";
            double emiOfLoan2 = Util.emiOfLoan(parseDouble3, parseDouble4, this.time2.doubleValue());
            double doubleValue = (this.time1.doubleValue() * emiOfLoan) - parseDouble;
            double doubleValue2 = (this.time2.doubleValue() * emiOfLoan2) - parseDouble3;
            this.differenceEMI = emiOfLoan - emiOfLoan2;
            this.differenceTotalAmount = doubleValue - doubleValue2;
            if (emiOfLoan >= emiOfLoan2) {
                TextView textView = this.txtLCCEMICompareL1;
                textView.setText(str + Util.round(emiOfLoan, 2));
                TextView textView2 = this.txtLCCEMICompareL2;
                textView2.setText(str + Util.round(emiOfLoan2, 2));
                this.txtLCCEMICompareL1Text.setText("Loan 1: ");
                this.txtLCCEMICompareL2Text.setText("Loan 2: ");
            } else if (emiOfLoan < emiOfLoan2) {
                TextView textView3 = this.txtLCCEMICompareL2;
                textView3.setText(str + Util.round(emiOfLoan, 2));
                TextView textView4 = this.txtLCCEMICompareL1;
                textView4.setText(str + Util.round(emiOfLoan2, 2));
                this.txtLCCEMICompareL2Text.setText("Loan 1: ");
                this.txtLCCEMICompareL1Text.setText("Loan 2: ");
            }
            if (doubleValue >= doubleValue2) {
                TextView textView5 = this.txtLCCAmountCompareL1;
                textView5.setText(str + Util.round(doubleValue, 2));
                TextView textView6 = this.txtLCCAmountCompareL2;
                textView6.setText(str + Util.round(doubleValue2, 2));
                this.txtLCCAmountCompareL1Text.setText("Loan 1: ");
                this.txtLCCAmountCompareL2Text.setText("Loan 2: ");
            } else if (doubleValue < doubleValue2) {
                TextView textView7 = this.txtLCCAmountCompareL2;
                textView7.setText(str + Util.round(doubleValue, 2));
                TextView textView8 = this.txtLCCAmountCompareL1;
                textView8.setText(str + Util.round(doubleValue2, 2));
                this.txtLCCAmountCompareL2Text.setText("Loan 1: ");
                this.txtLCCAmountCompareL1Text.setText("Loan 2: ");
            }
            TextView textView9 = this.txtLCCEMIDifference;
            textView9.setText(str + Util.round(Math.abs(this.differenceEMI), 2));
            TextView textView10 = this.txtLCCAmountDifference;
            textView10.setText(str + Util.round(Math.abs(this.differenceTotalAmount), 2));
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
