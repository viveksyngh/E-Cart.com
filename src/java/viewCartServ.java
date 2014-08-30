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
public class viewCartServ extends HttpServlet {
   
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
        String uid=(String)hs.getAttribute("name");
        HttpSession session=request.getSession(true);
        out.println("<h6 align=center >"+uid+"</h6>");
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
            if(con==null)
            {
                out.println("<h1>Connection not created!!<h1>");
            }
            else 
            
            {
                 PreparedStatement ps=con.prepareStatement("select * FROM PRODUCT,CART WHERE CART.PRODUCTID=PRODUCT.PRODUCTID AND CART.USERID=? ");
                ps.setString(1, uid);
                ResultSet rs=ps.executeQuery();
               
                 out.println("<h1 align=center >YOUR CART</h1>");
                    out.println("<body background=\"backgrnd.jpg\" >");
                    out.println("<table border=1 align=center bgcolor=#C8C8C8 >");
                    out.println("<tr>");
                    
                    out.println("<td>PRODUCT ID</td>");
                    out.println("<td>PRODUCT NAME</td>");
                    out.println("<td>PRICE</td>");
                    out.println("<td>QUATITTY</td>");
                    out.println("<td>MANUFACTURER</td>");
                    out.println("<td></td>");
                    out.println("</tr>");
                    
                
               
                while(rs.next())
                {
                    String Pid=rs.getString("PRODUCTID");
                    String Pn=rs.getString("PRODNAME");
                    String pr=rs.getString("PRICE");
                    int prs=Integer.parseInt(pr);
                    String mf=rs.getString("MANUFACT");
                    String q=rs.getString("NUM_PRO");
                    
                   
                    out.println("<tr>");
                    out.println("<td>"+Pid + "<form method=post action=remove ><input type=hidden value="+Pid+" name=si /></td>");
                    out.println("<td>"+Pn+"</td>");
                    out.println("<td>"+prs+"</td>");
                    out.println("<td>"+q+"</td>");
                    out.println("<td>"+mf+"</td>");
                    out.println("<td><input type=submit value=remove /></form></td>");
                    out.println("</tr>");
                                   }
                out.println("");
                out.println("<br>");
            
            
         /* }
            
            catch (Exception e)
            {
                
            }
        try */
        
        //Class.forName("oracle.jdbc.driver.OracleDriver");
           // Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
           // if(con==null)
            /*{
                out.println("<h1>Connection not created!!<h1>");
            }
            else
            { */
                 PreparedStatement ps1=con.prepareStatement("select sum(NUM_PRO * PRICE) as AMOUNT from total_price where USERID=? ");
                 ps1.setString(1, uid);
                 ResultSet rs1=ps1.executeQuery();
                 while(rs1.next())
                 {
                     String amt=rs1.getString("AMOUNT");
                     int amt1= Integer.parseInt(amt);
                     out.println("YOUR TOTAL AMOUNT IS Rs"+ amt1);
                     out.println("<br><br>");
                     out.println("<br><br><form method=post action=checkout.jsp ><input type=submit value=Checkout /></form><br><br> ");
                     out.println("<form method=post action=update > <input type=submit value=Update Cart /></form>");
                 }
                
            }
            
        
         }
        catch(Exception e)
        {
            
        }
        try {
           out.println("<title>VIEW CART</title>");  
            
            
            out.println("<br><br><a href=\"E-cart.jsp\">CONTINUE SHOPING</a><br>");
            out.println("</body>");
           
            
         
         
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
