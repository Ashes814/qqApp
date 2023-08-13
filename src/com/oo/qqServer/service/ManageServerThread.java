package com.oo.qqServer.service;

import java.util.HashMap;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ManageServerThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();
    // add Thread Object to hm set
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getScct(String userId) {
        return hm.get(userId);
    }
}
