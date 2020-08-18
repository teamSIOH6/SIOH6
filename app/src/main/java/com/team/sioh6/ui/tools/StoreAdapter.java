package com.team.sioh6.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team.sioh6.R;
import com.team.sioh6.UrlMaskingActivity;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    Context context;
    List<StoreModel> storeModelList;

    public StoreAdapter(Context context, List<StoreModel> storeModelList) {
        this.context = context;
        this.storeModelList = storeModelList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.store_single_view,parent,false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        StoreModel model = storeModelList.get(position);
        holder.storeName.setText(model.getStoreName());
        holder.storeLocation.setText(model.getStoreLocation());
    }

    @Override
    public int getItemCount() {
        return storeModelList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView storeName, storeLocation;
        TextView directions;
        ImageView ola;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            storeName = itemView.findViewById(R.id.storeName);
            storeLocation = itemView.findViewById(R.id.storeLocation);
            directions = itemView.findViewById(R.id.directions);
            ola = itemView.findViewById(R.id.ola);
            directions.setOnClickListener(this);
            ola.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            double lat = storeModelList.get(getAdapterPosition()).getStoreLat();
            double lng = storeModelList.get(getAdapterPosition()).getStoreLong();
            switch (v.getId()){
                case R.id.ola:
                    String url = "https://book.olacabs.com/?lat=" + ToolsFragment.myLat +"&lng=" +
                            ToolsFragment.myLong + "&drop_lat=" + lat + "&drop_lng=" + lng + "&dsw=yes";
                    Intent intent=new Intent(context, UrlMaskingActivity.class);
                    intent.putExtra("name","Ola");
                    intent.putExtra("link",url);
                    context.startActivity(intent);
                    break;

                case R.id.directions:
                    String uri = "http://maps.google.com/maps?saddr=" + ToolsFragment.myLat + "," +
                            ToolsFragment.myLong + "&daddr=" + lat + "," + lng;
                    Intent in=new Intent(context, UrlMaskingActivity.class);
                    in.putExtra("name","Google Maps");
                    in.putExtra("link",uri);
                    context.startActivity(in);
                    //Intent in = new Intent(android.content.Intent.ACTION_VIEW,
                    //        Uri.parse("http://maps.google.com/maps?saddr=" + ToolsFragment.myLat + "," +
                    //                ToolsFragment.myLong + "&daddr=" + lat + "," + lng));
                    //context.startActivity(in);
                    break;
            }
        }
    }
}
