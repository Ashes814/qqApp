package com.oo.qqServer.common;

import java.io.Serializable;

/**
 * @author 欧欧
 * @version 1.0
 * 表示客户端和服务器端通信时的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // 增加序列化后的兼容性
    private String sender; // 发送者
    private String getter; //接收者
    private String content; //内容
    private String sentTime; //发送时间需要被序列化，所以使用String而非日期
    private String mesType; //消息类型，文件，聊天，登录等

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
