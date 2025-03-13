package com.demo.cashloanemi.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.demo.cashloanemi.Activity.BankingCalculator.CompoundInterestCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.FixDepositCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.PublicProvidentFundCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.RecurringDepositCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.ReturnOnInvestmentCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.SimpleInterestCalculatorActivity;
import com.demo.cashloanemi.Activity.BankingCalculator.TimeValueOfMoneyCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.BreakEventPointCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.CumulativeGrowthActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.GSTCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.GrossProfitCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.InflationCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.MarginCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.MarginWithSalesCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.MarkupCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.OperatingMarginCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.PriceCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.SalesTaxCalculatorActivity;
import com.demo.cashloanemi.Activity.BusinessCalculator.VATCalculatorActivity;
import com.demo.cashloanemi.Activity.LoanCalculator.CompareLoanCalculatorActivity;
import com.demo.cashloanemi.Activity.LoanCalculator.DiscountCalculatorActivity;
import com.demo.cashloanemi.Activity.LoanCalculator.LoanEligibilityActivity;
import com.demo.cashloanemi.Activity.LoanCalculator.TaxCalculatorActivity;
import com.demo.cashloanemi.Activity.LoanCalculator.TipCalculatorActivity;
import com.demo.cashloanemi.Activity.MutualFundCalculator.AddInvestmentCalculatorActivity;
import com.demo.cashloanemi.Activity.MutualFundCalculator.SIPCalculatorActivity;
import com.demo.cashloanemi.Activity.MutualFundCalculator.SIPPlanCalculatorActivity;
import com.demo.cashloanemi.Activity.MutualFundCalculator.STPCalculatorActivity;
import com.demo.cashloanemi.Activity.MutualFundCalculator.SWPCalculatorActivity;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.CalculatorListAdapter;
import com.demo.cashloanemi.Click.CalculatorNameItemClick;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import com.bumptech.glide.Glide;
import com.demo.cashloanemi.ads.AdsCommon;

public class OthersCalculatorActivity extends AppCompatActivity {
    CalculatorListAdapter backingCalculatorAdapter;
    CalculatorListAdapter businessCalculatorAdapter;
    CalculatorNameItemClick click;
    ImageView imgBankingCalArrow;
    ImageView imgBusinessCalArrow;
    ImageView imgLoanCalArrow;
    ImageView imgSIPCalArrow;
    LinearLayout llBankingCal;
    LinearLayout llBankingCalArrow;
    LinearLayout llBusinessCal;
    LinearLayout llBusinessCalArrow;
    LinearLayout llLoanCal;
    LinearLayout llLoanCalArrow;
    LinearLayout llSIPCal;
    LinearLayout llSIPCalArrow;
    CalculatorListAdapter loanCalculatorAdapter;
    String nameww;
    PrefManager prefManager;
    RecyclerView rcvBankingCalculatorName;
    RecyclerView rcvBusinessCalculatorName;
    RecyclerView rcvLoanCalculatorName;
    RecyclerView rcvSIPCalculatorName;
    CalculatorListAdapter sipAdapter;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_otheremicalulator);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.prefManager = new PrefManager(this);
        this.rcvLoanCalculatorName = (RecyclerView) findViewById(R.id.rcvLoanCalculatorName);
        this.rcvBankingCalculatorName = (RecyclerView) findViewById(R.id.rcvBankingCalculatorName);
        this.rcvBusinessCalculatorName = (RecyclerView) findViewById(R.id.rcvBusinessCalculatorName);
        this.rcvSIPCalculatorName = (RecyclerView) findViewById(R.id.rcvSIPCalculatorName);
        this.llBankingCalArrow = (LinearLayout) findViewById(R.id.llBankingCalArrow);
        this.llLoanCalArrow = (LinearLayout) findViewById(R.id.llLoanCalArrow);
        this.llBusinessCalArrow = (LinearLayout) findViewById(R.id.llBusinessCalArrow);
        this.llSIPCalArrow = (LinearLayout) findViewById(R.id.llSIPCalArrow);
        this.llBankingCal = (LinearLayout) findViewById(R.id.llBankingCal);
        this.llLoanCal = (LinearLayout) findViewById(R.id.llLoanCal);
        this.llBusinessCal = (LinearLayout) findViewById(R.id.llBusinessCal);
        this.llSIPCal = (LinearLayout) findViewById(R.id.llSIPCal);
        this.imgBankingCalArrow = (ImageView) findViewById(R.id.imgBankingCalArrow);
        this.imgLoanCalArrow = (ImageView) findViewById(R.id.imgLoanCalArrow);
        this.imgBusinessCalArrow = (ImageView) findViewById(R.id.imgBusinessCalArrow);
        this.imgSIPCalArrow = (ImageView) findViewById(R.id.imgSIPCalArrow);
        this.click = new CalculatorNameItemClick() {
            @Override
            public void getItem(String str) {
                OthersCalculatorActivity.this.nameww = str;
                OthersCalculatorActivity.this.itemClick(str);
            }
        };
        this.loanCalculatorAdapter = new CalculatorListAdapter(Util.getLoanCalculatorNameList(), Util.getLoanCalculatorIconList(), this.click);
        this.backingCalculatorAdapter = new CalculatorListAdapter(Util.getBackingCalculatorNameList(), Util.getBackingCalculatorIconList(), this.click);
        this.businessCalculatorAdapter = new CalculatorListAdapter(Util.getBusinessCalculatorList(), Util.getBusinessCalculatorIconList(), this.click);
        this.sipAdapter = new CalculatorListAdapter(Util.getSipCalculatorList(), Util.getSipCalculatorIconList(), this.click);
        rcvSetAdapter(this.rcvLoanCalculatorName, this.loanCalculatorAdapter);
        rcvSetAdapter(this.rcvBankingCalculatorName, this.backingCalculatorAdapter);
        rcvSetAdapter(this.rcvBusinessCalculatorName, this.businessCalculatorAdapter);
        rcvSetAdapter(this.rcvSIPCalculatorName, this.sipAdapter);
        arrowClick(this.llLoanCalArrow, this.rcvLoanCalculatorName, this.imgLoanCalArrow, this.llLoanCal);
        arrowClick(this.llBankingCalArrow, this.rcvBankingCalculatorName, this.imgBankingCalArrow, this.llBankingCal);
        arrowClick(this.llBusinessCalArrow, this.rcvBusinessCalculatorName, this.imgBusinessCalArrow, this.llBusinessCal);
        arrowClick(this.llSIPCalArrow, this.rcvSIPCalculatorName, this.imgSIPCalArrow, this.llSIPCal);
    }

    private void arrowClick(LinearLayout linearLayout, final RecyclerView recyclerView, final ImageView imageView, final LinearLayout linearLayout2) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerView.getVisibility() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    Glide.with((FragmentActivity) OthersCalculatorActivity.this).load(Integer.valueOf(R.drawable.ic_down_arrow)).into(imageView);
                    linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
                    return;
                }
                recyclerView.setVisibility(View.VISIBLE);
                Glide.with((FragmentActivity) OthersCalculatorActivity.this).load(Integer.valueOf(R.drawable.ic_up_arrow)).into(imageView);
                linearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
            }
        });
    }

    private void rcvSetAdapter(RecyclerView recyclerView, CalculatorListAdapter calculatorListAdapter) {
        recyclerView.setAdapter(calculatorListAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, 1));
    }

    
    public void itemClick(String str) {
        String str2 = str;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2130835864:
                if (str2.equals(" Fixed\nDeposit")) {
                    c = 0;
                    break;
                }
                break;
            case -2094232380:
                if (str2.equals("GST\nCalculator")) {
                    c = 1;
                    break;
                }
                break;
            case -1975254172:
                if (str2.equals("Markup\nCalculator")) {
                    c = 2;
                    break;
                }
                break;
            case -1860347967:
                if (str2.equals("TVM\nCalculator")) {
                    c = 3;
                    break;
                }
                break;
            case -1679829819:
                if (str2.equals("Compare")) {
                    c = 4;
                    break;
                }
                break;
            case -1448269390:
                if (str2.equals("SIP\nCalculator")) {
                    c = 5;
                    break;
                }
                break;
            case -1260944192:
                if (str2.equals("SWP\nCalculator")) {
                    c = 6;
                    break;
                }
                break;
            case -985316322:
                if (str2.equals("Margin\nCalculator")) {
                    c = 7;
                    break;
                }
                break;
            case -935154178:
                if (str2.equals("Cumulative\nGrowth")) {
                    c = 8;
                    break;
                }
                break;
            case -744968254:
                if (str2.equals("Simple\nInterest")) {
                    c = 9;
                    break;
                }
                break;
            case -644818721:
                if (str2.equals("Break Event\nPoint")) {
                    c = 10;
                    break;
                }
                break;
            case -439944500:
                if (str2.equals("Gross Profit\nCalculator")) {
                    c = 11;
                    break;
                }
                break;
            case -436243797:
                if (str2.equals("Discount\nCalculator")) {
                    c = 12;
                    break;
                }
                break;
            case -380735171:
                if (str2.equals("STP\nCalculator")) {
                    c = 13;
                    break;
                }
                break;
            case -304351721:
                if (str2.equals("Operating\nMargin")) {
                    c = 14;
                    break;
                }
                break;
            case -231640847:
                if (str2.equals("Recurring\nDeposit")) {
                    c = 15;
                    break;
                }
                break;
            case -138793312:
                if (str2.equals("ROI\nCalculator ")) {
                    c = 16;
                    break;
                }
                break;
            case -101390333:
                if (str2.equals("VAT\nCalculator")) {
                    c = 17;
                    break;
                }
                break;
            case 84091:
                if (str2.equals("Tip")) {
                    c = 18;
                    break;
                }
                break;
            case 462775873:
                if (str2.equals("Tax\nCalculator")) {
                    c = 19;
                    break;
                }
                break;
            case 737020781:
                if (str2.equals("Eligibility")) {
                    c = 20;
                    break;
                }
                break;
            case 843172398:
                if (str2.equals("Margin\nWith Sales")) {
                    c = 21;
                    break;
                }
                break;
            case 858346589:
                if (str2.equals("SIP Plan\nCalculator")) {
                    c = 22;
                    break;
                }
                break;
            case 1018725542:
                if (str2.equals("PPF\nCalculator")) {
                    c = 23;
                    break;
                }
                break;
            case 1084120924:
                if (str2.equals("Add\nInvestment")) {
                    c = 24;
                    break;
                }
                break;
            case 1340896599:
                if (str2.equals("Compound\nInterest ")) {
                    c = 25;
                    break;
                }
                break;
            case 1456992098:
                if (str2.equals("Inflation\nCalculator")) {
                    c = 26;
                    break;
                }
                break;
            case 1860722147:
                if (str2.equals("Price\nCalculator")) {
                    c = 27;
                    break;
                }
                break;
            case 1931534325:
                if (str2.equals("Sales Tax\nCalculator")) {
                    c = 28;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Intent intent = new Intent(this, FixDepositCalculatorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return;
            case 1:
                Intent intent2 = new Intent(this, GSTCalculatorActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                return;
            case 2:
                Intent intent3 = new Intent(this, MarkupCalculatorActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                return;
            case 3:
                Intent intent4 = new Intent(this, TimeValueOfMoneyCalculatorActivity.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                return;
            case 4:
                Intent intent5 = new Intent(this, CompareLoanCalculatorActivity.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);
                return;
            case 5:
                Intent intent6 = new Intent(this, SIPCalculatorActivity.class);
                intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent6);
                return;
            case 6:
                Intent intent7 = new Intent(this, SWPCalculatorActivity.class);
                intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent7);
                return;
            case 7:
                Intent intent8 = new Intent(this, MarginCalculatorActivity.class);
                intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent8);
                return;
            case 8:
                Intent intent9 = new Intent(this, CumulativeGrowthActivity.class);
                intent9.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent9);
                return;
            case 9:
                Intent intent10 = new Intent(this, SimpleInterestCalculatorActivity.class);
                intent10.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent10);
                return;
            case 10:
                Intent intent11 = new Intent(this, BreakEventPointCalculatorActivity.class);
                intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent11);
                return;
            case 11:
                Intent intent12 = new Intent(this, GrossProfitCalculatorActivity.class);
                intent12.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                return;
            case 12:
                Intent intent13 = new Intent(this, DiscountCalculatorActivity.class);
                intent13.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent13);
                return;
            case 13:
                Intent intent14 = new Intent(this, STPCalculatorActivity.class);
                intent14.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent14);
                return;
            case 14:
                Intent intent15 = new Intent(this, OperatingMarginCalculatorActivity.class);
                intent15.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent15);
                return;
            case 15:
                Intent intent16 = new Intent(this, RecurringDepositCalculatorActivity.class);
                intent16.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent16);
                return;
            case 16:
                Intent intent17 = new Intent(this, ReturnOnInvestmentCalculatorActivity.class);
                intent17.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent17);
                return;
            case 17:
                Intent intent18 = new Intent(this, VATCalculatorActivity.class);
                intent18.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent18);
                return;
            case 18:
                Intent intent19 = new Intent(this, TipCalculatorActivity.class);
                intent19.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent19);
                return;
            case 19:
                Intent intent20 = new Intent(this, TaxCalculatorActivity.class);
                intent20.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent20);
                return;
            case 20:
                Intent intent21 = new Intent(this, LoanEligibilityActivity.class);
                intent21.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent21);
                return;
            case 21:
                Intent intent22 = new Intent(this, MarginWithSalesCalculatorActivity.class);
                intent22.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent22);
                return;
            case 22:
                Intent intent23 = new Intent(this, SIPPlanCalculatorActivity.class);
                intent23.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent23);
                return;
            case 23:
                Intent intent24 = new Intent(this, PublicProvidentFundCalculatorActivity.class);
                intent24.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent24);
                return;
            case 24:
                Intent intent25 = new Intent(this, AddInvestmentCalculatorActivity.class);
                intent25.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent25);
                return;
            case 25:
                Intent intent26 = new Intent(this, CompoundInterestCalculatorActivity.class);
                intent26.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent26);
                return;
            case 26:
                Intent intent27 = new Intent(this, InflationCalculatorActivity.class);
                intent27.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent27);
                return;
            case 27:
                Intent intent28 = new Intent(this, PriceCalculatorActivity.class);
                intent28.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent28);
                return;
            case 28:
                Intent intent29 = new Intent(this, SalesTaxCalculatorActivity.class);
                intent29.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent29);
                return;
            default:
                return;
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
