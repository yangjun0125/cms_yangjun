<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>我的文章</title>
</head>
<body>
	<c:forEach items="${info.list }" var="article">
		<div class="media">
			<img alt="..." src="/pic/${article.picture }" class="mr-3 rounded"
				style="width: 200px; height: 150px;">
			<div class="media-body">
				<h5 class="mt-0">${article.title }</h5>
				<div style="float: right; padding-top: 80px; padding-right: 30px;">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-dark" data-toggle="modal"
						data-target="#exampleModalScrollable" onclick="articleDetail(${article.id})">详情</button>
				</div>
			</div>
		</div>
		<hr>
	</c:forEach>
	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalScrollableTitle"><span id="title"></span></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <span id="content"></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script type="text/javascript">
		function articleDetail(id){
			$.get("/my/articleDetail",{id:id},function(article){
				$("#title").empty();
				$("#title").append(article.title);
				$("#content").append(article.content);
			})
		}
	
		function goPage(page) {
			$("#center").load("/my/articles?page=" + page);
		}
	</script>
</body>
</html>