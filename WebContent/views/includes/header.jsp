<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>${param.title }</title>
		
		<!--  
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
		-->
		
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.request.contextPath}/assets/front/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    	<!-- Custom fonts for this template -->
  		<link href="${pageContext.request.contextPath}/assets/front/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    	<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    	<!-- Custom styles for this template -->
    	<link href="${pageContext.request.contextPath}/assets/front/css/clean-blog.min.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/assets/front/css/quiz.css" rel="stylesheet">
	</head>
	
	
	<body>
	
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Quiz App</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <c:choose>
				<c:when test="${not empty sessionScope.userToLogin }">
				
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/quizzes" class="nav-link">Quizzes</a>
					</li>
				
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/dashboard" class="nav-link">Dashboard</a>
					</li>
				
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a>
					</li>
				</c:when>
				
				<c:otherwise>
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/register" class="nav-link">Register</a>
					</li>
					
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>
					</li>
				</c:otherwise>
			</c:choose>
          </ul>
        </div>
      </div>
    </nav>
		