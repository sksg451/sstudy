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
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>regdate</th>
			<th>delete</th>
			<th>modify</th>
		</tr>
			<tr>
				<td><c:out value="${board.bno }"/></td>
				<td><c:out value="${board.title }"/></td>
				<td><c:out value="${board.content }"/></td>
				<td><c:out value="${board.writer }"/></td>
				<td><c:out value="${board.regdate }"/></td>
				<td><a href="/board/remove?bno=${board.bno }" role="button">삭제</a>
				<td><a href="/board/modify?bno=${board.bno }" role="button">수정</a>
			</tr>
	</table>
</body>
</html>