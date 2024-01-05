<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/main/main.js"></script>
<title>메인 화면</title>
</head>
<body>
	<!--
	 	로그인을 한 사용자는 마이페이지, 로그아웃, 게시판보기가 가능 
		로그인을 하지 않은 사용자는 로그인 하기,게시판보기가 가능
	-->
	<%
		if(session.getAttribute("userInfo")==null){
	%>
			<button id="gotoLoginBtn">로그인으로 이동</button>
			<button id="gotoBoardBtn">게시판으로 이동</button>
	<%
		}else{
	%>
			<button id="gotoBoardBtn">게시판으로 이동</button>
			<button id="gotoMypageBtn">마이페이지로 이동</button>
			<button id="gotoLogoutBtn">로그아웃</button>
	<%
		}
	%>
</body>
</html>