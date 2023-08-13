package com.oo.common;

import java.io.Serializable;

/**
 * @author 欧欧
 * @version 1.0
 * Represents User's information
 */
public class User implements Serializable { // 序列化，使得User对象能够以对象形式保存与传输

    private static final long serialVersionUID = 1L; // 增加序列化后的兼容性
    private String userId;
    private String passwd;

    public User() {}

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
