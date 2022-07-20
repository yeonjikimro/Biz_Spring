<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix ="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/detail.js?ver=2022-07-20-008"></script>
<style>
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
	background-color: #f5f5f5;
	display: flex;
	flex-direction: column;
}

header {
	background-color: #cb9ae3;
	color: white;
	height: 200px;
	text-align: center;
}

header h1 {
	font-weight: 900;
	text-shadow: 1px 1px 1px black;
	line-height: 100px;
	
}

nav ul {
	display: flex;
	list-style: none;
	background-color: #c38dd9;
	color: white;
}

nav li {
	padding: 12px 16px;
	margin: 1.5rem;
}

nav a {
	color: inherit;
	text-decoration: none;
}

</style>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>	
</body>
</html>



