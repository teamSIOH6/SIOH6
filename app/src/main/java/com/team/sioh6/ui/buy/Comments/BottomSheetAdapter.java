package com.team.sioh6.ui.buy.Comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team.sioh6.R;

import java.util.List;

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.MyViewHolder> {
    private Context context;
    private FragmentManager fragmentManager;
    private List<String> userNameList;
    private List<String> userCommentList;

    public BottomSheetAdapter(Context context, FragmentManager fragmentManager, List<String> userNameList, List<String> userCommentList) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.userNameList = userNameList;
        this.userCommentList = userCommentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.buy_comment_first_single,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(userNameList.get(position));
        holder.userComment.setText(userCommentList.get(position));
    }

    @Override
    public int getItemCount() {
        return userCommentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView userComment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userComment = itemView.findViewById(R.id.user_comment);
        }
    }
}
