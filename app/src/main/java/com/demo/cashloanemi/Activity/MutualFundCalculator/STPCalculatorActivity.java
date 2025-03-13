package com.demo.cashloanemi.Activity.MutualFundCalculator;

import android.content.Intent;
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

import java.util.ArrayList;

public class STPCalculatorActivity extends AppCompatActivity {
    ArrayList<Long> beginTransfereeList;
    ArrayList<Long> beginTransferorList;
    Button btnSTPCalculator;
    EditText edtSTPAmount;
    EditText edtSTPInitialInvestmentAmount;
    EditText edtSTPRORTransferee;
    EditText edtSTPRORTransferor;
    EditText edtSTPTenure;
    ArrayList<Long> endTransfereeList;
    ArrayList<Long> endTransferorList;
    ImageView imgClearSTPAmount;
    ImageView imgClearSTPInitialInvestmentAmount;
    ImageView imgClearSTPRORTransferee;
    ImageView imgClearSTPRORTransferor;
    ImageView imgClearSTPTenure;
    ArrayList<Long> interestTransfereeList;
    ArrayList<Long> interestTransferorList;
    LinearLayout llSTPAmount;
    LinearLayout llSTPInitialInvestmentAmount;
    LinearLayout llSTPRORTransferee;
    LinearLayout llSTPRORTransferor;
    LinearLayout llSTPTenure;
    PrefManager prefManager;
    Toolbar toolbar;
    ArrayList<Long> transferredInOrOutList;
    TextView txtSTPMoreDetail;
    TextView txtSTPTotalAmount;
    TextView txtSTPTotalProfit;
    TextView txtSTPTransfereeBalance;
    TextView txtSTPTransferorBalance;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_stpcalculator);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.beginTransferorList = new ArrayList<>();
        this.endTransferorList = new ArrayList<>();
        this.interestTransferorList = new ArrayList<>();
        this.transferredInOrOutList = new ArrayList<>();
        this.beginTransfereeList = new ArrayList<>();
        this.endTransfereeList = new ArrayList<>();
        this.interestTransfereeList = new ArrayList<>();
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.edtSTPAmount = (EditText) findViewById(R.id.edtSTPAmount);
        this.imgClearSTPAmount = (ImageView) findViewById(R.id.imgClearSTPAmount);
        this.llSTPAmount = (LinearLayout) findViewById(R.id.llSTPAmount);
        this.edtSTPInitialInvestmentAmount = (EditText) findViewById(R.id.edtSTPInitialInvestmentAmount);
        this.imgClearSTPInitialInvestmentAmount = (ImageView) findViewById(R.id.imgClearSTPInitialInvestmentAmount);
        this.llSTPInitialInvestmentAmount = (LinearLayout) findViewById(R.id.llSTPInitialInvestmentAmount);
        this.edtSTPRORTransferor = (EditText) findViewById(R.id.edtSTPRORTransferor);
        this.imgClearSTPRORTransferor = (ImageView) findViewById(R.id.imgClearSTPRORTransferor);
        this.llSTPRORTransferor = (LinearLayout) findViewById(R.id.llSTPRORTransferor);
        this.edtSTPRORTransferee = (EditText) findViewById(R.id.edtSTPRORTransferee);
        this.imgClearSTPRORTransferee = (ImageView) findViewById(R.id.imgClearSTPRORTransferee);
        this.llSTPRORTransferee = (LinearLayout) findViewById(R.id.llSTPRORTransferee);
        this.edtSTPTenure = (EditText) findViewById(R.id.edtSTPTenure);
        this.imgClearSTPTenure = (ImageView) findViewById(R.id.imgClearSTPTenure);
        this.llSTPTenure = (LinearLayout) findViewById(R.id.llSTPTenure);
        this.btnSTPCalculator = (Button) findViewById(R.id.btnSTPCalculator);
        this.txtSTPTotalAmount = (TextView) findViewById(R.id.txtSTPTotalAmount);
        this.txtSTPTotalProfit = (TextView) findViewById(R.id.txtSTPTotalProfit);
        this.txtSTPTransferorBalance = (TextView) findViewById(R.id.txtSTPTransferorBalance);
        this.txtSTPTransfereeBalance = (TextView) findViewById(R.id.txtSTPTransfereeBalance);
        this.txtSTPMoreDetail = (TextView) findViewById(R.id.txtSTPMoreDetail);
        Util.textChangedListener(this.edtSTPAmount, this.imgClearSTPAmount, this.llSTPAmount);
        Util.textChangedListener(this.edtSTPInitialInvestmentAmount, this.imgClearSTPInitialInvestmentAmount, this.llSTPInitialInvestmentAmount);
        Util.textChangedListener(this.edtSTPRORTransferor, this.imgClearSTPRORTransferor, this.llSTPRORTransferor);
        Util.textChangedListener(this.edtSTPRORTransferee, this.imgClearSTPRORTransferee, this.llSTPRORTransferee);
        Util.textChangedListener(this.edtSTPTenure, this.imgClearSTPTenure, this.llSTPTenure);
        this.btnSTPCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STPCalculatorActivity.this.STPCalculator();
            }
        });
        this.txtSTPMoreDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STPCalculatorActivity.this.STPCalculator();
                Intent intent = new Intent(STPCalculatorActivity.this, STPDetailsActivity.class);
                intent.putExtra("beginTransferorList", STPCalculatorActivity.this.beginTransferorList);
                intent.putExtra("endTransferorList", STPCalculatorActivity.this.endTransferorList);
                intent.putExtra("interestTransferorList", STPCalculatorActivity.this.interestTransferorList);
                intent.putExtra("transferredInOrOutList", STPCalculatorActivity.this.transferredInOrOutList);
                intent.putExtra("beginTransfereeList", STPCalculatorActivity.this.beginTransfereeList);
                intent.putExtra("endTransfereeList", STPCalculatorActivity.this.endTransfereeList);
                intent.putExtra("interestTransfereeList", STPCalculatorActivity.this.interestTransfereeList);
                STPCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    
    public void STPCalculator() {
        String obj = this.edtSTPAmount.getText().toString();
        String obj2 = this.edtSTPRORTransferee.getText().toString();
        String obj3 = this.edtSTPRORTransferor.getText().toString();
        String obj4 = this.edtSTPInitialInvestmentAmount.getText().toString();
        String obj5 = this.edtSTPTenure.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty() || obj5.isEmpty()) {
            Toast.makeText(this, "Enter the Value", Toast.LENGTH_SHORT).show();
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
        if (obj4.isEmpty()) {
            obj4 = "0";
        }
        if (obj.isEmpty()) {
            obj = "0";
        }
        if (((!Util.checkAmount(obj, this.edtSTPAmount)) | (!Util.checkAmount(obj4, this.edtSTPInitialInvestmentAmount)) | (!Util.checkPercentage50(obj2, this.edtSTPRORTransferee)) | (!Util.checkPercentage50(obj3, this.edtSTPRORTransferor))) || (!Util.checkPeriod360(Double.parseDouble(obj5), this.edtSTPTenure))) {
            this.txtSTPMoreDetail.setVisibility(View.GONE);
            return;
        }
        double parseDouble = Double.parseDouble(obj5);
        double parseDouble2 = Double.parseDouble(obj2);
        double parseDouble3 = Double.parseDouble(obj3);
        double parseDouble4 = Double.parseDouble(obj4);
        double parseDouble5 = Double.parseDouble(obj);
        this.beginTransferorList.clear();
        this.endTransferorList.clear();
        this.interestTransferorList.clear();
        this.transferredInOrOutList.clear();
        this.beginTransfereeList.clear();
        this.endTransfereeList.clear();
        this.interestTransfereeList.clear();
        if (parseDouble == 0.0d || parseDouble2 == 0.0d || parseDouble3 == 0.0d || parseDouble4 == 0.0d || parseDouble5 == 0.0d) {
            this.txtSTPTotalAmount.setText("");
            this.txtSTPTotalProfit.setText("");
            this.txtSTPTransferorBalance.setText("");
            this.txtSTPTransfereeBalance.setText("");
            this.txtSTPMoreDetail.setVisibility(View.GONE);
            return;
        }
        double d = parseDouble3 / 1200.0d;
        double d2 = parseDouble2 / 1200.0d;
        int i = 0;
        double d3 = parseDouble5;
        double d4 = parseDouble4 - parseDouble5;
        double d5 = 0.0d;
        while (((double) i) < parseDouble) {
            this.beginTransferorList.add(Long.valueOf((long) Util.round(parseDouble4, 0)));
            this.transferredInOrOutList.add(Long.valueOf((long) d3));
            double d6 = d4;
            double d7 = parseDouble5;
            double round = d * Util.round(d6, 0);
            parseDouble4 = Util.round(d6, 0) + Util.round(round, 0);
            d5 += round;
            this.endTransferorList.add(Long.valueOf((long) Util.round(parseDouble4, 0)));
            this.interestTransferorList.add(Long.valueOf((long) Util.round(round, 1)));
            i++;
            parseDouble5 = d7;
            d = d;
            d4 = parseDouble4;
            d3 = 0.0d;
        }
        double d8 = parseDouble5;
        double d9 = 0.0d;
        double d10 = d5;
        int i2 = 0;
        double d11 = d4;
        while (((double) i2) < parseDouble) {
            this.beginTransfereeList.add(Long.valueOf((long) Util.round(d9, 0)));
            double round2 = Util.round(parseDouble5, 0) * d2;
            parseDouble5 = Util.round(parseDouble5, 0) + Util.round(round2, 0);
            d10 += round2;
            this.endTransfereeList.add(Long.valueOf((long) parseDouble5));
            this.interestTransfereeList.add(Long.valueOf((long) round2));
            i2++;
            d9 = parseDouble5;
        }
        this.txtSTPTotalAmount.setText(Util.round(d8, 2) + "");
        this.txtSTPTotalProfit.setText("" + Util.round(d10, 0));
        this.txtSTPTransferorBalance.setText("" + Util.round(d11, 2));
        this.txtSTPTransfereeBalance.setText("" + Util.round(d9, 2));
        this.txtSTPMoreDetail.setVisibility(View.VISIBLE);
    }

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
