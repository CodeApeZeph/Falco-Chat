package com.example.sefu.falcochat.model;

/**
 * Created by sefu on 8/18/2017.
 */

public class GroupChatModel {

    String itemName;
    String membersNumber;
    int itemIcon;
    int id_;

    public GroupChatModel(String itemName, String membersNumber, int itemIcon, int id_) {
        this.itemName = itemName;
        this.membersNumber = membersNumber;
        this.itemIcon = itemIcon;
        this.id_ = id_;
    }

    public String getItemName() {
        return itemName;
    }

    public String getMembersNumber() {
        return membersNumber;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public int getId_() {
        return id_;
    }
}
