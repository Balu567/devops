<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
* {
    box-sizing: border-box;
}
.container {
    position: relative;
    text-align: center;
    color: white;
}
.centered {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
img {
    border-radius: 8px;
}
.btn {
  border: none;
  color: black;
  padding: 50px 50px;
  text-align: center;
  font-size: 16px;
  margin: 2px 2px;
  opacity: 0.7;
  transition: 0.3s;
}
.btn:hover {opacity: 1}
.column {
    float: left;
    width: 30%;
    padding: 10px;
}
.row::after {
    content: "";
    clear: both;
    display: table;
}
#example1 {
    background: url(../img/f40.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    height:90%;
    width:90%;
}
.example1.welcome{
top:200px;
align:center;

}

</style>
<body>
<div  id="example1" style="height:680px;width:1350px;border: 0px solid #000">
<br><br><br>
<%@include file="Header.jsp" %>
<br>
<br>
<br>
<br>
<div class="welcome">
<h1 align="center"><font color="white">Choose your Action!</font></h1>
</div>
<div align="right" class="row">
  <div class="column">
  	<div class="container">
  	<div class="btn">
   <a href="../BankServlet?action=ViewCustomer">    
    <img src="../img/f32.jpg" alt="ImageLoading" height="100%" width="100%">
    </a>
    <div class="centered"><h2>View Customer Status</h2></div>
    </div>
  </div>
  </div>

  
  
  <div class="column">
  	<div class="container">
  	<div class="btn">
 	<a href="../BankServlet?action=ViewAccount">
    <img src="../img/f32.jpg" alt="ImageLoading" height="100%" width="100%">
    </a>
    <div class="centered"><h2>View Account Status</h2></div>
    </div>
  </div>
  </div>
  </div>
  <%@include file="footer.jsp" %>
  </div>
 
</body>
</html>