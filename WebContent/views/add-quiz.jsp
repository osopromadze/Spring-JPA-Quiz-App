<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Add Quiz" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

<c:set var="id" value="0" scope="page"/>

	<div class="content">
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-md-6 col-md-offset-3">
		    		<div class="card">
		    			
			    			<div class="header">
			    				<h4 class="title">Add Quiz</h4>
			    			</div>
			    			
			    			<div class="content">
			    				<form:form action="${pageContext.request.contextPath}/add-quiz" method="post" modelAttribute="quiz">
	    							<div class="form-group">
	                                    <form:label path="name">Quiz name</form:label>
	                                    <form:input type="text" cssClass="form-control border-input" placeholder="Enter theme name" path="name"/>
	                                    <form:errors path="name" cssClass="text-danger" />
	                                </div>
                                      
                                    <div class="text-center">
                                    	<button type="submit" class="btn btn-info btn-fill btn-wd">Add quiz</button>
                                	</div>
                            	</form:form>         
			    				
			    			</div>
			    			
			    			
		    			
		    		</div>
		    		
		    		
		    	</div>
		    	
		    </div>
		    
		    <div class="row">
		    	<div class="col-md-12">
		    		<div class="card">
		    			<div class="header">
			    				<h4 class="title">Quiz list</h4>
			    			</div>
			    			
			    			<div class="content table-responsive table-full-width">
			    				<c:choose>
			    					<c:when test="${not empty allQuizzes }">
					    				<table class="table table-hover">
					    					<thead>
		                                    	<tr>
			                                    	<th>ID</th>
			                                        <th>Name</th>
			                                        <th>Question count</th>
			                                  		<th>Add question</th>
			                                  		<th>Edit</th>
			                                  		<th>Delete</th>
		                                    	</tr>
		                                    </thead>
		                                    
		                                    <tbody>
		                                    	
		                                    	<c:forEach items="${allQuizzes }" var="quiz">
		                                    		<c:set var="id" value="${id + 1 }" scope="page"/>
		                                    	
		                                    		<tr>
		                                    			<td>${id }</td>
		                                    			<td>${quiz.name }</td>
		                                    			<td>${quiz.questions.size() }</td>
		                                    			<td>
		                                    				<form action="${pageContext.request.contextPath}/show-add-question" method="post">
		                                    					<input type="hidden" name="quizId" value="${quiz.id }" />
		                                    					<button class="btn btn-primary">Add question</button>
		                                    				</form>
		                                    			</td>
		                                    			
		                                    			<td>
		                                    				<a href="${pageContext.request.contextPath}/edit-quiz/${quiz.id}" class="btn btn-info">Edit</a>
		                                    			</td>
		                                    			
		                                    			<td>
		                                    				<form action="${pageContext.request.contextPath}/delete-quiz" method="post">
		                                    					<input type="hidden" name="quizId" value="${quiz.id }" />
		                                    					<button class="btn btn-danger">Delete</button>
		                                    				</form>
		                                    			</td>
		                                    		</tr>
		                                    	</c:forEach>
		                                    	
		                                    </tbody>
		                                    	
		                                    		
		                                    	
		                                    	
		                                    	
		                                    
					    				</table>
				    				</c:when>
				    				
			    					<c:otherwise>
                                   		<p class="text-center">There are no quizzes</p>
                                   	</c:otherwise>
			    				</c:choose>
			    			</div>
		    		</div>
		    	</div>
		    </div>
		    
		</div>
	</div>
    
<%@include file="includes/dashboard-footer.jsp" %>