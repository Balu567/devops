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
		var amount;
		amount=document.getElementById("amount").value;
		if(isNaN(amount)){
			//window.location = "deposit.jsp";
			alert("Amount should be digits");
			return false;
		}
		else if(amount<=0)
			{
			
			alert("Amount should be greater than 0");
			return false;
			}
		return true;
		
	}
	function function1(){
		var amount;
		amount=document.getElementById("amount").value;
		if(amount.isNaN ||amount<=0){
			
			alert("Amount should be digits");
			
		}
	}
	</script>
	<%long custid=(Long)request.getAttribute("cid");%>
<%long accid=(Long)request.getAttribute("accid");%>
<body>
<br>
<div  id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<br>
<%@include file="Header.jsp" %>
<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>

<center>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<b>Customer_id</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  name="id" value="<%=custid%>" readonly>
<br>
<center><b>AccountId</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  name="accid" value="<%=accid %>"readonly></center>
<br>
<center><b>DepositAmount</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="amount" id="amount" placeholder="enter amount" required="required" onchange="function1()">
<br><br>
<button class="btn" type="submit" name="action" value="depositAmmount" onclick="return myFunction();"><b>Deposit</b></button></center>
<br><br><br>
</form>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</center>
</div>
</body>
</html>