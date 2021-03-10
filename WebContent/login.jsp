<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Lato|Muli|Source+Sans+Pro');


body, html {
    height: 100%;
    font-family: Arial, Helvetica, sans-serif;
}

* {
    box-sizing: border-box;
}

.bg-img {
    /* The image used */
    background-image: url("img/nnj.jpg");

   	height:100%;

    /* Center and scale the image nicely */
    background-position: cover;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
}

/* Add styles to the form container */
.container {
    position: fixed;
    top:80px;
    right: 0;
    margin: 30px;
    max-width: 300px;
    padding: 16px;
   background-color:white;
   opacity:0.9;
    font-family: 'Lato', sans-serif;
	font-family: 'Source Sans Pro', sans-serif;
	font-family: 'Muli', sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}
.bg-img .content {
align:center;
    position: absolute;
    top: 0;
    background: rgba(0, 0, 0, 0.4); /* Black background with transparency */
    color: #f1f1f1;
    width: 100%;
    padding: 5px;
    font-family: 'Lato', sans-serif;
	font-family: 'Source Sans Pro', sans-serif;
	font-family: 'Muli', sans-serif;
}

/* Set a style for the submit button */
.btn {
    background-color: grey;
    color: white;
    padding: 16px 20px;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 1;
}
.head{
align:center;
    position: fixed;
    top: 0;
    background: rgba(0, 0, 0, 0.4); /* Black background with transparency */
    color: #f1f1f1;
    width: 100%;
    padding: 5px;
    font-family: 'Lato', sans-serif;
	font-family: 'Source Sans Pro', sans-serif;
	font-family: 'Muli', sans-serif;
}
.btn:hover {
    opacity: 1;
}
</style>

<script type="text/javascript">
	function function1(){
		var empid;
		var Exp = /^[0-9a-zA-Z]/;
	empid=document.getElementById("employeeid").value;
		if(empid.length!=9 || !empid.match(Exp) ||empid==""){
			document.getElementById("employeeid").value="";
			 document.getElementById("employeeid").required=true;
		alert("Enter 9 digit EmployeeId");
		
		}
		
	}
	function function2(){
		var password;
		password=document.getElementById("password").value;
        if(password.length>9){
			empid=document.getElementById("submit").disabled=false;
	}
        else{
        	 document.getElementById("password").value="";
			 document.getElementById("password").required=true;
        	alert("Enter valid password");
   		

        }
	}	

	

</script>
<body>

<div class="bg-img">
<br>
<div class="head">
  <h1 align="center"><font color="white">BANK RETAIL MANAGEMENT</font></h1>
</div>

  <form action="BankServlet" class="container" method="post">
  <font color="red"><%if(request.getAttribute("msg")!=null) {%>
  <%= request.getAttribute("msg")%>
  <%} %></font>
    <h1>Login</h1>

    <label for="email">User ID</label>
    <input type="text" name="id" placeholder="Enter User ID" id="employeeid" onchange="function1()" required/>

    <label for="psw">Password</label>
    <input type="password" name="password" placeholder="Enter Password"id="password" onchange="function2()" required/>

    <button  class="btn" type="submit" name="action"  value="Login">Login</button>
  </form>
    <%@include file="jsp/footer.jsp" %>
</div>


</body>
</html>
