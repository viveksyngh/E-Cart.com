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
public class removeServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs=request.getSession(true);
        HttpSession session = request.getSession(true);
        String s=(String)session.getAttribute("name");
        HttpSession sesh = request.getSession(true);
       String s1=request.getParameter("si");
       String s2=request.getParameter("quan");
       RequestDispatcher rd=null;
       ServletContext sc1=getServletContext();
       int s3=Integer.parseInt(s2);
        out.println(s2);
        out.println(s);
        out.println(s1);
        try {
       /*     Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
            if(con==null)
            {
                out.println("<h1>Connection not created!!<h1>");
            }
            else 
            
            {
                PreparedStatement ps=con.prepareStatement("delete from cart WHERE CART.PRODUCTID=? AND CART.USERID=?");
                ps.setString(1, s1);
                ps.setString(2, s);
                
          int x=ps.executeUpdate();
          if(x==1)
          {
              out.println("Query executed");
          }
                
            response.sendRedirect("/viewCartServ");    
                
            }
            
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateServ at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }catch(Exception e)
        {
            
        }
        finally { 
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