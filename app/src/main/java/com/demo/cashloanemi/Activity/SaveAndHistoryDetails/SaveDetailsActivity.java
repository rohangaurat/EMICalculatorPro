package com.demo.cashloanemi.Activity.SaveAndHistoryDetails;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.AdCommon.AppsForLight_Const;
import com.demo.cashloanemi.AdCommon.PrefManager;
import com.demo.cashloanemi.Adapter.AddISaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.CompoundInterestSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.EMILoanSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.FDSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.PPFSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.RDSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.SimpleInterestSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.TVMSaveDetailsAdapter;
import com.demo.cashloanemi.Adapter.TipSaveDetailsAdapter;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.ads.AdsCommon;


public class SaveDetailsActivity extends AppCompatActivity {
    EMILoanSaveDetailsAdapter EMILoanAdapter;
    FDSaveDetailsAdapter FDAdapter;
    PPFSaveDetailsAdapter PPFAdapter;
    RDSaveDetailsAdapter RDAdapter;
    TipSaveDetailsAdapter TipAdapter;
    AddISaveDetailsAdapter addIAdapter;
    CompoundInterestSaveDetailsAdapter ciAdapter;
    DatabaseHelper db;
    LinearLayout llListIsEmpty;
    PrefManager prefManager;
    RecyclerView rcvEMILoanSaveDetails;
    SimpleInterestSaveDetailsAdapter siAdapter;
    Toolbar toolbar;
    TVMSaveDetailsAdapter tvmAdapter;
    TextView txtToolbarTitle;



    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_save_details);


        AdsCommon.InterstitialAdsOnly(this);

        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        FrameLayout qureka = (FrameLayout) findViewById(R.id.qureka);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        this.prefManager = new PrefManager(this);
        String stringExtra = getIntent().getStringExtra(DatabaseHelper.DB_NAME);
        this.db = new DatabaseHelper(this);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.rcvEMILoanSaveDetails = (RecyclerView) findViewById(R.id.rcvEMILoanSaveDetails);
        this.llListIsEmpty = (LinearLayout) findViewById(R.id.llListIsEmpty);
        this.txtToolbarTitle = (TextView) findViewById(R.id.txtToolbarTitle);
        stringExtra.hashCode();
        char c = 65535;
        switch (stringExtra.hashCode()) {
            case -1854260776:
                if (stringExtra.equals("Simple Interest")) {
                    c = 0;
                    break;
                }
                break;
            case 2238:
                if (stringExtra.equals("FD")) {
                    c = 1;
                    break;
                }
                break;
            case 2610:
                if (stringExtra.equals("RD")) {
                    c = 2;
                    break;
                }
                break;
            case 79430:
                if (stringExtra.equals("PPF")) {
                    c = 3;
                    break;
                }
                break;
            case 83467:
                if (stringExtra.equals("TVM")) {
                    c = 4;
                    break;
                }
                break;
            case 84091:
                if (stringExtra.equals("Tip")) {
                    c = 5;
                    break;
                }
                break;
            case 42340863:
                if (stringExtra.equals("Compound Interest")) {
                    c = 6;
                    break;
                }
                break;
            case 205896690:
                if (stringExtra.equals("Add Investment")) {
                    c = 7;
                    break;
                }
                break;
            case 1734990127:
                if (stringExtra.equals("EMI Loan")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getSimpleInterestList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    SimpleInterestSaveDetailsAdapter simpleInterestSaveDetailsAdapter = new SimpleInterestSaveDetailsAdapter(this.db.getSimpleInterestList());
                    this.siAdapter = simpleInterestSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(simpleInterestSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 1:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getFDList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    FDSaveDetailsAdapter fDSaveDetailsAdapter = new FDSaveDetailsAdapter(this.db.getFDList());
                    this.FDAdapter = fDSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(fDSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 2:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getRDList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    RDSaveDetailsAdapter rDSaveDetailsAdapter = new RDSaveDetailsAdapter(this.db.getRDList());
                    this.RDAdapter = rDSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(rDSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 3:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getPPFList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    PPFSaveDetailsAdapter pPFSaveDetailsAdapter = new PPFSaveDetailsAdapter(this.db.getPPFList());
                    this.PPFAdapter = pPFSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(pPFSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 4:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getTVMList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    TVMSaveDetailsAdapter tVMSaveDetailsAdapter = new TVMSaveDetailsAdapter(this.db.getTVMList());
                    this.tvmAdapter = tVMSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(tVMSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 5:
                this.txtToolbarTitle.setText("Loan Calculator");
                if (this.db.getTipList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    TipSaveDetailsAdapter tipSaveDetailsAdapter = new TipSaveDetailsAdapter(this.db.getTipList());
                    this.TipAdapter = tipSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(tipSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 6:
                this.txtToolbarTitle.setText("Banking Calculator");
                if (this.db.getCompoundInterestList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    CompoundInterestSaveDetailsAdapter compoundInterestSaveDetailsAdapter = new CompoundInterestSaveDetailsAdapter(this.db.getCompoundInterestList());
                    this.ciAdapter = compoundInterestSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(compoundInterestSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 7:
                this.txtToolbarTitle.setText("Mutual Fund And SIP Calculator");
                if (this.db.getAddIList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    AddISaveDetailsAdapter addISaveDetailsAdapter = new AddISaveDetailsAdapter(this.db.getAddIList());
                    this.addIAdapter = addISaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(addISaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
            case 8:
                this.txtToolbarTitle.setText("Loan Calculator");
                if (this.db.getEMILoanList().size() != 0) {
                    this.llListIsEmpty.setVisibility(View.GONE);
                    this.rcvEMILoanSaveDetails.setVisibility(View.VISIBLE);
                    EMILoanSaveDetailsAdapter eMILoanSaveDetailsAdapter = new EMILoanSaveDetailsAdapter(this.db.getEMILoanList());
                    this.EMILoanAdapter = eMILoanSaveDetailsAdapter;
                    this.rcvEMILoanSaveDetails.setAdapter(eMILoanSaveDetailsAdapter);
                    break;
                } else {
                    this.rcvEMILoanSaveDetails.setVisibility(View.GONE);
                    this.llListIsEmpty.setVisibility(View.VISIBLE);
                    break;
                }
        }
        this.rcvEMILoanSaveDetails.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
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
