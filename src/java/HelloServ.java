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
 * @author EUSER
 */
public class HelloServ extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<H1>!</H1>");
        ServletContext sc=getServletContext();
        Connection con=(Connection)sc.getAttribute("connect");
        HttpSession hs=request.getSession(true);
        String nm=(String)hs.getAttribute("name");
        String pwd=(String)request.getAttribute("password");
        out.println(nm+pwd);
        out.println("<html>\n");
out.println("<head><title> Page</title></head>\n" +
"<body bgcolor=\"#f0f0f0\">\n");
out.println("<form method=\"post\" action=\"cartServ\">\n");
out.println("<input type=\"submit\" value=\"Add to cart\"/>");
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServ at " + request.getContextPath () + "</h1>");
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
