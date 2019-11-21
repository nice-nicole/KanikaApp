package com.example.kanikaapp.Model;

import com.google.firebase.database.Exclude;

public class SparePart {
    private String mName;
    private String mImageUrl;

    public SparePart() {
        //empty constructor needed
    }

    public SparePart(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
