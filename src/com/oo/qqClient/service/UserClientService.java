package com.oo.qqClient.service;

import com.oo.qqClient.common.User;

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



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
