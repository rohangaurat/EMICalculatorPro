package com.demo.cashloanemi.Activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.ConverterFavoriteAdapter;
import com.demo.cashloanemi.Adapter.ConverterHistoryAdapter;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.bumptech.glide.Glide;
import com.demo.cashloanemi.ads.AdsCommon;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyActivity extends AppCompatActivity {
    ConverterFavoriteAdapter adapter;
    Button btnConverter;
    OkHttpClient client;
    ConnectivityManager cm;
    ConverterHistoryAdapter converterHistoryAdapter;
    String currentTime;
    DatabaseHelper db;
    EditText edtCCAmount;
    String from = "";
    ImageView imgAddFavorite;
    ImageView imgClearCCAmount;
    ImageView imgFavouriteIcon;
    ImageView imgHistoryIcon;
    int isFavorite = 1;
    LinearLayout llCCAmount;
    LinearLayout llFavourite;
    LinearLayout llHistory;
    PrefManager prefManager;
    ProgressDialog progress;
    RecyclerView rcvConverterFavorite;
    RecyclerView rcvConverterHistory;
    String resultData = "";
    Spinner spCCFrom;
    Spinner spCCTo;
    String to = "";
    Toolbar toolbar;
    TextView txtCurrency;
    TextView txtFavourite;
    TextView txtHistory;
    TextView txtNoData;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_currency);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        PrefManager prefManager2 = new PrefManager(this);
        this.prefManager = prefManager2;
        this.client = new OkHttpClient();
        this.db = new DatabaseHelper(this);
        this.cm = (ConnectivityManager) getSystemService("connectivity");
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.edtCCAmount = (EditText) findViewById(R.id.edtCCAmount);
        this.spCCFrom = (Spinner) findViewById(R.id.spCCFrom);
        this.spCCTo = (Spinner) findViewById(R.id.spCCTo);
        this.btnConverter = (Button) findViewById(R.id.btnConverter);
        this.txtCurrency = (TextView) findViewById(R.id.txtCurrency);
        this.llHistory = (LinearLayout) findViewById(R.id.llHistory);
        this.llFavourite = (LinearLayout) findViewById(R.id.llFavourite);
        this.imgAddFavorite = (ImageView) findViewById(R.id.imgAddFavorite);
        this.rcvConverterFavorite = (RecyclerView) findViewById(R.id.rcvConverterFavorite);
        this.rcvConverterHistory = (RecyclerView) findViewById(R.id.rcvConverterHistory);
        this.txtHistory = (TextView) findViewById(R.id.txtHistory);
        this.txtFavourite = (TextView) findViewById(R.id.txtFavourite);
        this.imgHistoryIcon = (ImageView) findViewById(R.id.imgHistoryIcon);
        this.imgFavouriteIcon = (ImageView) findViewById(R.id.imgFavouriteIcon);
        this.txtNoData = (TextView) findViewById(R.id.txtNoData);
        this.imgClearCCAmount = (ImageView) findViewById(R.id.imgClearCCAmount);
        this.llCCAmount = (LinearLayout) findViewById(R.id.llCCAmount);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progress = progressDialog;
        progressDialog.setMessage("Please wait...");
        this.progress.setTitle("Loading");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Util.getCurrencyCode());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCCTo.setAdapter(arrayAdapter);
        this.spCCFrom.setAdapter(arrayAdapter);
        this.spCCFrom.setSelection(0);
        this.spCCTo.setSelection(1);
        adapterFavorite();
        adapterHistory();
        this.rcvConverterFavorite.setVisibility(View.GONE);
        this.rcvConverterHistory.setVisibility(View.VISIBLE);
        this.spCCFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                CurrencyActivity.this.from = Util.getCurrencyCode().get(i);
                CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_un_favorite);
                CurrencyActivity.this.isFavorite = 1;
                CurrencyActivity.this.imgAddFavorite.setVisibility(View.GONE);
            }
        });
        this.spCCTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                CurrencyActivity.this.to = Util.getCurrencyCode().get(i);
                CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_un_favorite);
                CurrencyActivity.this.isFavorite = 1;
                CurrencyActivity.this.imgAddFavorite.setVisibility(View.GONE);
            }
        });
        this.edtCCAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_un_favorite);
                CurrencyActivity.this.isFavorite = 1;
                CurrencyActivity.this.imgAddFavorite.setVisibility(View.GONE);
            }
        });
        this.btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkInfo activeNetworkInfo = CurrencyActivity.this.cm.getActiveNetworkInfo();
                if (CurrencyActivity.this.edtCCAmount.getText().toString().length() == 0) {
                    Toast.makeText(CurrencyActivity.this, "Enter The Value", Toast.LENGTH_SHORT).show();
                } else if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    Toast.makeText(CurrencyActivity.this, "Network is not connected.", Toast.LENGTH_SHORT).show();
                } else {
                    CurrencyActivity.this.progress.show();
                    CurrencyActivity currencyActivity = CurrencyActivity.this;
                    new AsyncTaskCurrencyConverter(currencyActivity.client).execute(new String[0]);
                }
                CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_un_favorite);
                CurrencyActivity.this.isFavorite = 1;
            }
        });
        this.llFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrencyActivity.this.llFavourite.setBackgroundResource(R.drawable.borders_green);
                CurrencyActivity.this.txtFavourite.setTextColor(Color.parseColor("#01AC3B"));
                Glide.with((FragmentActivity) CurrencyActivity.this).load(Integer.valueOf(R.drawable.ic_un_favorite_green)).into(CurrencyActivity.this.imgFavouriteIcon);
                CurrencyActivity.this.llHistory.setBackground((Drawable) null);
                CurrencyActivity.this.txtHistory.setTextColor(Color.parseColor("#2F2F30"));
                Glide.with((FragmentActivity) CurrencyActivity.this).load(Integer.valueOf(R.drawable.ic_history_)).into(CurrencyActivity.this.imgHistoryIcon);
                CurrencyActivity.this.rcvConverterHistory.setVisibility(View.GONE);
                CurrencyActivity.this.rcvConverterFavorite.setVisibility(View.VISIBLE);
                CurrencyActivity.this.adapterFavorite();
                if (CurrencyActivity.this.db.getConverterFavorite().size() != 0) {
                    CurrencyActivity.this.txtNoData.setVisibility(View.GONE);
                    return;
                }
                CurrencyActivity.this.txtNoData.setText("No Favorites Found");
                CurrencyActivity.this.txtNoData.setVisibility(View.VISIBLE);
                CurrencyActivity.this.rcvConverterFavorite.setVisibility(View.GONE);
            }
        });
        this.llHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrencyActivity.this.llHistory.setBackgroundResource(R.drawable.borders_green);
                CurrencyActivity.this.txtHistory.setTextColor(Color.parseColor("#01AC3B"));
                Glide.with((FragmentActivity) CurrencyActivity.this).load(Integer.valueOf(R.drawable.ic_history_green)).into(CurrencyActivity.this.imgHistoryIcon);
                CurrencyActivity.this.llFavourite.setBackground((Drawable) null);
                CurrencyActivity.this.txtFavourite.setTextColor(Color.parseColor("#2F2F30"));
                Glide.with((FragmentActivity) CurrencyActivity.this).load(Integer.valueOf(R.drawable.ic_un_favorite)).into(CurrencyActivity.this.imgFavouriteIcon);
                CurrencyActivity.this.rcvConverterHistory.setVisibility(View.VISIBLE);
                CurrencyActivity.this.rcvConverterFavorite.setVisibility(View.GONE);
                CurrencyActivity.this.adapterHistory();
                if (CurrencyActivity.this.db.getConverterHistory().size() != 0) {
                    CurrencyActivity.this.txtNoData.setVisibility(View.GONE);
                    return;
                }
                CurrencyActivity.this.txtNoData.setText("No History");
                CurrencyActivity.this.txtNoData.setVisibility(View.VISIBLE);
                CurrencyActivity.this.rcvConverterHistory.setVisibility(View.GONE);
            }
        });
        if (this.db.getConverterHistory().size() != 0) {
            this.txtNoData.setVisibility(View.GONE);
        } else {
            this.txtNoData.setText("No History");
            this.txtNoData.setVisibility(View.VISIBLE);
            this.rcvConverterHistory.setVisibility(View.GONE);
        }
        this.imgAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CurrencyActivity.this.isFavorite == 0) {
                    CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_un_favorite);
                    CurrencyActivity.this.isFavorite = 1;
                } else {
                    CurrencyActivity.this.imgAddFavorite.setImageResource(R.drawable.ic_favorite);
                    CurrencyActivity.this.isFavorite = 0;
                }
                CurrencyActivity.this.db.updateConverterFavorite(CurrencyActivity.this.from, CurrencyActivity.this.to, CurrencyActivity.this.edtCCAmount.getText().toString(), CurrencyActivity.this.isFavorite);
                CurrencyActivity.this.adapterFavorite();
                if (CurrencyActivity.this.txtNoData.getText().toString().equals("No Favorites Found") && CurrencyActivity.this.txtNoData.getVisibility() == View.VISIBLE) {
                    CurrencyActivity.this.txtNoData.setVisibility(View.GONE);
                    CurrencyActivity.this.rcvConverterFavorite.setVisibility(View.VISIBLE);
                }
            }
        });
        textChangedListener(this.edtCCAmount, this.imgClearCCAmount, this.llCCAmount);
    }

    
    public void textChangedListener(final EditText editText, final ImageView imageView, final LinearLayout linearLayout) {
        editText.getText().toString();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                linearLayout.setBackgroundResource(R.drawable.borders_green);
                imageView.setVisibility(View.VISIBLE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                linearLayout.setBackgroundResource(R.drawable.borders_gray);
                imageView.setVisibility(View.GONE);
                editText.setError((CharSequence) null);
            }
        });
    }

    
    public void adapterHistory() {
        ConverterHistoryAdapter converterHistoryAdapter2 = new ConverterHistoryAdapter(this.db.getConverterHistory());
        this.converterHistoryAdapter = converterHistoryAdapter2;
        this.rcvConverterHistory.setAdapter(converterHistoryAdapter2);
        this.rcvConverterHistory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    
    public void adapterFavorite() {
        ConverterFavoriteAdapter converterFavoriteAdapter = new ConverterFavoriteAdapter(this.db.getConverterFavorite());
        this.adapter = converterFavoriteAdapter;
        this.rcvConverterFavorite.setAdapter(converterFavoriteAdapter);
        this.rcvConverterFavorite.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    public class AsyncTaskCurrencyConverter extends AsyncTask<String, Void, String> {
        OkHttpClient client;

        public AsyncTaskCurrencyConverter(OkHttpClient okHttpClient) {
            this.client = okHttpClient;
        }

        @Override
        public String doInBackground(String... strArr) {
            try {
                Request.Builder builder = new Request.Builder();
                Response execute = this.client.newCall(builder.url("https://currencyconverter9.p.rapidapi.com/convert?to=" + CurrencyActivity.this.to.trim() + "&amount=" + CurrencyActivity.this.edtCCAmount.getText().toString().trim() + "&from=" + CurrencyActivity.this.from.trim() + "").get().addHeader("X-RapidAPI-Key", "0564724cb7mshf5bf42cfffced01p13e9e8jsn9fbf2250814c").addHeader("X-RapidAPI-Host", "currencyconverter9.p.rapidapi.com").build()).execute();
                String string = execute.body().string();
                if (execute.code() == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(string).getJSONObject("result");
                        CurrencyActivity currencyActivity = CurrencyActivity.this;
                        currencyActivity.resultData = jSONObject.getString(currencyActivity.to);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return CurrencyActivity.this.resultData;
        }

        @Override
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (str != null) {
                CurrencyActivity.this.progress.dismiss();
                CurrencyActivity.this.currentTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a", Locale.getDefault()).format(new Date());
                CurrencyActivity.this.db.addConverterHistory(CurrencyActivity.this.currentTime, CurrencyActivity.this.from, CurrencyActivity.this.to, CurrencyActivity.this.edtCCAmount.getText().toString(), CurrencyActivity.this.resultData, CurrencyActivity.this.isFavorite);
                TextView textView = CurrencyActivity.this.txtCurrency;
                textView.setText(CurrencyActivity.this.resultData + "");
                CurrencyActivity.this.imgAddFavorite.setVisibility(View.VISIBLE);
                if (CurrencyActivity.this.txtNoData.getText().toString().equals("No History") && CurrencyActivity.this.txtNoData.getVisibility() == View.VISIBLE) {
                    CurrencyActivity.this.txtNoData.setVisibility(View.GONE);
                    CurrencyActivity.this.rcvConverterHistory.setVisibility(View.VISIBLE);
                }
                CurrencyActivity.this.adapterHistory();
            }
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
