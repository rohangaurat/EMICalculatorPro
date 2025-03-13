package com.demo.cashloanemi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.cashloanemi.Click.CalculatorNameItemClick;
import com.demo.cashloanemi.R;
import java.util.ArrayList;

public class CalculatorListAdapter extends RecyclerView.Adapter<CalculatorListAdapter.CalculatorListHolder> {
    ArrayList<String> calculatorNames;
    CalculatorNameItemClick click;
    Context context;
    ArrayList<Integer> iconList;

    public CalculatorListAdapter(ArrayList<String> arrayList, ArrayList<Integer> arrayList2, CalculatorNameItemClick calculatorNameItemClick) {
        this.calculatorNames = arrayList;
        this.iconList = arrayList2;
        this.click = calculatorNameItemClick;
    }

    @Override
    public CalculatorListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        return new CalculatorListHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calculator_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CalculatorListHolder calculatorListHolder, final int i) {
        calculatorListHolder.txtCalculatorName.setText(this.calculatorNames.get(i));
        calculatorListHolder.imgCalculatorIcon.setImageResource(this.iconList.get(i).intValue());
        calculatorListHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculatorListAdapter.this.click.getItem(CalculatorListAdapter.this.calculatorNames.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.calculatorNames.size();
    }

    class CalculatorListHolder extends RecyclerView.ViewHolder {
        ImageView imgCalculatorIcon;
        TextView txtCalculatorName;

        public CalculatorListHolder(View view) {
            super(view);
            this.txtCalculatorName = (TextView) view.findViewById(R.id.txtCalculatorName);
            this.imgCalculatorIcon = (ImageView) view.findViewById(R.id.imgCalculatorIcon);
        }
    }
}
