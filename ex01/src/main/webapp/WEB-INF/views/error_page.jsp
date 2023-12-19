<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>에러발생시 이동하는 페이지</h2>
	<h4>에러메세지</h4>
	<h4><c:out value="${exception.getMessage() }"></c:out></h4>
</body>
</html>