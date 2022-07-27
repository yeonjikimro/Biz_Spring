<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
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
form {
	margin: 30px auto;
}
form input {
	height: 30px;
	margin-top: 20px;
}
#button {
	background-color: 
}
</style>
<form method="POST">
	<input name="a_seq" type="hidden"
		value='<c:out value="${ADD.a_seq}" default="0" />' /> <input
		name="a_name" placeholder="이름" value="${ADD.a_name}" /> <input
		name="a_tel" placeholder="전화번호" value="${ADD.a_tel}" /> <input
		name="a_address" placeholder="주소" value="${ADD.a_address}" />
	<button id="button" type="submit">저장</button>
</form>
