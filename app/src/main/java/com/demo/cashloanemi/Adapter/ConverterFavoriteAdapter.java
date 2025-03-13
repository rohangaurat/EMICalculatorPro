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

public class ConverterFavoriteAdapter extends RecyclerView.Adapter<ConverterFavoriteAdapter.ConverterFavoriteHolder> {
    Context context;
    List<ConverterHistoryModel> converterFavorite;
    DatabaseHelper db;

    public ConverterFavoriteAdapter(List<ConverterHistoryModel> list) {
        this.converterFavorite = list;
    }

    @Override
    public ConverterFavoriteHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context2 = viewGroup.getContext();
        this.context = context2;
        return new ConverterFavoriteHolder(LayoutInflater.from(context2).inflate(R.layout.converter_favorite_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ConverterFavoriteHolder converterFavoriteHolder, final int i) {
        final ConverterHistoryModel converterHistoryModel = this.converterFavorite.get(i);
        this.db = new DatabaseHelper(this.context);
        converterFavoriteHolder.txtCFToAmount.setText(converterHistoryModel.getToAmount());
        converterFavoriteHolder.txtCFFromAmount.setText(converterHistoryModel.getFromAmount());
        TextView textView = converterFavoriteHolder.txtCFCode;
        textView.setText(converterHistoryModel.getFromCode() + "-" + converterHistoryModel.getToCode());
        converterFavoriteHolder.imgCFFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConverterFavoriteAdapter.this.db.updateConverterFavorite(converterHistoryModel.getFromCode(), converterHistoryModel.getToCode(), converterHistoryModel.getFromAmount(), 1);
                ConverterFavoriteAdapter.this.converterFavorite.remove(i);
                ConverterFavoriteAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.converterFavorite.size();
    }

    class ConverterFavoriteHolder extends RecyclerView.ViewHolder {
        ImageView imgCFFavorite;
        TextView txtCFCode;
        TextView txtCFFromAmount;
        TextView txtCFToAmount;

        public ConverterFavoriteHolder(View view) {
            super(view);
            this.txtCFCode = (TextView) view.findViewById(R.id.txtCFCode);
            this.txtCFFromAmount = (TextView) view.findViewById(R.id.txtCFFromAmount);
            this.txtCFToAmount = (TextView) view.findViewById(R.id.txtCFToAmount);
            this.imgCFFavorite = (ImageView) view.findViewById(R.id.imgCFFavorite);
        }
    }
}
