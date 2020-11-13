package com.example.bigproject.db.database;

public class ImageTotalData {
    String id, seaGId, picture;
    int number_picture;

    public ImageTotalData(String id, String seaGId, String picture,int number_picture) {
        this.id = id;
        this.seaGId = seaGId;
        this.picture = picture;
        this.number_picture = number_picture;
    }

    public int getNumber_picture() {
        return number_picture;
    }

    public void setNumber_picture(int number_picture) {
        this.number_picture = number_picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeaGId() {
        return seaGId;
    }

    public void setSeaGId(String seaGId) {
        this.seaGId = seaGId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
