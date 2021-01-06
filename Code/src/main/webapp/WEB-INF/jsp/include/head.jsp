<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Top menu -->

<nav class="navbar navbar-inverse navbar-no-bg navbar-fixed-top"
	role="navigation">
	<div class="container">
		<div style="position: absolute; left: 40px; top: 6px;"></div>
		<div style="position: absolute; left: 150px; top: -2px;">
			<!-- 需要跳转函数去index页面-->
			<a class="navbar-brand" href="<c:url value="/index" />"><font color="#fff">医院预约挂号系统</font></a>
		</div>
		<div class="collapse navbar-collapse" id="top-navbar-1">
			<ul class="nav navbar-nav navbar-right">
				<li><span class="li-text"></span> <span class="li-text">
				</span> <span class="li-social"> </span>
					<div>
						<!-- 判断用户是否已存在 -->
						<c:if test="${userInfo == null}">
							<!-- 需要跳转函数去login页面-->
							<a class="navbar-brand" style="font-size: 12px;"
								href="<c:url value="/login" />"><strong>登录</strong></a>
							<!-- 需要跳转函数去sign页面
							<a class="navbar-brand" style="font-size: 12px;"
								href="<c:url value="/sign" />"><strong>注册</strong></a>-->
						</c:if>
						<!-- 存在则显示登陆 -->
						<c:if test="${userInfo != null}">
							<!-- 若用户已完善信息，显示用户名。点击用户名时触发得到患者所有相关表单信息并返回到usercenter的函数 -->
							<a class="navbar-brand" style="font-size: 12px;" href="<c:url value="/userCenter" />"><strong><font color="#fff">欢迎您,${userInfo.userName }</font></strong></a>
							<a class="navbar-brand" style="font-size: 12px;"
								href="<c:url value="/logOff" />"><strong>注销</strong></a><!-- 注销函数，返回index-->
						</c:if>
						<a class="navbar-brand" style="font-size: 12px;" href="<c:url value="/fenzhenlogin" />"><strong>分诊台登陆</strong></a>
					</div></li>
			</ul>
		</div>
	</div>
</nav>
