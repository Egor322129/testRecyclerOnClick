package com.example.android.testrecycleronclick;

public class Song {

    private String mName;
    private int mAudioResourceId;
    private int mImageResourceId;

    public Song(String mName, int mImageResourceId) {
        this.mName = mName;
        this.mAudioResourceId = 0;
        this.mImageResourceId = mImageResourceId;
    }

    public String getName() {
        return mName;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
