package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
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

public class SetActivity extends AppCompatActivity {

    private TextView college;
    private TextView no;
    private TextView name;
    private TextView sex;
    private TextView grade;
    private TextView major;

    private EditText userName;
    private EditText passWord;
    private EditText information;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        initData();
        initSwitch();

    }

    private void initData(){

        userName = findViewById(R.id.EditText1);
        passWord = findViewById(R.id.EditText2);
        information = findViewById(R.id.EditText3);
        college = findViewById(R.id.EditText4);
        no = findViewById(R.id.EditText5);
        name = findViewById(R.id.EditText6);
        sex = findViewById(R.id.EditText7);
        grade = findViewById(R.id.EditText8);
        major = findViewById(R.id.EditText9);

        String text = ((MyApplication)SetActivity.this.getApplicationContext()).user.getCollege();
        college.setText(text);

        int t = ((MyApplication)SetActivity.this.getApplicationContext()).user.getNo();
        text = String.valueOf(t);
        no.setText(text);

        text = ((MyApplication)SetActivity.this.getApplicationContext()).user.getName();
        name.setText(text);

        text = ((MyApplication)SetActivity.this.getApplicationContext()).user.getSex();
        sex.setText(text);

        text = ((MyApplication)SetActivity.this.getApplicationContext()).user.getGrade();
        grade.setText(text);

        text = ((MyApplication)SetActivity.this.getApplicationContext()).user.getMajor();
        major.setText(text);

    }

    private void initSwitch(){

        Switch Acollege = findViewById(R.id.open1);
        Switch Ano = findViewById(R.id.open2);
        Switch Aname = findViewById(R.id.open3);
        Switch Asex = findViewById(R.id.open4);
        Switch Agrade = findViewById(R.id.open5);
        Switch Amajor = findViewById(R.id.open6);

        Acollege.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = college;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    String College = ((MyApplication)SetActivity.this.getApplicationContext()).user.getCollege();
                    tv.setText(College);
                }
            }
        });

        Ano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = no;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    int No = ((MyApplication)SetActivity.this.getApplicationContext()).user.getNo();
                    tv.setText(String.valueOf(No));
                }
            }
        });

        Aname.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = name;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    String Name = ((MyApplication)SetActivity.this.getApplicationContext()).user.getName();
                    tv.setText(Name);
                }
            }
        });

        Asex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = sex;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    String Sex = ((MyApplication)SetActivity.this.getApplicationContext()).user.getSex();
                    tv.setText(Sex);
                }
            }
        });

        Agrade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = grade;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    String Grade = ((MyApplication)SetActivity.this.getApplicationContext()).user.getGrade();
                    tv.setText(Grade);
                }
            }
        });

        Amajor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = major;
                if (isChecked)
                {
                    tv.setText("保密");
                }else{
                    String Major = ((MyApplication)SetActivity.this.getApplicationContext()).user.getMajor();
                    tv.setText(Major);
                }
            }
        });

    }

    public void Click3(View view) {//更改头像

    }

    public void RRegisterRequest(//信息验证，身份正确且未注册过则跳转
                                final String college, final String photo, final String no, final String name, final String sex, final String grade,
                                final String major, final String userName, final String passWord, final String information) {
        //请求地址
        String url = "http://192.168.43.129:8080/WebApplication1/RRegisterServlet";    //注①
        String tag = "RRegister";    //注②
        int trueNo = ((MyApplication)SetActivity.this.getApplicationContext()).user.getNo();

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
                            JSONObject jsonObject = (JSONObject) new JSONObject(response).get("params3");  //注③
                            String result = jsonObject.getString("Result");  //注④
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            if (result.equals("success")) {  //注⑤
                                //做自己的登录成功操作，如页面跳转
                                ((MyApplication)SetActivity.this.getApplicationContext()).user.setUserInformation(
                                        userName, passWord, Integer.parseInt(photo));
                                Toast.makeText(getApplicationContext(),
                                        "注册成功success", Toast.LENGTH_SHORT).show();
                                //利用Intent进行不同Activity（页面）之间的数据传送
                                Intent intent = new Intent();
                                intent.setClass(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                //做自己的登录失败操作，如Toast提示
                                Toast.makeText(getApplicationContext(),
                                        "保存失败", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            //做自己的请求异常操作，如Toast提示（“无网络连接”等）
                            Toast.makeText(getApplicationContext(),
                                    "JSONException网络错误等异常", Toast.LENGTH_SHORT).show();
                            Log.e("TAG", no+userName+passWord+name+grade+major+college+information+e.getMessage(), e);
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
                params.put("NOSHOW", no);  //注⑥
                params.put("NO",String.valueOf (
                        ((MyApplication)SetActivity.this.getApplicationContext()).user.getNo()));
                params.put("Photo", photo);
                params.put("UserName", userName);
                params.put("Password", passWord);
                params.put("Name", name);
                params.put("Sex", sex);
                String nation = ((MyApplication)SetActivity.this.getApplicationContext()).user.getNation();
                params.put("Nation", nation);
                params.put("Grade", grade);
                params.put("Major", major);
                params.put("College", college);
                params.put("Information", information);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    public void Click4(View view) {//保存设置的个人信息，然后返回登录页面
        //提示信息已成功保存
        String UserName = userName.getText().toString().trim();
        String Photo = "1";
        String PassWord = passWord.getText().toString().trim();
        String Information = information.getText().toString().trim();
        String College = college.getText().toString().trim();
        String Name = name.getText().toString().trim();
        String No = no.getText().toString().trim();
        String Sex = sex.getText().toString().trim();
        String Grade = grade.getText().toString().trim();
        String Major = major.getText().toString().trim();

        //返回登录首页面
        RRegisterRequest(College, Photo,No,Name,Sex,Grade,Major,UserName,PassWord,Information);
    }
}
