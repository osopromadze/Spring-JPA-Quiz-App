<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

		<!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/assets/front/img/quiz-header.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>Quiz App</h1>
              <span class="subheading">Demo</span>
            </div>
          </div>
        </div>
      </div>
    </header>
		
<%@include file="includes/footer.jsp" %>