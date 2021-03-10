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

    background: url(../img/f2.jpg);
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
		var accid;
		accid = document.getElementById("accid").value;
		if ( accid.isNaN ||accid.length != 9) {
			document.getElementById("accid").value="";
			 document.getElementById("accid").required=true;
			alert("Enter 9 digit Account Id");
			
		}

	}
</script>
<body>
<div align="center"  id="example1" style="height:1000px;width:1350px;border: 0px solid #000">
<%@include file="Header.jsp" %>
<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<%if(request.getAttribute("message")!=null){ %>
	<%=request.getAttribute("message") %>
<%} %>
<br><br>
<b>AccountId</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="accid" id="accid" placeholder="Enter 9 digit id" required="required" onchange="function1()"><br><br>
<br><br><br>
<b>Count</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="count">
  <option value="1" >1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
</select><br><br><br><br>
<input type="submit" name="action" value="viewStatement">
</form>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>
</body>
</html>