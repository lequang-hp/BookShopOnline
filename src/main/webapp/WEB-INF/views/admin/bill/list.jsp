<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List bill</title>
</head>
<body>
	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item">List bill</li>
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
								<th>User</th>
								<th>Total</th>
								<th>Delivery Address</th>
								<th>Create Date</th>
								<th>Function</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>User</th>
								<th>Total</th>
								<th>Delivery Address</th>
								<th>Create Date</th>
								<th>Function</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td>${item.createdBy}</td>
									<td>${item.total}</td>
									<td>${item.deliveryAddress}</td>
									<td>${item.createdDate}</td>
									<td>
										<c:url var = "createURL" value="/admin/bill/detail?createdBy=${item.createdBy}&billId=${item.id}"/>
										<a href="${createURL}">Detail</a>
									</td>
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