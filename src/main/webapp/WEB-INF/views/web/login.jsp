<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="row login">
      <div class="col-lg-1"></div>
      <div class="col-lg-7"></div>
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
          		<div> <input type="text" value="" placeholder="user name" name="j_username" required></div>
        	</div>
        	<div>
          		<label>Password</label>
          		<div> <input type="password" value="" placeholder="password" name="j_password" required></div>
        	</div>
        	<div class="sub-log"><input type="submit" value="Login"></a></div>
        </form>
        <div class="support">
          <a href="<c:url value='/dang-ky'/>">register here now</a>
        </div>
      </div>
      <div class="col-lg-1"></div>
</div>
</body>
</html>