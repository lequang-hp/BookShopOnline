<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List user</title>
</head>
<body>
	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item">Setting</li>
			<li class="breadcrumb-item active">List user</li>
		</ol>

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
								<th>Id</th>
								<th>User name</th>
								<th>Email</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Create Date</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Id</th>
								<th>User name</th>
								<th>Email</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Create Date</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td>${item.id}</td>
									<td>${item.userName}</td>
									<td>${item.email}</td>
									<td>${item.address}</td>
									<td>${item.phone}</td>
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