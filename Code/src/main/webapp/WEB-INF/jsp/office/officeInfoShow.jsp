<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室信息</title>
<!-- CSS -->
<jsp:include page="../include/headtag.jsp" />
<!-- <link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
<link rel="stylesheet"
	href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
<link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">科室详情</h3>
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
						<img alt="请检查网络，图片加载出现了一点小问题" src="${hos.hospitalImg }">
					</div>
					<div class="col-md-4">
						<p class="text-left">
							<font color="#eb6864">医院名称：</font>${hos.hospitalName }
						</p>
						<p class="text-left">
							<font color="#eb6864">科室名称：</font>${office.officesName  }
						</p>
						<p class="text-left">
							<font color="#eb6864">医生数量：</font>${office.doctorNum }
						</p>
					</div>
				</div>
				<hr />

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in text-left" id="home">
						<div class="col-md-12">
							<div class="col-md-12">
								<p class="text-left"><font color="#eb6864">请选择预约医生</font></p>
								
							</div>
							<div style="border-bottom: 1px solid #ccc;"></div>
						</div>
						
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>科室医生</th>
									<th>医生姓名</th>
									<th>医生性别</th>
									<th>医生职称</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="doc" items="${doctor }" varStatus="status">
									<tr>
										<td>${ status.index + 1}</td>
										<td><a href="<c:url value='/doctorInfoShow/${doc.id}' />">${doc.doctorName }</a></td>
										<td>${doc.doctorSex }</td>
										<td>${doc.doctorTitle }</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
</html>