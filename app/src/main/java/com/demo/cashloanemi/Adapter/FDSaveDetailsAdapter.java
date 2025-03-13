package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.FDModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class FDSaveDetailsAdapter extends RecyclerView.Adapter<FDSaveDetailsAdapter.FDSaveDetailsHolder> {
    double balance = 0.0d;
    List<FDModel> fdList;
    double interest = 0.0d;
    double totalInterest = 0.0d;

    public FDSaveDetailsAdapter(List<FDModel> list) {
        this.fdList = list;
    }

    @Override
    public FDSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FDSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fd_rd_ppf_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(FDSaveDetailsHolder fDSaveDetailsHolder, int i) {
        FDSaveDetailsHolder fDSaveDetailsHolder2 = fDSaveDetailsHolder;
        FDModel fDModel = this.fdList.get(i);
        double installment = fDModel.getInstallment();
        double interestRate = fDModel.getInterestRate();
        double investmentAmount = fDModel.getInvestmentAmount();
        double year = fDModel.getYear();
        this.balance = investmentAmount;
        double d = year * installment;
        double d2 = interestRate / (100.0d * installment);
        int i2 = 0;
        double d3 = installment;
        while (((double) i2) < d) {
            double d4 = this.balance;
            double d5 = d;
            double d6 = d4 * d2;
            this.interest = d6;
            this.balance = d4 + d6;
            this.totalInterest += d6;
            i2++;
            d = d5;
        }
        fDSaveDetailsHolder2.txtFDTitle.setText(fDModel.getTitle());
        fDSaveDetailsHolder2.txtFDIInterestRate.setText("" + interestRate + "%");
        fDSaveDetailsHolder2.txtFDIInvestmentAmount.setText("" + investmentAmount + "");
        fDSaveDetailsHolder2.txtFDIYear.setText("" + year + "");
        fDSaveDetailsHolder2.txtFDIInstallment.setText("" + d3 + "");
        fDSaveDetailsHolder2.txtFDOTotalAmount.setText("" + Util.round(this.totalInterest + investmentAmount, 2));
        fDSaveDetailsHolder2.txtFDOTotalInterest.setText("" + Util.round(this.totalInterest, 2));
    }

    @Override
    public int getItemCount() {
        return this.fdList.size();
    }

    class FDSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtFDIInstallment;
        TextView txtFDIInterestRate;
        TextView txtFDIInvestmentAmount;
        TextView txtFDIYear;
        TextView txtFDOTotalAmount;
        TextView txtFDOTotalInterest;
        TextView txtFDTitle;

        public FDSaveDetailsHolder(View view) {
            super(view);
            this.txtFDOTotalAmount = (TextView) view.findViewById(R.id.txtFDOTotalAmount);
            this.txtFDOTotalInterest = (TextView) view.findViewById(R.id.txtFDOTotalInterest);
            this.txtFDIYear = (TextView) view.findViewById(R.id.txtFDIYear);
            this.txtFDIInstallment = (TextView) view.findViewById(R.id.txtFDIInstallment);
            this.txtFDIInterestRate = (TextView) view.findViewById(R.id.txtFDIInterestRate);
            this.txtFDIInvestmentAmount = (TextView) view.findViewById(R.id.txtFDIInvestmentAmount);
            this.txtFDTitle = (TextView) view.findViewById(R.id.txtFDTitle);
        }
    }
}
