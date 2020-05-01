<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.util.SecurityUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class=" row slider">
		<div class="col-lg-1"></div>
		<div class="col-lg-7 img1">
			<img class="mySlides"
				src="<c:url value='/template/web/img/ba1.jpg'/>" alt=""> <img
				class="mySlides" src="<c:url value='/template/web/img/img3.jpg'/>"
				alt=""> <img class="mySlides"
				src="<c:url value='/template/web/img/img4.jpg'/>" alt=""> <img
				class="mySlides" src="<c:url value='/template/web/img/img5.jpg'/>"
				alt="">
			<button class="button-left" onclick="plusDivs(-1)">&#10094;</button>
			<button class="button-right" onclick="plusDivs(1)">&#10095;</button>
		</div>
		<div class="col-lg-3 img2">
			<img class="slides-auto"
				src="<c:url value='/template/web/img/ba2.jpg'/>" alt=""> <img
				class="slides-auto"
				src="<c:url value='/template/web/img/imgr2.jpg'/>" alt=""> <img
				class="slides-auto"
				src="<c:url value='/template/web/img/imgr3.jpg'/>" alt=""> <img
				class="slides-auto"
				src="<c:url value='/template/web/img/imgr4.jpg'/>" alt="">
		</div>
	</div>

	<div class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
				<strong>${message}</strong>
			</div>
		</c:if>
	</div>

	<div class="row content">
		<form action='<c:url value = 'trang-chu'/>' id="forSubmit" method="get">

			<div class="col-lg-1"></div>
			<div class="col-lg-2 list">
				<div class="categori">Categories</div>
				<a href='<c:url value = '/trang-chu'/>' class="all">ALL</a>
				<div class="Fiction-list">
					<p>Fiction & Literature</p>
					<c:forEach var="item" items="${categories}">
						<c:url var="createNewURL" value="/sach/the-loai">
							<c:param name="categoryID" value="${item.id}" />
						</c:url>
						<a href="${createNewURL}" class="tem">${item.name}</a>
					</c:forEach>
				</div>
			</div>

			<div class="col-lg-8 book">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
				</ul>
				
				
			    <ul class="pagination" id="pagination"></ul>
			    
				<input type="hidden" value="" id="page" name="page" /> 
				<input type="hidden" value="" id="limit" name="limit" />
				
				<div class="list-book">
					<c:forEach var="item" items="${model.listResult}">
						<div class="img-book">
							<c:url var="createNewURL" value="/sach/chi-tiet">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<security:authorize access="isAnonymous()">
								<a href="" onclick="demo()"> <img
									src="<c:url value='${item.img}'/>" alt="">
								</a>
							</security:authorize>

							<security:authorize access="isAuthenticated()">
								<a href="${createNewURL}"> <img
									src="<c:url value='${item.img}'/>" alt="">
								</a>
							</security:authorize>

							<div class="tit">${item.title}</div>
							<div>
								<p>${item.price}$</p>
							</div>
						</div>
					</c:forEach>
					<br/>
				</div>
			</div>
			
			<div class="col-lg-1"></div>
			
		</form>
	</div>

</body>

<script type="text/javascript">
var totalPages = ${model.totalPage};
var currentPage = ${model.page};
$(function () {
    window.pagObj = $('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: 10,
        startPage: currentPage,
        onPageClick: function (event, page) {
        	if (currentPage != page) {
        		$('#limit').val(5);
				$('#page').val(page);
				$('#formSubmit').submit();
			}
        }
    });
});
</script>
</html>