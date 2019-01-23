<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Profile" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

	<div class="content">
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                        	<div class="header">
	                            <div class="image">
	                                <img src="assets/img/background.jpg" alt="card header background"/>
	                            </div>
                            </div>
                            <div class="content">
                                <div class="author">
                                	<img class="avatar border-white" src="assets/img/faces/face-3.png" alt="user"/>
                                  	<h4 class="title">${user.firstName } ${user.lastName }<br />
                                     	<small>${user.username }</small>
                                  	</h4>
                                </div>
                                
                                <hr>
	                            <div class="text-center">
	                                <p>Total correct answers - ${user.totalCorrectAnswers }</p>
	                                <p>Total incorrect answers - ${user.totalIncorrectAnswers }</p>
	                            </div>
                            </div>
                            
                        </div>
                        
                    </div>
		    
		    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form:form action="${pageContext.request.contextPath}/profile" method="post" modelAttribute="userToUpdate">
                                    <div class="row">
                                    
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="username">Username</form:label>
                                                <form:input type="text" readonly="true" cssClass="form-control border-input" placeholder="Enter username" value="${userToUpdate.username }" path="username"/>
                                                <form:errors path="username" cssClass="text-danger" />
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="email">Email address</form:label>
                                                <form:input type="email" readonly="true" cssClass="form-control border-input" placeholder="Enter email" value="${userToUpdate.email }" path="email"/>
                                                <form:errors path="email" cssClass="text-danger" />
                                            </div>
                                        </div>
                                        
                                    </div>

                                    <div class="row">
                                        
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="firstName">First Name</form:label>
                                                <form:input type="text" cssClass="form-control border-input" placeholder="Enter first name" value="${userToUpdate.firstName }" path="firstName"/>
                                                <form:errors path="firstName" cssClass="text-danger" />
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="lastName">Last Name</form:label>
                                                <form:input type="text" cssClass="form-control border-input" placeholder="Enter last name" value="${userToUpdate.lastName }" path="lastName"/>
                                                <form:errors path="lastName" cssClass="text-danger" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                    
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="password">Password</form:label>
                                                <form:input type="password" cssClass="form-control border-input" placeholder="Enter password" value="${userToUpdate.password }" path="password"/>
                                                <form:errors path="password" cssClass="text-danger" />
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <form:label path="password2">Confrim password</form:label>
                                                <form:input type="password" cssClass="form-control border-input" placeholder="Confrim password" value="${userToUpdate.password2 }" path="password2"/>
                                                <form:errors path="password2" cssClass="text-danger" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form:form>
                            </div>
                        </div>
                    </div>
		    </div>
		</div>
	</div>
    
<%@include file="includes/dashboard-footer.jsp" %>