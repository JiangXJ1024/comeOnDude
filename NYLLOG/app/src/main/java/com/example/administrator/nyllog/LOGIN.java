package com.example.administrator.nyllog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class LOGIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button log=(Button)findViewById(R.id.button1);
        log.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LOGIN.this,FRIEND.class);
                startActivity(intent);

                //连接服务器
                JSONObject j=new JSONObject();
                EditText t1=(EditText) findViewById(R.id.editText1);
                EditText t2=(EditText) findViewById(R.id.editText2);
                String user=t1.getText().toString();
                String password=t2.getText().toString();
                try {
                    j.put("user", user);
                    j.put("password", password);
                    SOCKET.send(j.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                };


            }
        });




    }

}

