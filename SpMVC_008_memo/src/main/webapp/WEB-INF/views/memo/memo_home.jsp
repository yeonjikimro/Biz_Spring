<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
table {
	margin: 150px auto;
	width: 60%;
}
table tr td {
	text-align: center;
	padding-top: 50px;
	font-size: 25px;
	cursor: pointer;
}
table tr td:hover {
	color: #d4b631;
}
.btn_box a{
	display: inline-block;
	float: right;
	margin-right: 500px;
	color: black;
	font-size: 20px;
	font-weight: 900;
}
.btn_box a:hover {
	color: grey;
}
table th, td {
	margin-top: 50px;	
}
table tr th {
	font-size : 30px;
}


</style>
<%@ include file="../include/header.jsp"%>
<body>

	<div>
		<table class="memo">
		<colgroup>
			<col width="50px">
			<col width="100px">
			<col width="100px">
			<col width="70px">
			<col width="100px">
			
		</colgroup>
		<thead>
		<tr>
			<th>No.</th>
			<th>날짜</th>
			<th>시각</th>
			<th>작성자</th>
			<th>메모내용</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-seq="${MEMO.m_seq}">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
					<td>${MEMO.m_author}</td>
					<td>${MEMO.m_memo}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<div class="btn_box">
			<a href="${rootPath}/memo/insert">메모 등록</a>
		</div>
	</div>

</body>
<script src="${rootPath}/static/js/memo.js?22-06-27-001"></script>
</html>