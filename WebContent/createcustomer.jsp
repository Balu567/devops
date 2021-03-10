<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Executive options</title>
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
function function1(){
	var ssnid;
	var Exp = /^[0-9a-zA-Z]/;
	ssnid=document.getElementById("ssnid").value;
	if(ssnid.length!=9 || !ssnid.match(Exp) ||ssnid==""){
		document.getElementById("ssnid").value="";
		 document.getElementById("ssnid").required=true;
	alert("Enter 9 digit EmployeeId");
	
	}
	
}
	function function3() {
		var age;
		age = document.getElementById("age").value;
		if (age < 18 || age >120 || age.isNaN) {
			 document.getElementById("age").value="";
			 document.getElementById("age").required=true;
			alert("Enter valid age!");

		}

	}
	function function2() {
		var custname;
		custname = document.getElementById("custname").value;
		if (!/^[a-zA-Z_ ]/.test(custname)) {
			 document.getElementById("custname").value="";
			 document.getElementById("custname").required=true;
			alert("Enter valid name");

		}

	}
	function function4() {
		var address1;
		var Exp = /^[0-9a-zA-Z]/;
		
		address1 = document.getElementById("address1").value;
		if(!address1.match(Exp)){
			 document.getElementById("address1").value="";
			 document.getElementById("address1").required=true;
			alert("Enter valid address");

		}

	}
	function function5() {
		var city;
		city = document.getElementById("city").value;
		if (!/^[a-zA-Z]/.test(city)) {
			 document.getElementById("city").value="";
			 document.getElementById("city").required=true;
			alert("Enter valid city");

		}

	}
	function function6() {
		var state;
		state = document.getElementById("state").value;
		if (!/^[a-zA-Z]/.test(state)) {
			 document.getElementById("state").value="";
			 document.getElementById("state").required=true;
			alert("Enter valid state");

		}

	}

	
</script>
<body>
<div  align="center" id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<br>
<%@include file="jsp/Header.jsp" %>
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

	<form action="<%=request.getContextPath()%>/BankServlet" method="post">
		<%
		if (request.getAttribute("message") != null) {
	%>
	<p align="center" style="color:red">
	<%=request.getAttribute("message")%>
	</p>
	<%
		}
	%>
		Customer SSN ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="ssnid" id="ssnid" required="required"  placeholder="9 digit ssn id" onchange="function1()"/> 
		<br><br>
		Customer Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="custname" id="custname"required="required"  placeholder="enter customer name" onchange="function2()">
		<br><br>
		Age&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="age" required="required"  placeholder=" age between 18-120" id="age" onchange="function3()">
		<br><br>
		Address Line1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addressline1" id="address1" required="required"  placeholder="address1" onchange="function4()">
		<br><br>		
		Address Line2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addressline2" id="address1" required="required"  placeholder="address2" onchange="function4()">
	    <br><br>		
		City&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" required="required"  placeholder="city" name="city" id="city" onchange="function5()">
		<br><br>		
		State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" required="required"  placeholder="state" name="state" id="state" onchange="function6()">
	     <br> <br>
		
		<button onclick="return myFunction()" id="submit" name="action" value="createcustomer">Submit</button>
	</form>
	<br><br>
<center><a href="<%=request.getContextPath() %>/1.jsp"><b>Back to Main Page</b></a></center>
<%@include file="jsp/footer.jsp" %>
</div>
</body>
</html>