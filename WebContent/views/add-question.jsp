<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/dashboard-header.jsp">
    <jsp:param name="title" value="Add Question" />
    <jsp:param value="${loggedInUser }" name="loggedInUser"/>
</jsp:include>

<c:set var="id" value="0" scope="page"/>

	<div class="content">
	<form:form action="${pageContext.request.contextPath}/add-question" method="post" modelAttribute="question">
		<form:input type="hidden" path="quiz.id" value="${question.quiz.id }"/>
		
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-md-6 col-md-offset-3">
		    		<div class="card">
			    			<div class="header">
			    				<h4 class="title">Add question to quiz "${question.quiz.name }"</h4>
			    			</div>
			    			
			    			<div class="content">
			    				
	    							<div class="form-group">
	                                    <form:label path="text">Question</form:label>
	                                    <form:input type="text" cssClass="form-control border-input" placeholder="Enter question" path="text"/>
	                                    <form:errors path="text" cssClass="text-danger" />
	                                </div>
                                    
                            	         
			    				
			    			</div>
		    			
		    		</div>
		    		
		    		
		    	</div>
		    	
		    </div>
		    
		     <div class="row">
		    	<div class="col-md-6 col-md-offset-3">
		    		<div class="card">
			    			<div class="header">
			    				<h4 class="title">Add asnwers to this question</h4>
			    			</div>
			    			
			    			<div class="content">
			    				 
			    				 <c:forEach items="${question.answers }" var="answer" varStatus="status">
			    				 	<c:if test="${status.index == 0 }"></c:if>
			    				 	
			    				 	<c:choose>
			    				 		<c:when test="${status.index == 0 }">
			    				 			<div class="form-group">
			                                    <form:label path="answers[${status.index}].text">Answer ${status.count } (True)</form:label>
			                                    <form:input type="text" cssClass="form-control border-input" placeholder="Enter true answer" path="answers[${status.index}].text"/>
			                  					<form:errors path="answers[${status.index}].text" cssClass="text-danger" />
			                                </div>
			    				 		</c:when>
			    				 		
			    				 		<c:otherwise>
			    				 			<div class="form-group">
			                                    <form:label path="answers[${status.index}].text">Answer ${status.count } (False)</form:label>
			                                    <form:input type="text" cssClass="form-control border-input" placeholder="Enter false answer" path="answers[${status.index}].text"/>
			                  					<form:errors path="answers[${status.index}].text" cssClass="text-danger" />
			                                </div>
			    				 		</c:otherwise>
			    				 	</c:choose>
			    				 
		    				 	 	
			    				 </c:forEach>
		    				 	
								<div class="text-center">
									<button type="submit" class="btn btn-info btn-fill btn-wd">Save question</button>
								</div>
			    			</div>
		    			
		    		</div>
		    		
		    		
		    	</div>
		    	
		    </div>
		    
		</div>
		</form:form>
	</div>
    
<%@include file="includes/dashboard-footer.jsp" %>