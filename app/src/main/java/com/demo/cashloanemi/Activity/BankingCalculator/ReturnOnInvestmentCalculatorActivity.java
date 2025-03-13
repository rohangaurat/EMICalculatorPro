package com.demo.cashloanemi.Activity.BankingCalculator;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class ReturnOnInvestmentCalculatorActivity extends AppCompatActivity {
    Button btnROICalculator;
    Calendar calendar;
    int diffractionMonth;
    int diffractionYear;
    EditText edtROIAmountInvested;
    EditText edtROIAmountReturned;
    int fromMonth;
    int fromYear;
    ImageView imgClearROIAmountInvested;
    ImageView imgClearROIAmountReturned;
    LinearLayout llROIAmountInvested;
    LinearLayout llROIAmountReturned;
    LinearLayout llROIPickFromDate;
    LinearLayout llROIPickToDate;

    PrefManager prefManager;
    int toMonth;
    int toYear;
    Toolbar toolbar;
    TextView txtROICompoundAnnual;
    TextView txtROIGainOrLoss;
    TextView txtROIInvestmentPeriod;
    TextView txtROIPickFromDate;
    TextView txtROIPickToDate;
    TextView txtROIReturnOnInvestment;
    TextView txtROISimpleAnnual;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_return_on_investment_calculator);


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
        this.calendar = Calendar.getInstance();
        this.edtROIAmountInvested = (EditText) findViewById(R.id.edtROIAmountInvested);
        this.imgClearROIAmountInvested = (ImageView) findViewById(R.id.imgClearROIAmountInvested);
        this.llROIAmountInvested = (LinearLayout) findViewById(R.id.llROIAmountInvested);
        this.edtROIAmountReturned = (EditText) findViewById(R.id.edtROIAmountReturned);
        this.imgClearROIAmountReturned = (ImageView) findViewById(R.id.imgClearROIAmountReturned);
        this.llROIAmountReturned = (LinearLayout) findViewById(R.id.llROIAmountReturned);
        this.btnROICalculator = (Button) findViewById(R.id.btnROICalculator);
        this.txtROIPickFromDate = (TextView) findViewById(R.id.txtROIPickFromDate);
        this.txtROIPickToDate = (TextView) findViewById(R.id.txtROIPickToDate);
        this.txtROIInvestmentPeriod = (TextView) findViewById(R.id.txtROIInvestmentPeriod);
        this.txtROIGainOrLoss = (TextView) findViewById(R.id.txtROIGainOrLoss);
        this.txtROIReturnOnInvestment = (TextView) findViewById(R.id.txtROIReturnOnInvestment);
        this.txtROISimpleAnnual = (TextView) findViewById(R.id.txtROISimpleAnnual);
        this.txtROICompoundAnnual = (TextView) findViewById(R.id.txtROICompoundAnnual);
        this.llROIPickFromDate = (LinearLayout) findViewById(R.id.llROIPickFromDate);
        this.llROIPickToDate = (LinearLayout) findViewById(R.id.llROIPickToDate);
        Util.textChangedListener(this.edtROIAmountInvested, this.imgClearROIAmountInvested, this.llROIAmountInvested);
        Util.textChangedListener(this.edtROIAmountReturned, this.imgClearROIAmountReturned, this.llROIAmountReturned);
        this.btnROICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnOnInvestmentCalculatorActivity.this.ROICalculator();
            }
        });
        this.llROIPickToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnOnInvestmentCalculatorActivity returnOnInvestmentCalculatorActivity = ReturnOnInvestmentCalculatorActivity.this;
                returnOnInvestmentCalculatorActivity.datePick(returnOnInvestmentCalculatorActivity.txtROIPickToDate);
            }
        });
        this.llROIPickFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnOnInvestmentCalculatorActivity returnOnInvestmentCalculatorActivity = ReturnOnInvestmentCalculatorActivity.this;
                returnOnInvestmentCalculatorActivity.datePick(returnOnInvestmentCalculatorActivity.txtROIPickFromDate);
            }
        });
        this.txtROIPickFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnOnInvestmentCalculatorActivity returnOnInvestmentCalculatorActivity = ReturnOnInvestmentCalculatorActivity.this;
                returnOnInvestmentCalculatorActivity.datePick(returnOnInvestmentCalculatorActivity.txtROIPickFromDate);
            }
        });
        this.txtROIPickToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnOnInvestmentCalculatorActivity returnOnInvestmentCalculatorActivity = ReturnOnInvestmentCalculatorActivity.this;
                returnOnInvestmentCalculatorActivity.datePick(returnOnInvestmentCalculatorActivity.txtROIPickToDate);
            }
        });
    }

    
    public void datePick(final TextView textView) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.AlertDialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                //TextView textView = textView;
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append("/");
                int i4 = i2 + 1;
                sb.append(i4);
                sb.append("/");
                sb.append(i);
                textView.setText(sb.toString());
                if (textView == ReturnOnInvestmentCalculatorActivity.this.txtROIPickToDate) {
                    ReturnOnInvestmentCalculatorActivity.this.toMonth = i4;
                    ReturnOnInvestmentCalculatorActivity.this.toYear = i;
                } else if (textView == ReturnOnInvestmentCalculatorActivity.this.txtROIPickFromDate) {
                    ReturnOnInvestmentCalculatorActivity.this.fromYear = i;
                    ReturnOnInvestmentCalculatorActivity.this.fromMonth = i4;
                }
                ReturnOnInvestmentCalculatorActivity.this.ROICalculator();
            }
        }, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
        datePickerDialog.setCancelable(false);
        datePickerDialog.show();
    }

    
    public void ROICalculator() {
        String obj = this.edtROIAmountInvested.getText().toString();
        String obj2 = this.edtROIAmountReturned.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (!(!Util.checkAmount(obj, this.edtROIAmountInvested)) && !(!Util.checkAmount(obj2, this.edtROIAmountReturned))) {
            long parseInt = (long) Integer.parseInt(obj);
            long parseInt2 = (long) Integer.parseInt(obj2);
            if (parseInt2 == 0 || parseInt == 0 || this.toMonth == 0 || this.toYear == 0 || this.fromMonth == 0 || this.fromYear == 0) {
                this.txtROICompoundAnnual.setText("");
                this.txtROIGainOrLoss.setText("");
                this.txtROIInvestmentPeriod.setText("");
                this.txtROIReturnOnInvestment.setText("");
                this.txtROISimpleAnnual.setText("");
                return;
            }
            dateDiffraction();
            double d = ((double) this.diffractionYear) + (((double) this.diffractionMonth) * 0.0834d);
            long j = parseInt2 - parseInt;
            long j2 = j / parseInt;
            TextView textView = this.txtROICompoundAnnual;
            textView.setText(Util.round((Math.pow((double) (parseInt2 / parseInt), 1.0d / d) - 1.0d) * 100.0d, 2) + "%");
            TextView textView2 = this.txtROIGainOrLoss;
            textView2.setText("" + j);
            TextView textView3 = this.txtROIInvestmentPeriod;
            textView3.setText(this.diffractionYear + " Year " + this.diffractionMonth + " Month ");
            TextView textView4 = this.txtROIReturnOnInvestment;
            StringBuilder sb = new StringBuilder();
            sb.append(Util.round((double) (100 * j2), 2));
            sb.append("%");
            textView4.setText(sb.toString());
            TextView textView5 = this.txtROISimpleAnnual;
            textView5.setText(Util.round((((double) j2) / d) * 100.0d, 2) + "%");
        }
    }

    
    public void dateDiffraction() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.diffractionYear = Period.between(LocalDate.of(this.fromYear, this.fromMonth, 3), LocalDate.of(this.toYear, this.toMonth, 5)).getYears();
            this.diffractionMonth = Period.between(LocalDate.of(this.fromYear, this.fromMonth, 3), LocalDate.of(this.toYear, this.toMonth, 5)).getMonths();
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
