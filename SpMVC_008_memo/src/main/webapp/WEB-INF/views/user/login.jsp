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
<<<<<<< HEAD
	form {
		width: 50%;
		text-align: center;
		display: inline-block;
		margin-top : 300px;
		margin-left : 500px;
=======
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	html {
		width: 100vw;
		height: 100vh;
	}
	body {
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	form {
		width: 50%;
		text-align: center;
>>>>>>> 60bc61ab5f327f32b0c405442bc3fee930d635b8
	}
	input {
		padding : 1rem;
		width: 100%;
	}
<<<<<<< HEAD
	h1 { margin: 20px;}
</style>
</head>
<%@ include file="../include/header.jsp"%>
<body>
	<form method="post">
	<h1>LOGIN</h1>
		<input name="username" placeholder="USERNAME 입력 후 Enter를 치세요">	
	</form>


=======
</style>
</head>
<body>
	<form method="post">
		<input name="username" placeholder="USERNAME 입력 후 Enter를 누르시오">	
	</form>
>>>>>>> 60bc61ab5f327f32b0c405442bc3fee930d635b8
</body>
</html>