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
public class Prodcut extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
            if(!(con==null))
            {
                out.println("<H1>Connection Created!!</H1>");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("Select * from PRODUCT");
                out.println("After Query:");
                while(rs.next())
                {
                    String Pid=rs.getString("PRODUCTID");
                    String cat=rs.getString("CATEGORY");
                    String pn=rs.getString("PRODNAME");
                    int pc=rs.getInt("PRICE");
                    String mf=rs.getString("MANUFACT");
                    String des=rs.getString("DESCRP");
                    
                    out.println("ProductID" + Pid +"\n");
                    out.println("Category" + cat);
                    out.println("Productname" + pn);
                    out.println("Price" + pc);
                    out.println("Manufacture" + mf);
                    out.println("descr" + des);
                }
            }
            else 
            { 
                out.println("Connection not created");
            }
        }
        catch(Exception e)
        {
        }
        
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prodcut</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Prodcut at " + request.getContextPath () + "</h1>");
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
