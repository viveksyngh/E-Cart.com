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
public class cartServ extends HttpServlet {
   
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
        String uid=(String)hs.getAttribute("name");
        out.println(uid);
        String pid=request.getParameter("pid");
        session.setAttribute("p",pid);
        out.println(pid);
        String num=request.getParameter("quantity");
        int nums=Integer.parseInt(num);
        out.println(nums);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");
            if(con==null)
            {
                out.println("<h1>Connection not created!!<h1>");
            }
            else 
            
            {
                out.println("<h1>Connection created!!<h1>");
            
                PreparedStatement ps=con.prepareStatement("INSERT INTO CART VALUES(?,?,?)");
                ps.setString(1,uid);
                ps.setString(2,pid);
                ps.setInt(3,nums);
                int x=ps.executeUpdate();
                if(x==1)
                {
                    out.println("<h1>Product is successfully Added to your Cart!!<h1>");
                    out.println("<form method=\"post\" action=\"viewCartServ \">");
                    out.println("<input type=\"submit\" value=\"View Cart\" /></form>");
                    out.println("<form method=\"post\" action=\"E-cart.jsp\">");
                    out.println("<input type=\"submit\" value=\"Continue Shopping\" />");
                    response.sendRedirect("/viewCartServ");
                }
                }
            }
        
        
    catch (Exception e)
    {
    }
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cartServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartServ at " + request.getContextPath () + "</h1>");
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
