<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import = "com.laptrinhjavaweb.util.SecurityUtils" %>
<c:url var="cartAPI" value="/api/cart" />
<c:url var="cartURL" value="/gio-hang" />	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your cart</title>
<style>
	#inf{
		color:red;
	}
</style>
</head>
<body>
	
	<c:if test="${empty model.listResult}">
		<div class="container">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">
					<strong>${message}</strong>
				</div>
			</c:if>
			<img src="<c:url value='/template/web/img/sorry-icon.png'/>" style="display:block;margin-left:auto;margin-right:auto;width:300px;height:300px;">
			<h2 style="text-align:center;" id ="inf">You have not selected the product !!!</h2>
		</div>
	</c:if>
	
	<c:if test="${not empty model.listResult}">
		<div class="container">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">
									<strong>${message}</strong>
								</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa sản phẩm' onclick="warningBeforeDelete()">
												<span>Delete</span>
											</button>		
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th>Name</th>
													<th>Count</th>
													<th>Price</th>
													<th>Date</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
														<td>${item.title}</td>
														<td>${item.count}</td>
														<td>$${item.price}</td>
														<td>${item.createdDate}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<h2 style="color:red;">Total: $${total}</h2>
									</div>
								</div>
							</div>
							<br/>
							<form action='<c:url value = '/dat-hang' />' method = "get">
								<button type="submit" class="btn btn-success"><b>Continue</b></button><br/>
							</form>
						</div>
					</div>
				</div>
			</div>
	</div>
	</c:if>
							
	<script>
	function warningBeforeDelete(){
		swal({
			  title: "Are you sure?",
			  text: "You will not be able to recover this imaginary file!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Yes, delete it!",
			  cancelButtonText: "No, cancel plx!"
			}).then(function(isConfirm) {
				console.log(isConfirm);
			  if (isConfirm.value) {
			    // call api delete
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
			    	return $(this).val();
			    }).get();
				deleteCart(ids);
			  }
			});
	}
	
	function deleteCart(data) {
        $.ajax({
            url: '${cartAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${cartURL}?&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${cartURL}?message=error_system";
            }
        });
    }
	</script>
</body>
</html>