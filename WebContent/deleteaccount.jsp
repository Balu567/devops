<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script>
function function1() {
	var cid;
	cid = document.getElementById("cid").value;
	if (cid.length != 9 || cid.isNaN ||cid=="") {
		 document.getElementById("cid").value="";
		 document.getElementById("cid").required=true;
		alert("Enter 9 digit Customer ID");
		
	}

}
</script>
<body>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<div  id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<%@include file="jsp/Header.jsp" %>
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
<%if(request.getAttribute("message")!=null){ %>
	<p align="center" style="color:red"><b>
	<%=request.getAttribute("message") %>
	</b>
	</p>
<%} %>
<br><br><br>
<center><b>CustomerId&nbsp;&nbsp;&nbsp;</b><input type="text"name="id" id="cid" placeholder="9 digit Customer" required="required" onchange="function1()"></center><br>
<center><button name="action" value="ConfirmDelete"><b>ConfirmDelete</b></button></center>
<br><br>
<center><a href="<%=request.getContextPath() %>/1.jsp"><b>Back to Main Page</b></a></center>

</div>

</form>
<br><br>
<%@include file="jsp/footer.jsp" %>
</body>
</html>