<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('${pageContext.request.contextPath}/assets/front/img/black.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>${quiz.name }</h1>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<span style="display:none" id="questionsJson">${questionsJson }</span>
	<span style="display:none" id="quizId">${quiz.id }</span>
	<span style="display:none" id="username">${loggedInUser.username }</span>
	<span style="display:none" id="path">${pageContext.request.contextPath}</span>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
			
			<div id="quiz"></div>
			<div id="next" class="btn btn-success btn-sm float-right">Next</div>
			<div id="start" class="btn btn-success btn-sm float-right">Try again</div>
			</div>
		</div>
	</div>
	
	

<%@include file="includes/footer.jsp"%>