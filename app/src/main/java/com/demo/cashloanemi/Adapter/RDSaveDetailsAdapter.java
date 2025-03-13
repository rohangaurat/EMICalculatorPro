package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.RDModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class RDSaveDetailsAdapter extends RecyclerView.Adapter<RDSaveDetailsAdapter.RDSaveDetailsHolder> {
    List<RDModel> rdList;

    public RDSaveDetailsAdapter(List<RDModel> list) {
        this.rdList = list;
    }

    @Override
    public RDSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RDSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fd_rd_ppf_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RDSaveDetailsHolder rDSaveDetailsHolder, int i) {
        RDSaveDetailsHolder rDSaveDetailsHolder2 = rDSaveDetailsHolder;
        RDModel rDModel = this.rdList.get(i);
        double installment = rDModel.getInstallment();
        double interestRate = rDModel.getInterestRate();
        double investmentAmount = rDModel.getInvestmentAmount();
        double year = rDModel.getYear();
        double d = (interestRate / 400.0d) + 1.0d;
        double d2 = installment;
        double pow = ((Math.pow(d, 4.0d * year) - 1.0d) * investmentAmount) / (1.0d - Math.pow(d, -0.3333333333333333d));
        rDSaveDetailsHolder2.llFDOInvestmentAmount.setVisibility(View.VISIBLE);
        rDSaveDetailsHolder2.txtRDTitle.setText(rDModel.getTitle());
        TextView textView = rDSaveDetailsHolder2.txtRDIInterestRate;
        textView.setText("" + interestRate + "%");
        TextView textView2 = rDSaveDetailsHolder2.txtRDIInvestmentAmount;
        textView2.setText("" + investmentAmount + "");
        TextView textView3 = rDSaveDetailsHolder2.txtRDIYear;
        textView3.setText("" + year + "");
        TextView textView4 = rDSaveDetailsHolder2.txtRDIInstallment;
        textView4.setText("" + d2 + "");
        TextView textView5 = rDSaveDetailsHolder2.txtRDOTotalAmount;
        textView5.setText("" + Util.round(pow, 2));
        TextView textView6 = rDSaveDetailsHolder2.txtRDOTotalInterest;
        StringBuilder sb = new StringBuilder("");
        double d3 = investmentAmount * 12.0d * year;
        sb.append(Util.round(pow - d3, 2));
        textView6.setText(sb.toString());
        TextView textView7 = rDSaveDetailsHolder2.txtRDOInvestmentAmount;
        textView7.setText("" + Util.round(d3, 2));
    }

    @Override
    public int getItemCount() {
        return this.rdList.size();
    }

    class RDSaveDetailsHolder extends RecyclerView.ViewHolder {
        LinearLayout llFDOInvestmentAmount;
        TextView txtRDIInstallment;
        TextView txtRDIInterestRate;
        TextView txtRDIInvestmentAmount;
        TextView txtRDIYear;
        TextView txtRDOInvestmentAmount;
        TextView txtRDOTotalAmount;
        TextView txtRDOTotalInterest;
        TextView txtRDTitle;

        public RDSaveDetailsHolder(View view) {
            super(view);
            this.txtRDOTotalAmount = (TextView) view.findViewById(R.id.txtFDOTotalAmount);
            this.txtRDOTotalInterest = (TextView) view.findViewById(R.id.txtFDOTotalInterest);
            this.txtRDIYear = (TextView) view.findViewById(R.id.txtFDIYear);
            this.txtRDIInstallment = (TextView) view.findViewById(R.id.txtFDIInstallment);
            this.txtRDIInterestRate = (TextView) view.findViewById(R.id.txtFDIInterestRate);
            this.txtRDIInvestmentAmount = (TextView) view.findViewById(R.id.txtFDIInvestmentAmount);
            this.txtRDOInvestmentAmount = (TextView) view.findViewById(R.id.txtFDOInvestmentAmount);
            this.txtRDTitle = (TextView) view.findViewById(R.id.txtFDTitle);
            this.llFDOInvestmentAmount = (LinearLayout) view.findViewById(R.id.llFDOInvestmentAmount);
        }
    }
}
