<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院预约挂号</title>
<%
	/********** 保存网站的基本路径 ***********/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//将该路径地址缓存到 session中 ,例如：http://localhost:8090/tjnu_ssh_1128/
	session.setAttribute("mybasePath", basePath);
%>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<link rel="stylesheet"
	href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
	<!-- 上方浮窗 -->
	<jsp:include page="../include/head.jsp" />
	<!-- 左边浮窗 -->
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<div id="tip" class="jumbotron text-left" style="padding-left: 45px;background-color: #ffffff">
						<div class="modal-header" style="padding-left: 45px;background-color: #ffffff">
							<button id="close" name = "close" type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
						</div>
						<h2>	
							医院挂号系统上线了
							</h1>
							<p>为解决患者排队等候的问题，采用除传统挂号方式外的预约挂号方式.</p>
						</h2>
					</div>

				</div>
			</div>
			<hr />
			<div class="carousel slide" id="carousel-630453">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-630453"></li>
					<li data-slide-to="1" data-target="#carousel-630453" class="active"></li>
					<li data-slide-to="2" data-target="#carousel-630453"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="${mybasePath}assets/img/1.jpg" />

					</div>
					<div class="item active">
						<img alt="" src="${mybasePath}assets/img/2.jpg" />

					</div>
					<div class="item">
						<img alt="" src="${mybasePath}assets/img/3.jpg" />

					</div>
				</div>
				<a class="left carousel-control" href="#carousel-630453"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#carousel-630453"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
    <script type="text/javascript">
    $("#close").click(function(){
    	 /*  $("#tip").remove();  */
    	  $("#tip").fadeTo("slow", 0.01, function(){//fade
    		    $(this).slideUp("slow", function() {//slide up
    		      $(this).remove();//then remove from the DOM
    		    });
    		  }); 
    });
    </script>
</html>