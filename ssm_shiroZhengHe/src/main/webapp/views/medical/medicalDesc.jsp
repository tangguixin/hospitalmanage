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
				<label>药品编号:</label> 
				<label>${medical.id}</label> 
			</div>
			<div style="margin-top: 10px;">
				<label>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label> 
				<label>${medical.name}</label> 
			</div>
			<div style="margin-top: 10px;">
				<label>成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分:</label> 
				<label>${medical.chengfen}</label> 
			</div>
			<div style="margin-top: 10px;">
				<label>用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法:</label> 
				<label>${medical.yongfa}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用:</label> 
				<label>${medical.zuoyong}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>副&nbsp;&nbsp;作&nbsp;&nbsp;用:</label> 
				<label>${medical.fuzuoyong}</label> 
			</div>

			<div style="margin-top: 10px;">
				<label>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格:</label> 
				<label>${medical.price}元</label> 
			</div>
			
			<div style="margin-top: 10px;">
				<label>保&nbsp;&nbsp;质&nbsp;&nbsp;期:</label> 
				<label>${medical.baozhiqi}个月</label> 
			</div>
			
			<div style="margin-top: 10px;">
				<label>生产日期:</label> 
				<label>${shenchanriqi}</label> 
			</div>
			
			<div style="margin-top: 10px;">
				<label>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司:</label> 
				<label>${medical.company}</label> 
			</div>
			
			
			<div id="btn" style="margin-top: 20px;">
				<a id="backBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-back'" style="width: 15%; height: 32px">返回</a>
			</div>
		</form>
	</div>
</body>
</html>