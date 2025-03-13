package com.demo.cashloanemi.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.demo.cashloanemi.Activity.LoanCalculator.EMICalculatorActivity;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;
import com.facebook.ads.NativeAdLayout;

public class HomeActivity extends AppCompatActivity {
    ImageView img_rate_review;
    LinearLayout llBasicCalculator;
    LinearLayout llCashCount;
    LinearLayout llCurrencyConverter;
    LinearLayout llEmiCal;
    LinearLayout llNumberToWord;
    LinearLayout llOtherCalculator;
    PrefManager prefManager;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);

        //Reguler Native Ads
        FrameLayout admob_native_frame = (FrameLayout) findViewById(R.id.Admob_Native_Frame);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) findViewById(R.id.native_ad_container);
        FrameLayout maxNative = (FrameLayout) findViewById(R.id.max_native_ad_layout);
        AdsCommon.RegulerBigNative(this, admob_native_frame, nativeAdLayout, maxNative);



        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.prefManager = new PrefManager(this);
        this.llNumberToWord = (LinearLayout) findViewById(R.id.llNumberToWord);
        this.llCashCount = (LinearLayout) findViewById(R.id.llCashCount);
        this.llCurrencyConverter = (LinearLayout) findViewById(R.id.llCurrencyConverter);
        this.llBasicCalculator = (LinearLayout) findViewById(R.id.llBasicCalculator);
        this.llEmiCal = (LinearLayout) findViewById(R.id.llEmiCal);
        this.llOtherCalculator = (LinearLayout) findViewById(R.id.llOtherCalculator);
        this.llEmiCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EMICalculatorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.llOtherCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, OthersCalculatorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.img_rate_review);
        this.img_rate_review = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate app
                final String rateapp = getPackageName();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + rateapp));
                startActivity(intent1);
            }
        });
        this.llBasicCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SimpleCalculatorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.llCashCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CashCountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.llCurrencyConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CurrencyActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.llNumberToWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AmountToWordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Exitdailog();
    }

    public void Exitdailog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.exit_dialog);
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCanceledOnTouchOutside(false);
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.adView);
        ((LinearLayout) dialog.findViewById(R.id.lin_exit_yes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                HomeActivity.this.finish();
            }
        });
        ((LinearLayout) dialog.findViewById(R.id.lin_exit_no)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        try {
            dialog.show();
        } catch (Exception unused) {
            dialog.dismiss();
        }
    }
}
