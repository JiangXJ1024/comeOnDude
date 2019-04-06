package com.example.mycome0;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class NewActivity extends AppCompatActivity {
    Spinner College;
    EditText No;
    EditText Name;
    EditText IdNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //下拉列表框--选择所在院校
        String[] ctype = new String[]{"哈尔滨工业大学（威海）", "山东大学（威海）"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = super.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

        College = (Spinner)findViewById(R.id.spinner1);
        No =(EditText)findViewById(R.id.editText1);  //
        Name = (EditText)findViewById(R.id.editText2);
        IdNumber =(EditText)findViewById(R.id.editText3);  //获取密码
    }

    public void RegisterRequest(//信息验证，身份正确且未注册过则跳转
                                final String College, final String No, final String Name, final String IdNumber) {
        //请求地址
        String url = "http://192.168.43.129:8080/WebApplication1/RegisterServlet";    //注①
        String tag = "Register";    //注②

        //getApplicationContext（）无法在静态函数中
        //取得请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        //防止重复请求，所以先取消tag标识的请求队列
        requestQueue.cancelAll(tag);
        Toast.makeText(getApplicationContext(),
                "requestQueue", Toast.LENGTH_SHORT).show();

        //创建StringRequest，定义字符串请求的请求方式为POST(省略第一个参数会默认为GET方式)
        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = (JSONObject) new JSONObject(response).get("params2");  //注③
                            String result = jsonObject.getString("Result");  //注④
                            Toast.makeText(getApplicationContext(),
                                    result, Toast.LENGTH_SHORT).show();
                            int state = Integer.parseInt(result);
                            Toast.makeText(getApplicationContext(),
                                    result, Toast.LENGTH_SHORT).show();
                            switch (state){
                                case 0:
                                    ((MyApplication)NewActivity.this.getApplicationContext()).user.setBasicInformation(
                                            College, Name, Integer.parseInt(No));
                                    ((MyApplication)NewActivity.this.getApplicationContext()).user.initUser(
                                            jsonObject.getString("Sex"),
                                            jsonObject.getString("Nation"),
                                            jsonObject.getString("Grade"),
                                            jsonObject.getString("Major"));
                                    Intent intent = new Intent();
                                    intent.setClass(getApplicationContext(), SetActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "success", Toast.LENGTH_SHORT).show();
                                    finish();
                                    break;
                                case 1:
                                    Toast.makeText(getApplicationContext(),
                                            "You are allready registered!", Toast.LENGTH_SHORT).show();
                                    break;
                                case 2:
                                    Toast.makeText(getApplicationContext(),
                                            "未查找到该学生", Toast.LENGTH_SHORT).show();
                                    break;
                                case 3:
                                    Toast.makeText(getApplicationContext(),
                                            "SQL语句错误", Toast.LENGTH_SHORT).show();
                                    break;
                                case 4:
                                    Toast.makeText(getApplicationContext(),
                                            "身份信息验证错误", Toast.LENGTH_SHORT).show();
                                    break;
                                case 5:
                                    Toast.makeText(getApplicationContext(),
                                            "身份信息验证错误（该学号已注册", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        } catch (JSONException e) {
                            //做自己的请求异常操作，如Toast提示（“无网络连接”等）
                            Toast.makeText(getApplicationContext(),
                                    "JSONException网络错误等异常", Toast.LENGTH_SHORT).show();
                            Log.e("TAG", College+No+Name+IdNumber+e.getMessage(), e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //做自己的响应错误操作，如Toast提示（“请稍后重试”等）
                Toast.makeText(getApplicationContext(),
                        "onErrorResponse网络错误等异常,请稍后重试", Toast.LENGTH_SHORT).show();
                Log.e("TAG", error.getMessage(), error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("studentNo", No);  //注⑥
                params.put("name", Name);
                params.put("college", College);
                params.put("IDnumber", IdNumber);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Click2(View view) {//激活账号-验证信息

        String college = ((TextView)College.getSelectedView()).getText().toString().trim();
        String no = No.getText().toString().trim();
        String name = Name.getText().toString().trim();
        String idNumber = IdNumber.getText().toString().trim();

        //信息验证
        RegisterRequest(college, no, name, idNumber);

    }
}
