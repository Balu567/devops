<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.bean.Transactions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%ArrayList <Transactions> arr=(ArrayList<Transactions>)request.getAttribute("arr") ;%>

<script>
function function1(){
	window.print();
}


</script>

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
<body>
<div  id="example1" style="height:100%;width:100%;border: 0px solid #000; background-size: cover;" >


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
<br><center>
<table><tr><td>AccountId</td><td>TransactionDate</td><td>Description</td><td>Type</td><td>Amount</td>
<%for (Transactions t:arr){ %>
	<tr><td><%=t.getAccountid() %></td>
	<td><%=t.getTransactiondate() %></td>
	<td><%=t.getTransaction_description() %></td>
	<td><%=t.getTransaction_type() %></td>
	<td><%=t.getAmount() %></td></tr>
<%} %>
</table>
<br>
<br>
<button onclick="function1()">Print</button>
</center>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>

</body>
</html>