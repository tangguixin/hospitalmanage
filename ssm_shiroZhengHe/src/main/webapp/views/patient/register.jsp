<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
		$("#resetBtn").bind("click", function() {
			$('#form').form('clear');
		});
		
		
  $("#zhuceBtn").bind('click',function(){
			  
			  var isValid = $("#form").form('validate');
			  
			  if(!isValid){
				  //表单验证失败
			  }else{
				  //说明表单验证成功，ajax提交表单
				 
				    $.ajax({
			            //几个参数需要注意一下
			                type: "POST",//方法类型
			                dataType: "json",//预期服务器返回的数据类型
			                url: "<%=path%>/userAction/saveRegister.do",
			                data: $('#form').serialize(),
			                success: function (result) {
			                	
			                	$.messager.confirm('提示','注册成功，点击返回登录',function(r){    
			                	    if (r){    
			                	    	window.location.href="<%=path%>/index.jsp";    
			                	    } else{
			                	    	$('#form').form('clear');
			                	    }
			                	});  
			                	
			                },
			                error : function() {
			                    alert("系统异常！");
			                }
			            });
				  
				  
			  }
			  
			  
      });
		
	})
	
</script>

</head>
<body>
	<div style="margin-top: 150px; margin-left: 550px;">
		<form id="form" method="post" class="easyui-form">
			<div>
				<label>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</label> <input class="easyui-textbox" type="text"
					name="username" data-options="required:true" />
			</div>
			<div style="margin-top: 10px;">
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label> <input class="easyui-textbox" type="text"
					name="password" data-options="required:true" />
			</div>
			<div style="margin-top: 10px;">
				<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label> <input class="easyui-textbox" type="text"
					name="truename" data-options="required:true" />
			</div>
			<div style="margin-top: 10px;">
				<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <select id="cc" class="easyui-combobox" name="sex"
					style="width: 50px; height: 30px;">
					<option value="男" selected="selected">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div style="margin-top: 10px;">
				<label>出生日期:</label> <input id="dd" type="text" name="birthday"
					class="easyui-datebox" required="required"> </input>
			</div>

			<div style="margin-top: 10px;">
				<label>身份证号:</label> <input id="dd" type="text" name="shenfenzheng"
					class="easyui-numberbox" required="required"> </input>
			</div>

			<div style="margin-top: 10px;">
				<label>电话号码:</label> <input id="dd" type="text" name="phone"
					class="easyui-numberbox" required="required"> </input>
			</div>

			<div style="margin-top: 10px;">
				<label>家庭住址:</label> <input id="dd" type="text" name="address"
					class="easyui-textbox" required="required"> </input>
			</div>
			
			<div id="btn" style="margin-top: 20px;">
				<a id="zhuceBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" style="width: 15%; height: 32px">注册</a>
				<a id="resetBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-man'"
					style="width: 15%; height: 32px; margin-right: 55px;">重置</a>
			</div>
		</form>
	</div>
</body>
</html>