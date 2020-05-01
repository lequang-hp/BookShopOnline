<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import = "com.laptrinhjavaweb.util.SecurityUtils" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10 product-book">
			<div class="book">
				<div class="col-lg-4 left">
					<img src="<c:url value='${model.img}'/>" alt="" style="width:255px;height:391px;">
				</div>
				<div class="col-lg-8 right">
					<h1>${model.title}<img src="<c:url value='/template/web/img/a2.jpg'/>" alt=""></h1>
					<p>${model.shortDescription}</p>
					<form action='<c:url value='/sach/chi-tiet'/>' method="post">
						<div class="buy-book">
								<input type="hidden" name = "bookID" value = "${model.id}">
								<div class="pricer">
									<h2>Our pricer: <b>$${model.price}</b><input type="submit" value="Add to cart" onclick="validateAmount()"></h2>
									<small style="font-weight:bold;font-size:120%;">Discount: ${model.discount}%</small>
								</div>
								<div class="credit-card">
									<p>
										Safe, secure Shopping<br>
										<a href=""><img src="<c:url value='/template/web/img/card1.png'/>"  alt=""></a> 
										<a href=""><img src="<c:url value='/template/web/img/card2.png'/>" alt=""></a> 
										<a href=""><img src="<c:url value='/template/web/img/card3.png'/>" alt=""></a>
										<a href=""><img src="<c:url value='/template/web/img/card4.png'/>" alt=""></a>
									</p>
								</div>
						</div>
						Amount: <input type="number" placeholder="Amount" style="width:100px;height:30px;" value="1" name="count" min = "1" required>
					</form>		
				</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-8 infor-table">
			<div class="but">
				<button class="button" onclick="openInformation('infor')">Product Information</button>
				<button class="button" onclick="openInformation('other')">Other details</button>
			</div>
			<div class="information">
				<div class="openin" id="infor">
					<p>The Star Wars Episode I: The Phatom Menace novelization was
						written by terry Brooks and published on April 21, 1999 by Del
						Rey. It is based on the script of the movie of the same name.
						Narration for the abridged audio version was performed by Michael
						Cumpsty. The unabridged version was performed ay alexander Adams.
						On January 31, 2012, a new paperback edition</p>
				</div>
				<div class="openin" id="other">
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industy. lirem Ipsum has been the industy's standard
						dummy text ever since the 1500s, when an unknow printer took a
						galley of type and scrambled it to make a type specimen book. It
						has survived not only five centuries, but also the leap into
						elictronic tyoesetting, remaning essentially. The unabridged
						version was performed ay alexander Adams. On January 31, 2012, a
						new paperback edition</p>
				</div>
			</div>
			<div class="comment">
				<h1>Product review</h1>
				<div class="user-comment">
					<c:if test="${not empty comments}">
						<c:forEach var ="item" items="${comments}">
							<div class="comment-1">
								<div class="avata" style="margin-bottom: 60px;">
									<img src="<c:url value='/template/web/img/p4.jpg'/>" alt="avata">
									<small>${item.username}</small>
								</div>
								<p>${item.content}</p>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			
			<h1>Write a comment</h1>
			<form action='<c:url value='/binh-luan'/>' method="post">
				<input type="hidden" name = "bookID" value = "${model.id}">
				<div class="write-comment">
					<div class="message">
						<label>message</label> <input type="text" name="cmt">
					</div>
				</div>
				<input type="submit" value="Submit" id="submit-comment">
			</form>
		</div>
		<div class="col-lg-2">
			<div class="like-book">
				<h2>You may also like</h2>
				<div class="book-most">
					<img src="<c:url value='/template/web/img/b2.jpg'/>" alt="">
					<div class="name-book">
						<p>The war of art</p>
						<h1>$200</h1>
						<a href="<c:url value='/sach/chi-tiet?id=2'/>"><input type="submit" value="Read more" id=""></a>
					</div>
				</div>
				<div class="book-most">
					<img src="<c:url value='/template/web/img/b1.jpg'/>" alt="">
					<div class="name-book">
						<p>The Hare with Amber Eyes</p>
						<h1>$100</h1>
						<a href="<c:url value='/sach/chi-tiet?id=1'/>"><input type="submit" value="Read more" id=""></a>
					</div>
				</div>
				<div class="book-most">
					<img src="<c:url value='/template/web/img/b3.jpg'/>" alt="">
					<div class="name-book">
						<p>Can love happen twice</p>
						<h1>$100</h1>
						<a href="<c:url value='/sach/chi-tiet?id=3'/>"><input type="submit" value="Read more" id=""></a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
</body>
</html>