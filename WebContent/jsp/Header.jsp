<%
if(session.getAttribute("login")!="valid"){
	response.sendRedirect("../login.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.head{
align:center;
    position: absolute;
    top: 0;
    background: rgba(0, 0, 0, 0.4); /* Black background with transparency */
    color: #f1f1f1;
    width: 100%;
    
    font-family: 'Lato', sans-serif;
	font-family: 'Source Sans Pro', sans-serif;
	font-family: 'Muli', sans-serif;
}
.button {
	float:right;
	background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 18px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button4 {background-color: #e7e7e7; color: black;border-radius: 12px;} 
</style>
<body>
<div class="head">

<table><tr ><td>&emsp;&emsp;&emsp;</td><td align="center"> <p align="center" style="font-size:2em"><font color="white">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;BANK MANAGEMENT</font><p></td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td>

<td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td>
<td><a href="<%=request.getContextPath()%>/BankServlet?action=logout" class="button button4">Log Out</a></td></tr></table>
</div>


</body>
</html>