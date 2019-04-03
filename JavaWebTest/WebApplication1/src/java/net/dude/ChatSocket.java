/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import net.sf.json.JSONException;

//import org.json.JSONException;
//import org.json.JSONObject;
import net.sf.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class ChatSocket extends Thread{

    private Socket socket;
    private BufferedWriter bWriter;
    private BufferedReader bReader;

    public ChatSocket (Socket socket) {
        this.socket = socket;
        try {
            bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //把自己的话写入输出流
    public void out(String s)
    {
        s += "\n";
        try {
            bWriter.write(s);
            bWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run()
    {
        try
        {
            String s;
            //当输入流有输入时
            while ((s = bReader.readLine()) != null)
            {
                try
                {
                    JSONObject root = JSONObject.fromObject(s);

                    //服务器收到的是聊天内容
                    if(root.has("content"))
                    {
                        String toID = root.getString("toID");


                        ChatSocket cs = ChatManager.getChatManager().hashMap.get(toID);
                        if(cs != null)
                        {
                            cs.out(s);
                        }
                        else
                         {
                             System.out.println("没有该用户" + toID);
                         }

                    }

                    //当服务器收到的是登录信息
                    else if(root.has("user") && root.has("password"))
                    {
                        JSONObject a = new JSONObject();


                        //为了便于测试，设定的是密码和用户名相等，等到之后整合再做修改
                        //当用户名=密码时（即正确登录）
                        if(root.getString("user").equalsIgnoreCase(root.getString("password")))
                        {
                            //当前登录用户不在线
                            if(!ChatManager.getChatManager().hashMap.containsKey("user"))
                            {
                                a.put("result", true);
                                ChatManager.getChatManager().hashMap.put(root.getString("user"), this);
                            }
                            //当前登录用户已上线
                            else
                            {
                                a.put("result", false);
                            }
                        }
                        //用户名不等于密码，即输入密码不正确
                        else
                        {
                            a.put("result", false);
                        }
                        out(a.toString());
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
