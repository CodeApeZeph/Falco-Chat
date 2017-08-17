package com.example.sefu.falcochat.model;

/**
 * Created by sefu on 7/31/2017.
 */

public class FriendChatModel {

    String friendName;
    String textName;
    int userProfile;
    int id_;

    public FriendChatModel(String friendName, String textName, int userProfile, int id_) {
        this.friendName = friendName;
        this.textName = textName;
        this.userProfile = userProfile;
        this.id_ = id_;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getTextName() {
        return textName;
    }

    public int getUserProfile() {
        return userProfile;
    }

    public int getId_() {
        return id_;
    }
}
