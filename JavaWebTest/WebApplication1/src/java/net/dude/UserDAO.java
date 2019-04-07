/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;
/**
 *
 * @author ASUS
 */
public class UserDAO {
     /**
     * 查询给定用户名的用户的详细信息
     *
     * @param userName 给定的用户名
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUser(String No) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE No=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, Integer.parseInt(No));
            
            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
//                user.setUserName(resultSet.getString("No"));
                user.setPassword(resultSet.getString("Password"));
                user.initUser(resultSet.getString("Sex"),
                            resultSet.getString("Nation"),
                            resultSet.getString("Grade") , 
                            resultSet.getString("Major"));
                user.setBasicInformation(resultSet.getString("College"),
                        resultSet.getString( "Name"), 
                        resultSet.getInt("No"));
                user.setUserInformation(resultSet.getString("UserName"),
                            resultSet.getString("Password"),
                            resultSet.getString("Information") , 
                            resultSet.getInt("Photo"));
                user.setNoShow(resultSet.getString("NoShow"));
                
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
    
    /**
     * 查询该用户注册情况
     * @param studentNo 给定的学号
     * @param name 真实姓名
     * @param college 大学
     * @param IDnumber 身份证号
     * @param state 状态
     * @return 0未注册、1已注册、2未查找到该人、3SQL查询错误、4身份信息验证错误、5身份信息验证错误（该学号已注册
     */
    public static User stateUser(int studentNo,String name, String college,String IDnumber) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM allstudent WHERE No=?");
        User u = new User();
        
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1,studentNo );
            
            resultSet = preparedStatement.executeQuery();
            
            int state;
            if (resultSet.next()) {
                state = resultSet.getInt("State");
                //验证身份信息
                if(name.equals(resultSet.getString("Name"))&&college.equals(resultSet.getString("College"))
                        &&IDnumber.equals(resultSet.getString("IDnumber"))){
                    u.setState(state);
                    u.initUser(resultSet.getString("Sex"),
                            resultSet.getString("Nation"),
                            resultSet.getString("Grade") , 
                            resultSet.getString("Major"));
                    if(0==state){
                        //修改数据库
                    }
                    return u;
                }
                else if(state==1){
                    u.setState(5);
                    return u;
                }
                else{
                    u.setState(4);
                    return u;
                }
                
            } else {
                u.setState(2);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            u.setState(3);
            return u;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
    
    /**
     *提交发布信息
     * @param fno 
     * @param num
     * @param type
     * @param finalno
     * @param releasetime
     * @param starttime
     * @param endtime
     * @param content
     * @return
     */
    public static boolean ReleaseMessage(int fno,int num,int type,String releasetime,String starttime,String endtime,String content)
    {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        
//        SimpleDateFormat nowTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//        long now=System.currentTimeMillis();
//        String time = nowTime.format(now);
//        fno = 180400202;
//        num = 1;
////        type = 1;
//        finalno= 0; 
//        releasetime = time;
//        starttime = time;
//        endtime = time;
//        content = time;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.////////////////////////////////////////////////////////////
                append("INSERT INTO all_come(FirstNO,Number,State,Type,LastTime,StartTime,EndTime,Content,IdNumber) VALUES(?,?,?,?,?,?,?,?,?)");

            //设置数据库的字段值
            try {
                preparedStatement = connection.prepareStatement(sqlStatement.toString());
                preparedStatement.setInt(1, fno);
                preparedStatement.setInt(2, num);
//                preparedStatement.setInt(3, finalno);
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, type);
                preparedStatement.setString(5, releasetime);
                preparedStatement.setString(6, starttime);
                preparedStatement.setString(7, endtime);
                preparedStatement.setString(8, content);
                Calendar c=Calendar.getInstance();////////////////////////////////////////////////////////////////
                preparedStatement.setString(9, String.valueOf(c.getTimeInMillis()));////////////////////////////////
                int colnum = preparedStatement.executeUpdate();
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
}
