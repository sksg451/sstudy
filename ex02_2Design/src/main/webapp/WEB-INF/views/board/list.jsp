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
											<th>delete</th>
											<th>modify</th>
										</tr>
                                </thead>
                                <c:forEach var="vo" items="${boardList}">
									<tr>
										<td><c:out value="${vo.bno }"/></td>
										<td><a href="/board/get?bno=${vo.bno}"><c:out value="${vo.title }"/></a></td>
										<td><c:out value="${vo.content }"/></td>
										<td><c:out value="${vo.writer }"/></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${vo.regdate }"/></td>
										<td><a href="/board/remove?bno=${vo.bno }" role="button">삭제</a>
										<td><a href="/board/modify?bno=${vo.bno }" role="button">수정</a>
									</tr>
								</c:forEach>
                                <tbody>
                                    
                                </tbody>
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
	});
</script>
<%@include file="../includes/footer.jsp"%>