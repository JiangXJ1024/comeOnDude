/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
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