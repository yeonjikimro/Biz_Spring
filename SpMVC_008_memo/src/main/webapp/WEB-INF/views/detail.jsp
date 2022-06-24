<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<body>
	<header>
		<h1>MEMO</h1>
	</header>
	<section>
		<div>
			<div class="detail">
				<h2>메모장</h2>
				<p>NO : ${MEMO.m_seq} </p>
				<p>작성자 : ${MEMO.m_author}</p>
				<p>작성일자 : ${MEMO.m_date}</p>
				<p>작성시각 : ${MEMO.m_time}</p>
				<p>작성내용 : ${MEMO.m_memo}</p>	
				<img src="${rootPath}/upload/${MEMO.m_image}">
			</div>
			<div class="btn-box">
				<a href="${rootPath}/home" class="list">리스트</a>
				<a href="${rootPath}/${MEMO.m_seq}/update" class="update">수정</a>
				<a href="${rootPath}/${MEMO.m_seq}/delete" class="delete">삭제</a>
			</div>
		</div>
	</section>
</body>

</html>