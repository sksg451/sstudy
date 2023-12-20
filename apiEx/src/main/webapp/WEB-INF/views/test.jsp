<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>기상청_단기예보 ((구)_동네예보) 조회서비스</title>
<style type="text/css">
	table,td,th {
		border: 1px solid black
	}
</style>
</head>
<body>
	<h1>기상청_단기예보 조회서비스</h1>
	<button onclick="ajaxTest()">검색</button>
	
	<table id="resultArea"></table>
	
	<script type="text/javascript">
		function ajaxTest() {
			$("#resultArea").empty();
			$.ajax({
				url : "ajaxTest",
				type : "GET",
				data : "",// view에서 전달할 데이터가 없는경우 컨트롤러가 받는 값은 빈 문자열
				contentType: "application/json; charset=utf-8;",//서버로 보내는 데이터 유형 지정
				dataType : "json", // 서버에서 응답하는 데이터 유형
				success: function(data) {
					console.log(data.response.body.items.item);
					let html = "";
					
					html += "<tr>";
					for(let key in data.response.body.items.item[0]){
						html += "<th>"+key+"</th>";
					}
					html += "</tr>";
					
					for(let i of data.response.body.items.item){
						html += "<tr>";
						for(let key in i){
							html += "<td>"+i[key]+"</td>";
						}
						html += "</tr>";
					}
					$("#resultArea").append(html);
				},
				error: function(e) {
					console.log(e);
				}
				
			});
		}
	</script>
	
</body>
</html>