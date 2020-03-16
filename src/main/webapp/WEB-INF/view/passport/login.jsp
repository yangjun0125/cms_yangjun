<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resource/bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/resource/jquery/screen.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>登录</title>
</head>
<body>
	<div class="container" style="width: 450px; padding-top: 10px;">
	<span style="color:  red;">${msg }</span>
		<form id="form1">
			<div class="form-group">
				<label for="username">用户名</label> <input id="username" type="text"
					class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="password">密码</label> <input id="password"
					type="password" class="form-control" name="password">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-info">登录</button>
				<button type="reset" class="btn btn-warning">重置</button>
			</div>

		</form>

	</div>
	
	<script type="text/javascript">
	  $(function(){
		  
		  $("#form1").validate({
			  
			  //1 .定义规则
			  rules:{
				 username:{
					 required:true,//用户名不能为空
				 }, 
				 password:{
					 required:true,//密码不能为空
				 }, 
			  },
			  //2.定义消息提示
				 messages:{
					username:{
						 required:"用户名不能为空",
					} , 
					 password:{
						 required:"密码不能为空",
					 }, 
				 },submitHandler:function(flag){
					 //如果校验通过。则执行注册
					 $.post("/passport/login",$("#form1").serialize(),function(result){
						 if(result.code==200){
							 $("#tt").html("<font color='red'>登录成功</font>");
							 location.href="/";
						 }else{
							 alert(result.msg);
						 }
					 })
				 }  
			  
			  
		  })
		  
		  
		  
	  })
	
	
	</script>
</body>
</html>