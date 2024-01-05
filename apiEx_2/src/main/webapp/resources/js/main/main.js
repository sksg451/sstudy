main={};

$(document).ready(function(){
	
	$("#gotoLoginBtn").click(function(){
		location.href="/";
	});
	
	$("#gotoLogoutBtn").click(function(){
		location.href="/logout";
	});
	
	$("#gotoBoardBtn").click(function(){
		alert("게시판으로 이동");
	});
	
	$("#gotoMypageBtn").click(function(){
		alert("마이페이지로 이동");
	});
});