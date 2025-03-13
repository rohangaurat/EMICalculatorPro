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

public class CompoundInterestCalculatorActivity extends AppCompatActivity {
    YearWiseAdapter adapter;
    Button btnBCICalculator;
    Button btnBCIMonth;
    Button btnBCISave;
    Button btnBCIYear;
    Button btnDialogSave;
    double ciAmount;
    double ciInterestRate;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtBCIInterestRate;
    EditText edtBCIPrincipalAmount;
    EditText edtBCITenure;
    EditText edtTitleName;
    ImageView imgClearBCIInterestRate;
    ImageView imgClearBCIPrincipalAmount;
    ImageView imgClearBCITenure;
    ArrayList<Long> interestList;
    boolean isYear = true;
    LinearLayout llBCIInterestRate;
    LinearLayout llBCIPrincipalAmount;
    LinearLayout llBCITenure;
    LinearLayout llBCITitle;
    PrefManager prefManager;
    RecyclerView rcvBCI;
    Toolbar toolbar;
    ArrayList<Long> totalBalanceList;
    ArrayList<Long> totalInterestList;
    TextView txtBCIInterestEarned;
    TextView txtBCIPrincipalAmount;
    TextView txtBCISavaDetail;
    TextView txtBCITotalValue;
    Double year = Double.valueOf(0.0d);

    

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_compound_interest_calculator_activity);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.interestList = new ArrayList<>();
        this.totalInterestList = new ArrayList<>();
        this.totalBalanceList = new ArrayList<>();
        this.interestList = new ArrayList<>();
        this.totalInterestList = new ArrayList<>();
        this.totalBalanceList = new ArrayList<>();
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.db = new DatabaseHelper(this);
        Dialog dialog2 = new Dialog(this);
        this.dialog = dialog2;
        dialog2.setContentView(R.layout.save_dialog);
        this.dialog.getWindow().setLayout(1000, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.edtTitleName = (EditText) this.dialog.findViewById(R.id.edtTitleName);
        this.btnDialogSave = (Button) this.dialog.findViewById(R.id.btnDialogSave);
        this.llBCIPrincipalAmount = (LinearLayout) findViewById(R.id.llBCIPrincipalAmount);
        this.llBCIInterestRate = (LinearLayout) findViewById(R.id.llBCIInterestRate);
        this.llBCITenure = (LinearLayout) findViewById(R.id.llBCITenure);
        this.edtBCIPrincipalAmount = (EditText) findViewById(R.id.edtBCIPrincipalAmount);
        this.edtBCIInterestRate = (EditText) findViewById(R.id.edtBCIInterestRate);
        this.edtBCITenure = (EditText) findViewById(R.id.edtBCITenure);
        this.imgClearBCIPrincipalAmount = (ImageView) findViewById(R.id.imgClearBCIPrincipalAmount);
        this.imgClearBCIInterestRate = (ImageView) findViewById(R.id.imgClearBCIInterestRate);
        this.imgClearBCITenure = (ImageView) findViewById(R.id.imgClearBCITenure);
        this.btnBCICalculator = (Button) findViewById(R.id.btnBCICalculator);
        this.btnBCISave = (Button) findViewById(R.id.btnBCISave);
        this.btnBCIYear = (Button) findViewById(R.id.btnBCIYear);
        this.btnBCIMonth = (Button) findViewById(R.id.btnBCIMonth);
        this.txtBCIInterestEarned = (TextView) findViewById(R.id.txtBCIInterestEarned);
        this.txtBCIPrincipalAmount = (TextView) findViewById(R.id.txtBCIPrincipalAmount);
        this.txtBCITotalValue = (TextView) findViewById(R.id.txtBCITotalValue);
        this.txtBCISavaDetail = (TextView) findViewById(R.id.txtBCISavaDetail);
        this.rcvBCI = (RecyclerView) findViewById(R.id.rcvBCI);
        this.llBCITitle = (LinearLayout) findViewById(R.id.llBCITitle);
        Util.textChangedListener(this.edtBCIPrincipalAmount, this.imgClearBCIPrincipalAmount, this.llBCIPrincipalAmount);
        Util.textChangedListener(this.edtBCIInterestRate, this.imgClearBCIInterestRate, this.llBCIInterestRate);
        Util.textChangedListener(this.edtBCITenure, this.imgClearBCITenure, this.llBCITenure);
        this.btnBCIYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompoundInterestCalculatorActivity.this.isYear = true;
                CompoundInterestCalculatorActivity.this.btnBCIMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CompoundInterestCalculatorActivity.this.btnBCIYear.setBackgroundResource(R.drawable.borders_green);
                CompoundInterestCalculatorActivity.this.CICalculator();
            }
        });
        this.btnBCIMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompoundInterestCalculatorActivity.this.isYear = false;
                CompoundInterestCalculatorActivity.this.btnBCIYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                CompoundInterestCalculatorActivity.this.btnBCIMonth.setBackgroundResource(R.drawable.borders_green);
                CompoundInterestCalculatorActivity.this.CICalculator();
            }
        });
        this.btnBCICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompoundInterestCalculatorActivity.this.llBCITitle.setVisibility(View.VISIBLE);
                CompoundInterestCalculatorActivity.this.CICalculator();
            }
        });
        this.btnBCISave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompoundInterestCalculatorActivity.this.CICalculator();
                CompoundInterestCalculatorActivity.this.edtTitleName.setText("");
                CompoundInterestCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = CompoundInterestCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, CompoundInterestCalculatorActivity.this.edtTitleName)) {
                            CompoundInterestCalculatorActivity.this.db.addCompoundInterestColumn(obj, CompoundInterestCalculatorActivity.this.ciAmount, CompoundInterestCalculatorActivity.this.ciInterestRate, CompoundInterestCalculatorActivity.this.year.doubleValue());
                            CompoundInterestCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                CompoundInterestCalculatorActivity.this.btnBCISave.setVisibility(View.GONE);
                CompoundInterestCalculatorActivity.this.dialog.show();
            }
        });
        this.txtBCISavaDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompoundInterestCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "Compound Interest");
                CompoundInterestCalculatorActivity.this.startActivity(intent);
            }
        });
    }


    public void CICalculator() {
        String obj = this.edtBCIPrincipalAmount.getText().toString();
        String obj2 = this.edtBCIInterestRate.getText().toString();
        String obj3 = this.edtBCITenure.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            Toast.makeText(this, "Enter the Value", 0).show();
        }
        if (obj2.isEmpty()) {
            obj2 = "0";
        }
        if (obj3.isEmpty()) {
            obj3 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (this.isYear) {
            this.year = Double.valueOf(Double.parseDouble(obj3));
        } else {
            this.year = Double.valueOf(Double.parseDouble(obj3) / 12.0d);
        }
        if (((!Util.checkAmount(obj, this.edtBCIPrincipalAmount)) | (!Util.checkPercentage50(obj2, this.edtBCIInterestRate))) || (!Util.checkPeriod30(this.year.doubleValue(), this.edtBCITenure))) {
            this.btnBCISave.setVisibility(View.GONE);
            return;
        }
        this.ciAmount = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.ciInterestRate = parseDouble;
        if (this.ciAmount == 0.0d || parseDouble == 0.0d || this.year.doubleValue() == 0.0d) {
            this.txtBCIInterestEarned.setText("");
            this.txtBCIPrincipalAmount.setText("");
            this.txtBCITotalValue.setText("");
            this.interestList.clear();
            this.totalBalanceList.clear();
            this.totalInterestList.clear();
            this.adapter = new YearWiseAdapter(this.interestList, this.totalBalanceList, this.totalInterestList);
            this.btnBCISave.setVisibility(View.GONE);
        } else {
            double d = 100.0d;
            double pow = this.ciAmount * Math.pow((this.ciInterestRate / 100.0d) + 1.0d, this.year.doubleValue());
            this.interestList.clear();
            this.totalBalanceList.clear();
            this.totalInterestList.clear();
            double d2 = this.ciAmount;
            TextView textView = this.txtBCIInterestEarned;
            textView.setText(Util.round(pow - this.ciAmount, 2) + "");
            TextView textView2 = this.txtBCIPrincipalAmount;
            textView2.setText(Util.round(this.ciAmount, 2) + "");
            TextView textView3 = this.txtBCITotalValue;
            textView3.setText(Util.round(pow, 2) + "");
            int i = 0;
            double d3 = 0.0d;
            while (((double) i) < this.year.doubleValue()) {
                double d4 = (this.ciInterestRate / d) * d2;
                d2 += d4;
                double d5 = d3 + d4;
                this.totalInterestList.add(Long.valueOf((long) Util.round(d5, 2)));
                this.interestList.add(Long.valueOf((long) Util.round(d4, 2)));
                this.totalBalanceList.add(Long.valueOf((long) Util.round(d2, 2)));
                i++;
                d3 = d5;
                d = 100.0d;
            }
            this.adapter = new YearWiseAdapter(this.interestList, this.totalBalanceList, this.totalInterestList);
            this.btnBCISave.setVisibility(View.VISIBLE);
        }
        this.rcvBCI.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.rcvBCI.setAdapter(this.adapter);
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
