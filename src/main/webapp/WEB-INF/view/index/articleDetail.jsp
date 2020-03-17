<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>${article.title }</title>
<meta name="keywords" content="${article.keywords }">
<meta name="original" content="${article.original }">
</head>
<body>
		<div class="table-fluid">
		<div class="row">
			<div class="col-sm-12"
				style="background-color: black; height: 30px; padding-left: 20px;">
				<span style="color: white; font-family: 华文琥珀; font-size: 20px;">下载APP</span>
			</div>
		</div>
		<div class="row">
			<!--左侧栏目  -->
			<div class="col-sm-2" style="padding-top: 15px;">
				
			</div>
			<!--中间栏目  -->
			<div class="col-sm-7" style="padding-top: 15px;">
				<h3>${article.title }</h3>
				<p>${article.user.username }<fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p>${article.content }</p>
					
				<c:if test="${collect!=null}">
				 <button type="button" onclick="deleteCollect()" class="btn btn-link">★&nbsp;  取消收藏</button>
				</c:if>
				<c:if test="${collect==null}">
				     <button type="button" onclick="collect(1)" class="btn btn-link">☆ &nbsp;  未收藏</button>
				</c:if>
					
				<hr>
				<c:if test="${null !=sessionScope.user}">
				<div class="col-md-7">
				<h3>文章评论:</h3>
					<textarea rows="7" cols="7" style="width: 773px;" name="content"></textarea>
					<button type="button" onclick="addcomment()" 
					class="btn btn-success">提交</button>
				</div>
				</c:if>
				<div>
					<c:forEach items="${info.list }" var="comment">
						<hr>
						<p>${comment.user.username} 
						<fmt:formatDate value="${comment.created }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						${comment.content} 
					</c:forEach>
				</div>
			</div>
			<!--右侧栏目  -->
			<div class="col-sm-3">
				<div class="card" style="width: 18rem; margin-top: 6px">
					<div class="card-header">评论排行榜</div>
					<div class="card-body">
						<!-- 最新文章 --10篇 -->
						<c:forEach items="${info2.list}" var="article" varStatus="i">
						 <p>  ${i.count} ${article.title }</p>
							
						
						</c:forEach>
					</div>
				</div>
			
			
			</div>
			</div>
		</div>
	
	<script type="text/javascript">
	
	
	$(function(){
		$.post("/openlog",{articleId:'${article.id }'},function(flag){
			if(flag){
				alert("访问加1");
			}
		})
	})
	
	
	function deleteCollect(){
		
		var id ='${collect.id}';
		$.post("/deleteCollect",{id:id},function(flag){
			if(flag){
				alert("取消收藏成功");
				window.location.reload();
			}else{
				alert("取消收藏收藏失败，需要登录后才能取消收藏")
			}
		})
		
	}

	function collect(){
		//文章标题
		var title ='${article.title}';
		//文章的url
		
		var url=window.location.href;
		$.post("/collect",{text:title,url:url},function(flag){
			if(flag){
				alert("收藏成功");
				window.location.reload();
			}else{
				alert("收藏失败，需要登录后才能收藏")
			}
		})
		
	}
		
		function addcomment() {
			var articleId='${article.id}';
			var content=$("[name='content']").val();
			$.post("/addComment",{articleId:articleId,content:content},function(flag){
				if(flag){
					alert("评论成功");
					location.reload();
				}else{
					alert("评论失败,需要登录")
				}
			})
		}
	</script>
</body>
</html>