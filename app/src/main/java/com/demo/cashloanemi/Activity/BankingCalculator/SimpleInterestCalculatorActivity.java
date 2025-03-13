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
import com.demo.cashloanemi.Activity.SaveAndHistoryDetails.SaveDetailsActivity;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.demo.cashloanemi.ads.AdsCommon;

public class SimpleInterestCalculatorActivity extends AppCompatActivity {
    Button btnBSICalculator;
    Button btnBSIMonth;
    Button btnBSISave;
    Button btnBSIYear;
    Button btnDialogSave;
    DatabaseHelper db;
    Dialog dialog;
    EditText edtBSIInterestRate;
    EditText edtBSIPrincipalAmount;
    EditText edtBSITenure;
    EditText edtTitleName;
    ImageView imgClearBSIInterestRate;
    ImageView imgClearBSIPrincipalAmount;
    ImageView imgClearBSITenure;
    boolean isYear = true;
    LinearLayout llBSIInterestRate;
    LinearLayout llBSIPrincipalAmount;
    LinearLayout llBSITenure;
    PrefManager prefManager;
    double siAmount;
    double siInterestRate;
    Toolbar toolbar;
    TextView txtBSIInterestEarned;
    TextView txtBSIPrincipalAmount;
    TextView txtBSISavaDetail;
    TextView txtBSITotalValue;
    Double year = Double.valueOf(0.0d);


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple_interest_calculator);


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
        this.llBSIPrincipalAmount = (LinearLayout) findViewById(R.id.llBSIPrincipalAmount);
        this.llBSIInterestRate = (LinearLayout) findViewById(R.id.llBSIInterestRate);
        this.llBSITenure = (LinearLayout) findViewById(R.id.llBSITenure);
        this.edtBSIPrincipalAmount = (EditText) findViewById(R.id.edtBSIPrincipalAmount);
        this.edtBSIInterestRate = (EditText) findViewById(R.id.edtBSIInterestRate);
        this.edtBSITenure = (EditText) findViewById(R.id.edtBSITenure);
        this.imgClearBSIPrincipalAmount = (ImageView) findViewById(R.id.imgClearBSIPrincipalAmount);
        this.imgClearBSIInterestRate = (ImageView) findViewById(R.id.imgClearBSIInterestRate);
        this.imgClearBSITenure = (ImageView) findViewById(R.id.imgClearBSITenure);
        this.btnBSICalculator = (Button) findViewById(R.id.btnBSICalculator);
        this.btnBSISave = (Button) findViewById(R.id.btnBSISave);
        this.btnBSIYear = (Button) findViewById(R.id.btnBSIYear);
        this.btnBSIMonth = (Button) findViewById(R.id.btnBSIMonth);
        this.txtBSIInterestEarned = (TextView) findViewById(R.id.txtBSIInterestEarned);
        this.txtBSIPrincipalAmount = (TextView) findViewById(R.id.txtBSIPrincipalAmount);
        this.txtBSITotalValue = (TextView) findViewById(R.id.txtBSITotalValue);
        this.txtBSISavaDetail = (TextView) findViewById(R.id.txtBSISavaDetail);
        Util.textChangedListener(this.edtBSIPrincipalAmount, this.imgClearBSIPrincipalAmount, this.llBSIPrincipalAmount);
        Util.textChangedListener(this.edtBSIInterestRate, this.imgClearBSIInterestRate, this.llBSIInterestRate);
        Util.textChangedListener(this.edtBSITenure, this.imgClearBSITenure, this.llBSITenure);
        this.btnBSIYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleInterestCalculatorActivity.this.isYear = true;
                SimpleInterestCalculatorActivity.this.btnBSIMonth.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SimpleInterestCalculatorActivity.this.btnBSIYear.setBackgroundResource(R.drawable.borders_green);
                SimpleInterestCalculatorActivity.this.SICalculator();
            }
        });
        this.btnBSIMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleInterestCalculatorActivity.this.isYear = false;
                SimpleInterestCalculatorActivity.this.btnBSIYear.setBackgroundResource(R.drawable.background_basic_cal_gray);
                SimpleInterestCalculatorActivity.this.btnBSIMonth.setBackgroundResource(R.drawable.borders_green);
                SimpleInterestCalculatorActivity.this.SICalculator();
            }
        });
        this.btnBSICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleInterestCalculatorActivity.this.SICalculator();
            }
        });
        this.btnBSISave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleInterestCalculatorActivity.this.SICalculator();
                SimpleInterestCalculatorActivity.this.edtTitleName.setText("");
                SimpleInterestCalculatorActivity.this.btnDialogSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String obj = SimpleInterestCalculatorActivity.this.edtTitleName.getText().toString();
                        if (Util.checkEmpty(obj, SimpleInterestCalculatorActivity.this.edtTitleName)) {
                            SimpleInterestCalculatorActivity.this.db.addSimpleInterestColumn(obj, SimpleInterestCalculatorActivity.this.siAmount, SimpleInterestCalculatorActivity.this.siInterestRate, SimpleInterestCalculatorActivity.this.year.doubleValue());
                            SimpleInterestCalculatorActivity.this.dialog.dismiss();
                        }
                    }
                });
                SimpleInterestCalculatorActivity.this.btnBSISave.setVisibility(View.GONE);
                SimpleInterestCalculatorActivity.this.dialog.show();
            }
        });
        this.txtBSISavaDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SimpleInterestCalculatorActivity.this, SaveDetailsActivity.class);
                intent.putExtra(DatabaseHelper.DB_NAME, "Simple Interest");
                SimpleInterestCalculatorActivity.this.startActivity(intent);
            }
        });
    }

    

    public void SICalculator() {
        String obj = this.edtBSIPrincipalAmount.getText().toString();
        String obj2 = this.edtBSIInterestRate.getText().toString();
        String obj3 = this.edtBSITenure.getText().toString();
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
        if (((!Util.checkAmount(obj, this.edtBSIPrincipalAmount)) | (!Util.checkPercentage50(obj2, this.edtBSIInterestRate))) || (!Util.checkPeriod30(this.year.doubleValue(), this.edtBSITenure))) {
            this.btnBSISave.setVisibility(View.GONE);
            return;
        }
        this.siAmount = Double.parseDouble(obj);
        double parseDouble = Double.parseDouble(obj2);
        this.siInterestRate = parseDouble;
        if (this.siAmount == 0.0d || parseDouble == 0.0d || this.year.doubleValue() == 0.0d) {
            this.txtBSIInterestEarned.setText("");
            this.txtBSIPrincipalAmount.setText("");
            this.txtBSITotalValue.setText("");
            this.btnBSISave.setVisibility(View.GONE);
            return;
        }
        double doubleValue = ((this.siAmount * this.siInterestRate) * this.year.doubleValue()) / 100.0d;
        TextView textView = this.txtBSIInterestEarned;
        textView.setText(Util.round(doubleValue, 2) + "");
        TextView textView2 = this.txtBSIPrincipalAmount;
        textView2.setText(Util.round(this.siAmount, 2) + "");
        TextView textView3 = this.txtBSITotalValue;
        textView3.setText(Util.round(this.siAmount + doubleValue, 2) + "");
        this.btnBSISave.setVisibility(View.VISIBLE);
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
