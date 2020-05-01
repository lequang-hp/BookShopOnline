<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Information</title>
	<style>
    </style>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style="text-align:center;color:blue;">Order Information</h1>
<div class="container" style = "width:700px;">
	<form action='<c:url value = '/dat-hang'/>' method = "post">
		<table class="table table-dark table-bordered">
	        <tbody>
	        <tr>
	            <td style="width: 30%">Name</td>
	            <td style="width: 70%;"><input type="text" size="50" readonly="readonly" value = "${myUser.userName}"></td>
	        </tr>
	
	        <tr>
	            <td>Phone</td>
	            <td><input type="text" size="50" readonly="readonly" value = "${myUser.phone}"></td>
	        </tr>
	        
	        <tr>
	            <td>Email</td>
	            <td><input type="text" size="50" readonly="readonly" value = "${myUser.email}"></td>
	        </tr>
	        
	        <tr>
	            <td>Delivery address</td>
	            <td><textarea rows="5" cols="55" name = "deliveryAddress" required></textarea></td>
	        </tr>
	        <tr>
	            <td colspan="2">
	            <button type="submit" class="btn btn-success">Confirm</button></td>          
	        </tr>
	        </tbody>
	    </table>
	</form>
</div>
</body>
</html>