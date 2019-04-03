/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class SaveMessageServlet extends HttpServlet {

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
            out.println("<title>Servlet SaveMessageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveMessageServlet at " + request.getContextPath() + "</h1>");
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

            //获得请求中传来的信息
            int fno = Integer.parseInt(request.getParameter("FNO").trim());
            int num = Integer.parseInt(request.getParameter("Number").trim());
            int type = Integer.parseInt(request.getParameter("Type").trim());
            String  releasetime = request.getParameter("ReleaseTime").trim();
            String  starttime = request.getParameter("StartTime").trim();
            String  endtime = request.getParameter("EndTime").trim();
            String content = request.getParameter("Content").trim();
            SimpleDateFormat nowTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//            long now=System.currentTimeMillis();
//            String time = nowTime.format(now);
//            int fno = 180400202;
//            int num = 1;
//            int type = 1;
//            String releasetime = time;
//            String starttime = time;
//            String endtime = time;
//            String content = time;

            //信息存储结果反馈
            Boolean verifyResult = UserDAO.ReleaseMessage(fno,num,type,releasetime,starttime,endtime,content);

            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if (verifyResult) {
                params.put("Result", "发布成功");
            } else {
                params.put("Result", "发布失败");
            }

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

}
