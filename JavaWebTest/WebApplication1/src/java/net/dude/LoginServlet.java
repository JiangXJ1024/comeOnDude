/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
//

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        // 设置响应内容类型  
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {

            //获得请求中传来的用户名和密码
            String accountNumber = request.getParameter("AccountNumber").trim();
            String password = request.getParameter("Password").trim();

            //密码验证结果
            //查询用户
            User result = UserDAO.queryUser(accountNumber);
            //账户密码验证
            Boolean verifyResult=(null != result && password.equals(result.getPassword())) ;

            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            

            if (verifyResult) {
                params.put("Result", "success");
                params.put("Sex", result.getSex());
                params.put("Nation", result.getNation());
                params.put("Grade", result.getGrade());
                params.put("Major", result.getMajor());
                params.put("College", result.getCollege());
                params.put("Name", result.getName());
                params.put("Information", result.getInformation());
                params.put("Photo", String.valueOf(result.getPhoto()));
                params.put("NoShow", result.getNoShow());
                params.put("UserName", result.getUserName());
            } else {
                params.put("Result", "failed");
            }
//            int state = result.getState();
//            params.put("Result", String.valueOf(state));
//            if(state == 0)
//            {
//                params.put("Sex", result.getSex());
//                params.put("Nation", result.getNation());
//                params.put("Grade", result.getGrade());
//                params.put("Major", result.getMajor());
//            }
            jsonObject.put("params2", params);

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
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

    /**
     * 验证用户名密码是否正确
     *
     * @param userName
     * @param password
     */
    private Boolean verifyLogin(String userNumber, String password) {
        //查询用户
        User user = UserDAO.queryUser(userNumber);
        //账户密码验证
        return null != user && password.equals(user.getPassword());
    }
}