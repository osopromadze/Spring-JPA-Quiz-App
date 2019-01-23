<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Users" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

<c:set var="id" value="0" scope="page"/>

	<div class="content">
    	<div class="container-fluid">
        	
        	<div class="row">
        		<div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Users</h4>
                                <p class="category">All users registered on website</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover">
                                    <thead>
                                    	<tr>
	                                    	<th>ID</th>
	                                        <th>Username</th>
	                                    	<th>Email</th>
	                                    	<th>Full Name</th>
	                                    	<th>Role</th>
	                                    	<th>Correct Answers</th>
	                                    	<th>Incorrect Answers</th>
	                                    	<th>Change Role</th>
                                    	</tr>
                                    </thead>
                                    
                                    <c:choose>
                                    
                                    	<c:when test="${empty allUsers }">
                                    		<p class="text-center">There are no users</p>
                                    	</c:when>
                                    	
                                    	<c:otherwise>
                                    		<tbody>
                                    			
                                    			<c:forEach items="${allUsers }" var="user">
                                    				<c:set var="id" value="${id + 1 }" scope="page"/>
                                    				
                                    					<tr>
		                                    				<td>${id }</td>
		                                    				<td>${user.username }</td>
		                                    				<td>${user.email }</td>
		                                    				<td>${user.firstName } ${user.lastName }</td>
		                                    				<td>${user.role.roleName }</td>
		                                    				<td>${user.totalCorrectAnswers }</td>
		                                    				<td>${user.totalIncorrectAnswers }</td>
		                                    				<td>
			                                    				<form action="${pageContext.request.contextPath}/change-role" method="post" >
			                                    					<select name="roleId" id="roleId" onchange="this.form.submit()" class="form-control">
			                                    						<option value="0">Choose Role</option>
					                                    				<c:forEach items="${allRoles }" var="role">
					                                    					<option value="${role.id }">${role.roleName }</option>
					                                    				</c:forEach>
				                                    				</select>
				                                    				
				                                    				<input type="hidden" value="${user.username }" id="username" name="username"/>
				                                    				
			                                    				</form>
		                                    				</td>
	                                    				</tr>
                                    				
                                    			</c:forEach>
                                   			</tbody>
                                    		
                                    	</c:otherwise>
                                    	
                                    </c:choose>
                                    
                                </table>

                            </div>
                        </div>
                    </div>
        	</div>
    	</div>
    </div>
    
<%@include file="includes/dashboard-footer.jsp" %>