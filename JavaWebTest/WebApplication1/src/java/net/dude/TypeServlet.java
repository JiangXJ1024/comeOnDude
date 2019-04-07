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
public class TypeServlet extends HttpServlet {

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
            out.println("<title>Servlet TypeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TypeServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    public class Type0Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //筛选符合state的显示,按时间先后显示(即存入数据库的先后顺序)
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM all_come WHERE State =? AND Type =?");
        try (PrintWriter out = response.getWriter()) {
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            try {
                preparedStatement = connection.prepareStatement(sqlStatement.toString());
                preparedStatement.setInt(1, 0);
                preparedStatement.setInt(2, Integer.parseInt(request.getParameter("type").trim()));
                resultSet = preparedStatement.executeQuery();
//                Allmessage allmes = new Allmessage();
                int i=0;
                while (resultSet.next()) {
//                    allmes.setFNO(resultSet.getInt("FirstNo"));
//                    allmes.setNum(resultSet.getInt("Number"));
//                    allmes.setFinalno(resultSet.getInt("FinalNo"));
//                    allmes.setType(resultSet.getInt("Type"));
//                    allmes.setReleasetime(resultSet.getString("LastTime"));
//                    allmes.setContent(resultSet.getString("Content"));
//                    allmes.setStarttime(resultSet.getString("StartTime"));
//                    allmes.setEndtime(resultSet.getString("EndTime"));
                    params.put("Result", "success");
                    params.put("FirstNo",String.valueOf(resultSet.getInt("FirstNo")));
                    params.put("Number",String.valueOf(resultSet.getInt("Number")));
                    params.put("FinalNo",String.valueOf(resultSet.getInt("FinalNo")));
                    params.put("Type",String.valueOf(resultSet.getInt("Type")));
                    params.put("Releasetime",resultSet.getString("LastTime"));
                    params.put("Content",resultSet.getString("Content"));
                    params.put("Starttime",resultSet.getString("StartTime"));
                    params.put("Endtime",resultSet.getString("EndTime"));
                    params.put("IdNumber",resultSet.getString("IdNumber"));////////////////////////////////////////
                    i++;
                    //params.put("类型","123");
                    jsonObject.put("params"+String.valueOf(i), params);
                    
                } 
                i++;
                params.put("Result", "failure");
                jsonObject.put("params"+String.valueOf(i), params);
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
