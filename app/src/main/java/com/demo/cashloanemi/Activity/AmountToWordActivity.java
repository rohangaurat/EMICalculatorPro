package com.demo.cashloanemi.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Locale;

public class AmountToWordActivity extends AppCompatActivity {
    Button btnTextToSpeech;
    ClipData clip;
    ClipboardManager clipboard;
    EditText edtAWAmount;
    PrefManager prefManager;
    TextToSpeech textToSpeech;
    Toolbar toolbar;
    TextView txtAWWord;
    TextView txtCopy;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_amount_to_word);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.edtAWAmount = (EditText) findViewById(R.id.edtAWAmount);
        this.txtAWWord = (TextView) findViewById(R.id.txtAWWord);
        this.btnTextToSpeech = (Button) findViewById(R.id.btnTextToSpeech);
        this.txtCopy = (TextView) findViewById(R.id.txtCopy);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.clipboard = (ClipboardManager) getSystemService("clipboard");
        this.textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != -1) {
                    AmountToWordActivity.this.textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        this.edtAWAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String trim = AmountToWordActivity.this.edtAWAmount.getText().toString().trim();
                if (trim.isEmpty()) {
                    return;
                }
                if (trim.length() <= 19) {
                    AmountToWordActivity.this.txtAWWord.setText(Words.convertToIndianCurrency(trim));
                    AmountToWordActivity.this.txtCopy.setTextColor(Color.parseColor("#2F2F30"));
                    return;
                }
                AmountToWordActivity.this.txtAWWord.setText("");
            }
        });
        this.btnTextToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmountToWordActivity.this.textToSpeech.speak(AmountToWordActivity.this.txtAWWord.getText().toString(), 0, (HashMap) null);
            }
        });
        this.txtCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmountToWordActivity.this.txtCopy.setTextColor(Color.parseColor("#01AC3B"));
                AmountToWordActivity amountToWordActivity = AmountToWordActivity.this;
                amountToWordActivity.clip = ClipData.newPlainText("label", amountToWordActivity.txtAWWord.getText().toString());
                AmountToWordActivity.this.clipboard.setPrimaryClip(AmountToWordActivity.this.clip);
            }
        });
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
