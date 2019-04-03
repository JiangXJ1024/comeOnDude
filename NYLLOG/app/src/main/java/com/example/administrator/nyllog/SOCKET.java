package com.example.administrator.nyllog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
public class SOCKET extends Service
{
    private static Socket socket;
    private static BufferedWriter bWriter;//输出流，发送、写入信息
    private static BufferedReader bReader;//输入流，接受、读取信息

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(SOCKET.this, "connect success", Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            public void run() {
                try {
                    socket = new Socket("192.168.43.129",8080);
                    bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                    bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

                    //readLine()是一个阻塞函数，当没有数据读取时，就一直会阻塞在那，而不是返回null
                    String s;
                    while ((s = bReader.readLine()) != null) {
                        /*
                        Intent intent = new Intent();
                        intent.putExtra("jsonString", s);
                        intent.setAction("SocketClient");
                        sendBroadcast(intent);
                        */
                        //注：此部分未测试，之后还需修正
                        ((MyApplication)SOCKET.this.getApplicationContext()).words=s;


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void send(String jsonString)
    {
        jsonString += "\n";
        try {
            bWriter.write(jsonString);
            bWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
