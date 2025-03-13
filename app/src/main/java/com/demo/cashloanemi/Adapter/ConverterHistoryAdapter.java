package com.demo.cashloanemi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.DataBase.DatabaseHelper;
import com.demo.cashloanemi.Modal.ConverterHistoryModel;
import com.demo.cashloanemi.R;
import java.util.List;

public class ConverterHistoryAdapter extends RecyclerView.Adapter<ConverterHistoryAdapter.ConverterHistoryHolder> {
    Context context;
    List<ConverterHistoryModel> converterHistory;
    DatabaseHelper db;

    public ConverterHistoryAdapter(List<ConverterHistoryModel> list) {
        this.converterHistory = list;
    }

    @Override
    public ConverterHistoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context2 = viewGroup.getContext();
        this.context = context2;
        return new ConverterHistoryHolder(LayoutInflater.from(context2).inflate(R.layout.converter_history_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ConverterHistoryHolder converterHistoryHolder, final int i) {
        ConverterHistoryModel converterHistoryModel = this.converterHistory.get(i);
        final int id = converterHistoryModel.getId();
        this.db = new DatabaseHelper(this.context);
        converterHistoryHolder.txtCHDateAndTime.setText(converterHistoryModel.getTime());
        converterHistoryHolder.txtCHToAmount.setText(converterHistoryModel.getToAmount());
        converterHistoryHolder.txtCHFromAmount.setText(converterHistoryModel.getFromAmount());
        TextView textView = converterHistoryHolder.txtCHCode;
        textView.setText(converterHistoryModel.getFromCode() + "-" + converterHistoryModel.getToCode());
        converterHistoryHolder.imgCHRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConverterHistoryAdapter.this.db.removeConverterHistory(id);
                ConverterHistoryAdapter.this.converterHistory.remove(i);
                ConverterHistoryAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.converterHistory.size();
    }

    class ConverterHistoryHolder extends RecyclerView.ViewHolder {
        ImageView imgCHRemove;
        TextView txtCHCode;
        TextView txtCHDateAndTime;
        TextView txtCHFromAmount;
        TextView txtCHToAmount;

        public ConverterHistoryHolder(View view) {
            super(view);
            this.txtCHCode = (TextView) view.findViewById(R.id.txtCHCode);
            this.txtCHFromAmount = (TextView) view.findViewById(R.id.txtCHFromAmount);
            this.txtCHToAmount = (TextView) view.findViewById(R.id.txtCHToAmount);
            this.txtCHDateAndTime = (TextView) view.findViewById(R.id.txtCHDateAndTime);
            this.imgCHRemove = (ImageView) view.findViewById(R.id.imgCHRemove);
        }
    }
}
