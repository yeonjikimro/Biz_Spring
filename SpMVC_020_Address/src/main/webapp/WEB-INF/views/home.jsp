<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	width: 100%;
	height: 100%;
	background-color: #f5f5f5;
}

.fon {
	margin: 100px auto !important;
	width: 300px;

}

div.fon h1, h6 {
	display: inline-block;
	color: #d4b631;
}

input {
	hegith: 30%;
}

table {
	margin: 100px auto;
	width: 60%;
	table-layout: fixed;
}

form {
	width: 800px;
	margin: 20px auto;
}

#button button{
	background-color: blue;
}

table tr td {
	text-align: center;
	padding-top: 50px;
	font-size: 20px;
	cursor: pointer;
}

table tr td:hover {
	color: #d4b631;
}
</style>
</head>
<body>
	<div class="fon">
		<h1>연지 친구 리스트</h1>
		<h6>친구친구</h6>
	</div>

	<form method="POST">
		<input name="a_seq" type="hidden"
			value='<c:out value="${ADD.a_seq}" default="0" />' /> <input
			name="a_name" placeholder="이름" value="${ADD.a_name}" /> <input
			name="a_tel" placeholder="전화번호" value="${ADD.a_tel}" /> <input
			name="a_address" placeholder="주소" value="${ADD.a_address}" />
		<button id="button" type="submit">저장</button>
	</form>
	<table>
		<tr>
			<th>seq</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${ADDS}" var="addr">
			<tr>
				<td><a href="${rootPath}/detail?seq=${addr.a_seq}">${addr.a_seq}</a></td>
				<td>${addr.a_name}</td>
				<td>${addr.a_tel}</td>
				<td>${addr.a_address}</td>
			</tr>
		</c:forEach>
	</table>
	
	<%@ include file= "/WEB-INF/views/pagination.jsp" %>

</body>
</html>