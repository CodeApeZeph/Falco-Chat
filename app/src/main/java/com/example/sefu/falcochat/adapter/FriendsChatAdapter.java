package com.example.sefu.falcochat.adapter;

/**
 * Created by sefu on 8/17/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sefu.falcochat.R;
import com.example.sefu.falcochat.model.FriendChatModel;

import java.util.ArrayList;


public class FriendsChatAdapter extends RecyclerView.Adapter<FriendsChatAdapter.MyViewHolder> {

    private ArrayList<FriendChatModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewFriendName;
        TextView textViewTextName;
        ImageView imageViewProfilePic;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewFriendName = (TextView) itemView.findViewById(R.id.username);
            this.textViewTextName = (TextView) itemView.findViewById(R.id.text);
            this.imageViewProfilePic = (ImageView) itemView.findViewById(R.id.profile);
        }
    }

    public FriendsChatAdapter(ArrayList<FriendChatModel> data) {
        this.dataSet = data;
    }

    @Override
    public FriendsChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_friend_chat_tem, parent, false);

        FriendsChatAdapter.MyViewHolder myViewHolder = new FriendsChatAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final FriendsChatAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewFriendName = holder.textViewFriendName;
        TextView textViewTextName = holder.textViewTextName;
        ImageView imageViewProfilePic = holder.imageViewProfilePic;

        textViewFriendName.setText(dataSet.get(listPosition).getFriendName());
        textViewTextName.setText(dataSet.get(listPosition).getTextName());
        imageViewProfilePic.setImageResource(dataSet.get(listPosition).getUserProfile());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
