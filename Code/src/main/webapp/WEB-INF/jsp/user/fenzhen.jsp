<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>联系我们</title>
    <%
        /********** 保存网站的基本路径 ***********/
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        //将该路径地址缓存到 session中 ,例如：http://localhost:8090/tjnu_ssh_1128/
        session.setAttribute("mybasePath", basePath);
    %>
    <!-- CSS -->
    <jsp:include page="../include/headtag.jsp" />
    <link rel="stylesheet"
          href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
    <link rel="stylesheet" href="${mybasePath}assets/css/style.css">
</head>
<body>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/menu.jsp" />
<div id="page-wrapper" style="margin-top: 50px;">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-left">个人中心</h3>
            </div>
        </div>
        <hr />
        <ul class="nav nav-tabs">
            <li class="active"><a href="#order" data-toggle="tab">处理预约</a></li>
            <li><a href="#userInfo" data-toggle="tab">挂号</a></li>

        </ul>
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in text-left" id="order">
                <div class="col-md-12">
                    <p class="text-left">
                        <font color="#eb6864">待处理预约</font>
                    </p>
                </div>

                <table class="table table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>订单</th>
                        <th>就诊时间</th><!-- time-->
                        <th>科室</th>
                        <th>医生</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 函数返回的预约表信息-->
                    <c:forEach var="orderRecords" items="${orderRecords }"
                               varStatus="status">
                        <c:if test="${orderRecords.isFinish==0 }">
                        <tr>
                            <td>${ status.index + 1}</td>
                            <td>${orderRecords.transactDate }</td><!-- time-->
                            <td>${orderRecords.officesName }</td>
                            <td>${orderRecords.doctorName }</td>
                            <td><a class="navbar-brand" style="font-size: 12px;"
                                   href="<c:url value="/logOff" />">分诊</a>
                            </td>
                        </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- 个人信息-->
            <div class="tab-pane fade text-left" id="userInfo">
                <div class="form-bottom">
                    <form role="form" action="fenzhenorder" method="post" class="login-form">
                        <div class="form-group col-xs-12">
                            <label class="sr-only" for="userid">id</label>请输入id(*):<input
                                type="password" name="userid" class="form-username form-control"
                                id="userid" required style="font-weight: bold"/>
                        </div>
                        <div class="form-group col-xs-12">
                            <button type="submit" class="btn">立即挂号</button>
                        </div>
                    </form>
                    <span><a href="/logOff">返回主页</a></span>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>

<script type="text/javascript">
    function cancel() {
        $("#cancel").submit();
        return false;
    }
</script>
</html>