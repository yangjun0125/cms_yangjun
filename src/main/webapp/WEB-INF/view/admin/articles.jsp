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
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>文章审核</title>
</head>
<body>
	<div class="form-group form-inline ">

		文章标题： <input type="text" name="title"
			class="form-control form-control-sm" value="${article.title }">
		&nbsp;&nbsp; 审核状态： <select name="status"
			class="form-control form-control-sm col-sm-1">
			<option value="0" ${article.status=="0"?"selected":"" }>待审</option>
			<option value="1" ${article.status=="1"?"selected":"" }>已审</option>
			<option value="-1" ${article.status=="-1"?"selected":"" }>驳回</option>
		</select> &nbsp;&nbsp;
		<button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
	</div>
	<table class="table table-bordered table-hover table-sm"
		style="text-align: center;">
		<tr>
			<td>序号</td>
			<td>标题</td>
			<td>作者</td>
			<td>发布时间</td>
			<td>所属栏目</td>
			<td>所属分类</td>
			<td>是否热门</td>
			<td>点击量</td>
			<td>其他</td>
		</tr>
		<c:forEach items="${info.list }" var="article" varStatus="id">
			<tr>
				<td>${id.count }</td>
				<td>${article.title }</td>
				<td>${article.user.username }</td>
				<td><fmt:formatDate value="${article.created }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${article.channel.name }</td>
				<td>${article.category.name }</td>
				<td><c:if test="${article.hot==1 }">
						<button type="button" class="btn btn-danger btn-sm"
							onclick="update(${article.id},this)">是</button>
					</c:if> <c:if test="${article.hot==0 }">
						<button type="button" class="btn btn-primary btn-sm"
							onclick="update(${article.id},this)">否</button>
					</c:if></td>
				<td>${article.hits }</td>
				<td>
					<button type="button" class="btn btn-dark" data-toggle="modal"
						data-target="#exampleModalScrollable"
						onclick="articleDetail(${article.id})">详情</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>


	<!-- Modal -->
	<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalScrollableTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalScrollableTitle">
						<span id="title"></span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<span id="content"></span>
				</div>
				<div class="modal-footer">
					<span id="msg">
						<button type="button" class="btn btn-success"
							onclick="updateStatus(1)">通过</button>
						<button type="button" class="btn btn-danger"
							onclick="updateStatus(-1)">驳回</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</span>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	//审核文章
	
	function updateStatus(status) {
		$.post("/admin/update",{id:articlesid,status:status},function(flag){
			if(flag){
				$("#msg").append("操作成功！")
				location.reload();
			}else{
				$("#msg").append("操作失败！")
			}
		})
	}
	
	var articlesid;
	function articleDetail(id){
		articlesid=id;
		$("#msg").text();//清空上一次的文章审核操作状态
		$.get("/admin/articleDetail",{id:id},function(article){
			$("#title").empty();
			$("#title").append(article.title);
			$("#content").append(article.content);
		})
	}
	
	function update(id,obj) {	
		var hot=$(obj).text()=="是"?0:1;
		$.post("/admin/update",{id:id,hot:hot},function(flag){
			if(flag){
				$(obj).text($(obj).text()=="是"?"否":"是");//改变按钮的内容
				$(obj).attr("class",$(obj).text()=="否"?"btn btn-primary btn-sm":"btn btn-danger btn-sm")
			}
		})
	}	
	
	function query(){
		  var status=$("[name='status']").val();
		  var title=$("[name='title']").val();
		  $("#center").load("/admin/articles?status="+status+"&title="+title);
	  }

	  
	  function goPage(page){
			//在中间区域加载
			$("#center").load("/admin/articles?page="+page);
		}
	</script>
</body>
</html>