<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List book</title>
</head>
<body>
	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item">List book</li>
		</ol>

		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Data Table
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Id</th>
								<th>Title</th>
								<th>Image</th>
								<th>Price($)</th>
								<th>Discount(%)</th>
								<th>Function</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Id</th>
								<th>Title</th>
								<th>Image</th>
								<th>Price($)</th>
								<th>Discount(%)</th>
								<th>Function</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items="${model.listResult}">
								<tr>
									<td>${item.id}</td>
									<td>${item.title}</td>
									<td><img src='<c:url value='${item.img}'/>' style="width:103px;height:151px;"></td>
									<td>${item.price}</td>
									<td>${item.discount}</td>
									<td>
										<c:url var="updateBookURL" value="/admin/book/edit">
											<c:param name="id" value="${item.id}" />
										</c:url> 
										<a href="${updateBookURL}">Update</a>
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