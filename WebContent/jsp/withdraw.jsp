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
	var amount,bal;
	amount=document.getElementById("amount").value;
	bal=document.getElementById("balance").value;
	
	if(amount.isNaN||amount<=0){
		
		alert("Enter value greater than 0");
		
	}
	else if(amount>bal){
		alert("Your balance is "+bal+" .Please enter amount lesser than "+bal);
		
	}
}
</script>
<%long custid=(Long)request.getAttribute("cid");%>
<%long accid=(Long)request.getAttribute("accid");%>
<%double accbalance=(Double)request.getAttribute("accbalance"); %>
<body>
<div align="center" id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<%@include file="Header.jsp" %>

<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>
</ul>
</div>
<br>
<br>
<center>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<input type="hidden" value="<%=accbalance%>" id="balance">
<b>Customer_Id</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  name="id" value="<%=custid%>" readonly><br><br>
<b>Account_id</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  name="accid" value="<%=accid %>" readonly><br><br>
<b>Withdraw_Amount</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="amount" id="amount" placeholder="Between 100 to 50000" required="required"onchange="return function1()"><br><br>
<button class="btn" type="submit" name="action" value="withdrawAmmount" onclick="return function1()"><b>WithDraw</b></button>
<input type="reset">
<br><br><br>
</form>
</center>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>
</body>
</html>