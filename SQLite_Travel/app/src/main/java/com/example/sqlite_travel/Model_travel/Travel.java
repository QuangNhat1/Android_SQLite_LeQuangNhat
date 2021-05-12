package com.example.sqlite_travel.Model_travel;

public class Travel {
    private int mId;
    private String mName;

    public Travel(){
    }

    public Travel(String mName) {
        this.mName = mName;
    }

    public Travel(int mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
