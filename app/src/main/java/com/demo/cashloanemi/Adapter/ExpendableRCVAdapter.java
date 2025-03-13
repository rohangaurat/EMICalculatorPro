package com.demo.cashloanemi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.R;
import java.util.ArrayList;

public class ExpendableRCVAdapter extends RecyclerView.Adapter<ExpendableRCVAdapter.ExpendableRCVHolder> {
    ArrayList<String> s;

    public ExpendableRCVAdapter(ArrayList<String> arrayList) {
        this.s = arrayList;
    }

    @Override
    public ExpendableRCVHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ExpendableRCVHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expendable_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ExpendableRCVHolder expendableRCVHolder, int i) {
        expendableRCVHolder.txtCalculator.setText(this.s.get(i));
    }

    @Override
    public int getItemCount() {
        return this.s.size();
    }

    class ExpendableRCVHolder extends RecyclerView.ViewHolder {
        RecyclerView rcvCalculator;
        TextView txtCalculator;

        public ExpendableRCVHolder(View view) {
            super(view);
            this.txtCalculator = (TextView) view.findViewById(R.id.txtCalculator);
        }
    }
}
