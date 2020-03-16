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
<title>注册</title>
</head>
<body>
	<div class="container">
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
				<label for="repassword">确认密码</label> <input id="repassword"
					type="password" class="form-control" name="repassword">
			</div>
			<div class="form-group form-inline">
				<label for="gender">性别</label> <input id="gender" type="radio"
					class="form-check-input" name="gender" value="1" checked>男 <input
					id="gender" type="radio" class="form-check-input" name="gender"
					value="0">女
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-info">注册</button>
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
					 rangelength:[2,10],//用户名长度在2-10之间
					 remote:{
						 type:"post",
						 data:{
							 username:function(){
								 return $("#username").val();
							 }
						 },
						 url:"/passport/checkName",
					 },
				 }, 
				 password:{
					 required:true,//密码不能为空
					 rangelength:[6,10],//密码长度在6-10之间
				 }, 
				 repassword:{//确认密码和密码一致
					 equalTo:"#password"
				 }, 
			  },
			  //2.定义消息提示
				 messages:{
					username:{
						 required:"用户名不能为空",
						 rangelength:"用户名长度在2-10之间",
						 remote:"用户名已被注册",
					} , 
					 password:{
						 required:"密码不能为空",
						 rangelength:"密码长度在6-10之间"
					 }, 
					 repassword:{
						 equalTo:"两次密码不一致",
					 }, 
				 },submitHandler:function(flag){
					 //如果校验通过。则执行注册
					 $.post("/passport/reg",$("#form1").serialize(),function(result){
						 if(result.code==200){
							 $("#tt").html("<font color='red'>注册成功,请登录</font>");
							 $("#passport").load("/passport/login");
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