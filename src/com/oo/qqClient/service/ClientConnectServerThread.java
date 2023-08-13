package com.oo.qqClient.service;

import com.oo.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author 欧欧
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread {
    // this thread should hold Socket
    private Socket socket;
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Thread needs to communicate with server, so we need a while loop
        while (true) {
            System.out.println("Client Thread, waiting for server ");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // Without Message, Thread will be blocked
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Socket getSocket() {
        return socket;
    }
}
