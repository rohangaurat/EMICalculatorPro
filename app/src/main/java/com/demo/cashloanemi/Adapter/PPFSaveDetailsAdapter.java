package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.PPFModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class PPFSaveDetailsAdapter extends RecyclerView.Adapter<PPFSaveDetailsAdapter.PPFSaveDetailsHolder> {
    List<PPFModel> ppfList;

    public PPFSaveDetailsAdapter(List<PPFModel> list) {
        this.ppfList = list;
    }

    @Override
    public PPFSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PPFSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fd_rd_ppf_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(PPFSaveDetailsHolder pPFSaveDetailsHolder, int i) {
        double d;
        double d2 = 0;
        double d3 = 0;
        PPFSaveDetailsHolder pPFSaveDetailsHolder2 = pPFSaveDetailsHolder;
        PPFModel pPFModel = this.ppfList.get(i);
        double installment = pPFModel.getInstallment();
        double interestRate = pPFModel.getInterestRate();
        double investmentAmount = pPFModel.getInvestmentAmount();
        double month = pPFModel.getMonth();
        PPFModel pPFModel2 = pPFModel;
        double d4 = investmentAmount;
        int i2 = 1;
        while (true) {
            d = 0.0d;
            if (((double) i2) > month) {
                break;
            }
            int i3 = i2;
            if (i2 % 12 == 0) {
                for (int i4 = 1; ((double) i4) <= installment; i4++) {
                    d4 = Util.round(d4, 0) + investmentAmount;
                    d += (Util.round(d4, 0) * interestRate) / (100.0d * installment);
                }
            }
            d4 = Util.round(d4, 2) + d;
            i2 = i3 + 1;
        }
        if (installment == 1.0d) {
            d = (investmentAmount * month) / 12.0d;
        } else {
            if (installment == 2.0d) {
                d2 = investmentAmount * month;
                d3 = 6.0d;
            } else if (installment == 4.0d) {
                d2 = investmentAmount * month;
                d3 = 3.0d;
            } else if (installment == 12.0d) {
                d = investmentAmount * month;
            }
            d = d2 / d3;
        }
        double d5 = d;
        double round = Util.round(d4, 0) - investmentAmount;
        pPFSaveDetailsHolder2.txtPPFOInvestmentAmount.setVisibility(View.VISIBLE);
        pPFSaveDetailsHolder2.txtPPFTitle.setText(pPFModel2.getTitle());
        TextView textView = pPFSaveDetailsHolder2.txtPPFIInterestRate;
        textView.setText("" + interestRate + "%");
        TextView textView2 = pPFSaveDetailsHolder2.txtPPFIInvestmentAmount;
        textView2.setText("" + investmentAmount + "");
        TextView textView3 = pPFSaveDetailsHolder2.txtPPFIYear;
        textView3.setText("" + Util.round(month * 0.0833334d, 2) + "");
        TextView textView4 = pPFSaveDetailsHolder2.txtPPFIInstallment;
        textView4.setText("" + installment + "");
        TextView textView5 = pPFSaveDetailsHolder2.txtPPFOTotalInterest;
        textView5.setText("" + Util.round(round - d5, 2));
        TextView textView6 = pPFSaveDetailsHolder2.txtPPFOInvestmentAmount;
        textView6.setText("" + Util.round(d5, 2));
        TextView textView7 = pPFSaveDetailsHolder2.txtPPFOTotalAmount;
        textView7.setText("" + Util.round(round, 2));
    }

    @Override
    public int getItemCount() {
        return this.ppfList.size();
    }

    class PPFSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtPPFIInstallment;
        TextView txtPPFIInterestRate;
        TextView txtPPFIInvestmentAmount;
        TextView txtPPFIYear;
        TextView txtPPFOInvestmentAmount;
        TextView txtPPFOTotalAmount;
        TextView txtPPFOTotalInterest;
        TextView txtPPFTitle;

        public PPFSaveDetailsHolder(View view) {
            super(view);
            this.txtPPFOTotalAmount = (TextView) view.findViewById(R.id.txtFDOTotalAmount);
            this.txtPPFOTotalInterest = (TextView) view.findViewById(R.id.txtFDOTotalInterest);
            this.txtPPFIYear = (TextView) view.findViewById(R.id.txtFDIYear);
            this.txtPPFIInstallment = (TextView) view.findViewById(R.id.txtFDIInstallment);
            this.txtPPFIInterestRate = (TextView) view.findViewById(R.id.txtFDIInterestRate);
            this.txtPPFIInvestmentAmount = (TextView) view.findViewById(R.id.txtFDIInvestmentAmount);
            this.txtPPFOInvestmentAmount = (TextView) view.findViewById(R.id.txtFDOInvestmentAmount);
            this.txtPPFTitle = (TextView) view.findViewById(R.id.txtFDTitle);
        }
    }
}
