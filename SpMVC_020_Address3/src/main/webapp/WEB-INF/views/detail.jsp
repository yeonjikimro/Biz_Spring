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
}

.body {
	display: flex;
	flex-direction: column;
	width: 60%;
	margin: 70px auto;
	height: 100vh;
}


}
.detail_div {
	display: flex;
	flex-direction: column;
	font-size: 20px;
}

.upde_button {
	display: flex;
	justify-content: flex-end;
	font-weight: 900;
	border-bottom: 3px solid black;
	border-top: 1px solid #ddd;
	padding: 20px;
}

.upde_button a {
	margin-right: 30px;
	color: black;
	font-size: 20px;
}

.upde_button a:hover {
	color: #d4b631;
}

.de_title {
	font-size: 30px;
	margin: 10px auto;
	width: 500px;
}
.de_title h3 {
	display: inline-block;
}

.detail_div {
	border-bottom: 1px solid #ddd;
	padding: 20px;
	box-sizing: border-box;
	border-top: 3px solid black;
}
.de_title span {
	color: #d4b631;
	padding-right: 20px;
}
.memo_to {
	margin: 70px auto;
	table-layout: fixed;

}


</style>
</head>
<body>
<div class="body">
		<h1 class="memo_to">Hi</h1>
	<div class="detail_div">
		<h3 class="de_title"><span>이름 :</span> ${ADD.a_name}</h3>
		<h3 class="de_title"><span>전화번호 : </span>${ADD.a_tel}</h3>
		<h3 class="de_title"><span>주소 : </span>${ADD.a_address}</h3>
	</div>
	<div class="upde_button">
		<a href="${rootPath}/update?seq=${ADD.a_seq}">수정하기</a> <a
			href="${rootPath}/delete?seq=${ADD.a_seq}">삭제하기</a> <a
			href="${rootPath}/">처음으로</a>
	</div>
</div>
</body>
</html>