<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="${rootPath}/static/js/fileup_name.js?22-06-29-002"></script>
<style>
form {
	width: 100%;
	text-align: center;
	display: flex; 
	flex-direction : column; 
	align-items : center;
	margin-top: 150px;
	justify-content: center;
}

.fileup {
	display: inline-block;
	float: right;
	margin-top: 30px;
}

.fileup .upload-name {
	margin: 50px auto;
	display: inline-block;
	height: 40px;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 60%;
	color: #999999;
}

.fileup label {
	display: inline-block;
	padding: 10px 20px;
	color: #fff;
	vertical-align: middle;
	background-color: #999999;
	cursor: pointer;
	height: 40px;
}

button {
	height: 40px;
	width: 70px; font-size : 20px;
	border: none;
	vertical-align: middle;
	font-size: 20px;
}

button:hover {
	background-color: #d4b631;
	cursor: pointer;
}

textarea {
	font-size: 20px;
	height: 300px;
}

form h2 {
	font-size: 20px;
	margin-bottom: 10px;
	text-align: left;
	color: #ccc;
}

h2 {
	display: inline-block;
	margin-right: 30px;
}

div.title {
	display: flex;
	justify-content: center;
	align-items: left;
	margin-bottom: 20px;
}

div.title input {
	width: 500px;
	height: 30px;
}
</style>
<%@ include file="../include/header.jsp"%>
<body>
	<form method="POST" class="write" enctype="multipart/form-data">
		<input name="m_seq" hidden="hidden"
			value='<c:out value="${MEMO.m_seq}" default="0"></c:out>'>
		<div class="title">
			<h2>제목</h2>
			<input value="${MEMO.m_title}" name="m_title" placeholder="제목을 입력하세요" />
		</div>
		<textarea name="m_memo" cols="100" rows="30" placeholder="메모를 입력하세요">${MEMO.m_memo} </textarea>
		<div class="fileup">
			<label for="upload-name">파일찾기 </label> <input id="upload-name"
				name="file" type="file" accept="images/*" style="display: none;">
			<button type="submit">저장</button>
		</div>
	</form>
</body>

</html>