<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp" %>	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill detail</title>
</head>
<body>
	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item">Bill detail</li>
		</ol>
		
		<h2>User of information</h2>
		<ul>
			<li>${user.userName}</li>
			<li>${user.phone}</li>
			<li>${user.email}</li>
		</ul>
		<!-- DataTables Example -->
		 <div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>Title</th>
								<th>Count</th>
								<th>Price</th>
								<th>Date</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Title</th>
								<th>Count</th>
								<th>Price</th>
								<th>Date</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td>${item.title}</td>
									<td>${item.count}</td>
									<td>$${item.price}</td>
									<td>${item.createdDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
		</div> 
	</div>
	<!-- /.container-fluid -->
</body>
</html>