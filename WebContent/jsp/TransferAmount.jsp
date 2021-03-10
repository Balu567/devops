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
table {
    font-family:arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
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
    position: fixed;
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
	top:20px;
	background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 8px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-top: 1px;
    cursor: pointer;
}
</style>
<script type="text/javascript">
	function function1(){
		var empid;
	empid=document.getElementById("targetAccountId").value;
		if(empid.length!=9 || empid.isNaN){
		alert("Enter 9 digit Account ID");
		}
		
	}
	function function2(){
		var amount;
		amount=document.getElementById("transferAmount").value;
		if(amount.isNaN ||amount<=0){
			
			alert("Amount should be digits");
			
		}
	}
	function function3(){
		var amount;
		var empid;
		empid=document.getElementById("targetAccountId").value;
		amount=document.getElementById("transferAmount").value;
		if(empid.length!=9 || empid.isNaN){
			alert("Enter 9 digit EmployeeId");
			return false;
		}
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
		
</script>
<%long sourceaccountId=(long)request.getAttribute("sourceAccountId");%>
<%String message=(String)request.getAttribute("message");%>
<body>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">

<div  align="center" id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<div class="head">
<h1 class="texthead" align="center" color="black">Bank Retail Management</h1>
<td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td><td>&emsp;&emsp;&emsp;</td>
<td><a href="<%=request.getContextPath()%>/BankServlet?action=logout" class="button button4">Log Out</a></td></tr></table>
 

</div>
<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>
<h2 align="center">Transfer Amount</h2>
<%if(message!=null){ %>
<p style="color:red;align:center"><%=message %></p>
<%} %>
Source AccountID &nbsp;&nbsp;<input type="text" name="sourceAccountId"  id="sourceAccountId" value="<%=sourceaccountId%>" readonly>
<br><br>
Target AccountID &nbsp;&nbsp;<input type="text" name="targetAccountId" placeholder="Enter a 9 digit target id"  id="targetAccountId" required="required" onchange="function1()"/>
<br><br>
Transfer Amount &nbsp;&nbsp;&nbsp;<input type="text" name="transferAmount" id="transferAmount" placeholder="enter amount" required="required" onchange="function2()"/>
<br><br>
<button class="btn" type="submit" name="action" value="TransferAmount" onclick="return function3();">Transfer</button>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div></form>
</body>
</html>