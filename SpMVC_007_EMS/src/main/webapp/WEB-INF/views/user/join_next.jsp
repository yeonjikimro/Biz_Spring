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
		<form:input path="email"/><br/>
		
		<form:input path="key" placeholder="인증키"/><br/>
		<c:if test = "${not empty error }">
			<p>인증키가 잘못되었습니다</p>
		</c:if>
		
		<br/><form:input path="username" placeholder="USER NAME"/>		
		<form:input path="password" type="password"/>
		<input name="re_password" id="re_password" />
		<form:input path="name"/>
		<button>회원가입</button>
	</form:form>

</body>
</html>