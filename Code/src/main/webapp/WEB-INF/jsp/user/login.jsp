<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登录</title>
<jsp:include page="../include/headtag.jsp" />
<!-- CSS -->

<link rel="stylesheet"
	href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">

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
	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3 style="color: #969696;">用户登录</h3>
								<p>请输入身份证和密码</p>
							</div>
							<div class="pull-right-bottom">
								<p class="text-danger"
									style="position: absolute; right: 60px; bottom: 300px"
									id="errorTip">${error}</p>
							</div>

						</div>

						<div class="form-bottom">
							<form role="form" action="login" method="post" class="login-form">
								<div class="form-group col-xs-12">
									<label class="sr-only" for="userIdenf">身份证号</label>身份证号(*):<input
										type="text" name="userIdenf" class="form-username form-control"
										id="userIdenf" required style="font-weight: bold"
										onkeyup="isCheckIdenf()" /><span id="idenfTip"></span>
								</div>
								<div class="form-group col-xs-12">
									<!-- 输入密码-->
									<label class="sr-only" for="userPassword">Password</label>密码(*):
									<input type="password" name="userPassword" placeholder="用户密码"
										class="form-password form-control" id="userPassword"
										style="font-weight: bold" required onkeyup="isClearTip()">
								</div>
								<div class="form-group col-xs-12">
									身份(*): <select class="form-control input-control "
												   name="userType">
									<option value="病人">病人</option>
									<option value="医生">医生</option>
									<option value="药房">药房</option>
								</select>
								</div>
								<div class="form-group col-xs-12">
									<button type="submit" class="btn">立即登录</button>
								</div>
							</form>
							<span><a href="index">返回主页</a></span>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
	<script src="${mybasePath}assets/js/scripts.js"></script>


            <script src="assets/js/placeholder.js"></script>

	<script type="text/javascript">
		function isClearTip() {
			document.getElementById("errorTip").innerHTML = "";
		}
	</script>
	<script type="text/javascript">
		function isCheckIdenf() {
			var idenf = document.getElementById("userIdenf").value;
			document.getElementById("errorTip").innerHTML = "";
			if (idenf != "") {
				var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
				isok = reg.test(idenf);
				if (isok) {
					document.getElementById("idenfTip").innerHTML = "<font color='#969696'>身份证格式正确</font>";
					document.getElementById("btn").disabled = false;
				} else {
					document.getElementById("btn").disabled = true;
					document.getElementById("idenfTip").innerHTML = "身份证格式不正确";
				}
			} else {
				document.getElementById("idenfTip").innerHTML = "";
			}
		}
	</script>

</body>

</html>