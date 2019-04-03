package com.example.administrator.nylfirst;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




public class ServerListener extends Thread{


    public void run() {
        //端口范围:1-65535
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(8080);
            while(true) {
                Socket socket = serverSocket.accept();
                //System.out.println("有客户端连接到了端口");
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            System.out.println("连接错误！");
        }
    }
}
