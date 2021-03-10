<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#example1 {

    background: url(img/f2.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    height:100%;
}
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
</style>

<script type="text/javascript">
function function3() {
	var age;
	age = document.getElementById("age").value;
	if (age < 18 || age.isNaN || age > 110) {
		 document.getElementById("age").value="";
		 document.getElementById("age").required=true;
		alert("Enter valid age!");
	}
}

	function function2() {
		var custname;
		custname = document.getElementById("custname").value;
		var Exp = /^[A-Za-z]+$/;
		if (!(custname.match(Exp))) {
			 document.getElementById("custname").value="";
			 document.getElementById("custname").required=true;
			alert("Enter valid name");
			
		}
		}
			
		function function4() {
			var address1;
			var Exp = /^[0-9a-z]/;
			
			address1 = document.getElementById("address1").value;
			if(!address1.match(Exp)){
				document.getElementById("address1").value="";
				 document.getElementById("address1").required=true;
				alert("Enter valid address");

			}
		}
	</script>
<%Customer customer=(Customer)request.getAttribute("customerDetails"); %>
<%String message=(String)request.getAttribute("message");%>

<body>
<div align="center" id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<%@include file="Header.jsp" %>
<br>
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
<%if(message=="Customer Updatation failed"){ %>

<p style="color:red;align:center"><%=message %></p>
<%} %>
<%if(message=="Customer Update initiated successfully"){ %>

<h3 align="center"><font color="green"><%=message %></font></h3>
<%} %>
<br>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<div align="center">
&nbsp;&nbsp;&nbsp;&nbsp;<b>SSN ID </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ssnId" id="ssnId" value="<%=customer.getSsn()%>"readonly>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<b>CustomerID</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="customerId" id="customerId" value="<%=customer.getCustomerid()%>"readonly>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<b>Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="custname" value="<%=customer.getName()%>" onchange="function2()" >
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<b>Address</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" id="address1" value="<%=customer.getAddress()%>"onchange="function4()">
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<b>Age</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="age" id="age" value="<%=customer.getAge()%>"  onchange="function3()">
<br><br>

<button  class="btn" id="submit" name="action" value="updateCustomer">Update/Edit</button><br><br>
<br><br>
<center><a href="<%=request.getContextPath() %>/1.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>
</form>
</div>
</body>
</html>