package com.example.bigproject.db.database;

public class ImageDetailData {
    String id, name, avatar, date;

    public ImageDetailData(String id, String name, String date, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
