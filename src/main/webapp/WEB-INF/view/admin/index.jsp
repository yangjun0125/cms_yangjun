<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="table-fluid">
		<div class="row" style="background-color: #009FD9; height: 55px;">
			<div class="col-md-12">
				<img alt="" src="/resource/images/111.png" style="height: 55px; width: 65px; 
				"><span style="color: white; font-family: 华文琥珀; font-size: 20px;">今日头条-管理员中心</span>
				
				<div style="float: right; text-align: center;">

					<c:if test="${null !=sessionScope.admin}">


						<div class="btn-group dropleft">
							<button type="button" class="btn btn-link dropdown-toggle btn-sm"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">	<font color="white" size="2px">登录信息</font></button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">${sessionScope.admin.username }</a><a
									class="dropdown-item" href="/passport/logout">注销</a>
							</div>
						</div>
					</c:if>
					
				</div>
			</div>		
		</div>
		<div class="row" style="padding-top: 10px;">
			<div class="col-md-2 rounded"
			style="text-align:center;">
				<nav class="nav flex-column">
				  <a class="list-group-item active" href="#" data="admin/articles">文章审核</a>
				  <a class="list-group-item" href="#" data="admin/users">用户管理</a>
				  <a class="list-group-item" href="#">栏目管理</a>
				  <a class="list-group-item" href="#">分类管理</a>
				  <a class="list-group-item" href="#">系统设置</a>
				</nav>
			</div>		
			<div class="col-md-10" id="center">
			
			</div>		
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		$("#center").load("/admin/articles");
		$("a").click(function() {
			var url=$(this).attr("data");
			$("a").removeClass("active");
			$(this).addClass(" list-group-item active");
			//在中间区域显示url
			$("#center").load(url);
		})
	})
	</script>
</body>
</html>