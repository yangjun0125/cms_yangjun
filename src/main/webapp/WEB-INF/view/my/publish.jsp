<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>KindEditor JSP</title>
<link rel="stylesheet"
	href="/resource/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="/resource/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="/resource/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8"
	src="/resource/kindeditor/plugins/code/prettify.js"></script>
<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	
	<script type="text/javascript">
		//为栏目添加内容--栏目分类 二级联动
		$(function() {
			$.get("/channel/channels",function(list){
				for ( var i in list) {
					$("#chnannels").append("<option value='"+list[i].id+"'>"+list[i].name
							+"</option>")
				}
				$("#chnannels").change(function() {
					var channelid=$(this).val();
					$.get("/channel/selectsByChannelId",{channelid:channelid},function(list){
						$("#category").empty();
						for ( var i in list) {
							$("#category").append("<option value='"+list[i].id+"'>"+list[i].name
									+"</option>")
						}
					})
				})
			})
		})
	</script>
</head>
<body>
	<form id="fid">
		<div class="form-group">
			<label for="title">文章标题：</label> <input type="text" name="title"
				class="form-control-md col-md-8" id="title">
		</div>

		<div class="form-group">
			<label for="title">所属栏目：</label> <select id="chnannels"
				class="from-control form-control-sm col-sm-3" name="channelId">
				<option>请选择</option>
			</select>
			<label for="title">所屬分类：</label> <select id="category"
				class="from-control form-control-sm col-sm-3" name="categoryId">
				<option>请选择</option>
			</select>
		</div>
		<div class="form-group">
			文章标题图片：<input type="file" name="file" class="btn btn-link">
		</div>
		<textarea name="content1" cols="100" rows="8"
			style="width: 810px; height: 250px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br /> <input type="button" name="button" class="btn btn-success"
			value="发布文章" onclick="publish()"/>
	</form>
</body>
<script type="text/javascript">
	function publish() {
		var formData=new FormData($("#fid")[0]);
		//获取文本编辑器里面的html内容，并封装到formData中
		formData.set("content",editor1.html())
		
		$.ajax({
			type:"post",
			url:"my/publish",
			//告诉jQuery不要去处理发送的数据
			processData:false,
			contentType:false,
			data:formData,
			success:function(flag){
				if(flag){
					alert("发布成功")
					 location.href="/my/" 
				}
			}
		})
	}
</script>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>