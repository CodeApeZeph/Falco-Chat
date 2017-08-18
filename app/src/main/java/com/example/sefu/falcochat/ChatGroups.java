package com.example.sefu.falcochat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sefu.falcochat.adapter.GroupChatAdapter;
import com.example.sefu.falcochat.model.GroupChatModel;
import com.example.sefu.falcochat.model.MyGroupChatData;

import java.util.ArrayList;

public class ChatGroups extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<GroupChatModel> data;

    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    LinearLayout friendTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_chat_groups);


        friendTransition = (LinearLayout) findViewById(R.id.friendsTransition);

        friendTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGroup = new Intent(getApplicationContext(), ChatFriends.class);
                startActivity(startGroup);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_chat_group);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<GroupChatModel>();
        for (int i = 0; i < MyGroupChatData.itemNameArray.length; i++) {
            data.add(new GroupChatModel(
                    MyGroupChatData.itemNameArray[i],
                    MyGroupChatData.membersNumberArray[i],
                    MyGroupChatData.itemIconArray[i],
                    MyGroupChatData.id_[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        adapter = new GroupChatAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
