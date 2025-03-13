package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Modal.tipModal;
import com.demo.cashloanemi.R;
import com.demo.cashloanemi.Utils.Util;
import java.util.List;

public class TipSaveDetailsAdapter extends RecyclerView.Adapter<TipSaveDetailsAdapter.TipSaveDetailsHolder> {
    List<tipModal> tipList;

    public TipSaveDetailsAdapter(List<tipModal> list) {
        this.tipList = list;
    }

    @Override
    public TipSaveDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TipSaveDetailsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tip_save_details_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(TipSaveDetailsHolder tipSaveDetailsHolder, int i) {
        TipSaveDetailsHolder tipSaveDetailsHolder2 = tipSaveDetailsHolder;
        tipModal tipmodal = this.tipList.get(i);
        double billAmount = tipmodal.getBillAmount();
        double tipRate = tipmodal.getTipRate();
        double split = tipmodal.getSplit();
        double taxRate = tipmodal.getTaxRate();
        double d = (((tipRate + taxRate) * billAmount) / 100.0d) + billAmount;
        tipModal tipmodal2 = tipmodal;
        TextView textView = tipSaveDetailsHolder2.txtTipOTotalPayAmount;
        double d2 = billAmount;
        textView.setText("" + Util.round(d, 2));
        TextView textView2 = tipSaveDetailsHolder2.txtTipOEachPay;
        textView2.setText("" + Util.round(d / split, 2));
        TextView textView3 = tipSaveDetailsHolder2.txtTipOTotalTipAmount;
        textView3.setText("" + Util.round((billAmount * tipRate) / 100.0d, 2));
        TextView textView4 = tipSaveDetailsHolder2.txtTipISplit;
        textView4.setText("" + split);
        TextView textView5 = tipSaveDetailsHolder2.txtTipITaxRate;
        textView5.setText("" + taxRate);
        TextView textView6 = tipSaveDetailsHolder2.txtTipITipRate;
        textView6.setText("" + tipRate);
        TextView textView7 = tipSaveDetailsHolder2.txtTipIBillAmount;
        textView7.setText("" + d2);
        TextView textView8 = tipSaveDetailsHolder2.txtTipTitle;
        textView8.setText("" + tipmodal2.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.tipList.size();
    }

    class TipSaveDetailsHolder extends RecyclerView.ViewHolder {
        TextView txtTipIBillAmount;
        TextView txtTipISplit;
        TextView txtTipITaxRate;
        TextView txtTipITipRate;
        TextView txtTipOEachPay;
        TextView txtTipOTotalPayAmount;
        TextView txtTipOTotalTipAmount;
        TextView txtTipTitle;

        public TipSaveDetailsHolder(View view) {
            super(view);
            this.txtTipOTotalPayAmount = (TextView) view.findViewById(R.id.txtTipOTotalPayAmount);
            this.txtTipOEachPay = (TextView) view.findViewById(R.id.txtTipOEachPay);
            this.txtTipOTotalTipAmount = (TextView) view.findViewById(R.id.txtTipOTotalTipAmount);
            this.txtTipISplit = (TextView) view.findViewById(R.id.txtTipISplit);
            this.txtTipITaxRate = (TextView) view.findViewById(R.id.txtTipITaxRate);
            this.txtTipITipRate = (TextView) view.findViewById(R.id.txtTipITipRate);
            this.txtTipIBillAmount = (TextView) view.findViewById(R.id.txtTipIBillAmount);
            this.txtTipTitle = (TextView) view.findViewById(R.id.txtTipTitle);
        }
    }
}
