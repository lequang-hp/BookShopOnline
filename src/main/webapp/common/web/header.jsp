<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import = "com.laptrinhjavaweb.util.SecurityUtils" %>    
<div class="row top">
	<div class="col-lg-11 sider-top" style="height:40px;">
		<security:authorize access = "isAuthenticated()">
			<button type="button" class="btn btn-outline-success"><%= SecurityUtils.getPrincipal().getUsername() %></button>
					
			<a href='<c:url value = "/thoat"/>'><span style="font-size:120%;">Logout</span></a>
			
		</security:authorize>
	</div>
	<div class="col-lg-1"></div>
</div>

<security:authorize access = "isAuthenticated()">
	<div class="row header">
	<div class="col-lg-3 logo">
		<a href="<c:url value='/trang-chu'/>"><img src="<c:url value='/template/web/img/logo.jpg'/>"></a>
	</div>
	<div class="col-lg-4 search">
		<form action = '<c:url value = "/sach/tim-kiem"/>' method = "post">
			<input type="text" name = "searchValue"> <input type="submit" value="SEARCH">
		</form>
	</div>
	<div class="col-lg-4 shop-cart">
		<div class="check-cart">
			<div>
				<img src="<c:url value='/template/web/img/iconShop.png'/>" alt=""><b>Your cart</b>
			</div>
			<div class="monney">
				<form action='<c:url value = '/gio-hang'/>'>
					<input type="submit" value="Chekout">
				</form>
			</div>
		</div>
		<div class="wish-list">
			<img  src="<c:url value='/template/web/img/iconstar.png'/>" alt=""><br/>
			
			<%-- <form action = '<c:url value = '/lich-su'/>' method = "POST">
				<input type="hidden" name = "username" value = "<%= SecurityUtils.getPrincipal().getUsername() %>">
				<input type = "submit" value = "Your bill">
			</form> --%>
			<a href = '<c:url value = "/lich-su"/>' >Your bill</a>
		</div>
	</div>
</div>
</security:authorize>