package com.example.mycome0;

//package com.example.dell.myapplication;

public class User {
    //用户姓名
    private String userName;
    //用户密码
    private String password;
    //头像
    private int no;
    //头像
    private int photo;
    //真实姓名
    private String name;
    //性别
    private String sex;
    //民族
    private String nation;
    //年级
    private String grade;
    //专业
    private String major;
    //大学
    private String college;
    //身份证号
    private String iDnumber;
    //个人介绍
    private String information;

    public void initUser(String ssex,String nnation,String ggrade,String mmajor){
//        name = nname;
        sex = ssex;
        nation = nnation;
        grade = ggrade;
        major = mmajor;
    }

    public void setBasicInformation(String College, String Name, int No){
        college = College;
        name = Name;
        no =No;
    }

    public String getName() {
        return name;
    }

    public int getNo() {
        return no;
    }

    public String getSex() {
        return sex;
    }

    public String getNation() {
        return nation;
    }

    public String getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    public String getCollege() {
        return major;
    }


}

