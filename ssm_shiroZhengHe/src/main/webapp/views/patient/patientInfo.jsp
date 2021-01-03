<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/script/easyUI-1.4/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/script/easyUI-1.4/themes/icon.css">
<script type="text/javascript"
	src="<%=path%>/script/easyUI-1.4/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/script/easyUI-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/script/easyUI-1.4/locale/easyui-lang-zh_CN.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
		$(function(){
			$("#backBtn").bind("click",function(){
				
				history.back();
				
			})
		})

	

</script>

</head>
<body>
	<div style="margin-top: 150px; margin-left: 550px;">
		<form id="form" method="post" class="easyui-form">
			<div style="margin-top: 10px;">
				<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label> 
				<label>${patient.truename}</label> 
			</div>
			<div style="margin-top: 10px;">
				<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> 
				<label>${patient.sex}</label> 
			</div>
			<div style="margin-top: 10px;">
				<label>出生日期:</label>
				<label>${patient.birthday}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>身份证号:</label>
				<label>${patient.shenfenzheng}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>电话号码:</label>
				<label>${patient.phone}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>家庭住址:</label>
				<label>${patient.address}</label> 
			</div>
			
			<div style="margin-top: 10px;">
				<label>个人病史:</label>
				<c:forEach items="${chufangrecordList}" var="chufangrecord">
					<label>病情:<span style="color:#FF3030">${chufangrecord.bingqing}</span></label> <label>用药：<span style="color:#FF3030">${chufangrecord.chufang}</span></label> <br />
				</c:forEach>
			</div>
			
			<div id="btn" style="margin-top: 20px;">
				<a id="backBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-back'" style="width: 15%; height: 32px">返回</a>
			</div>
		</form>
	</div>
</body>
</html>