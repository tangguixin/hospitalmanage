<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		
		//初始化表格
		$('#dg').datagrid({
			
			url:"<%=path%>/medicalAction/getData.do",
			width : 630,
			striped : true,
			toolbar : "#search",
			title : "处方药品",
			//定义顶部工具栏的DataGrid面板
			columns : [ [
			 {
				title : "药品编号",
				field : "medical_id",
				width : 150,
				align : "center",
				//允许列使用排序,与表格中的remoteSort属性配合使用
				//如果sortable:true，remoteSort也为true，则对表格中的所有数据排序
				//如果sortable:true，remoteSort也为false，则对表格中的所有数据排序
				sortable : true
			}, {
				title : "药品名称",
				field : "medical_name",
				width : 150,
				align : "center",

			}, {
				title : "用法",
				field : "medical_yongfa",
				width : 100,
				align : "center",
			}, {
				title : "作用",
				field : "medical_zuoyong",
				width : 127,
				align : "center",
			}, {
				title : "添加操作",
				field : "id",
				width : 100,
				align : "center",
				formatter: function(value,row,index){
				
					 return '<button onclick="addMedical('+row["id"]+',${doctor.id},${patient.id});">添加</button>   <button onclick="MedicalDesc('+row["id"]+');">查看</button>';  
				}
			}
			] ]
		});
		
		
		
		//确定添加药品
		$("#quedingBtn").bind("click", function() {
			
			$.ajax({
				 url:'<%=path%>/chufangRecordAction/saveMedical.do',
				 type:'POST', 
				 data:{
					 recordid:"${recordid}",
					 bingqing:$("#bingqing").val(),
					 patientId:"${patient.userId}",
					 doctorId:"${doctor.id}"
				    },
				 success:function(data,textStatus,jqXHR){
					 $.messager.confirm('提示','开药成功',function(r){    
						    if (r){    
						    	 window.location.href='<%=path%>/views/doctor/doctor.jsp';
						    }else{
						    	 window.location.href='<%=path%>/views/doctor/doctor.jsp';
						    }
						}); 
				    }
				
			})
			
		})
		
		
	})
	
	
	function addMedical(medical_id,doctor_id,patient_id){
		$.ajax({
			 url:'<%=path%>/chufangRecordAction/addMedical.do',
			 type:'POST', //GET
			 data:{
				 selelctedMedicalId:medical_id,
				 doctorId:doctor_id
			    },
			 success:function(data,textStatus,jqXHR){
				 $.messager.alert('提示','添加成功'); 
			    }
			
		})
		
	}
	
	//查看药品详细
	function MedicalDesc(medical_id){
		location.href="<%=path%>/medicalAction/medicalDesc.do?selelctedMedicalId="+medical_id;
	}
	
	

	//搜素
	function doSearch(){
		var medicalname=$("#medicalname").val();
		var zuoyong=$("#zuoyong").val();
		
		if( medicalname != "" & zuoyong != ""){
			$.messager.alert('警告','只能选择一个条件'); 
			return;
		}else{
			
		if(medicalname!=""){
			
			$('#dg').datagrid({
                //queryParams方法在请求远程数据的时候发送额外的参数,参数一定要是json格式的对象，而表单序列化后是数组对象。需要将数组对象转为json格式的对象
                queryParams: {
                    "name":medicalname
                }
            });
			
		}else if(zuoyong!=""){
			
			$('#dg').datagrid({
                //queryParams方法在请求远程数据的时候发送额外的参数,参数一定要是json格式的对象，而表单序列化后是数组对象。需要将数组对象转为json格式的对象
                queryParams: {
                    "zuoyong":zuoyong
                }
            });
			
		}
			
		}
	}
	
</script>
</head>
<body>
	<div id="top" style=" margin-left: 400px;">
		<div>
			<label>医生：</label>
			<label>${doctor.name}</label>
		</div>
		<div>
			<label>患者：</label>
			<label>${patient.truename}</label>
		</div>
		<div>
			<label>病情：</label>
			<textarea rows="3" cols="30" id="bingqing" name="bingqing" style="margin-top: 20px;"></textarea>

		</div>
	</div>
	<div style="margin-top: 5px; margin-left: 400px;">
		<table id="dg"></table>
	</div>
		<div id="btn" style="margin-top: 20px;">
				<a id="quedingBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" style="width: 100px; height: 32px;margin-left: 405px;">确定</a>
				<a id="backBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-back'"
					style="width: 100px; height: 32px; margin-right: 55px;">返回</a>
			</div>
			
			<div style="margin-top: 5px; margin-left: 400px;">
		<table id="dg"></table>
	</div>

	<div id="search" style="padding: 3px">
		<span>药品名称:</span> 
		<input id="medicalname" style="line-height: 20px; width:60px;border: 1px solid #ccc"> 
		<span>作用:</span>
		<input id="zuoyong" style="line-height: 20px;width:60px ;border: 1px solid #ccc"> 
		<a href="#" class="easyui-linkbutton" style="margin-left: 75px;" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch();">搜索</a>
	</div>
			
			
</body>
</html>