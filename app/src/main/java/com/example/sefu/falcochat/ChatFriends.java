package com.example.sefu.falcochat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sefu.falcochat.adapter.FriendsChatAdapter;
import com.example.sefu.falcochat.model.FriendChatModel;
import com.example.sefu.falcochat.model.MyFriendChatData;

import java.util.ArrayList;

public class ChatFriends extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<FriendChatModel> data;

    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_chat_friends);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_chat_friend);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<FriendChatModel>();
        for (int i = 0; i < MyFriendChatData.friendNameArray.length; i++) {
            data.add(new FriendChatModel(
                 MyFriendChatData.friendNameArray[i],
                    MyFriendChatData.textNameArray[i],
                    MyFriendChatData.userProfileArray[i],
                    MyFriendChatData.id_[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        adapter = new FriendsChatAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
