package com.oo.qqClient.service;

import com.oo.common.Message;
import com.oo.common.MessageType;
import com.oo.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 欧欧
 * @version 1.0
 * this class is used for user sign up and sign in
 */
public class UserClientService {
    private boolean b = false;
    private User u = new User();
    private Socket socket;

    // sign up validation
    public boolean checkUser(String userId, String pwd) {
        // create User Object
        u.setUserId(userId);
        u.setPasswd(pwd);
        // connect to service
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            // getObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); // sending user object

            //Reading Message object returned by serve
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {

                // create a thread to keep connect with server
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                // launch client thread
                ccst.start();
                // store thread in a set, making app more extensible
                ManageClientConnectServerThread.addClientConnectServerThread(u.getUserId(), ccst);

                b = true;

            } else {
                // close socket
                socket.close();

            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return b;


    }

    // ask for online friend list
    public void onlineFriendList() {
        // Send A Message, MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);

        // Send to Server
        // should get current Socket's OOS
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message); // Send a Message object ask server for online user list
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
