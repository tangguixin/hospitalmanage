<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html>
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
</head>
<script type="text/javascript">
	$(function() {
		
		   $('#loginAndRegDialog').dialog({
	            title : '用户登录',
	            width : 300,
	            height : 200,
	            closable : false,
	            cache : false,
	            modal : true,
	            buttons : "#btn"
	        });
		
		
		$("#registerBtn").bind("click", function() {
			window.location.href="<%=path%>/userAction/register.do";
		});
		
		  $("#loginBtn").bind('click',function(){
			  
			  var isValid = $("#form").form('validate');
			  
			  if(!isValid){
				  //表单验证失败
			  }else{
				  //说明表单验证成功，ajax提交表单
				 
				    $.ajax({
			            //几个参数需要注意一下
			                type: "POST",//方法类型
			                dataType: "json",//预期服务器返回的数据类型
			                url: "<%=path%>/userAction/login.do",
			                data: $('#form').serialize(),
			                success: function (result) {
			                    	
			                	if(result.errMsg!=null){
			                		//说明用户名和密码错误
			                		$.messager.alert('提示',result.errMsg);  
			                	}else{
			                		//说明用户名密码正确
			                		var type=result.type;
			                		var baseURL="<%=path%>";
			                		
			                		if(type=="患者"){
			                			window.location.href=baseURL+"/views/patient/patient.jsp";
			                		}else if(type=="医生"){
			                			window.location.href=baseURL+"/views/doctor/doctor.jsp";
			                		}
			                		
			                	}
			                    
			                    
			                },
			                error : function() {
			                    alert("系统异常！");
			                }
			            });
				  
				  
			  }
			  
			  
      });
		
		


	})
</script>
<body>

<h1 style="margin-top: 150px;margin-left: 550px;">社区门诊管理系统</h1>
	<div id="loginAndRegDialog">
		
		<form id="form" method="post" class="easyui-form">
			<div style="margin-top: 20px; margin-left: 60px; margin-right: 60px;">
				<input type="text" id="username" name="username" value="doc1"
					class="easyui-textbox"
					data-options="iconCls:'icon-man',prompt:'请输入用户名',required:true"
					style="width: 100%; height: 35px">
			</div>
			<div style="margin-top: 20px; margin-left: 60px; margin-right: 60px;">
				<input type="password" id="password" name="password" value="111"
					class="easyui-textbox"
					data-options="iconCls:'icon-man',prompt:'请输入密码',required:true"
					style="width: 100%; height: 35px">
			</div>


			<div id="btn" style="margin-top: 20px;">
				<a id="loginBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" style="width: 30%; height: 32px">登录</a>
				<a id="registerBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-man'"
					style="width: 30%; height: 32px; margin-right: 55px;">注册</a>
			</div>
		</form>
	</div>
	
</body>
</html>