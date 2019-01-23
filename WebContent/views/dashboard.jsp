<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Dashboard" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

	<div class="content">
		<div class="container-fluid">
		    
		    <h1 class="text-center">Dashboard</h1>
		    
		</div>
	</div>
    
<%@include file="includes/dashboard-footer.jsp" %>