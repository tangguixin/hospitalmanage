<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生简介</title>
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
<link rel="stylesheet" href="${mybasePath}assets/date/css/index.css">
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/date/js/index.js"></script>
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">医生详情</h3>
				</div>
			</div>
			<hr />
			<div class="col-md-12">
				<ul class="nav nav-tabs">

					<li class="active"><a href="#home" data-toggle="tab"
							aria-expanded="true">预约挂号</a></li>
				</ul>
				<hr />
				<div class="col-md-12">
					<div class="col-md-3">
						<img alt="请检查网络，图片加载出现了一点小问题" src="${doctor.doctorImg }"
							style="width: 180px; height: 180px;">
					</div>
					<div class="col-md-4">
						<p class="text-left">
							<font color="#eb6864">医生姓名：</font>${doctor.doctorName }
						</p>
						<p class="text-left">
							<font color="#eb6864">医生性别：</font>${doctor.doctorSex }
						</p>
						<p class="text-left">
							<font color="#eb6864">医生科室：</font>${doctor.officesName }
						</p>
						<p class="text-left">
							<font color="#eb6864">医生科室：</font>${userInfo.userId }
						</p>
					</div>
				</div>
				<hr />
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in text-left" id="home">
							<div class="col-md-12">
								<div style="border-bottom: 1px solid #ccc;"></div>
								<br />
								<br />
							</div>
							<hr />
							<form class="form-search form-horizontal" id="orderInfo"
								action="<c:url value='/order' />" method="post">
								<input type="hidden" id="orderInfoValue" name="orderInfoValue" value=""/>
								<input type="hidden" id="userId" name="userId" value="${userInfo.userId }"/>
								<input type="hidden" id="doctorId" name="doctorId" value="${doctor.doctorId }"/>
								<input type="hidden" id="roomId" name="roomId" value="${office.roomId }"/>
								<input type="hidden" id="type" name="type" value="科室预约"/>
								</form>
								<div class="a" style="width: 800px;">
								</div>
						</div>
				</div>
			</div>
		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
</html>