<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="card card-register mx-auto mt-5">
		
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form:form action="register" method="post" modelAttribute="user">
          <div class="form-group">
            <div class="form-label-group">
              <form:input path="userName" cssClass="form-control" placeholder="User Name"/>
              <label for="userName">User Name</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <form:input path="email" cssClass="form-control" placeholder="Email" />
              <label for="email">Email</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <form:password path="password" cssClass="form-control" placeholder="Password" />
              <label for="password">Password</label>
            </div>
          </div>
          
          <div class="form-group">
            <div class="form-label-group">
              <form:input path="address" cssClass="form-control" placeholder="Address" />
              <label for="address">Address</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <form:input path="phone" cssClass="form-control" placeholder="Phone" />
              <label for="phone">Phone</label>
            </div>
          </div>
          <input type="submit" value="Register" />
        </form:form>
      </div>
    </div>
</body>
</html>