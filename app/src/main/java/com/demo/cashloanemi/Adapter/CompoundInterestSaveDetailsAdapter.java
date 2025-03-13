package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.CompoundInterestModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class CompoundInterestSaveDetailsAdapter extends RecyclerView.Adapter<CompoundInterestSaveDetailsAdapter.CompoundInterestSaveDetailsHolder> {
    List<CompoundInterestModel> compoundInterestList;

    public CompoundInterestSaveDetailsAdapter(List<CompoundInterestModel> list) {
        this.compoundInterestList = list;
    }

    @Override
    public CompoundInterestSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CompoundInterestSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.si_and_ci_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CompoundInterestSaveDetailsHolder compoundInterestSaveDetailsHolder, int i) {
        CompoundInterestModel compoundInterestModel = this.compoundInterestList.get(i);
        double loanAmount = compoundInterestModel.getLoanAmount();
        double interestRate = compoundInterestModel.getInterestRate();
        double year = compoundInterestModel.getYear();
        double pow = Math.pow((interestRate / 100.0d) + 1.0d, year) * loanAmount;
        TextView textView = compoundInterestSaveDetailsHolder.txtCITitle;
        textView.setText("" + compoundInterestModel.getTitle());
        TextView textView2 = compoundInterestSaveDetailsHolder.txtCIIPrincipalAmount;
        textView2.setText("" + Util.round(loanAmount, 2) + "");
        TextView textView3 = compoundInterestSaveDetailsHolder.txtCIIInterestRate;
        textView3.setText("" + Util.round(interestRate, 2) + "%");
        TextView textView4 = compoundInterestSaveDetailsHolder.txtCIIYear;
        textView4.setText("" + Util.round(year, 2));
        TextView textView5 = compoundInterestSaveDetailsHolder.txtCIOTotalAmount;
        textView5.setText("" + Util.round(pow, 2));
        TextView textView6 = compoundInterestSaveDetailsHolder.txtCIOTotalInterest;
        textView6.setText("" + Util.round(pow - loanAmount, 2));
    }

    @Override
    public int getItemCount() {
        return this.compoundInterestList.size();
    }

    class CompoundInterestSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtCIIInterestRate;
        TextView txtCIIPrincipalAmount;
        TextView txtCIIYear;
        TextView txtCIOTotalAmount;
        TextView txtCIOTotalInterest;
        TextView txtCITitle;

        public CompoundInterestSaveDetailsHolder(View view) {
            super(view);
            this.txtCITitle = (TextView) view.findViewById(R.id.txtSITitle);
            this.txtCIIPrincipalAmount = (TextView) view.findViewById(R.id.txtSIIPrincipalAmount);
            this.txtCIIYear = (TextView) view.findViewById(R.id.txtSIIYear);
            this.txtCIIInterestRate = (TextView) view.findViewById(R.id.txtSIIInterestRate);
            this.txtCIOTotalInterest = (TextView) view.findViewById(R.id.txtSIOTotalInterest);
            this.txtCIOTotalAmount = (TextView) view.findViewById(R.id.txtSIOTotalAmount);
        }
    }
}
