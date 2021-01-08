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
<!-- 需要传回所有处方单 -->
<body>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/menu.jsp" />
<div id="page-wrapper" style="margin-top: 50px;">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-left">配药中心</h3>
            </div>
        </div>
        <hr />
        <ul class="nav nav-tabs">
            <li class="active"><a href="#order" data-toggle="tab">待处理处方</a></li>
        </ul>
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in text-left" id="order">
                <div class="col-md-12">
                    <p class="text-left">
                        <font color="#eb6864">待处理处方</font>
                    </p>
                </div>

                <table class="table table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>订单</th>
                        <th>患者id</th><!-- time-->
                        <th>医生id</th>
                        <th>药品id</th>
                        <th>操作</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 函数返回的处方表信息-->
                    <c:forEach var="orderRecords" items="${orderRecords }"
                               varStatus="status">
                        <tr>
                            <td>${ status.index + 1}</td>
                            <td>${orderRecords.patientId }</td><!-- time-->
                            <td>${orderRecords.doctorId }</td>
                            <td>${orderRecords.drugid }</td>
                            <td><c:if test="${orderRecords.jiesuan ==0}">
                                <a href="<c:url value='/addchufangqueue/${orderRecords.id}' />"><strong>取药</strong></a>
                                </c:if>
                                <c:if test="${orderRecords.jiesuan ==1}">
                                <a href="<c:url value='/addpeiyaoqueue/${orderRecords.id}' />"><strong>配药</strong></a>
                                </c:if>
                                <c:if test="${orderRecords.jiesuan ==2}">
                                <a href="<c:url value='/fayao/${orderRecords.id}' />"><strong>发药</strong></a>
                                </c:if>
                            <td>c:if test="${orderRecords.jiesuan !=-1}">
                            <a href="<c:url value='/tuiyao/${orderRecords.id}/${orderRecords.patientId}' />"><strong>退药</strong></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>


</html>