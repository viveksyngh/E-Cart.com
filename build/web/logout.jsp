<%-- 
    Document   : logout
    Created on : 13 Jul, 2012, 1:05:19 AM
    Author     : Vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*;" %>
<%session.invalidate();%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOG OUT</title>
    </head>
    <body background="thanku.jpg" height=800 width=1200 >
        <h2> YOU HAVE LOG OUT... PLEASE <a href="login1.html" target="self" >CLICK HERE</a> TO LOG IN </h2>
        
    </body>
</html>
