<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>${param.title }</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />

    <link href="${pageContext.request.contextPath}/assets/css/animate.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  Fonts and icons     
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

	<c:set var="fullUrl" value="${requestScope['javax.servlet.forward.request_uri']}" />
	<c:set var="url" value="${fullUrl.substring(pageContext.request.contextPath.length() + 1) }" />
	
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="${pageContext.request.contextPath}"><span class="simple-text">Quiz App</span></a>
            </div>

            <ul class="nav">
                <li class="${url == 'dashboard' ? 'active' : ''}">
                    <a href="${pageContext.request.contextPath}/dashboard">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="${url == 'profile' ? 'active' : ''}">
                    <a href="${pageContext.request.contextPath}/profile">
                        <i class="ti-user"></i>
                        <p>My Profile</p>
                    </a>
                </li>
                <c:if test="${loggedInUser.roleId == 1}">
	                <li class="${url == 'users' ? 'active' : ''}">
	                    <a href="${pageContext.request.contextPath}/users">
	                        <i class="ti-view-list-alt"></i>
	                        <p>User List</p>
	                    </a>
	                </li>
                </c:if>
                
                <c:if test="${loggedInUser.roleId == 1 or loggedInUser.roleId == 2}">
	                <li class="${url == 'add-quiz' ? 'active' : ''}">
	                    <a href="${pageContext.request.contextPath}/add-quiz">
	                        <i class="ti-pencil-alt"></i>
	                        <p>Add / Edit Quiz</p>
	                    </a>
	                </li>
                </c:if>
            </ul>
    	</div>
    </div>
    
    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                    
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fas fa-user"></i>
									<p>${loggedInUser.username }</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                              		<li><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
									<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                              </ul>
                        </li>
                        
                    </ul>

                </div>
            </div>
        </nav>