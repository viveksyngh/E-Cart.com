/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author EUSER
 */
public class UpdtServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rl=request.getParameter("t1");
        String mk=request.getParameter("t2");
        double mks=Double.parseDouble(mk);
  
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","iamvivek");
        if(con==null)
        {
            out.println("<H1>Unable to create connection!</H1>");
        }
        else
        {
            out.println("<H1>connection created!</H1>");
        PreparedStatement ps=con.prepareStatement("UPDATE STUDENT SET MARKS=? WHERE ROLL=?");
        ps.setDouble(1,mks);
        ps.setString(2,rl);
        int x=ps.executeUpdate();
        if(x==1)
        {
            out.println("<H1>1 record updated!</H1>");
        }
        else
        {
            out.println("<H1>No record updated!</H1>");
        }
        }
        }catch(Exception e){}
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdtServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdtServ at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
