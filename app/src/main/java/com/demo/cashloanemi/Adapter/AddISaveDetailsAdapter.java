package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.AddInvestmentModel;
import com.demo.cashloanemi.R;
import java.util.List;

public class AddISaveDetailsAdapter extends RecyclerView.Adapter<AddISaveDetailsAdapter.AddISaveDetailsHolder> {
    List<AddInvestmentModel> addIList;

    public AddISaveDetailsAdapter(List<AddInvestmentModel> list) {
        this.addIList = list;
    }

    @Override
    public AddISaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AddISaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_investment_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(AddISaveDetailsHolder addISaveDetailsHolder, int i) {
        AddISaveDetailsHolder addISaveDetailsHolder2 = addISaveDetailsHolder;
        AddInvestmentModel addInvestmentModel = this.addIList.get(i);
        double startingPayment = addInvestmentModel.getStartingPayment();
        double monthlyPayment = addInvestmentModel.getMonthlyPayment();
        double month = addInvestmentModel.getMonth();
        double rate = addInvestmentModel.getRate();
        double totalInvestment = addInvestmentModel.getTotalInvestment();
        double balance = addInvestmentModel.getBalance();
        TextView textView = addISaveDetailsHolder2.txtAddIMonthlyInvestmentAmount;
        textView.setText("" + monthlyPayment);
        TextView textView2 = addISaveDetailsHolder2.txtADDIRate;
        textView2.setText("" + rate);
        TextView textView3 = addISaveDetailsHolder2.txtAddIStaringInvestmentAmount;
        textView3.setText("" + startingPayment);
        TextView textView4 = addISaveDetailsHolder2.txtAddiTitle;
        textView4.setText("" + addInvestmentModel.getTitle());
        TextView textView5 = addISaveDetailsHolder2.txtADDIMonth;
        textView5.setText("" + month);
        TextView textView6 = addISaveDetailsHolder2.txtAddOTotalBalance;
        textView6.setText("" + balance);
        TextView textView7 = addISaveDetailsHolder2.txtADDOTotalInvestmentAmount;
        textView7.setText("" + totalInvestment);
    }

    @Override
    public int getItemCount() {
        return this.addIList.size();
    }

    class AddISaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtADDIMonth;
        TextView txtADDIRate;
        TextView txtADDOTotalInvestmentAmount;
        TextView txtAddIMonthlyInvestmentAmount;
        TextView txtAddIStaringInvestmentAmount;
        TextView txtAddOTotalBalance;
        TextView txtAddiTitle;

        public AddISaveDetailsHolder(View view) {
            super(view);
            this.txtAddiTitle = (TextView) view.findViewById(R.id.txtAddiTitle);
            this.txtAddIStaringInvestmentAmount = (TextView) view.findViewById(R.id.txtAddIStaringInvestmentAmount);
            this.txtAddIMonthlyInvestmentAmount = (TextView) view.findViewById(R.id.txtAddIMonthlyInvestmentAmount);
            this.txtADDIMonth = (TextView) view.findViewById(R.id.txtADDIMonth);
            this.txtADDIRate = (TextView) view.findViewById(R.id.txtADDIRate);
            this.txtADDOTotalInvestmentAmount = (TextView) view.findViewById(R.id.txtADDOTotalInvestmentAmount);
            this.txtAddOTotalBalance = (TextView) view.findViewById(R.id.txtAddOTotalBalance);
        }
    }
}
