

<%-- 
    Document   : productdetail
    Created on : 9 Jul, 2012, 9:43:03 PM
    Author     : Saikat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCT DETAILS</title>
    </head>
    <body>
       <%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>


    
        <TITLE>Product Details</TITLE>
    

            

<H1 align="center" ><b>Product Details</b></H1>
        


       

        <% Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vivek","iamvivek");

            Statement statement = connection.createStatement(); %>

            <%!String id = request.getParameter("id"); %>  

            <% ResultSet resultset = 
                statement.executeQuery("select * from product where productid='" + id + "'") ; 

            if(!resultset.next()) {
                out.println("Sorry, could not find that publisher. " +
                "Please <A HREF='tryAgain.html'>try again</A>.");
            } else {
			String a;
                
        %>
 
			<img src="id.jpg" width="500" height="500"><br>
			
           <font color="blue">Product Name :<%= resultset.getString(1); %><br>
				Price :<%= resultset.getString(2) %><br>
               Manufacturer :<%= resultset.getString(3) %><br>
               Description :<%= resultset.getString(4) %><br>
               Discount : <%= resultset.getString(5) %><br>
			   Model no : <%= result.getString(6) %><br>
		   
       <br>
       <% 
           } 
       %>
       
    </body>
</html>
