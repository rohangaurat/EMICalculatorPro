package com.demo.cashloanemi.Adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.TVMModel;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class TVMSaveDetailsAdapter extends RecyclerView.Adapter<TVMSaveDetailsAdapter.TVMSaveDetailsHolder> {
    double futureValue;
    double installment;
    double mode;
    double payment;
    double presentValue;
    double rate;
    double select;
    List<TVMModel> tvmList;
    double year;

    public TVMSaveDetailsAdapter(List<TVMModel> list) {
        this.tvmList = list;
    }

    @Override
    public TVMSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TVMSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tvm_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(TVMSaveDetailsHolder tVMSaveDetailsHolder, int i) {
        TVMModel tVMModel = this.tvmList.get(i);
        this.futureValue = tVMModel.getFutureValue();
        this.presentValue = tVMModel.getPresentValue();
        this.payment = tVMModel.getPayment();
        this.rate = tVMModel.getRate();
        this.year = tVMModel.getYear();
        this.installment = tVMModel.getInstallment();
        this.mode = tVMModel.getMode();
        this.select = tVMModel.getSelect();
        TextView textView = tVMSaveDetailsHolder.txtTVMTitle;
        textView.setText("" + tVMModel.getTitle());
        TextView textView2 = tVMSaveDetailsHolder.txtTVMSaveFutureValue;
        textView2.setText("" + Util.round(this.futureValue, 2));
        TextView textView3 = tVMSaveDetailsHolder.txtTVMSavePresentValue;
        textView3.setText("" + Util.round(this.presentValue, 2));
        TextView textView4 = tVMSaveDetailsHolder.txtTVMSavePayment;
        textView4.setText("" + Util.round(this.payment, 2));
        TextView textView5 = tVMSaveDetailsHolder.txtTVMSaveRate;
        textView5.setText("" + Util.round(this.rate, 2));
        TextView textView6 = tVMSaveDetailsHolder.txtTVMSaveYear;
        textView6.setText("" + Util.round(this.year, 2));
        TextView textView7 = tVMSaveDetailsHolder.txtTVMSaveInstallment;
        textView7.setText("" + Util.round(this.installment, 2));
        tVMSaveDetailsHolder.llTVMSaveMode.setVisibility(View.GONE);
        double d = this.select;
        if (d == 1.0d) {
            tVMSaveDetailsHolder.txtTVMSavePresentValue.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (d == 2.0d) {
            tVMSaveDetailsHolder.txtTVMSavePayment.setTypeface(Typeface.DEFAULT_BOLD);
            tVMSaveDetailsHolder.llTVMSaveMode.setVisibility(View.VISIBLE);
            TextView textView8 = tVMSaveDetailsHolder.txtTVMSaveMode;
            textView8.setText("Mode :- " + this.mode);
        } else if (d == 3.0d) {
            tVMSaveDetailsHolder.txtTVMSaveFutureValue.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (d == 4.0d) {
            tVMSaveDetailsHolder.txtTVMSaveRate.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (d == 5.0d) {
            tVMSaveDetailsHolder.txtTVMSaveYear.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    @Override
    public int getItemCount() {
        return this.tvmList.size();
    }

    class TVMSaveDetailsHolder extends RecyclerView.ViewHolder {
        LinearLayout llTVMSaveMode;
        TextView txtTVMSaveFutureValue;
        TextView txtTVMSaveInstallment;
        TextView txtTVMSaveMode;
        TextView txtTVMSavePayment;
        TextView txtTVMSavePresentValue;
        TextView txtTVMSaveRate;
        TextView txtTVMSaveYear;
        TextView txtTVMTitle;

        public TVMSaveDetailsHolder(View view) {
            super(view);
            this.txtTVMTitle = (TextView) view.findViewById(R.id.txtTVMTitle);
            this.txtTVMSaveFutureValue = (TextView) view.findViewById(R.id.txtTVMSaveFutureValue);
            this.txtTVMSavePresentValue = (TextView) view.findViewById(R.id.txtTVMSavePresentValue);
            this.txtTVMSavePayment = (TextView) view.findViewById(R.id.txtTVMSavePayment);
            this.txtTVMSaveRate = (TextView) view.findViewById(R.id.txtTVMSaveRate);
            this.txtTVMSaveYear = (TextView) view.findViewById(R.id.txtTVMSaveYear);
            this.txtTVMSaveInstallment = (TextView) view.findViewById(R.id.txtTVMSaveInstallment);
            this.txtTVMSaveMode = (TextView) view.findViewById(R.id.txtTVMSaveMode);
            this.llTVMSaveMode = (LinearLayout) view.findViewById(R.id.llTVMSaveMode);
        }
    }
}
