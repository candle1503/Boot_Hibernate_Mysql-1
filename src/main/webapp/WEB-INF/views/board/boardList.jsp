<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<h2>${board}List</h2>
		<form id="frm" class="col-sm-4" action="./${board}List">
			<input type="hidden" name="curPage" id="p">
			<div class="input-group">
				<select class="form-control" id="sel1" name="kind">
					<option id="title" value="title">title</option>
					<option id="writer" value="writer">writer</option>
					<option id="contents" value="contents">contents</option>
				</select> 
				<input type="text" class="form-control" placeholder="Search" name="search" value="${param.search}">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
		<table class="table talbe-hover">
			<!-- 모바일 웹같은 곳에서는 ul / li 를 테이블 대신 씀 -->
			<tr>
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Contents</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>

			<c:forEach items="${page.content}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td>
						<%-- <c:catch>
							<c:forEach begin="1" end="${vo.dept}" var="i">
								ㄴ	
							</c:forEach>
						</c:catch> --%> <a href="${board}Select?num=${vo.num}">${vo.title}</a>
					</td>
					<td>${vo.writer}</td>
					<td>${vo.contents}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<span><a href="#" class="custompager" title="0">&lt;&lt;</a></span>
			<span><a href="#" class="custompager" title="${page.number-1}"> &lt;</a></span>
			<c:forEach begin="${page.number}" end="${page.number+4}" var="i">
				
				<c:if test="${i lt page.totalPages}">
					<a href="#" class="custompager" title="${i}">${i+1}</a>
				</c:if>
			</c:forEach>
			<span><a href="#" class="custompager" title="${page.number+1}">&gt;</a></span>
			<span><a href="#" class="custompager" title="${page.totalPages-1}">&gt;&gt;</a></span>
			
		</div>

		<a href="./${board}Write" class="btn btn=danger">write</a>
	</div>
	<script type="text/javascript">
		$(".custompager").click(function(){
			alert("ddd");
			var page=$(this).attr("title");
			$("#p").val(page*1+1);
			$("#frm").submit();
		});
	

		var kind = '${param.kind}';
		if(kind == ''){
			$("#title").prop("selected", true);
		}else {
			$("#"+kind).prop("selected", true);
		}
		




		var result = '${result}';
		if(result != '') {
			if(result == 1) {
				alert("게시글 쓰기 성공");
			} else {
				alert("게시글 쓰기 실패");
			}
		}
	</script>
</body>
</html>