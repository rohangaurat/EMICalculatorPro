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

public class TipCalculatorActivity extends AppCompatActivity {
    double billAmount;
    Button btnDialogSave;
    Button btnTIPCalculator;
    Button btnTIPSave;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtTIPBill;
    EditText edtTIPSplit;
    EditText edtTIPTaxRate;
    EditText edtTIPTipRate;
    EditText edtTitleName;
    ImageView imgClearTIPBill;
    ImageView imgClearTIPSplit;
    ImageView imgClearTIPTaxRate;
    ImageView imgClearTIPTipRate;
    LinearLayout llTIPBill;
    LinearLayout llTIPSplit;
    LinearLayout llTIPTaxRate;
    LinearLayout llTIPTipRate;
    PrefManager prefManager;
    double split;
    double taxRate;
    double tipRate;
    Toolbar toolbar;
    TextView txtTIPEachPay;
    TextView txtTIPSavaDetail;
    TextView txtTIPTotalPayAmount;
    TextView txtTIPTotalTipAmount;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tip_calculator);


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
        this.llTIPBill = (LinearLayout) findViewById(R.id.llTIPBill);
        this.llTIPTipRate = (LinearLayout) findViewById(R.id.llTIPTipRate);
        this.llTIPSplit = (LinearLayout) findViewById(R.id.llTIPSplit);
        this.llTIPTaxRate = (LinearLayout) findViewById(R.id.llTIPTaxRate);
        this.edtTIPBill = (EditText) findViewById(R.id.edtTIPBill);
        this.edtTIPTipRate = (EditText) findViewById(R.id.edtTIPTipRate);
        this.edtTIPSplit = (EditText) findViewById(R.id.edtTIPSplit);
        this.edtTIPTaxRate = (EditText) findViewById(R.id.edtTIPTaxRate);
        this.imgClearTIPBill = (ImageView) findViewById(R.id.imgClearTIPBill);
        this.imgClearTIPTipRate = (ImageView) findViewById(R.id.imgClearTIPTipRate);
        this.imgClearTIPSplit = (ImageView) findViewById(R.id.imgClearTIPSplit);
        this.imgClearTIPTaxRate = (ImageView) findViewById(R.id.imgClearTIPTaxRate);
        this.btnTIPCalculator = (Button) findViewById(R.id.btnTIPCalculator);
        this.btnTIPSave = (Button) findViewById(R.id.btnTIPSave);
        this.txtTIPTotalTipAmount = (TextView) findViewById(R.id.txtTIPTotalTipAmount);
        this.txtTIPTotalPayAmount = (TextView) findViewById(R.id.txtTIPTotalPayAmount);
        this.txtTIPEachPay = (TextView) findViewById(R.id.txtTIPEachPay);
        this.txtTIPSavaDetail = (TextView) findViewById(R.id.txtTIPSavaDetail);
        Util.textChangedListener(this.edtTIPBill, this.imgClearTIPBill, this.llTIPBill);
        Util.textChangedListener(this.edtTIPTipRate, this.imgClearTIPTipRate, this.llTIPTipRate);
        Util.textChangedListener(this.edtTIPSplit, this.imgClearTIPSplit, this.llTIPSplit);
        Util.textChangedListener(this.edtTIPTaxRate, this.imgClearTIPTaxRate, this.llTIPTaxRate);
        this.btnTIPCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipCalculatorActivity.this.tipCalculator();
            }
        });
        this.btnTIPSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipCalculatorActivity.this.tipCalculator();
                TipCalculatorActivity.this.edtTitleName.setText("");
                TipCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = TipCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, TipCalculatorActivity.this.edtTitleName)) {
                            TipCalculatorActivity.this.db.addTipColumn(obj, TipCalculatorActivity.this.billAmount, TipCalculatorActivity.this.tipRate, TipCalculatorActivity.this.taxRate, TipCalculatorActivity.this.split);
                            TipCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                TipCalculatorActivity.this.btnTIPSave.setVisibility(View.GONE);
                TipCalculatorActivity.this.dialog.show();
            }
        });
        this.txtTIPSavaDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "Tip");
                TipCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    
    public void tipCalculator() {
        String obj = this.edtTIPBill.getText().toString();
        String obj2 = this.edtTIPTipRate.getText().toString();
        String obj3 = this.edtTIPSplit.getText().toString();
        String obj4 = this.edtTIPTaxRate.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty() || obj4.isEmpty()) {
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
        if (((!Util.checkPercentage100(obj2, this.edtTIPTipRate)) | (!Util.checkEmpty(obj3, this.edtTIPSplit)) | (!Util.checkPercentage100(obj4, this.edtTIPTaxRate))) || (!Util.checkAmount(obj, this.edtTIPBill))) {
            this.btnTIPSave.setVisibility(View.GONE);
            return;
        }
        this.billAmount = Double.parseDouble(obj);
        this.tipRate = Double.parseDouble(obj2);
        this.split = Double.parseDouble(obj3);
        double parseDouble = Double.parseDouble(obj4);
        this.taxRate = parseDouble;
        double d = this.billAmount;
        if (d != 0.0d) {
            double d2 = this.split;
            if (d2 >= 1.0d) {
                double d3 = this.tipRate;
                double d4 = (((d3 + parseDouble) * d) / 100.0d) + d;
                TextView textView = this.txtTIPTotalTipAmount;
                textView.setText("" + Util.round((d * d3) / 100.0d, 2));
                TextView textView2 = this.txtTIPTotalPayAmount;
                textView2.setText("" + Util.round(d4, 2));
                TextView textView3 = this.txtTIPEachPay;
                textView3.setText("" + Util.round(d4 / d2, 2));
                this.btnTIPSave.setVisibility(View.VISIBLE);
                return;
            }
        }
        this.txtTIPTotalTipAmount.setText("");
        this.txtTIPTotalPayAmount.setText("");
        this.txtTIPEachPay.setText("");
        this.btnTIPSave.setVisibility(View.GONE);
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
