<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill History</title>
</head>
<body>

<c:if test="${empty model}">
		<div class="container">
			<img src="<c:url value='/template/web/img/sorry-icon.png'/>" style="display:block;margin-left:auto;margin-right:auto;width:300px;height:300px;">
			<h2 style="text-align:center;" id ="inf">You bill history is empty !!!</h2>
		</div>
</c:if>
	
<c:if test="${not empty model}">
		<div class="container">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Title</th>
													<th>Image</th>
													<th>Count</th>
													<th>Price</th>
													<th>Date</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td>${item.title}</td>
														<td><img src ='<c:url value='${item.img}'/>' style="width:103px;height:151px"></td>
														<td>${item.count}</td>
														<td>$${item.price}</td>
														<td>${item.createdDate}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<br/>
						</div>
					</div>
				</div>
			</div>
	</div>
	</c:if>
</body>
</html>