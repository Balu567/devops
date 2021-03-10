<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="java.util.*"%>
    
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
function Validate()
{
    var e = document.getElementById("ddlView");
    var strUser = e.options[e.selectedIndex].value;

    var strUser1 = e.options[e.selectedIndex].text;
    if(strUse==0)
    {
        alert("Please select an account");
    }
}
</script>
<%ArrayList<Long> ob=(ArrayList<Long>)request.getAttribute("acclist");%>

<body style="align:center">
<div  id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<%@include file="Header.jsp" %>
<br>
<div class="nav">
<ul>
<li><a href="how.jsp">View Mini Statement</a></li>

</ul>
</div><br>
<br>
<form action="<%=request.getContextPath()%>/BankServlet" method="post">
<%String message=(String)request.getAttribute("message");%>
<%if(message!=null){ %>
<center><p style="color:red;align:center"><%=message %></p></center>
<%} %>
<center>
<select name="accountId" id="ddlView">

<%for(Long l:ob){ %>

<option value="<%=l %>"><%=l %></option>

<%} %>
</select><br><br>

<button name="action" value="AccountChoice" onclick="Validate()">Submit</button>
</center>
</form>
<br><br>
<center><a href="<%=request.getContextPath() %>/5.jsp"><b>Back to Main Page</b></a></center>
<%@include file="footer.jsp" %>
</div>
</body>
</html>