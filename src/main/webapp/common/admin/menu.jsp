<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>        
<!DOCTYPE html>
<ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Account</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Login Screens:</h6>
          <a class="dropdown-item" href = '<c:url value = '/register'/>'>Create admin account</a>
          <a class="dropdown-item" href = '<c:url value = '/admin/user/list_user'/>'>List user account</a>
          <a class="dropdown-item" href = '<c:url value = '/admin/user/list_admin'/>'>List admin account</a>
          <div class="dropdown-divider"></div>
        </div>
      </li>
      
      <li class="nav-item dropdown">
       <%--  <a class="nav-link" href = '<c:url value = '/admin/book/list'/>'>
          <i class="fas fa-fw fa-chart-area"></i>
          <span>List book</span></a> --%>
          
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Book</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Function</h6>
          <a class="dropdown-item" href = '<c:url value = '/admin/book/list'/>'>List book</a>
          <a class="dropdown-item" href = '<c:url value = '/admin/book/edit'/>'>Insert new book</a>
          <div class="dropdown-divider"></div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href = '<c:url value = '/admin/bill/list'/>'>
          <i class="fas fa-fw fa-table"></i>
          <span>List bill</span></a>
      </li>
    </ul>