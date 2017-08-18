package com.example.sefu.falcochat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sefu.falcochat.R;
import com.example.sefu.falcochat.model.GroupChatModel;

import java.util.ArrayList;

/**
 * Created by sefu on 8/18/2017.
 */

public class GroupChatAdapter extends RecyclerView.Adapter<GroupChatAdapter.MyViewHolder> {

    private ArrayList<GroupChatModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewItemName;
        TextView textViewNumberOfMembers;
        ImageView imageViewItemIcon;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewItemName = (TextView) itemView.findViewById(R.id.itemName);
            this.textViewNumberOfMembers = (TextView) itemView.findViewById(R.id.membersNumber);
            this.imageViewItemIcon = (ImageView) itemView.findViewById(R.id.itemIcon);
        }
    }

    public GroupChatAdapter(ArrayList<GroupChatModel> data) {
        this.dataSet = data;
    }

    @Override
    public GroupChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_group_chat_item, parent, false);

        GroupChatAdapter.MyViewHolder myViewHolder = new GroupChatAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final GroupChatAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewItemName = holder.textViewItemName;
        TextView textViewNumberOfMembers = holder.textViewNumberOfMembers;
        ImageView imageViewItemIcon = holder.imageViewItemIcon;

        textViewItemName.setText(dataSet.get(listPosition).getItemName());
        textViewNumberOfMembers.setText(dataSet.get(listPosition).getMembersNumber());
        imageViewItemIcon.setImageResource(dataSet.get(listPosition).getItemIcon());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
