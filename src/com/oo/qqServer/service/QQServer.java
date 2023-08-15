package com.oo.qqServer.service;

import com.oo.common.Message;
import com.oo.common.MessageType;
import com.oo.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 欧欧
 * @version 1.0
 */
public class QQServer {
    private ServerSocket ss = null;
    // user Collection
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("atm", new User("atm", "123456"));
        validUsers.put("btm", new User("btm", "123456"));
        validUsers.put("ctm", new User("ctm", "123456"));
        validUsers.put("dtm", new User("dtm", "123456"));
    }

    private boolean checkUser(String userId, String pwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }

        if (!user.getPasswd().equals(pwd)) {
            return false;
        }

        return true;
    }

    public QQServer() {
        System.out.println("Server is listening at 9999 port...");
        try {
            ss = new ServerSocket(9999);
            while (true) {
                // when connected to a client, the server will keep listen
                Socket socket = ss.accept();
                // get ois related to socket
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // get oos
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();
                // create message object
                Message message = new Message();
                // Verify
                if (checkUser(u.getUserId(), u.getPasswd())) {
                    // legal user
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    // create a thread to keep connect with client
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();
                    // put Thread into a hashset
                    ManageServerThread.addClientThread(u.getUserId(), serverConnectClientThread);

                } else {
                    System.out.println("id: " + u.getUserId()+"log failed");
                    // illegal user
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    // close socket
                    socket.close();

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
