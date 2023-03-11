package com.example.thailandstudy.two;

public class Icons {
    private int iId;
    private String iName;

    public Icons() {
    }
    public Icons(String iName) {
        this.iName = iName;
    }
    public Icons(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
