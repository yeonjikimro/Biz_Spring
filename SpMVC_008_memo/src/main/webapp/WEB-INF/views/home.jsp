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
	<div>
		<table class="memo">
				<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
					<tr data-seq="${MEMO.m_seq}">
						<td>${INDEX.count}</td>
						<td>${MEMO.m_memo}</td>
						<td>${MEMO.m_author}</td>
						<td>${MEMO.m_date}</td>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
		<div class="btn_box">
			<a href="${rootPath}/insert">도서정보추가</a>
		</div>
	</div>

</body>
<script src="${rootPath}/static/js/memo.js?22-06-04"></script>
</html>