package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.R;
import java.util.ArrayList;

public class MutualFundAndSIPAdapter extends RecyclerView.Adapter<MutualFundAndSIPAdapter.MutualFundAndSIPHolder> {
    ArrayList<Double> balanceBeginList;
    ArrayList<Double> balanceEndList;
    ArrayList<Double> interestList;
    ArrayList<Double> transferredInOrOutList;

    public MutualFundAndSIPAdapter(ArrayList<Double> arrayList, ArrayList<Double> arrayList2, ArrayList<Double> arrayList3, ArrayList<Double> arrayList4) {
        this.balanceBeginList = arrayList;
        this.balanceEndList = arrayList2;
        this.interestList = arrayList3;
        this.transferredInOrOutList = arrayList4;
    }

    @Override
    public MutualFundAndSIPHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MutualFundAndSIPHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mutual_fund_and_sip_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MutualFundAndSIPHolder mutualFundAndSIPHolder, int i) {
        TextView textView = mutualFundAndSIPHolder.txtBalanceAtBegin;
        textView.setText(this.balanceBeginList.get(i) + "");
        TextView textView2 = mutualFundAndSIPHolder.txtBalanceAtEnd;
        textView2.setText(this.balanceEndList.get(i) + "");
        TextView textView3 = mutualFundAndSIPHolder.txtTotalInterestMW;
        textView3.setText(this.interestList.get(i) + "");
        TextView textView4 = mutualFundAndSIPHolder.txtWithdrawal;
        textView4.setText(this.transferredInOrOutList.get(i) + "");
        TextView textView5 = mutualFundAndSIPHolder.txtMonthNumber;
        textView5.setText("" + (i + 1));
    }

    @Override
    public int getItemCount() {
        return this.balanceEndList.size();
    }

    class MutualFundAndSIPHolder extends RecyclerView.ViewHolder {
        TextView txtBalanceAtBegin;
        TextView txtBalanceAtEnd;
        TextView txtMonthNumber;
        TextView txtTotalInterestMW;
        TextView txtWithdrawal;

        public MutualFundAndSIPHolder(View view) {
            super(view);
            this.txtBalanceAtEnd = (TextView) view.findViewById(R.id.txtBalanceAtEnd);
            this.txtTotalInterestMW = (TextView) view.findViewById(R.id.txtTotalInterestMW);
            this.txtWithdrawal = (TextView) view.findViewById(R.id.txtWithdrawal);
            this.txtBalanceAtBegin = (TextView) view.findViewById(R.id.txtBalanceAtBegin);
            this.txtMonthNumber = (TextView) view.findViewById(R.id.txtMonthNumber);
        }
    }
}
