<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다.</h1>
	<!-- isAuthenticated : 로그인이 되었을 때만 보여라 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username"/>
		<sec:authentication property="principal.email"/>
		<sec:authentication property="principal.realname"/>	
	</sec:authorize>
	
	<form:form class="logout" action="${rootPath}/logout" >
		<button>로그아웃</button>
	</form:form>
</body>
</html>