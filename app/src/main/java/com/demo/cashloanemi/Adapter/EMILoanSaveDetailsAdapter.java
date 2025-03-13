package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.emiLoanModal;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class EMILoanSaveDetailsAdapter extends RecyclerView.Adapter<EMILoanSaveDetailsAdapter.EMILoanSaveDetailsHolder> {
    List<emiLoanModal> emiLoanList;

    public EMILoanSaveDetailsAdapter(List<emiLoanModal> list) {
        this.emiLoanList = list;
    }

    @Override
    public EMILoanSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new EMILoanSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emi_loan_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(EMILoanSaveDetailsHolder eMILoanSaveDetailsHolder, int i) {
        EMILoanSaveDetailsHolder eMILoanSaveDetailsHolder2 = eMILoanSaveDetailsHolder;
        emiLoanModal emiloanmodal = this.emiLoanList.get(i);
        double emiLoanAmount = emiloanmodal.getEmiLoanAmount();
        double emiLoanRate = emiloanmodal.getEmiLoanRate();
        double emiLoanMonths = emiloanmodal.getEmiLoanMonths();
        double emiOfLoan = Util.emiOfLoan(emiLoanAmount, emiLoanRate, emiLoanMonths);
        double d = emiOfLoan * emiLoanMonths;
        TextView textView = eMILoanSaveDetailsHolder2.txtEMILoneATitle;
        textView.setText("" + emiloanmodal.getEmiLoanTitle());
        TextView textView2 = eMILoanSaveDetailsHolder2.txtEMILoneIAmount;
        textView2.setText("" + emiLoanAmount);
        TextView textView3 = eMILoanSaveDetailsHolder2.txtEMILoneIMonth;
        textView3.setText("" + emiLoanMonths);
        TextView textView4 = eMILoanSaveDetailsHolder2.txtEMILoneIRate;
        textView4.setText("" + emiLoanRate + "%");
        TextView textView5 = eMILoanSaveDetailsHolder2.txtEMILoneOInterest;
        textView5.setText("" + Util.round(d - emiLoanAmount, 2) + "");
        TextView textView6 = eMILoanSaveDetailsHolder2.txtEMILoneOMonthlyEMI;
        textView6.setText("" + Util.round(emiOfLoan, 2) + "");
        TextView textView7 = eMILoanSaveDetailsHolder2.txtEMILoneOPrincipalAmount;
        textView7.setText("" + Util.round(emiLoanAmount, 2) + "");
        TextView textView8 = eMILoanSaveDetailsHolder2.txtEMILoneOTotalPayment;
        textView8.setText("" + Util.round(d, 2) + "");
    }

    @Override
    public int getItemCount() {
        return this.emiLoanList.size();
    }

    class EMILoanSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtEMILoneATitle;
        TextView txtEMILoneIAmount;
        TextView txtEMILoneIMonth;
        TextView txtEMILoneIRate;
        TextView txtEMILoneOInterest;
        TextView txtEMILoneOMonthlyEMI;
        TextView txtEMILoneOPrincipalAmount;
        TextView txtEMILoneOTotalPayment;

        public EMILoanSaveDetailsHolder(View view) {
            super(view);
            this.txtEMILoneOMonthlyEMI = (TextView) view.findViewById(R.id.txtEMILoneOMonthlyEMI);
            this.txtEMILoneOTotalPayment = (TextView) view.findViewById(R.id.txtEMILoneOTotalPayment);
            this.txtEMILoneOInterest = (TextView) view.findViewById(R.id.txtEMILoneOInterest);
            this.txtEMILoneOPrincipalAmount = (TextView) view.findViewById(R.id.txtEMILoneOPrincipalAmount);
            this.txtEMILoneIMonth = (TextView) view.findViewById(R.id.txtEMILoneIMonth);
            this.txtEMILoneIRate = (TextView) view.findViewById(R.id.txtEMILoneIRate);
            this.txtEMILoneIAmount = (TextView) view.findViewById(R.id.txtEMILoneIAmount);
            this.txtEMILoneATitle = (TextView) view.findViewById(R.id.txtEMILoneATitle);
        }
    }
}
