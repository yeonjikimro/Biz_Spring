<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="userVO">
		<h1>회원가입</h1>
		<p>회원가입을 위하여 Email 을 입력한 후 인증하여 주세요</p>
		<form:input path="email" type="email" />
		<form:errors path="email" />
		<button>이메일 인증</button>
	</form:form>

</body>
</html>