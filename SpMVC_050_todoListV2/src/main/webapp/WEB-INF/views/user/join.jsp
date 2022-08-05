<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>join</h1>

	<form:form>
		<h3>아이디 : <input name="id" placeholder="아이디를 입력하세요"></h3>
		<h3>비밀번호 : <input name="password" type="password"></h3>
		<h3>비밀번호 확인 : <input name="re_password" type="password"></h3>
		<h3>이메일 : <input name="email" placeholder="email을 입력하세요"></h3>
		<h3>이름 : <input name="realname" placeholder="이름을 입력하세요"></h3>
		<h3>닉네임 : <input name="nickname" placeholder="nickname을 입력하세요"></h3>
		
		<button>회원가입</button>	
	</form:form>

</body>
</html>