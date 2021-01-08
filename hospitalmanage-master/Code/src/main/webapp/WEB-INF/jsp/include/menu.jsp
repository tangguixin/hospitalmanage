<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="wrapper">

	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="#"> </a></li>
			<br>
			<li><a class="navbar-brand" href="<c:url value="/index" />"><font color="#fff">首页</font></a></li>
			<li><a class="navbar-brand" href="<c:url value="/doctorIndex" />"><font color="#fff">专家挂号</font></a></li>
			<li><a class="navbar-brand" href="<c:url value="/officeIndex" />"><font color="#fff">科室挂号</font></a></li>
			<br />
		</ul>
	</div>
	<!-- /#sidebar-wrapper -->


</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${mybasePath}assets/bootstrap/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>


