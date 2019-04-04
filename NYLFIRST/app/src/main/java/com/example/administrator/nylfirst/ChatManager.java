package com.example.administrator.nylfirst;

import java.util.HashMap;
import java.util.Vector;


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
