<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<hr>

	    <!-- Footer -->
	    <footer>
	      <div class="container">
	        <div class="row">
	          <div class="col-lg-8 col-md-10 mx-auto">
	            <ul class="list-inline text-center">
	              <li class="list-inline-item">
	                <a href="#">
	                  <span class="fa-stack fa-lg">
	                    <i class="fas fa-circle fa-stack-2x"></i>
	                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
	                  </span>
	                </a>
	              </li>
	              <li class="list-inline-item">
	                <a href="#">
	                  <span class="fa-stack fa-lg">
	                    <i class="fas fa-circle fa-stack-2x"></i>
	                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
	                  </span>
	                </a>
	              </li>
	              <li class="list-inline-item">
	                <a href="#">
	                  <span class="fa-stack fa-lg">
	                    <i class="fas fa-circle fa-stack-2x"></i>
	                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
	                  </span>
	                </a>
	              </li>
	            </ul>
	            <p class="copyright text-muted">Copyright &copy; Omari Sopromadze 2019</p>
	          </div>
	        </div>
	      </div>
	    </footer>
	
	    <!-- Bootstrap core JavaScript -->
	    <script src="${pageContext.request.contextPath}/assets/front/vendor/jquery/jquery.min.js"></script>
	    <script src="${pageContext.request.contextPath}/assets/front/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	    <!-- Custom scripts for this template -->
	    <script src="${pageContext.request.contextPath}/assets/front/js/clean-blog.min.js"></script>
	    
	    <c:set var="fullUrl" value="${requestScope['javax.servlet.forward.request_uri']}" />
		<c:set var="url" value="${fullUrl.substring(pageContext.request.contextPath.length()) }" />
		
		<c:if test="${url.startsWith('/quiz/')}">
			<script src="${pageContext.request.contextPath}/assets/front/js/quiz.js"></script>
		</c:if>
	    
	</body>
</html>