package com.demo.cashloanemi.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;

import java.util.ArrayList;

public class CashCountActivity extends AppCompatActivity {
    EditText edtCCQuantityRs10;
    EditText edtCCQuantityRs100;
    EditText edtCCQuantityRs20;
    EditText edtCCQuantityRs200;
    EditText edtCCQuantityRs2000;
    EditText edtCCQuantityRs50;
    EditText edtCCQuantityRs500;
    PrefManager prefManager;
    Toolbar toolbar;
    TextView txtCCTotalAmount;
    TextView txtCCTotalCash10;
    TextView txtCCTotalCash100;
    TextView txtCCTotalCash20;
    TextView txtCCTotalCash200;
    TextView txtCCTotalCash2000;
    TextView txtCCTotalCash50;
    TextView txtCCTotalCash500;
    TextView txtCCTotalQuantity;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cash_count);


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
        this.edtCCQuantityRs10 = (EditText) findViewById(R.id.edtCCQuantityRs10);
        this.edtCCQuantityRs20 = (EditText) findViewById(R.id.edtCCQuantityRs20);
        this.edtCCQuantityRs50 = (EditText) findViewById(R.id.edtCCQuantityRs50);
        this.edtCCQuantityRs100 = (EditText) findViewById(R.id.edtCCQuantityRs100);
        this.edtCCQuantityRs200 = (EditText) findViewById(R.id.edtCCQuantityRs200);
        this.edtCCQuantityRs500 = (EditText) findViewById(R.id.edtCCQuantityRs500);
        this.edtCCQuantityRs2000 = (EditText) findViewById(R.id.edtCCQuantityRs2000);
        this.txtCCTotalCash10 = (TextView) findViewById(R.id.txtCCTotalCash10);
        this.txtCCTotalCash20 = (TextView) findViewById(R.id.txtCCTotalCash20);
        this.txtCCTotalCash50 = (TextView) findViewById(R.id.txtCCTotalCash50);
        this.txtCCTotalCash100 = (TextView) findViewById(R.id.txtCCTotalCash100);
        this.txtCCTotalCash200 = (TextView) findViewById(R.id.txtCCTotalCash200);
        this.txtCCTotalCash500 = (TextView) findViewById(R.id.txtCCTotalCash500);
        this.txtCCTotalCash2000 = (TextView) findViewById(R.id.txtCCTotalCash2000);
        this.txtCCTotalAmount = (TextView) findViewById(R.id.txtCCTotalAmount);
        this.txtCCTotalQuantity = (TextView) findViewById(R.id.txtCCTotalQuantity);
        TextChangedListener(this.edtCCQuantityRs10, this.txtCCTotalCash10, 10);
        TextChangedListener(this.edtCCQuantityRs20, this.txtCCTotalCash20, 20);
        TextChangedListener(this.edtCCQuantityRs50, this.txtCCTotalCash50, 50);
        TextChangedListener(this.edtCCQuantityRs100, this.txtCCTotalCash100, 100);
        TextChangedListener(this.edtCCQuantityRs200, this.txtCCTotalCash200, 200);
        TextChangedListener(this.edtCCQuantityRs500, this.txtCCTotalCash500, 500);
        TextChangedListener(this.edtCCQuantityRs2000, this.txtCCTotalCash2000, 2000);
    }

    private void TextChangedListener(final EditText editText, final TextView textView, final int i) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String obj = editText.getText().toString();
                if (!obj.isEmpty()) {
                    //TextView textView = textView;
                    textView.setText((Long.parseLong(obj) * ((long) i)) + "");
                } else {
                    textView.setText("");
                }
                CashCountActivity.this.totalCashAmount();
                CashCountActivity.this.totalCashQuantity();
            }
        });
    }

    
    public void totalCashQuantity() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        String obj = this.edtCCQuantityRs10.getText().toString();
        String obj2 = this.edtCCQuantityRs20.getText().toString();
        String obj3 = this.edtCCQuantityRs50.getText().toString();
        String obj4 = this.edtCCQuantityRs100.getText().toString();
        String obj5 = this.edtCCQuantityRs200.getText().toString();
        String obj6 = this.edtCCQuantityRs500.getText().toString();
        String obj7 = this.edtCCQuantityRs2000.getText().toString();
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
        if (obj7.isEmpty()) {
            obj7 = "0";
        }
        long parseLong = Long.parseLong(obj);
        long parseLong2 = Long.parseLong(obj2);
        long parseLong3 = Long.parseLong(obj3);
        long parseLong4 = Long.parseLong(obj4);
        long parseLong5 = Long.parseLong(obj5);
        long parseLong6 = Long.parseLong(obj6);
        long parseLong7 = Long.parseLong(obj7);
        arrayList.add(Long.valueOf(parseLong));
        arrayList.add(Long.valueOf(parseLong2));
        arrayList.add(Long.valueOf(parseLong3));
        arrayList.add(Long.valueOf(parseLong4));
        arrayList.add(Long.valueOf(parseLong5));
        arrayList.add(Long.valueOf(parseLong6));
        arrayList.add(Long.valueOf(parseLong7));
        if (arrayList.size() != 0) {
            this.edtCCQuantityRs10.setHint((CharSequence) null);
            this.edtCCQuantityRs100.setHint((CharSequence) null);
            this.edtCCQuantityRs20.setHint((CharSequence) null);
            this.edtCCQuantityRs200.setHint((CharSequence) null);
            this.edtCCQuantityRs2000.setHint((CharSequence) null);
            this.edtCCQuantityRs50.setHint((CharSequence) null);
            this.edtCCQuantityRs500.setHint((CharSequence) null);
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((Long) arrayList.get(i)).longValue();
        }
        TextView textView = this.txtCCTotalQuantity;
        textView.setText("" + j);
    }

    
    public void totalCashAmount() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        long parseLong = Long.parseLong(this.txtCCTotalCash10.getText().toString());
        long parseLong2 = Long.parseLong(this.txtCCTotalCash20.getText().toString());
        long parseLong3 = Long.parseLong(this.txtCCTotalCash50.getText().toString());
        long parseLong4 = Long.parseLong(this.txtCCTotalCash100.getText().toString());
        long parseLong5 = Long.parseLong(this.txtCCTotalCash200.getText().toString());
        long parseLong6 = Long.parseLong(this.txtCCTotalCash500.getText().toString());
        long parseLong7 = Long.parseLong(this.txtCCTotalCash2000.getText().toString());
        arrayList.add(Long.valueOf(parseLong));
        arrayList.add(Long.valueOf(parseLong2));
        arrayList.add(Long.valueOf(parseLong3));
        arrayList.add(Long.valueOf(parseLong4));
        arrayList.add(Long.valueOf(parseLong5));
        arrayList.add(Long.valueOf(parseLong6));
        arrayList.add(Long.valueOf(parseLong7));
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((Long) arrayList.get(i)).longValue();
        }
        TextView textView = this.txtCCTotalAmount;
        textView.setText(j + "");
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
