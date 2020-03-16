<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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
		<h1>我的收藏夹</h1>
		<hr color="black">
		<c:forEach items="${collects }" var="collect">
		<input type="hidden" value="${collect.id }" id="id">
			<p>${collect.text }</p>
			<p>时间:<fmt:formatDate value="${collect.created }" pattern="YYYY-MM-dd HH:ss:mm"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="deleteCollect()">删除</a></p>
			<hr>
		</c:forEach>
		<script type="text/javascript">
		
		function deleteCollect(){
			
			var id =$("#id").val();
			$.post("/deleteCollect",{id:id},function(flag){
				if(flag){
					alert("取消收藏成功");
					window.location.reload();
				}else{
					alert("取消收藏收藏失败，需要登录后才能取消收藏")
				}
			})
			
		}		
		
		
		</script>
</body>
</html>