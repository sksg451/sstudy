<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상대경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Get</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	Board Get
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form role="form">
                        	  <div class="form-group">
                                  <label>Bno</label>
                                  <input class="form-control" readonly="readonly" name="bno" value="${board.bno }">
                              </div>
                              <div class="form-group">
                                  <label>Title</label>
                                  <input class="form-control" name="title" value="${board.title }">
                              </div>
							  <div class="form-group">
                                  <label>Contents</label>
                                  <textarea class="form-control" rows="5" cols="40" name="content" >
                                  	${board.content }
                                  </textarea>
                              </div>
                              <div class="form-group">
                                  <label>Writer</label>
                                  <input class="form-control" name="writer" readonly="readonly" value="${board.writer }">
                              </div>
                              
                              <!-- 사용자 지정 속성(커스텀 데이터 속성) -->
                              <button type="button" class="btn btn-default" data-oper = "modify">Modify Complete</button>
                              <button type="button" class="btn btn-default" data-oper = "remove">Delete</button>
                              <button type="button" class="btn btn-default" data-oper = "list">List</button>
                            </form>
                        </div>
                     </div>
                  </div>       
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        
<script type="text/javascript">
	$(document).ready(function() {
		
		let formObj = $("form");
		$(".btn").click(function() {
			let operation = $(this).data("oper");
			console.log(operation);
			
			if(operation == "list"){
				formObj.attr("action","/board/list")
				.attr("method","get");
			}else if(operation == "remove"){
				formObj.attr("action","/board/remove")
					.attr("method","get");
				// formObj.submit(); remove랑 modify쪽에 둘다 이걸 넣어줘야하지만 밖에 하나만 넣음
			}else if(operation == "modify"){
				formObj.attr("action","/board/modify")
				.attr("method","post");
			}
			formObj.submit();
		});
	});
</script>       

<%@include file="../includes/footer.jsp"%>