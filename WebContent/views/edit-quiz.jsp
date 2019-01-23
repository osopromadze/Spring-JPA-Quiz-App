<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Edit Quiz" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

	<div class="content">
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-md-6 col-md-offset-3">
		    		<div class="card">
		    			
			    			<div class="header">
			    				<h4 class="title">Edit Quiz</h4>
			    			</div>
			    			
			    			<div class="content">
			    				<form:form action="${pageContext.request.contextPath}/edit-quiz" method="post" modelAttribute="quiz">
			    					<form:hidden path="id" value="${quiz.id }" />
			    				
	    							<div class="form-group">
	                                    <form:label path="name">Quiz name</form:label>
	                                    <form:input type="text" cssClass="form-control border-input" placeholder="Enter theme name" path="name" value="${quiz.name }"/>
	                                    <form:errors path="name" cssClass="text-danger" />
	                                </div>
                                      
                                    <div class="text-center">
                                    	<button type="submit" class="btn btn-info btn-fill btn-wd">Edit quiz name</button>
                                	</div>
                            	</form:form>         
			    				
			    			</div>
			    			
			    			
		    			
		    		</div>
		    		
		    		
		    	</div>
		    	
		    </div>
		    <div class="row">
		    	<c:forEach items="${quiz.questions }" var="question" varStatus="questionStatus">
		    		<div class="col-md-4">
		    			<div class="card">
		    				<div class="header">
		    					<h4 class="title text-center">${question.text }</h4>
		    				</div>
		    				<div class="content">
		    					<p class="category text-center">Answers</p>
		    					<ol>
			    					<c:forEach items="${question.answers }" var="answer" varStatus="answerStatus">
			    						<li><p>${answer.text } 
			    						 <c:if test="${answer.isCorrect == 1}">(True)</c:if>
			    						</p></li>
			    					</c:forEach>
		    					</ol>
	    						<a href="${pageContext.request.contextPath}/edit-question/${question.id}" class="btn btn-primary btn-sm">Edit question</a>
	    						<form action="${pageContext.request.contextPath}/delete-question" method="post" class="form-inline pull-right">
	    							<input type="hidden" name="id" value="${question.id}"/>
	    							<input type="hidden" name="quizId" value="${quiz.id}"/>
	    							<input type="submit" value="Delete question" class="btn btn-danger btn-sm"/>
	    						</form>
		    				</div>
		    			</div>
		    		</div>
		    	</c:forEach>
	    	</div>
		</div>
	</div>
    
<%@include file="includes/dashboard-footer.jsp" %>