package com.xvitcoder.springmvcangularjs.beans;

import java.io.Serializable;

/**
 * Created by lucian on 15/06/16.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;

    public User(){
        System.out.println("been here - User ctor");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
