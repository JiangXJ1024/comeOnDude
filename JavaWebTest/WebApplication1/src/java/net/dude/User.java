/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

/**
 *
 * @author ASUS
 */
public class User {
    //用户姓名
    private String userName;
    //用户密码
    private String password;
    //头像
    private int photo;
    //学号
    private int no;
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
    //身份验证状态
    private int state;
    //对外显示
    private String noShow;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
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

    public void setUserInformation(String UserName, String Password,String Information, int Photo) {
        userName = UserName;
        password = Password;
        information = Information;
        photo = Photo;
    }

    public void setNoShow(String noShow) {
        this.noShow = noShow;
    }
    
    public void setState(int s) {
        state = s;
    }
    public int getState() {
        return state;
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
        return college;
    }

    public String getInformation() {
        return information;
    }

    public String getNoShow() {
        return noShow;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }
    
}
