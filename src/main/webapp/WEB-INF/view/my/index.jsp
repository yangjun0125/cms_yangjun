<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<title>今日头条-个人中心</title>
</head>
<body>
	<div class="table-fluid">
		<div class="row">
			<div class="col-md-12" style="background-color: red; height: 60px;">
				<a href="/"><img alt="" src="/resource/images/111.png" style="height: 60px; width: 65px;
				"></a><span style="color: white; font-family: 华文琥珀; font-size: 20px;">今日头条-个人中心</span>
				<div style="float: right; text-align: center;">
				<c:if test="${null !=sessionScope.user}">


						<div class="btn-group dropleft">
							<button type="button" class="btn btn-link dropdown-toggle btn-sm"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">	<font color="white" size="2px">登录信息</font></button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">${sessionScope.user.username }</a> <a
									class="dropdown-item" href="/my">个人中心</a> <a
									class="dropdown-item" href="/passport/logout">注销</a>
							</div>
						</div>
					</c:if>
					</div>
			</div>
		</div>
		<div class="row" style="padding-top: 5px">
			<div class="col-md-2"><!-- 左侧菜单 -->
				<ul class="list-group">
					<li class="list-group-item active"><a href="#" data="/my/articles"><font color="orange"><b>我的文章</b></font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font color="orange"><b>发布文章</b></font></a></li>
					<li class="list-group-item"><a href="#" data="/my/collectarticles"><font color="orange"><b>我的收藏</b></font></a></li>
					<li class="list-group-item"><a href="#"><font color="orange"><b>我的评论</b></font></a></li>
					<li class="list-group-item"><a href="#"><font color="orange"><b>个人信息</b></font></a></li>
				</ul>
			</div>
			<div class="col-md-10" id="center"><!-- 主要内容显示区域 -->
				<div style="display: none">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$("#center").load("/my/articles");
			$("li").click(function() {
				var url=$(this).children().attr("data");
				$("li").removeClass("active");
				$(this).addClass("list-group-item active");
				//在中间区域显示url
				$("#center").load(url);
			})
		})
	</script>
</body>
</html>