<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/taglib.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=chrome">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/template/web/css/style.css'/>" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

  
<!-- sweetalert -->
<script src="<c:url value='/template/web/sweetalert/sweetalert2.min.js' />"></script>
<link rel="stylesheet" href="<c:url value='/template/web/sweetalert/sweetalert2.min.css' />"></link> 
</head>

<body>
<div class="page">
	<!--Header-->
    <%@ include file="/common/web/header.jsp" %>
    
    <dec:body/>
    
    <!--Footer-->
    <%@ include file="/common/web/footer.jsp" %>
</div>

  <script src="<c:url value='/template/web/js/javaScript.js'/>"></script>
   
</body>
</html>