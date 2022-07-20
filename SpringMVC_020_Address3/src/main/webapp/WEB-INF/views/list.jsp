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
	margin: 50px auto !important;
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
	margin: 50px auto;
	//width: 60%;
	table-layout: fixed;
}

form {
	width: 800px;
	margin: 20px auto;
}

#button button{
	background-color: blue;
}

table tr th {
	font-size: 20px;
}

table tr td {
	text-align: center;
	padding-top: 30px;
	font-size: 20px;
	cursor: pointer;
	margin-left: 0;
}

table tr td:hover {
	color: #d4b631;
}
a {
	color: inherit;
	list-style: none;
	text-decoration: none;
}
form input {
	margin: 10px auto;
	width: 700px;
	height: 30px;
	padding: 20px;
	
}
a.inse {
	color: black;
	font-weight: 900;
	fonst-size: 20px;
	display: flex;
	margin-left: auto;
	margin-right: 400px;
	border: 1px 1px solid #ccc;
}
a.inse:hover {
	color: #d4b631;
}
</style>

</head>
<body>
	<div class="fon">
		<h1>연지 친구 리스트</h1>
		<h6>친구친구</h6>
	</div>


	<%// form에 한 개의 input box 만 있을 경우 input box에 text를 입력한 후 Enter를 누르면
		// input 박스에 담긴 문자열을 서버로 전송하는 기능이 활성화 된다. %>
	<form>
		<input name="search" placeholder="검색어 입력 후 Enter..."/>
	</form>
		<a class="inse" href="${rootPath}/insert"> 주소 추가하기 </a>
	<table class="list">
		<colgroup>
			<col width="100px"/>
			<col width="200px"/>
			<col width="200px"/>
			<col width="600px"/>
		</colgroup>
		<tr>
			<th>seq</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${ADDS}" var="addr">	
			<tr data-a_seq="${addr.a_seq}">
				<td>${addr.a_seq}</td>
				<td>${addr.a_name}</td>
				<td>${addr.a_tel}</td>
				<td>${addr.a_address}</td>
			</tr>
				
		</c:forEach>
	</table>
	
	<%@ include file= "/WEB-INF/views/pagination.jsp" %>

</body>
</html>