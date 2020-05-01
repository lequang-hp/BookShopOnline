<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
	<h1 style="text-align: center;color:blue;">Bill of Information</h1>
	<div class="container">
		<h2>User of information</h2>
		<ul>
			<li>${myUser.userName}</li>
			<li>${myUser.phone}</li>
			<li>${myUser.email}</li>
		</ul>
		<br />

		<h2>List</h2>
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>Count</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${cartDTO.listResult}">
								<tr>
									<td>${item.title}</td>
									<td>${item.count}</td>
									<td>$${item.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<h2 style="color: red;">Total: $${total}</h2>
				</div>
			</div>
		</div>
		
		<h2>Delivery address: </h2>
		<h3>${deliveryAddress}</h3>
	</div>
</body>
</html>