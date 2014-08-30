/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Vivek
 */
public class RegistrationServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out = response.getWriter();
         String fn=request.getParameter("t1");
          String mn=request.getParameter("t2");
           String ln=request.getParameter("t3");
            String ui=request.getParameter("t4");
             String pwd=request.getParameter("t5");
              String pn=request.getParameter("t6");
              double pns=Double.parseDouble(pn);
              String em=request.getParameter("t7");
               String add1=request.getParameter("t8");
                String add2=request.getParameter("t9");
                 String cy=request.getParameter("t10");
                  String st=request.getParameter("t11");
                   String pc=request.getParameter("t12");
                  double pcs=Double.parseDouble(pc);
                  RequestDispatcher rd=null;
                  ServletContext context=getServletContext();
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
        PreparedStatement ps=con.prepareStatement("INSERT INTO USER_INFO VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,fn);
        ps.setString(2,mn);
        ps.setString(3,ln);
         ps.setString(4,ui);
         ps.setString(5,pwd);
          ps.setDouble(6,pns);
           ps.setString(7,em);
            ps.setString(8,add1);
             ps.setString(9,add2);
              ps.setString(10,cy);
               ps.setString(11,st);
                ps.setDouble(12,pcs);
                
       int x=ps.executeUpdate();
        if(x==1)
        {
            out.println("<H3>Sucessfully Registered</H3>");
            out.print("<a href=login1.html target=_self> CLICK HERE TO LOGIN</a>");
            response.sendRedirect("login1.html");
            
        }
        else
        {
            out.println("<H1>No record inserted!</H1>");
        }
        }
        }catch(Exception e){}
                     
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServ at " + request.getContextPath () + "</h1>");
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
