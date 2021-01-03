<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%String path=request.getContextPath(); %>
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
		
		$('#department').combobox({
			onSelect:function(rec){
				//1.拿到所选科室， 
				//2. department表中拿到科室id 
				//3.doctor表中由id拿到该科室的所有医生
				
				$.ajax({
					   type: "POST",
					   url: "<%=path%>/doctorAction/getDoctorByDepartment.do",
					   data: "department="+rec.value,
					   success: function(msg){  //msg存放所选科室的所有医生名字
						   //拿到select
						   var doctorSelect = document.getElementById("doctorSelect");
					  	 //清除select的所有option
						doctorSelect.options.length=0;
						   //添加option	
						   for(var i=0;i<msg.length;i++){
							   var option = new Option(msg[i].name, msg[i].name);      
							   doctorSelect.options.add(option);  
						   }
						  
					   }
					});
				
				
			}
		});

		
		//为重置按钮绑定清除时间
		$("#resetBtn").bind("click", function() {
			$('#form').form('clear');
		});
		
		
		//预约按钮功能实现

		  $("#yuyueBtn").bind('click',function(){
			  
			  var isValid = $("#form").form('validate');
			  
			  if(!isValid){
				  //表单验证失败
			  }else{
				  //说明表单验证成功，ajax提交表单
				    $.ajax({
			            //几个参数需要注意一下
			                type: "POST",//方法类型
			                dataType: "json",//预期服务器返回的数据类型
			                url: "<%=path%>/userAction/yuyue.do",
			                data: $('#form').serialize(),
			                success: function (result) {
			                	
			                	if(result.msg!=null){
			                		$.messager.alert('提示',result.msg); 
				                	$('#form').form('clear');
			                	}else if(result.errmsg!=null){
			                		$.messager.alert('提示',result.errmsg); 
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
</head>
<body>
	<div style="margin-top: 5%;margin-left: 35%">
		<form id="form" method="post"  class="easyui-form" >
			
			<div style="margin-top: 10px;">
				<label>门诊科室:</label>
				<select id="department" class="easyui-combobox" name="department" style="width:200px;">   
				    <option value="骨科">骨科</option>   
				    <option value="男科">男科</option>   
				    <option value="妇科">妇科</option>   
				</select>  
			</div>
			
			<div style="margin-top: 10px;">
				<label>医生:</label>
				<select id="doctorSelect" name="doctor">
				</select>
			</div>
			
			<div style="margin-top: 10px;">
				<label>预约时间:</label>
				<input class="easyui-datetimebox" name="time"     
        data-options="required:true,showSeconds:false"  style="width:150px"> 
			</div>
			
			<div style="margin-top: 20px;">
					<a id="yuyueBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" style="width: 15%; height: 32px">预约</a>
					<a id="resetBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-clear'"
					style="width: 15%; height: 32px; ">重置</a>
			</div>
			
		</form>
</div>
</body>
</html>