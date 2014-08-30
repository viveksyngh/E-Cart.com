<%-- 
    Document   : E-cart
    Created on : 11 Jul, 2012, 4:13:32 AM
    Author     : Vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ page import="java.sql.*" %>
   <% HttpSession hs=request.getSession(true);
    String nm=(String)hs.getAttribute("name");
    if(nm==null)
        out.println("WELCOME GUEST ... PLEASE LOGIN TO CONTINUE SHOPPING");
    else
    {
        out.println("WELCOME " +nm); 
        
    }
    
    
      %>
      
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
        body {
    font-family: Arial, Helvetica, sans-serif;
    width: 1000px;
    text-align: center;
    margin: 20px auto;
}

#main { background: #FFFACD}

#header {
    height: 300px;
    
background-image:url(header_banner_design.jpg)
}

#logo {
    height: 155px;
    width: 155px;
    float: left;
    margin-left: 30px;
    margin-top: 20px;
}

#widgetBar {
    height: 40px;
    width: 1000px;
    float: right;
    
}

.headerWidget {
    width: 94px;
    margin: 15px 2px;
    font-size: small;
    float: right;
    line-height: 25px;
    background: #00FFFF;
}

#footer {
    height: 30px;
    /*width: 350px;*/
    clear: left;
    background: #eee;
}

#LeftColumn {
    height: 350px;
    width: 150px;
    float: left;
    background: #FFFFFF;
}

#RightColumn {
    height: 1000px;
    width: 850px;
    float: left;
   background-image:url(main1.jpg);
}

.categoryBox {
    height: 50px;
    width: 100px;
    margin: 21px 10px 6px;
    float: inherit;
    background: #FFFFFF;
}

.categoryLabelText {
    line-height: 150%;
    font-size: x-large;
}

#welcomeText {

	text-align: center;
	text-color: #20B2AA
}
    </style>
    <title>E-Dukan</title>
</head>



<body>
    <div>
        
	
         <a href="E-cart.jsp" target="_self"><img src="ecart.jpg" align="left"/></a>
        <div id="header">
           
			<div id="widgetBar">
			  <div class="headerWidget">
                               <% if(nm==null){ %>
                               <a href="login1.html" target="_self"> Login</a><% } else {%><a href="logout.jsp" target="_self">Logout</a><% } %>
			</div>

			<div class="headerWidget">
                             
                             <% if(nm==null){ %> 
                             <a href="registr.html" target="_parent">SIGN UP</a><% } else  {%><form methhod=post action=viewCartServ ><input type=image src=cart.jpg height=25 width=70></form> <% } %>
			</div>	

		  </div>
			<img src="shopping cart header.jpg" width="1000" height="208" >
		</div>
	
	
	<div id="LeftColumn">
			<div class="categoryBox">
				<a href="Laptops.jsp" style="text-decoration:none";>
				<span  class="categoryLabelText" >Laptop</span>
				</a>
		
                 
                 
			</div>
			<div class="categoryBox">
				<a href="Mobiles.jsp" style="text-decoration:none";>
				<span class="categoryLabelText" >Mobile</span>
				</a>
			</div>
			<div class="categoryBox">
				<a href="Camera.jsp" style="text-decoration:none";>
				<span class="categoryLabelText">Camera</span>
				</a>
			</div>
			<div class="categoryBox">
				<a href="Tablets.jsp" style="text-decoration:none";>
				<span class="categoryLabelText">Tablets</span>
				</a>
			</div>
		</div>

		
		
		<div id="RightColumn">
                     
			<div id="welcomeText">
				<p>&nbsp;</p>
				<p>[Welcome to E-Cart] </p>
			</div>
		</div>
		

		<div id="footer">
                     <p id="footerText">Copyright © E-Dukan.com / All Rights Reserved <a href="contact.jsp" >   CONTACT US</a></p>
		</div>



		</div>
    
   
</html>
