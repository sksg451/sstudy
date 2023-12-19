<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if(${not empty alert}){
			alert("${alert}");
		}
	});
</script>
<!-- jquery가 아니라 core를 썻을때
<script type="text/javascript">
	<c:if test="${not empty alert}">
		window.onload = function() {
	    alert("${alert}");
	};
	</c:if>
</script>
 -->
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
		<c:forEach var="vo" items="${boardList}">
			<tr>
				<td><c:out value="${vo.bno }"/></td>
				<td><a href="/board/get?bno=${vo.bno}"><c:out value="${vo.title }"/></a></td>
				<td><c:out value="${vo.content }"/></td>
				<td><c:out value="${vo.writer }"/></td>
				<td><c:out value="${vo.regdate }"/></td>
				<td><a href="/board/remove?bno=${vo.bno }" role="button">삭제</a>
				<td><a href="/board/modify?bno=${vo.bno }" role="button">수정</a>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/board/register">글쓰기</a>
	
	<form method="post" action="/board/list">
		<label>번호</label>
		<input type="text" name="bno"/>
		<button type="submit">수정</button>
	</form>
</body>
</html>