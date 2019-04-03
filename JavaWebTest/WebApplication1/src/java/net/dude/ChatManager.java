/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class ChatManager {

    //每个用户都有自己的socket端口
    private Vector<ChatSocket> vector = new Vector<ChatSocket>();
    public HashMap<String, ChatSocket> hashMap = new HashMap<String, ChatSocket>();


    private ChatManager () { }
    private static final ChatManager cm = new ChatManager();
    public static ChatManager getChatManager() {
        return cm;
    }

    public void add(ChatSocket chatSocket)
    {
        vector.add(chatSocket);
    }


}
