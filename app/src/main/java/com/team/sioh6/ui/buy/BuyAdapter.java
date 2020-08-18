package com.team.sioh6.ui.buy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team.sioh6.R;
import com.team.sioh6.UrlMaskingActivity;
import com.team.sioh6.ui.buy.Comments.BottomSheetDialog;
import com.team.sioh6.ui.tools.ToolsFragment;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.MyViewHolder> {

    private Context context;
    private List<BuyModel> buyModelList;
    private FragmentManager fragmentManager;
    private LayoutInflater inflater;

    public BuyAdapter(Context context, List<BuyModel> buyModelList, FragmentManager fragmentManager) {
        this.context = context;
        this.buyModelList = buyModelList;
        this.fragmentManager = fragmentManager;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.buy_single_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.e("BuyAdapter","check:- " + buyModelList.size());
        holder.userName.setText(buyModelList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return buyModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView profImg;
        TextView userName;
        TextView timeStamp;
        ImageView productImg;
        TextView productTitle;
        TextView productDetail;
        TextView status;
        TextView comments;
        TextView like;
        Button direction;
        ImageView share;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profImg = itemView.findViewById(R.id.imageView2);
            userName = itemView.findViewById(R.id.author);
            timeStamp = itemView.findViewById(R.id.posted_date);
            productImg = itemView.findViewById(R.id.img_blog);
            productTitle = itemView.findViewById(R.id.title);
            productDetail = itemView.findViewById(R.id.blog);
            status = itemView.findViewById(R.id.txt_status);
            comments = itemView.findViewById(R.id.comments);
            like = itemView.findViewById(R.id.txt_like);
            direction = itemView.findViewById(R.id.read);
            share = itemView.findViewById(R.id.img_share);
            comments.setOnClickListener(this);
            like.setOnClickListener(this);
            direction.setOnClickListener(this);
            share.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.comments:
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context,fragmentManager);
                    bottomSheetDialog.show(fragmentManager,"FirstViewComment");
                    break;

                case R.id.txt_like:
                    Toast.makeText(context,"Post Liked",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.read:
                    double lat = 17.3850;
                    double lng = 78.4867;
                    String uri = "http://maps.google.com/maps?saddr=" + BuyFragment.myLat + "," +
                            BuyFragment.myLong + "&daddr=" + lat + "," + lng;
                    Intent in=new Intent(context, UrlMaskingActivity.class);
                    in.putExtra("name","Google Maps");
                    in.putExtra("link",uri);
                    context.startActivity(in);
                    break;

                case R.id.img_share:
                    Toast.makeText(context,"Post Shared",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
