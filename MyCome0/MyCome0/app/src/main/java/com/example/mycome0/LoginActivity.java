package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
//import android.widget.Button;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    private EditText No;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        LinearLayout convertView= (LinearLayout) inflater.inflate(R.layout.activity_login, null);
        No = (EditText) findViewById(R.id.et_no);
        passWord = (EditText) findViewById(R.id.et_pass);

        //下拉列表框--选择所在院校
        String[] ctype = new String[]{"哈尔滨工业大学（威海）", "山东大学（威海）"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = super.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

    }


    public void Click0(View view) {//跳转到激活页面

        Intent intent =new Intent(LoginActivity.this,NewActivity.class);
        startActivity(intent);
        finish();
    }

    public void LoginRequest(final String accountNumber, final String password) {
        //请求地址
        String url = "http://192.168.43.129:8080/WebApplication1/LoginServlet";    //注①
        String tag = "Login";    //注②

        //getApplicationContext（）无法在静态函数中
        //取得请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        //防止重复请求，所以先取消tag标识的请求队列
        requestQueue.cancelAll(tag);

        //创建StringRequest，定义字符串请求的请求方式为POST(省略第一个参数会默认为GET方式)
        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = (JSONObject) new JSONObject(response).get("params");  //注③
                            String result = jsonObject.getString("Result");  //注④
                            Toast.makeText(getApplicationContext(),
                                    result, Toast.LENGTH_SHORT).show();
                            if (result.equals("success")) {  //注⑤
                                //做自己的登录成功操作，如页面跳转
                                Toast.makeText(getApplicationContext(),
                                        "success", Toast.LENGTH_SHORT).show();
                                //利用Intent进行不同Activity（页面）之间的数据传送
                                Intent intent = new Intent();
                                intent.setClass(getApplicationContext(), MainActivity.class);
//                                ((MyApplication)MainActivity.this.getApplicationContext()).user.initUser(
//                                        jsonObject.getString("Sex"),
//                                        jsonObject.getString("Nation"),
//                                        jsonObject.getString("Grade"),
//                                        jsonObject.getString("Major"));
                                startActivity(intent);
                                finish();
                            } else {
                                //做自己的登录失败操作，如Toast提示
                                Toast.makeText(getApplicationContext(),
                                        "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            //做自己的请求异常操作，如Toast提示（“无网络连接”等）
                            Toast.makeText(getApplicationContext(),
                                    "网络错误等异常", Toast.LENGTH_SHORT).show();
                            Log.e("TAG", e.getMessage(), e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //做自己的响应错误操作，如Toast提示（“请稍后重试”等）
                Log.e("TAG", error.getMessage(), error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("AccountNumber", accountNumber);  //注⑥
                params.put("Password", password);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    public void Click1(View view) {//点击登录跳转到主页面

//        String no = No.getText().toString().trim();
        String Password = passWord.getText().toString().trim();
        String no = No.getText().toString().trim();
        LoginRequest(no, Password);
//        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
//        startActivity(intent);
//        finish();
    }
}
