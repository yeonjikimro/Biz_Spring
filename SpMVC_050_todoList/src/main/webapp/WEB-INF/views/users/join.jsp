<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<input name="username" placeholder="USERNAME" />
		<input name="password" type="password" /> 
		<input name="re_password" type="password" />
		<input name="realname" placeholder="실명 입력" />
		<input name="nickname" placeholder="닉네임 입력" />
		<input name="email" placeholder="E-mail" />
		<button>회원가입</button>
	</form:form>

</body>
</html>