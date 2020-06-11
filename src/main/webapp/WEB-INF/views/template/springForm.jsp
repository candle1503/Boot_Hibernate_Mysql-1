<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form modelAttribute="boardVO" action="${board}${path}" method="post" enctype="multipart/form-data">
	  <form:input path="num" type="hidden" id="num" name="num"/>
	  <div class="form-group">
	    <label for="title">title</label>
	    <form:input path="title" type="text" class="form-control" id="title"/>
	  	<form:errors path="title" cssClass="r"/>
	  </div>
	  <div class="form-group">
	    <label for="writer">writer</label>
	    <form:input path="writer" type="text" class="form-control" id="writer"/>
	    <form:errors path="writer"/>
	  </div>
	  <div class="form-group">
	    <label for="contents">contents</label>
	    <form:textarea path="contents" cols="" rows="" class="form-control" id="contents"/>
	  	<form:errors path="contents"/>
	  </div>
	  
	  <input type="button" id="add" class="btn btn-info" value="fileAdd">
	  <div id="f" class="form-group"></div>
	  
	  <button type="submit" class="btn btn-default">Submit</button>
	</form:form>
