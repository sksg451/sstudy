login = {}; 
/* 그냥 js에서 첫번째 줄은 이렇게 해주는게 좋음 */
/*  
* 로그인 객체 초기화 
* 로그인 프로세스와 관련된 변수 및 함수를 모두 담겠다는 뜻(캡슐화)
* 캡슐화 : 서로 연관된 속성과 기능을 묶어서 관리(관리가 편해짐),
*	보호(데이터를 외부로부터 보호)
* 모듈화 : 관련된 기능을 그룹화(관리용이)
* 네임스페이스를 분리 -> 변수 및 함수명 충돌 방지 및 오버라이딩 방지
* 로그인 관련 기능 추가 시 login객체에 새로운 함수나 속성 추가 가능-> 확장용이
*/

$(document).ready(function(){
	$("#loginBtn").click(function(){
		alert("로그인 버튼 클릭");
		login.chkLogin();
	});
	
	$("#gotoMainBtn").click(function(){
		location.href="/main";
	});
	
	$("#userPw").keyup(function(event){
		// 13은 Enter
		if(event.keyCode == 13){
			$("#loginBtn").trigger("click");
		}
	});
	
});
	login.chkLogin = function(){
		let param = {
			userId : $("#userId").val(),
			userPw : $("#userPw").val()
		}
		
		$.ajax({
			url : "/chkLoginAjax",
			type : "POST",
			data : param,
			success : function(data){
				if(data=="success"){
					location.href = "/main";
				}else{
					alert("올바른 로그인 정보가 아닙니다.");
				}
			},
			error : function(e){
				console.log(e);
			}
		});
	}