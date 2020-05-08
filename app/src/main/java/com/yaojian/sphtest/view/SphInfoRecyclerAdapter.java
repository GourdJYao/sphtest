package com.yaojian.sphtest.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yaojian.sphtest.R;
import com.yaojian.sphtest.greendao.entity.MonthData;

import java.util.List;

public class SphInfoRecyclerAdapter extends RecyclerView.Adapter<SphInfoRecyclerAdapter.SphInfoViewHolder> {
    private List<MonthData> monthDataList;
    private Context context;

    public SphInfoRecyclerAdapter(Context context, List<MonthData> monthDataList) {
        this.context = context;
        this.monthDataList = monthDataList;
    }

    @NonNull
    @Override
    public SphInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_sphinfo, parent, false);
        return new SphInfoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SphInfoViewHolder holder, int position) {
        MonthData monthData = monthDataList.get(position);
        if (monthData.isWave()) {
            holder.clickImg.setVisibility(View.VISIBLE);
        } else {
            holder.clickImg.setVisibility(View.INVISIBLE);
        }
        holder.yearTv.setText(monthData.getMonthString());
        holder.dataTv.setText(monthData.getTotalData() + "");
    }

    @Override
    public int getItemCount() {
        return monthDataList == null ? 0 : monthDataList.size();
    }

    class SphInfoViewHolder extends RecyclerView.ViewHolder {

        private TextView yearTv;

        private TextView dataTv;

        private ImageView clickImg;

        SphInfoViewHolder(View itemView) {
            super(itemView);
            yearTv = (TextView) itemView.findViewById(R.id.year_tv);
            dataTv = (TextView) itemView.findViewById(R.id.data_tv);
            clickImg = (ImageView) itemView.findViewById(R.id.click_img);
        }
    }

    public void updateData(List<MonthData> monthDataList) {
        this.monthDataList = monthDataList;
        notifyDataSetChanged();
    }
}
