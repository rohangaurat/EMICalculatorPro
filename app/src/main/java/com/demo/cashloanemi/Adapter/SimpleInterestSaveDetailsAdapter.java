package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.SimpleInterestModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class SimpleInterestSaveDetailsAdapter extends RecyclerView.Adapter<SimpleInterestSaveDetailsAdapter.SimpleInterestSaveDetailsHolder> {
    List<SimpleInterestModel> simpleInterestList;

    public SimpleInterestSaveDetailsAdapter(List<SimpleInterestModel> list) {
        this.simpleInterestList = list;
    }

    @Override
    public SimpleInterestSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SimpleInterestSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.si_and_ci_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(SimpleInterestSaveDetailsHolder simpleInterestSaveDetailsHolder, int i) {
        SimpleInterestSaveDetailsHolder simpleInterestSaveDetailsHolder2 = simpleInterestSaveDetailsHolder;
        SimpleInterestModel simpleInterestModel = this.simpleInterestList.get(i);
        double loanAmount = simpleInterestModel.getLoanAmount();
        double interestRate = simpleInterestModel.getInterestRate();
        double year = simpleInterestModel.getYear();
        double d = ((loanAmount * interestRate) * year) / 100.0d;
        TextView textView = simpleInterestSaveDetailsHolder2.txtSIIPrincipalAmount;
        StringBuilder sb = new StringBuilder("");
        SimpleInterestModel simpleInterestModel2 = simpleInterestModel;
        sb.append(Util.round(loanAmount, 2));
        sb.append("");
        textView.setText(sb.toString());
        TextView textView2 = simpleInterestSaveDetailsHolder2.txtSIIInterestRate;
        textView2.setText("" + Util.round(interestRate, 2) + "%");
        TextView textView3 = simpleInterestSaveDetailsHolder2.txtSIIYear;
        textView3.setText("" + ((long) Util.round(year, 2)));
        TextView textView4 = simpleInterestSaveDetailsHolder2.txtSIOTotalAmount;
        textView4.setText("" + Util.round(loanAmount + d, 2));
        TextView textView5 = simpleInterestSaveDetailsHolder2.txtSIOTotalInterest;
        textView5.setText("" + Util.round(d, 2));
        TextView textView6 = simpleInterestSaveDetailsHolder2.txtSITitle;
        textView6.setText("" + simpleInterestModel2.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.simpleInterestList.size();
    }

    class SimpleInterestSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtSIIInterestRate;
        TextView txtSIIPrincipalAmount;
        TextView txtSIIYear;
        TextView txtSIOTotalAmount;
        TextView txtSIOTotalInterest;
        TextView txtSITitle;

        public SimpleInterestSaveDetailsHolder(View view) {
            super(view);
            this.txtSITitle = (TextView) view.findViewById(R.id.txtSITitle);
            this.txtSIIPrincipalAmount = (TextView) view.findViewById(R.id.txtSIIPrincipalAmount);
            this.txtSIIYear = (TextView) view.findViewById(R.id.txtSIIYear);
            this.txtSIIInterestRate = (TextView) view.findViewById(R.id.txtSIIInterestRate);
            this.txtSIOTotalInterest = (TextView) view.findViewById(R.id.txtSIOTotalInterest);
            this.txtSIOTotalAmount = (TextView) view.findViewById(R.id.txtSIOTotalAmount);
        }
    }
}
