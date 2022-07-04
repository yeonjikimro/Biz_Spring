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

	margin: 70px auto;

	height: 100vh;

}

 

div.img_up img {

	display: flex;

	width: 500px;

	margin: 100px auto;

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

 

ul li.de_title {

	font-size: 1em;

	font-weight: 600;

}

 

ul li.day {

	font-size: 0.875em;

	color: #999;

	text-align: center;

	float: right;

}

 

.detail_div ul {

	display: inline-block;

	border-bottom: 1px solid #ddd;

	padding: 20px;

	box-sizing: border-box;

	border-top: 3px solid black;

}

 

.detail_div ul li {

	list-style: none;

	display: inline-block;

}

 

div.author {

	display: flex;

	justify-content: flex-end;

	color: #ccc;

}

 

div.memo_up {

	display: flex;

	margin: 40px auto;

}

 

.memo_to {

	table-layout: fixed;

	margin-bottom: 70px;

}

 

.memo_to img {

	margin-bottom: 10px;

}

</style>

<%@ include file="../include/header.jsp"%>

<body>

	<div class="body">

		<div class="memo_to">

			<img src="${rootPath}/static/image/point_bg01.jpeg">

			<h1>Memo</h1>

		</div>

		<div class="detail_div">

			<ul>

				<li class="de_title">${MEMO.m_title}</li>

				<li class="day">${MEMO.m_date}&nbsp;${MEMO.m_time}</li>

			</ul>

			<div class="author">작성자 : ${MEMO.m_author}</div>

			<div class="img_up">

				<img src="${rootPath}/upload/${MEMO.m_up_image}"

					alt="${MEMO.m_image}">

			</div>

			<div class="memo_up">${MEMO.m_memo}</div>

		</div>

 

		<div class="upde_button">

		

 

	<a href="${rootPath}/memo/${MEMO.m_seq}/update">수정</a> <a

				href="${rootPath}/memo/${MEMO.m_seq}/delete">삭제</a> <a

				href="${rootPath}/memo/memo_home">리스트 보기</a>

		</div>

	</div>

</body>


</html>