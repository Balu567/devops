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
    background: url(img/bank.png);
    background-repeat: no-repeat;
    background-size: cover;
    height:100%;
}
</style>
</script>
<body bgcolor="white">

<h1 align="center">Welcome Executive!!!!!!</h1>
<div  id="example1" style="height:630px;width:1350px;border: 0px solid #000">
<br>
<table border="1px" align="center">
<tr>
<th >SL NO:</th>
<th>FUNCTION</th>
</tr>
<tr>
<td>1</td>
<td><a href="jsp/createcustomer.jsp">Customer</a> </td>
</tr>
<tr>
<td>2</td>
<td><a href="jsp/updateCustomer.jsp">Update Customer</a></td>
</tr>
<tr>
<td>3</td>
<td><a href="jsp/deletecustomer.jsp">Delete Customer</a></td>
</tr>
<tr>
<td>4</td>
<td><a href="jsp/createaccount.jsp">Create Account</a></td>
</tr>
<tr>
<td>5</td>
<td><a href="jsp/deleteaccount.jsp">Delete Account</a></td>
</tr>
<tr>
<td>6</td>
<td><a href="BankServlet?action=ViewCustomer">List Customers</a></td>
</tr>
<tr>
<td>7</td>
<td><a href="BankServlet?action=ViewAccount">List Accounts</a></td>
</tr>
</table>
</div>

</body>
</html>