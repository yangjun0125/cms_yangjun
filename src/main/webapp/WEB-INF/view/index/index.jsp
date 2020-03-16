<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/resource/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>今日头条-首页</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12"
				style="background-color: black; height: 30px; padding-left: 20px; padding-top: 2px">
				<span style="color: white; font-family: 华文琥珀; font-size: 20px;">下载APP</span>
				<div style="float: right; text-align: center;">
					
						<c:if test="${null==sessionScope.user}">
						<button type="button" class="btn btn-link btn-sm" onclick="reg()"
							data-toggle="modal" data-target="#exampleModal"><font color="white" >注册</font></button>
						<button type="button" class="btn btn-link btn-sm" onclick="login()"
							data-toggle="modal" data-target="#exampleModal"><font color="white">登录</font></button>
					</c:if>
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
		<div class="row">
			<!--左侧栏目  -->
			<div class="col-sm-2" style="padding-top: 15px;">
				<ul>
					<li><a href="/"><img alt=""
							src="/resource/images/logo-index.png" class="logo"></a></li>
					<li class="channel-item"><a href="/?hot=1"
						class="channel-item ${article.channelId==null?'active':'' }">热点</a></li>
					<c:forEach items="${channels }" var="channel">
						<li class="channel-item"><a href="/?channelId=${channel.id }"
							class="channel-item ${article.channelId==channel.id?'active':'' }">${channel.name }</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--中间栏目  -->
			<div class="col-sm-7">
				<c:if test="${article.channelId==null}">

					<div style="margin: 5px 5px 5px 5px">
						<div id="carouselExampleCaptions" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<c:forEach items="${slides }" var="slide" varStatus="i">
									<li data-target="#carouselExampleCaptions"
										data-slide-to="${i.index}" class="active"></li>
								</c:forEach>
							</ol>
							<div class="carousel-inner">
								<c:forEach items="${slides }" var="slide" varStatus="i">
									<div class="carousel-item ${i.index==0?'active':'' }">
										<img src="/pic/${slide.url }" class="d-block w-100 rounded"
											alt="..." style="width: 350px; height: 320px">
										<div class="carousel-caption d-none d-md-block">
											<h5>${slide.title }</h5>
										</div>
									</div>
								</c:forEach>
							</div>
							<a class="carousel-control-prev" href="#carouselExampleCaptions"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>

					</div>
					<hr>

				</c:if>

				<c:if test="${article.channelId!=null }">
					<div class="subchannel">
						<ul>
							<li class="sub-item ${article.categoryId==null?'sub-selected ':'' }"><a
								href="/?channelId=${article.channelId }">全部</a></li>
							<c:forEach items="${categorys }" var="category">
								<li class="sub-item"><a
									href="/?channelId=${article.channelId }&categoryId=${category.id }"
									class="sub-item
							${article.categoryId==category.id?'sub-selected ':'' }">
										${category.name }</a></li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<div>
					<c:forEach items="${info.list }" var="article">
						<div class="media">
							<img alt="..." src="/pic/${article.picture }"
								class="mr-3 rounded" style="width: 200px; height: 150px;">
							<div class="media-body">
								<h5 class="mt-0">
									<a href="/articleDetail?id=${article.id }" target="blank">${article.title }</a>
								</h5>
								<p>
									<b>作者：${article.user.username }</b>
								</p>
								<p>点击量：${article.hits }</p>
								<p>
									发布时间：
									<fmt:formatDate value="${article.created }"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</p>
							</div>
						</div>
						<hr>
					</c:forEach>
				</div>
				<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
			</div>
			<!--右侧栏目  -->
			<div class="col-sm-3" style="padding-top: 5px;">
				<div class="card" style="width: 18rem;">
					<div class="card-header">最新文章</div>
					<div class="card-body">
						<c:forEach items="${lastarticles.list }" var="lastarticle">
							<div class="media">
								<img alt="..." src="/pic/${lastarticle.picture }"
									class="mr-3 rounded" style="width: 60px; height: 60px;">
								<div class="media-body">
									<h5 class="mt-0">
										<a href="/articleDetail?id=${lastarticle.id }" target="blank">${lastarticle.title }</a>
									</h5>
								</div>
							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"><span id="tt"></span></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="passport">
							
						</div>
					</div>
				</div>
			</div>
	<script type="text/javascript">
		
		function reg() {
			 $("#tt").html("<h3>注册</h3>");
			$("#passport").load("/passport/reg");
		}
		
		function login() {
			 $("#tt").html("<h3>登录</h3>");
			$("#passport").load("/passport/login");
		}
	
		function goPage(page) {
			var channelId = '${article.channelId}'
			var categoryId = '${article.categoryId}'
			var hot = '${article.hot}'
			location.href = "/?channelId=" + channelId + "&categoryId="
					+ categoryId + "&page=" + page + "&hot=" + hot;
		}
	</script>
</body>
</html>