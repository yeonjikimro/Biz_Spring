<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		width: 50%;
		text-align: center;
		margin-left: 100px;
	}
	input {
		padding : 1rem;
		width: 100%;
	}

	h1 { margin: 20px;}
</style>
</head>
<%@ include file="../include/header.jsp"%>
<body>
	<form method="post">
	<h1>LOGIN</h1>
		<input name="username" placeholder="USERNAME 입력 후 Enter를 치세요">	
	</form>
</body>
</html>