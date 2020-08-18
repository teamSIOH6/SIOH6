package com.team.sioh6.ui.sell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team.sioh6.R;

import java.util.List;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.SellViewHolder> {

    private Context context;
    private List<SellModel> sellModelList;

    public SellAdapter(Context context, List<SellModel> sellModelList) {
        this.context = context;
        this.sellModelList = sellModelList;
    }

    @NonNull
    @Override
    public SellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sell_single_view,parent,false);
        return new SellViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellViewHolder holder, int position) {
        SellModel model = sellModelList.get(position);
        holder.productName.setText(model.getProductName());
        holder.productDetails.setText(model.getProductDetails());
        holder.date.setText(model.getProductDate());
        if (position != 0 && position != 1){
            holder.status.setText("Removed");
            holder.status.setTextColor(context.getResources().getColor(R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return sellModelList.size();
    }

    class SellViewHolder extends RecyclerView.ViewHolder{
        TextView productName, productDetails, date, status;
        ImageView share;
        public SellViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productDetails = itemView.findViewById(R.id.productDetails);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            share = itemView.findViewById(R.id.img_share);
        }
    }
}
