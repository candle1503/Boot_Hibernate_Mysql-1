<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>
	<c:if test="${not empty sessionScope.member}">
		<div id="memberId" style="display:none;" data-id="${member.id}"></div>
	</c:if>	
	<c:if test="${empty sessionScope.member}">
		<div id="memberId" style="display:none;" data-id="none"></div>
	</c:if>
	
	<div class="container">		
	<h2>${board}${path}</h2>
		<c:import url="../template/boardForm.jsp"></c:import>
	</div>
	<script type="text/javascript">

		$(function() {

			var memberId = $('#memberId').data("id");
			console.log(memberId);
			
			if(memberId != 'none') {

				$('#writer').val(memberId);
			}
		});
	</script>
</body>
</html>