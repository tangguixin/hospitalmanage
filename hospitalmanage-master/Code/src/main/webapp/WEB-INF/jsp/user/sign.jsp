<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户注册</title>
<jsp:include page="../include/headtag.jsp" />
<!-- CSS -->

<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
input:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px white inset;
	border: 1px solid #CCC !important;
}
</style>
</head>

<body>

	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<div class="form-top">
						<div class="form-top-left">
							<h3 style="color: #969696;">用户注册</h3>
							<p>请输入注册信息</p>
						</div>
						<div class="pull-right-bottom">
								<p class="text-danger"
									style="position: absolute; right: 60px; bottom: 430px"
									id="errorTip">${error}</p>
							</div>

					</div>
					<div class="form-bottom">
						<!-- 增加患者项的函数，顺便生成患者条码，成功返回登陆界面-->
						<form role="form" action="sign" method="post" class="login-form">
							<div class="form-group col-xs-12">
								<!-- 输入邮箱-->
								<label class="sr-only" for="userEmail">userEmail</label>邮箱(*):<input
									style="font-weight: bold" type="text" name="userEmail"
									id="userEmail" class="form-control input-control clearfix"
									required onkeyup="isCheckEmail()" /><span id="emailTip"></span>
							</div>
							<div class="form-group col-xs-12">
								<!-- 输入密码-->
								<label class="sr-only" for="userPassword">password</label>密码(*):<input
									style="font-weight: bold" type="password" name="userPassword"
									class="form-password form-control" id="pwd1" required />
							</div>
							<div class="form-group col-xs-12">
								<!-- 确认密码-->
								<label class="sr-only" for="userPasswordCof">passwordCof</label>确认密码(*):<input
									style="font-weight: bold" type="password"
									name="userPasswordCof" class="form-password form-control "
									id="pwd2" required onkeyup="isCheckPwd()" /> <span id="pwdTip"></span>
							</div>
							<div class="form-group col-xs-12">
								<button type="submit" class="btn" id="btn">立即注册</button>
							</div>
						</form>
						<span><a href="login">用户登录</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>

            <script src="assets/js/placeholder.js"></script>
	<script>
		function isCheckPwd() {
			var pwd1 = document.getElementById("pwd1").value;
			var pwd2 = document.getElementById("pwd2").value;
			document.getElementById("errorTip").innerHTML = "";
			if (pwd1 == pwd2) {
				document.getElementById("pwdTip").innerHTML = "两次密码相同";
				document.getElementById("btn").disabled = false;
			} else {
				document.getElementById("pwdTip").innerHTML = "两次密码不相同";
				document.getElementById("btn").disabled = true;
			}
		}
	</script>
	
	<script type="text/javascript">
		function isCheckEmail() {
			var email = document.getElementById("userEmail").value;
			document.getElementById("errorTip").innerHTML = "";
			if (email != "") {
				var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				isok = reg.test(email);
				if (isok) {
					document.getElementById("emailTip").innerHTML = "邮箱格式正确";
					document.getElementById("btn").disabled = false;
				} else {
					document.getElementById("btn").disabled = true;
					document.getElementById("emailTip").innerHTML = "邮箱格式不正确";
				}
			} else {
				document.getElementById("emailTip").innerHTML = "";
			}
		}
	</script>
</body>

</html>