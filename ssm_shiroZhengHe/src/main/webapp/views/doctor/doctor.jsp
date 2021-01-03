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
<title>预约挂号</title>
<script type="text/javascript">  
var _topWin = window;    
while (_topWin != _topWin.parent.window) {    
     _topWin = _topWin.parent.window;    
}    
if (window != _topWin)_topWin.document.location.href = '${pageContext.request.contextPath}/views/doctor/doctor.jsp';    
</script>  
</head>
<body class="easyui-layout">
	
    <div data-options="region:'north'" style="height:30px;">
    	<div id="userInfo" style="margin-left:85%;">
    		欢迎:${sessionScope.doctor.username}
    		 <a href="<%=path%>/userAction/uptpwdView.do">修改密码</a>
    		 <a href="<%=path%>/userAction/exit.do">退出</a>
    	</div>
    </div>   
    <div data-options="region:'south'" style="height:30px;">
    	<div id="down" style="text-align: center;">	版权所有，侵权必究。</div>
    </div>   
      
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    			<div id="tabs" class="easyui-tabs" fit="true" border="false">
			
			<div title="挂号查看"
				style="padding: 20px; overflow: hidden; color: red;">
				<iframe scrolling="auto" application="yes" frameborder="0" style="width:100%;height:100%;" src="<%=path%>/doctorAction/guahaoView.do"></iframe>
			</div>
			
		</div>
    	
    </div>   
	
</body>
</html>