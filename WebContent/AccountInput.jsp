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
<script type="text/javascript">
	function myFunction(){
		var empid,accid;
		
		empid=document.getElementById("uid").value;
		accid=document.getElementById("accid").value;
		if(empid.isNaN || accid.isNaN ||(empid.length!=9 && accid.length!=9||accid==""||empid=="")){
			alert("Enter valid credentials or leave unknown blank with value 0");
			return false;
		}
		else if(!empid.isNaN && !accid.isNaN && (empid.length!=9 ||accid.length!=9)){
			return true;
		}
		
	}
	function function1(){
		
		var acc;
		acc=document.getElementById("accid").value;
		if(accid=="")
			{
			alert("Either fill the box with 0 or valid account id");
			}
	}
	</script>
<%String message=(String)request.getAttribute("message");%>
<body>
<div  id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<br>
<%@include file="jsp/Header.jsp" %>

<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>
<%if(message!=null){ %>
<center><p style="color:red;align:center"><%=message %></p></center>
<%} %>
<center><h3>Enter the Customer/SSN ID</h3></center>
<form action="<%=request.getContextPath()%>/BankServlet" >
<center><input type="text" name="uid" id="uid" value="<%=0%>"></center>
<center><h3>Enter AccountId</h3></center>
<center><input type="text" name="accid" id="accid" onchange="function1()" value="<%=0%>"></center>
<br>
<center><button class="btn" type="submit" name="action" value="Submit_Account" onclick="return myFunction()">Submit</button></center>
</form><br><br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="jsp/footer.jsp" %>
</div>
</body>
</html>