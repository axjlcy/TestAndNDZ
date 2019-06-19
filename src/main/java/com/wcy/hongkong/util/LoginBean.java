package com.wcy.hongkong.util;

/**
 * @author ndzzz
 * @date 10:56 2019/6/18
 * @Description:
 */
public class LoginBean
{

    private String userName;

    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "{" +
                "\"userName\":\"" + userName + "\"" +
                ",\"passWord\":\"" + passWord + "\"" +
                "}";
    }
}
