<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们</title>
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
	<jsp:include page="../include/head.jsp" />
	<jsp:include page="../include/menu.jsp" />
	<div id="page-wrapper" style="margin-top: 50px;">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-left">个人中心</h3>
					<!-- 在payin，payout界面处理完后都返回idnex -->
					<!-- 后端用session.getAttribute()拿到病人信息，返回到payout界面 -->
					<a class="navbar-brand" style="font-size: 12px;" href="<c:url value="/onlinePay" />"><strong><font color="#000">费用结算</font></strong></a>
					<!-- 后端用session.getAttribute()拿到病人信息，返回到payin界面 -->
					<a class="navbar-brand" style="font-size: 12px;" href="<c:url value="/onlinePay" />"><strong><font color="#000">退款结算</font></strong></a>
				</div>
			</div>
			<hr />
			<ul class="nav nav-tabs">
				<li class="active"><a href="#order" data-toggle="tab">预约信息</a></li>
				<li><a href="#userInfo" data-toggle="tab">个人信息</a></li>
				<li><a href="#waitinfo" data-toggle="tab">排队信息</a></li>
				<li><a href="#chufanginfo" data-toggle="tab">处方信息</a></li>

			</ul>
			<br>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active in text-left" id="order">
					<div class="col-md-12">
						<p class="text-left">
							<font color="#eb6864">我的预约</font>
						</p>
					</div>

					<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>订单</th>
								<th>就诊时间</th><!-- time-->
								<th>科室</th>
								<th>医生</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<!-- 函数返回的预约表信息-->
							<c:forEach var="orderRecords" items="${list }"
								varStatus="status">
								<tr>
									<td>${ status.index + 1}</td>
									<td>${orderRecords.createTime }</td><!-- time-->
									<td>${orderRecords.roomId }</td>
									<td>${orderRecords.doctorId }</td>
									<td><c:if test="${orderRecords.isSuccess==false }">
											未处理
										</c:if>
										<c:if test="${orderRecords.isSuccess==true }">
											已处理
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 个人信息-->
				<div class="tab-pane fade text-left" id="userInfo">
					<div class="panel panel-primary text-left">
						<div class="panel-heading">
							<h3 class="panel-title">个人信息</h3>
						</div>
						<div class="panel-body">
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>姓名：${commonUser.userName }&nbsp;</h3><!-- 姓名-->
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>性别：${commonUser.userSex }&nbsp;</h3><!-- 姓名-->
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3">
									<h3>年龄：${commonUser.userPhone }</h3>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>地址：${commonUser.userAddress }</h3>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-12">
									<h3>身份证：${commonUser.shenfenzheng }</h3>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="tab-pane fade text-left" id="waitinfo">
					<div class="col-md-12">
						<p class="text-left">
							<font color="#eb6864">排队信息</font>
						</p>
					</div>

					<table class="table table-striped table-hover ">
						当前你处于第${ waitinfo}位
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade text-left" id="chufanginfo">
					<div class="col-md-12">
						<p class="text-left">
							<font color="#eb6864">我的处方</font>
						</p>
					</div>

					<table class="table table-striped table-hover ">
						<thead>
						<tr>
							<th>订单</th>
							<th>药品</th>
							<th>医生</th>
							<th>状态</th>
						</tr>
						</thead>
						<tbody>
						<!-- 函数返回的预约表信息-->
						<c:forEach var="orderRecords" items="${chufang }"
								   varStatus="status">
							<tr>
								<td>${ status.index + 1}</td>
								<td>${orderRecords.drugid }</td>
								<td>${orderRecords.doctorId }</td>
								<td><c:if test="${orderRecords.jiesuan==0 }">
									等待配药
								</c:if>
									<c:if test="${orderRecords.isFinish==1 }">
										正在配药
									</c:if>
									<c:if test="${orderRecords.isFinish==2 }">
										等待发药
									</c:if>
									<c:if test="${orderRecords.isFinish==3 }">
										正在发药
									</c:if>
									<c:if test="${orderRecords.isFinish==-1 }">
										退药
									</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>

<script type="text/javascript">
	function cancel() {
		$("#cancel").submit();
		return false;
	}
</script>
</html>