<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="form-group form-inline ">
		
		用户姓名： <input type="text" name="username"
			class="form-control form-control-sm" value="${user.username }">
		&nbsp;&nbsp; 用户状态： <select name="locked"
			class="form-control form-control-sm col-sm-1">
			<option value="0" ${user.locked=="0"?"selected":"" }>正常</option>
			<option value="1" ${user.locked=="1"?"selected":"" }>禁用</option>
		</select> &nbsp;&nbsp;
		<button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
	</div>
	<table class="table table-bordered table-hover table-sm"
		style="text-align: center;">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>性别</td>
			<td>生日</td>
			<td>注册时间</td>
			<td>用户状态</td>
		</tr>
		<c:forEach items="${info.list }" var="user" varStatus="id">
			<c:if test="${user.role==0 }">
			<tr>
				<td>${id.count }</td>
				<td>${user.username }</td>
				<td>${user.nickname }</td>
				<td>${user.gender }</td>
				<td>${user.birthday }</td>
				<td><fmt:formatDate value="${user.created }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><c:if test="${user.locked==0 }">
						<button type="button" class="btn btn-danger btn-sm"
							onclick="update(${user.id},this)">正常</button>
					</c:if> 
					<c:if test="${user.locked==1 }">
						<button type="button" class="btn btn-primary btn-sm"
							onclick="update(${user.id},this)">禁用</button>
					</c:if></td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
	
	<script type="text/javascript">
	
	function query(){
		  var locked=$("[name='locked']").val();
		  var username=$("[name='username']").val();
		  $("#center").load("/admin/users?username="+username+"&locked="+locked);
	  }
	
	function update(id,obj) {		
		var locked=$(obj).text()=="正常"?1:0;
		alert(locked)
		$.post("/admin/userupdate",{id:id,locked:locked},function(flag){
			if(flag){
				$(obj).text($(obj).text()=="正常"?"禁用":"正常");//改变按钮的内容
				$(obj).attr("class",$(obj).text()=="禁用"?"btn btn-primary btn-sm":"btn btn-danger btn-sm")
			}
		})
	}	
	  function goPage(page){
			//在中间区域加载
			$("#center").load("/admin/users?page="+page);
		}
	</script>
</body>
</html>