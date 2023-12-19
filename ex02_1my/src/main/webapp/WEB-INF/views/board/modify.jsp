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
	<form method="post" action="/board/modify">
		<h1>게시글 수정</h1>

		<label>제목</label>
		<input type="text" name="title" value="${board.title }"/>
		<label>내용</label>
		<textarea rows="3" cols="50" name="content">${board.content }</textarea>
		
		
		<input type="hidden" type="text" name="bno" value="${board.bno }"/>
		<input type="hidden" type="text" name="writer" value="${board.writer }"/>
		
		<button type="submit">수정</button>
		<input type="reset" value="다시하기">
	</form>
</body>
</html>