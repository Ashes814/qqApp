package com.oo.common;

/**
 * @author 欧欧
 * @version 1.0
 * 表示消息类型有哪些
 */
public interface MessageType {
    /*
    * 1. 在接口中定义一些常量，不同常量表示不同的消息类型
    * */
    String MESSAGE_LOGIN_SUCCEED = "1"; //表示登录成功
    String MESSAGE_LOGIN_FAIL = "2"; //表示登录失败
    String MESSAGE_COMM_MES = "3"; //Common message package
    String MESSAGE_GET_ONLINE_FRIEND = "4"; // get online friend list
    String MESSAGE_RET_ONLINE_FRIEND = "5"; // return online friend list
    String MESSAGE_CLIENT_EXIT = "6"; // client ask for exit

}
