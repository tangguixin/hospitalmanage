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
		
		
		
		//初始化表格
		$('#dg').datagrid({
			
			url:"<%=path%>/doctorAction/getData.do",
			width : 630,
			striped : true,
			title : "挂号信息",
			//定义顶部工具栏的DataGrid面板
			toolbar : "#search",
			columns : [ [
			//定义列，这里有三列，每一列的都是一个对象，title为列标题，field为字段的名称
			{
				title : "",
				field : "ck",
				checkbox : true
			}, {
				title : "姓名",
				field : "name",
				width : 150,
				align : "center",
				//允许列使用排序,与表格中的remoteSort属性配合使用
				//如果sortable:true，remoteSort也为true，则对表格中的所有数据排序
				//如果sortable:true，remoteSort也为false，则对表格中的所有数据排序
				sortable : true
			}, {
				title : "预约时间",
				field : "time",
				width : 150,
				align : "center",

			}, {
				title : "是否就诊",
				field : "isKanBing",
				width : 100,
				align : "center",
			} ,{
				title:"操作",
				field:"recordid",
				width : 200,
				align : "center",
				  formatter : function(value, row, index) {
					  return '<a href="<%=path%>/doctorAction/jiuzhen.do?recordid='+row["recordid"]+'">确认就诊</a>   <a href="<%=path%>/doctorAction/patientInfo.do?recordid='+row["recordid"]+'">患者信息</a>  <a href="<%=path%>/doctorAction/zhenduanView.do?recordid='+row["recordid"]+'">诊断</a>';  
	                }
			}
			
			] ]
		});

	})
	
		//搜素
		function doSearch(){
			var yuyueid=$("#yuyueid").val();
			var patientname=$("#patientname").val();
			var a= (yuyueid != null);
			var b= (patientname != null);
			
			if( yuyueid != "" & patientname != ""){
				$.messager.alert('警告','只能选择一个条件'); 
				return;
			}else{
				
			if(yuyueid!=""){
				
				$('#dg').datagrid({
                    //queryParams方法在请求远程数据的时候发送额外的参数,参数一定要是json格式的对象，而表单序列化后是数组对象。需要将数组对象转为json格式的对象
                    queryParams: {
                        "yuyueid":yuyueid
                    }
                });
				
			}else if(patientname!=""){
				
				$('#dg').datagrid({
                    //queryParams方法在请求远程数据的时候发送额外的参数,参数一定要是json格式的对象，而表单序列化后是数组对象。需要将数组对象转为json格式的对象
                    queryParams: {
                        "patientname":patientname
                    }
                });
				
			}
				
			}
			
			
			
		}
</script>
</head>
<body>
	<div style="margin-top: 5px; margin-left: 400px;">
		<table id="dg"></table>
	</div>

	<div id="search" style="padding: 3px">
		<span>预约编号:</span> <input id="yuyueid"
			style="line-height: 20px; width:60px;border: 1px solid #ccc"> <span>患者姓名:</span>
		<input id="patientname" 
			style="line-height: 20px;width:60px ;border: 1px solid #ccc"> 
			<a href="#" class="easyui-linkbutton" style="margin-left: 75px;" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch();">搜索</a>
	</div>


</body>
</html>