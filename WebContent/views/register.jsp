<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Register" />
</jsp:include>

<!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/assets/front/img/register-header.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>Register</h1>
              <span class="subheading">Register Demo</span>
            </div>
          </div>
        </div>
      </div>
    </header>
	
	<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="userToRegister">
						
						<div class="form-group">
							<form:label path="username">Username</form:label>
							<form:input type="text" cssClass="form-control" placeholder="Enter Username" path="username"/>
							<form:errors path="username" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<form:label path="email">Email</form:label>
							<form:input type="email" cssClass="form-control" path="email" placeholder="Enter Email"/>
							<form:errors path="email" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<form:label path="firstName">First Name</form:label>
							<form:input type="text" cssClass="form-control" path="firstName" placeholder="Enter first name"/>
							<form:errors path="firstName" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<form:label path="lastName">Email</form:label>
							<form:input type="text" cssClass="form-control" path="lastName" placeholder="Enter last name"/>
							<form:errors path="lastName" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:input type="password" cssClass="form-control" path="password" placeholder="Enter Password"/>
							<form:errors path="password" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<form:label path="password2">Confrim Password</form:label>
							<form:input type="password" cssClass="form-control" path="password2" placeholder="Confrim Password"/>
							<form:errors path="password2" cssClass="text-danger"/>
						</div>
						
						<div class="text-center">
							<input type="submit" class="btn btn-success" value="Register"/>
						</div>
					</form:form>
				</div>
			</div>
		</div>

<%@include file="includes/footer.jsp" %>