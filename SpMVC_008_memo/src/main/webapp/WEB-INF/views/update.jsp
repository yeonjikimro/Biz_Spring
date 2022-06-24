<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정하기</h1>
	<form method="POST" modelAttribute="memoVO" class="write" enctype="multipart/form-data">

		<div>
			<textarea rows="10" name="m_memo">${MEMO.m_memo}</textarea>
		</div>
		<div>
			<input type="file" name="fileup" />
		</div>

		<button type="submit">수정하기</button>
	</form>
</body>
</html>