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
			alert("Enter 9 digit number");
			window.location="viewByDate.jsp";
		}

	}
function myFunction(){
	var accid;
	var stdate,enddate;
	accid=document.getElementById("accid").value;
	stdate=document.getElementById("stdate").value;
	enddate=document.getElementById("enddate").value;
	if ( accid.isNaN ||accid.length != 9) {
		window.location="viewByDate.jsp";
		alert("Enter 9 digit number");
	    return false;
	}
	else if(stdate==enddate){
		window.location="viewByDate.jsp";
		alert("Enter different dates")
		return false;
	}
	return true;
}

</script>
<body>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<div  align="center" id="example1" style="height:1000px;width:1350px;border: 0px solid #000">
<%@include file="Header.jsp" %>
<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>
AccountId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="accid" placeholder="Enter 9 digit id" id="accid" onchange="function1()"><br><br>
StartDate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="stdate" id="stdate">
<br>
<br>
EndDate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="enddate" id="enddate">
<br><br>
<button class="btn" type= "submit" name="action" value="searchState" onclick="return myFunction();">searchStatus</button>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>
</form>
</body>
</html>