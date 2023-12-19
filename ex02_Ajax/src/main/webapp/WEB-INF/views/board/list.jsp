<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상대경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">글작성</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    	<tr>
											<th>bno</th>
											<th>title</th>
											<th>content</th>
											<th>writer</th>
											<th>regdate</th>
										</tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                            
                            <!-- /.table-responsive -->
                        </div>
                     </div>
                  </div>       
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        
		<!-- 사용자에게 보여줄 안내 문구 창 -->
		<div id="myModal" class="modal" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Modal title</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>Modal body text goes here.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary">Save changes</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
<script type="text/javascript">
	$(document).ready(function() {
		loadTableData();
		
		let result = '${alert}';
		console.log(result);
		checkModal(result);
		function checkModal(result) {
			if(result==''){
				return;
			}
			// 수정,삭제 시 메세지
			if(result == "success"){
				$(".modal-body").html("정상처리완료");
			// 글 등록 시 메세지
			}else if(parseInt(result)>0){
				$(".modal-body").html(parseInt(result)+"번 글이 등록 되었습니다.");
			}
			$("#myModal").modal("show");
		}
		$("#regBtn").click(function() {
			self.location = "/board/register";
		});
		
		function loadTableData(){
			$.ajax({
				url: "/board/getList",
				type: "POST",
				dataType : "json",
				success:function(data){
					// 아래에 $("tbody") 부분에 원래 #boardTbody있었는데 일단 안나와서 지움
					let boardTbody = $("tbody");
					// for( let item of items) -> 여기서 items 은 data와 같고 item은 board와 같음
					$.each(data, function(index,board){
						let regDate = new Date(board.regdate);
						let options = {year:"numeric",month:"2-digit", day:"2-digit", hour:"2-digit",minute:"2-digit"}
						let formatDate = regDate.toLocaleString("ko-KR",options);
						
						let row = $("<tr>");
						row.append($("<td>").text(board.bno));
						
						let titleLink = $("<a>").attr("href","/board/get?bno="+board.bno).text(board.title);
						let titleTd = $("<td>").append(titleLink);
						row.append($("<td>").text(titleLink));
						row.append($("<td>").text(board.content));
						row.append($("<td>").text(board.writer));
						row.append($("<td>").text(formatDate));
						
						
						boardTbody.append(row);
					});
				},
				error: function(e) {
					console.log(e);
				}
			});
		}// loadTableData 함수 선언 종료
		
	}); // $(document).ready 함수 선언 종료
</script>
<%@include file="../includes/footer.jsp"%>