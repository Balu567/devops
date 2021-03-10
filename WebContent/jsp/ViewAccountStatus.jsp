<%
if(session.getAttribute("login")!="valid"){
	response.sendRedirect("../login.jsp");
}
%>
<%@ page import="com.bean.AccountStatus"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.nav{
width:100%;
background:white;
height:70px;
margin-top:82px;
opacity:0.7;
}
ul{
list-style:none;
padding:0;
margin:0;
postion:absolute;
}
li{
float:left;
margin-top:30px;
}
a{
width:170px;
color:black;
display:block;
text-decoration:none;
font-size:17px;
padding-top:1px;
text-align:center;
border-radius:10px;
font-weight:bold;
}
a:hover {
background:grey;
transition:0.6s;
}
#example1 {

    background: url(img/f2.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    height:100%;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 80%;
	}

td,th 
{
    border: 1px solid #000c18;
    text-align: center;
    padding: 8px;
}
tr:nth-child(even)
	 {
    background-color: #dddddd;
	}
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
    padding: 8px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
<%ArrayList<AccountStatus> as=(ArrayList<AccountStatus>)request.getAttribute("as"); %>
<body>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<div  id="example1" style="height:100%;width:100%;border: 0px solid #000">


<div class="head">
<h1 class="texthead" align="center" color="black">Bank Retail Management</h1>
<td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td>
<td><a href="<%=request.getContextPath()%>/BankServlet?action=logout" class="button button4">Log Out</a></td></tr></table>
 

</div>
<br><br>
<div class="nav">
<ul>
<li><a href="createcustomer.jsp">Create Customer</a></li>
<li><a href="updateCustomer.jsp">Update Customer</a></li>
<li><a href="deletecustomer.jsp">Delete Customer</a></li>
<li><a href="<%=request.getContextPath() %>/BankServlet?action=ViewCustomer">View Customer List</a></li>
<li><a href="createaccount.jsp">Create Account</a></li>
<li><a href="deleteaccount.jsp">Delete Account</a></li>
<li><a href="<%=request.getContextPath() %>/BankServlet?action=ViewAccount">View Account Status</a></li>
</ul>
</div><br>
<br>
<h2 align="center"><font color="green">Account Status</font></h2>
<table align="center" border='1'>
<tr><th >Customer_ID</th>
	<th>Account_ID</th>
	<th>Account_type</th>
	<th>Status</th>
	<th>Message</th>
	<th>Last_Updated</th>
	<th>Action</th>
</tr>
<%for(AccountStatus i:as){%>
<tr><td><%=i.getCustomer_id()%></td>
	<td><%=i.getAccount_id() %></td>
	<td><%=i.getAccount_type()%></td>
	<td><%=i.getStatus()%></td>
	<td><%=i.getMessage()%></td>
	<td><%=i.getLast_updated()%></td>
	<td><input type="submit" name="action" value="RefreshAccount"/></td></tr>
<%}%>
</table>
<br>
<center><a href="<%=request.getContextPath() %>/1.jsp"><b>Back to Main Page</b></a></center>
<br>
<br><br><br><br>
<%@include file="footer.jsp" %>
</div>
</form>
</body>
</html>