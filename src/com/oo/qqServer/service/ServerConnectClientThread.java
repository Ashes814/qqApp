package com.oo.qqServer.service;

import com.oo.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author 欧欧
 * @version 1.0
 *
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId; //connected to userId in Server

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {

         while (true) {
             System.out.println("Server and Client, Reading..." + "ID:  " + userId);
             try {
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                 Message message = (Message) ois.readObject();
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }

         }
    }
}
