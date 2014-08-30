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
public class LoginServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nm=request.getParameter("t1");
        String pwd=request.getParameter("t2");
        out.println(nm+pwd);
        RequestDispatcher rd=null;
        ServletContext sc=getServletContext();
        HttpSession hs=request.getSession(true);
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
        if(con==null)
        {
            out.println("<H1>Unable to create connection!</H1>");
        }
        else
        {
        out.println("<H1>connection created!</H1>");
        sc.setAttribute("connect", con);
        
        PreparedStatement ps=con.prepareStatement("select * from USER_INFO where USER_ID=? and PASSWORD=?");
        ps.setString(1,nm);
        ps.setString(2,pwd);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
           response.sendRedirect("E-cart.jsp");
            //rd=sc.getNamedDispatcher("/HelloServ");
            hs.setAttribute("name", nm);
            request.setAttribute("password", pwd);
            out.println("<H1> ");
             out.println ("<a href=E-dukan.html >"); 
              out.println(" </a>" +nm+" your password is "+pwd+"</H1>");
        }
        else
        {
           // response.sendRedirect("login.html");
            rd=request.getRequestDispatcher("loginerror.html");
            
            //out.println("<H1>You are an invalid user!</H1>");
        }
        rd.forward(request, response);
        }
        }catch(Exception e){}
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServ at " + request.getContextPath () + "</h1>");
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
