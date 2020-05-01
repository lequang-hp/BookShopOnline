<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div class="row login">
		<div class="col-lg-1"></div>
		<div class="col-lg-7">
			<div class="register">
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}">
						<strong>${message}</strong>
					</div>
				</c:if>
				<h1>Register</h1>
		       
		        
				<form:form action='/BookOnline/dang-ky' method="post" modelAttribute="user">
					<div class="user-name">
						<label>User name</label> 
						<form:input path="userName"/><br/>
						<form:errors path="userName" style="color:red;"/>
					</div>
					<div class="password">
						<label>Password</label>
						<form:password path="password"/> <br/>
						<form:errors path="password" style="color:red;"/> 
					</div>
					<div class="email">
						<label>Email</label> 
						<form:input path="email"/><br/>
						<form:errors path="email" style="color:red;"/>
					</div>
					<div class="address">
						<label>Address</label> 
						<form:input path="address"/><br/> 
						<form:errors path="address" style="color:red;"/>
					</div>
					<div class="phone-number">
						<label>Phone-number</label> 
						<form:input path="phone"/><br/>
						<form:errors path="phone" style="color:red;"/>
					</div>
					<div class="sub-reg">
						<input type="submit" value="Register">
					</div>
				</form:form> 
			</div>
		</div>
		<div class="col-lg-3 sign-in">
			<c:if test="${param.incorrectAccount != null}">
				<div class="alert alert-danger">
					<strong>User or pass incorrect</strong>
				</div>
			</c:if>
				
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-danger">
					<strong>You not authorize</strong>
				</div>
			</c:if>
			
			
			<h1>Login</h1>
			<form action="j_spring_security_check" method="post">
			<div>
				<label>User name</label>
				<div>
					<input type="text" value="" placeholder="user name" name="j_username">
				</div>
			</div>
			<div>
				<label>Password</label>
				<div>
					<input type="password" value="" placeholder="password" name="j_password">
				</div>
			</div>
			<div class="sub-log">
				<a href="#"><input type="submit" value="Login"></a>
			</div>
			</form>
			<div class="support">
				<a href="<c:url value='/dang-ky'/>">register here now</a>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
</body>
</html>