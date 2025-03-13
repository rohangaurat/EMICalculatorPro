package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.R;
import java.util.ArrayList;

public class YearWiseAdapter extends RecyclerView.Adapter<YearWiseAdapter.CompoundInterestYearWiseHolder> {
    ArrayList<Long> interestList;
    ArrayList<Long> totalBalanceList;
    ArrayList<Long> totalInterestList;

    public YearWiseAdapter(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<Long> arrayList3) {
        this.interestList = arrayList;
        this.totalBalanceList = arrayList2;
        this.totalInterestList = arrayList3;
    }

    @Override
    public CompoundInterestYearWiseHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CompoundInterestYearWiseHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.compound_interest_year_wise, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CompoundInterestYearWiseHolder compoundInterestYearWiseHolder, int i) {
        TextView textView = compoundInterestYearWiseHolder.txtInterestYW;
        textView.setText("" + this.interestList.get(i));
        TextView textView2 = compoundInterestYearWiseHolder.txtYearNumber;
        textView2.setText((i + 1) + "");
        TextView textView3 = compoundInterestYearWiseHolder.txtTotalBalanceValueYW;
        textView3.setText("" + this.totalBalanceList.get(i));
        TextView textView4 = compoundInterestYearWiseHolder.txtTotalInterestYW;
        textView4.setText("" + this.totalInterestList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.totalBalanceList.size();
    }

    class CompoundInterestYearWiseHolder extends RecyclerView.ViewHolder {
        TextView txtInterestYW;
        TextView txtTotalBalanceValueYW;
        TextView txtTotalInterestYW;
        TextView txtYearNumber;

        public CompoundInterestYearWiseHolder(View view) {
            super(view);
            this.txtYearNumber = (TextView) view.findViewById(R.id.txtYearNumber);
            this.txtInterestYW = (TextView) view.findViewById(R.id.txtInterestYW);
            this.txtTotalInterestYW = (TextView) view.findViewById(R.id.txtTotalInterestYW);
            this.txtTotalBalanceValueYW = (TextView) view.findViewById(R.id.txtTotalBalanceValueYW);
        }
    }
}
