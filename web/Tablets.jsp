<%-- 
    Document   : Tablets
    Created on : 11 Jul, 2012, 4:51:53 AM
    Author     : Vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
    <% HttpSession hs=request.getSession(true);
    String nm=(String)hs.getAttribute("name");
    
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
    height: 1300px;
    width: 850px;
    float: left;
    background: #FFFACD;
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
        <% out.println(nm);%>
	
         <a href="E-dukan.html" target="_self"><img src="ecart.jpg" align="left"/></a>
        <div id="header">
           
			<div id="widgetBar">
			  <div class="headerWidget">
                            <% if(nm==null){ 
                               response.sendRedirect("login1.html");%><% } else {%><a href="logout.jsp" target="_self">Logout</a><% } %>
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

		<div id="welcomeText">
				<p>&nbsp;</p>
				<p>[Welcome to E-Cart] </p>
			</div>
		
		<div id="RightColumn">
                       <form method="post" action="cartServ">
      <table align="center" bgcolor="#FFFACD" ><b>
          
          <tr>
          <td><img src="ipad.jpg" height="200" width="200"></td>
          <td>IPAD 2</td>
          <td>Rs 46000</td>
          <form method="post" action="cartServ">
          <td>
         <input type="number" name="quantity" min="1" max="10" /></td>
          <td><input type="submit" value="add to cart" /><input type="hidden" name="pid" value="tb0001"/> </td>
          </form>
      </tr>
      <tr>
          <td><img src="surface.jpg" width="200" height="200"></img> </td>
          <td>MICROSOFT SURFACE</td>
          <td>Rs 36000</td>
           <form method="post" action="cartServ">
          <td>
          <input type="number" name="quantity" min="1" max="10" /><input type="hidden" name="pid" value="tb0002"/></td>
          <td><input type="submit" value="add to cart" /> </td>
      </form>
      </tr>
      <tr>
          <td><img src="gtab.jpg" width="200" height="200"></img> </td>
          <td>GALAXY TAB</td>
          <td>Rs 35000</td>
          <form method="post" action="cartServ">
          <td>
          <input type="number" name="quantity" min="1" max="10" /><input type="hidden" name="pid" value="tb0003"/></td>
          <td><input type="submit" value="add to cart" /> </td>
      </form>
      </tr>
      <tr>
          <td><img src="xoom.jpg" width="200" height="200"></img> </td>
          <td>MOTOROLA XOOM</td>
          <td>Rs 30000</td>
          <form method="post" action="cartServ">
          <td>
          <input type="number" name="quantity" min="1" max="10" /><input type="hidden" name="pid" value="tb0004"/></td>
          <td><input type="submit" value="add to cart" /> </td>
      </form>
      </tr>
      <tr>
          <td><img src="playbook.jpg" width="200" height="200"></img> </td>
          <td>BLACBERRY PLAYBOOK</td>
          <td>Rs 12000</td>
           <form method="post" action="cartServ">
          <td>
          <input type="number" name="quantity" min="1" max="10" /><input type="hidden" name="pid" value="tb0005"/></td>
          <td><input type="submit" value="add to cart" /> </td>
      </form>
      </tr>
      <tr>
          <td><img src="note.jpg" width="200" height="200"></img> </td>
          <td>SAMSUNG GALAXY NOTE</td>
          <td>Rs 38000</td>
           <form method="post" action="cartServ">
          <td>
          <input type="number" name="quantity" min="1" max="10" /><input type="hidden" name="pid" value="tb0006"/></td>
          <td><input type="submit" value="add to cart" /> </td>
      </form>
      </tr>
  </b>
      </table>
                     
			
		</div>
		

		<div id="footer">
			<p id="footerText">Copyright © E-Dukan.com / All Rights Reserved <a href="contact.jsp" >   CONTACT US</a></p>
		</div>



		</div>
  
    
   
    </body>
</html>
