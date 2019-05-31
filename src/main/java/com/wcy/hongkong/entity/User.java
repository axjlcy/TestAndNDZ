package com.wcy.hongkong.entity;

public class User {
    private Integer uId;

    private String uName;

    private String uPassword;

    public User(Integer uId, String uName, String uPassword) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public User() {
        super();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }
}