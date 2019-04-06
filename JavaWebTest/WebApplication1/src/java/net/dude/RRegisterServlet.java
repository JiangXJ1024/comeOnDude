/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class RRegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RRegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //筛选符合state的显示,按时间先后显示(即存入数据库的先后顺序)
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement0 = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO user(UserName,Password,Photo,Information,NO,Name,Sex,Nation,Grade,Major,College,NoShow) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

        try (PrintWriter out = response.getWriter()) {
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
//            String No = request.getParameter("NO").trim();
//            if(No.equals("保密")){
//                
//            }
            int no = Integer.parseInt(request.getParameter("NO").trim());
            int photo = Integer.parseInt(request.getParameter("Photo").trim());
            String userName = request.getParameter("UserName").trim();
            String password = request.getParameter("Password").trim();
            String sex = request.getParameter("Sex").trim();
            String name = request.getParameter("Name").trim();
            String nation = request.getParameter("Nation").trim();
            String grade = request.getParameter("Grade").trim();
            String major = request.getParameter("Major").trim();
            String college = request.getParameter("College").trim();
            String information = request.getParameter("Information").trim();
            String noShow = request.getParameter("NOSHOW").trim();
            
//            int no = 180400204;
//            int photo = 1;
//            String userName = "嘿嘿";
//            String password = "Password";
//            String sex = "Sex";
//            String name = "Name";
//            String nation ="Nation";
//            String grade = "Grade";
//            String major = "Major";
//            String college = "College";
//            String information = "Information";
            
            try {
                preparedStatement = connection.prepareStatement(sqlStatement.toString());
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                preparedStatement.setInt(3, photo);
                preparedStatement.setString(4, information);
                preparedStatement.setInt(5, no);
                preparedStatement.setString(6, name);
                preparedStatement.setString(7, sex);
                preparedStatement.setString(8, nation);
                preparedStatement.setString(9, grade);
                preparedStatement.setString(10, major);
                preparedStatement.setString(11, college);
                preparedStatement.setString(12, noShow);
                int colnum = preparedStatement.executeUpdate();
                //更新State
                StringBuilder sqlStatement0 = new StringBuilder();
                sqlStatement0.append("UPDATE allstudent set State = 1 WHERE No=? ");
                preparedStatement0 = connection.prepareStatement(sqlStatement0.toString());
                preparedStatement0.setInt(1, no);
                int colnum0 = preparedStatement0.executeUpdate();
                if(colnum0==1 && colnum==1){
                    params.put("Result", "success");
                }else{
                    params.put("Result", "Fature");
                }
                jsonObject.put("params3", params);
                out.write(jsonObject.toString());
            }catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
