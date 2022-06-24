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
<body>
<form method="POST"  class="write" enctype="multipart/form-data">
	<input name="m_seq" hidden="hidden" value='<c:out value="${MEMO.m_seq}" default="0"></c:out>'>
	
	<div>
		<input name="m_author" placeholder="작성자" type="text" value="${MEMO.m_author}" > 
		<input name="m_date" placeholder="작성일자" type="date" value="${MEMO.m_date}" hidden="hidden"> 
		<input name="m_time" placeholder="작성시각"  type="time" value="${MEMO.m_time}" hidden="hidden">  
		<textarea rows="10" name="m_memo">${MEMO.m_memo}</textarea>
	</div>
	<div>
	<input type="file" name="fileup"/>
	</div>
	
	<button type="submit">저장</button>
</form>
</body>

</html>