<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<style>
.body {
	display: flex;
	flex-direction: column;
	width: 60%;
	height: 60%;
	padding: 100px; 
	border : 1px solid #ccc;
	margin: 50px auto;
	border: 1px solid #ccc;
}

div.img_detail {
	display: flex;
	justify-content: space-evenly;
}

div img {
	display: flex;
	justify-content: flex-end;
	width: 500px;
	height: 250px;
}

.detail_div {
	display: flex;
	flex-direction: column;
	font-size: 20px;
}
.detail_div div {
	margin: 10px;
}

.upde_button {
	display: flex;
	justify-content: flex-end;
	margin-top: 100px;
	font-weight: 900;
}

.upde_button a {
	margin-right: 30px;
	color: black;
	font-size: 20px;
}

.upde_button a:hover {
	color: #d4b631;
}
</style>
<%@ include file="../include/header.jsp"%>
<body>
	<div class="body">
		<div class="img_detail">
			<div class="detail_div">
				<div>작성자 : ${MEMO.m_author}</div>
				<div>작성일자 : ${MEMO.m_date}</div>
				<div>작성시각 : ${MEMO.m_time}</div>
				<div>메모 : ${MEMO.m_memo}</div>
			</div>
			<div>
				<img src="${rootPath}/upload/${MEMO.m_up_image}"
					alt="${MEMO.m_image}">
			</div>
		</div>
		<div class="upde_button">
			<a href="${rootPath}/memo/${MEMO.m_seq}/update">수정</a> <a
				href="${rootPath}/memo/${MEMO.m_seq}/delete">삭제</a> <a
				href="${rootPath}/memo/memo_home">리스트 보기</a>
		</div>
	</div>
</body>
</html>