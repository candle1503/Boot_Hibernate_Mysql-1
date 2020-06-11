<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<form action="${board}${path}" method="post" enctype="multipart/form-data">
	  <input type="hidden" id="num" name="num" value="${vo.num}">
	  <div class="form-group">
	    <label for="title">title</label>
	    <input type="text" class="form-control" id="title" name="title" value="${vo.title}">
	  </div>
	  <div class="form-group">
	    <label for="writer">writer</label>
	    <input type="text" class="form-control" id="writer" name="writer" value="${vo.writer}">
	  </div>
	  <div class="form-group">
	    <label for="contents">contents</label>
	    <textarea cols="" rows="" class="form-control" id="contents" name="contents">${vo.contents}</textarea>
	  </div>
	  
	  <input type="button" id="add" class="btn btn-info" value="fileAdd">
	  <div id="f" class="form-group"></div>
	  
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
