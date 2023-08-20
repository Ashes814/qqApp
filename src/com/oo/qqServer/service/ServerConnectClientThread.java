package com.oo.qqServer.service;

import com.oo.common.Message;
import com.oo.common.MessageType;
import com.oo.qqClient.service.ManageClientConnectServerThread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                 if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                     System.out.println(message.getSender() + " get Online User List");

                     String onlineUser = ManageClientConnectServerThread.getOnlineUser();
                     // return message
                     // constructor a message object, and returning to client
                     Message message2 = new Message();
                     message2.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
                     message2.setContent(onlineUser);
                     message2.setGetter(message.getSender());
                     // return to client
                     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                     oos.writeObject(message2);



                 }
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }

         }
    }
}
