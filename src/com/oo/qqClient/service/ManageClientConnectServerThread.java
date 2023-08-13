package com.oo.qqClient.service;

import java.util.HashMap;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ManageClientConnectServerThread {
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    // add thread to set
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);

    }
    // get thread by userID
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

}
