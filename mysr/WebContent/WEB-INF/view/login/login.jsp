<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="loginResult">
		<table>
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="userId" />
				</td>
				<td rowspan="2">
					<input type="button" value="Login" onclick="this.form.submit();"/>
				</td>
			</tr>
			<tr>
				<td>PW</td>
				<td>
					<input type="password" name="userPw" />
				</td>
			</tr>
			<c:if test="${not empty msg}">
				<tr>
					<td colspan="2">${msg}</td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>













