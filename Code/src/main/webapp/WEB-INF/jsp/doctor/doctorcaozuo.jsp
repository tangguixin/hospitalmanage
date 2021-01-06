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
                <h3 class="text-left">医生中心</h3>
            </div>
        </div>
        <hr />
        <ul class="nav nav-tabs">
            <li class="active"><a href="#order" data-toggle="tab">病历编辑</a></li>
            <li><a href="#userInfo" data-toggle="tab">检验申请</a></li>
            <li><a href="#waitinfo" data-toggle="tab">门诊处方</a></li>
            <li><a href="#chufanginfo" data-toggle="tab">历史病历查询</a></li>

        </ul>
        <br>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in text-left" id="order">
                <div class="col-md-12">
                    <p class="text-left">
                        <font color="#eb6864">病历编辑</font>
                    </p>
                </div>
                <form role="form" action="addcaserecoder" method="post" class="login-form">
                    <div class="form-group col-xs-12">
                        <label class="sr-only" for="patientId">病人id</label>病人id(*):<input
                            type="password" name="patientId" class="form-username form-control"
                            id="patientId" required style="font-weight: bold"/></span>
                    </div>
                    <div class="form-group col-xs-12">
                        <!-- 输入密码-->
                        <label class="sr-only" for="doctorId">医生id</label>医生id(*):
                        <input type="password" name="doctorId"
                               class="form-password form-control" id="doctorId"
                               style="font-weight: bold" required >
                    </div>
                    <div class="form-group col-xs-12">
                        <label class="sr-only" for="string">病例</label>病例(*):<input
                            type="text" name="string" class="form-username form-control"
                            id="string" required style="font-weight: bold"
                            />
                    </div>
                    <div class="form-group col-xs-12">
                        <button type="submit" class="btn">添加病例</button>
                    </div>
                </form>

            </div>
            <!-- 个人信息-->
            <div class="tab-pane fade text-left" id="userInfo">
                <div class="panel panel-primary text-left">
                    <div class="panel-heading">
                        <h3 class="panel-title">检验申请</h3>
                    </div>
                    <form role="form" action="addchecklist" method="post" class="login-form">
                        <div class="form-group col-xs-12">
                            <label class="sr-only" for="patientId">病人id</label>病人id(*):<input
                                type="password" name="patientId" class="form-username form-control"
                                id="patientId1" required style="font-weight: bold"/></span>
                        </div>
                        <div class="form-group col-xs-12">
                            <!-- 输入密码-->
                            <label class="sr-only" for="doctorId">医生id</label>医生id(*):
                            <input type="password" name="doctorId"
                                   class="form-password form-control" id="doctorId1"
                                   style="font-weight: bold" required >
                        </div>
                        <div class="form-group col-xs-12">
                            检查项(*): <select class="form-control input-control "
                                           name="checkId">
                            <option value="1">检查项1</option>
                            <option value="2">检查项2</option>
                            <option value="3">检查项3</option>
                            <option value="4">检查项4</option>
                        </select>
                        </div>
                        <div class="form-group col-xs-12">
                            <button type="submit" class="btn">添加检查单</button>
                        </div>
                    </form>

                </div>
            </div>
            <div class="tab-pane fade text-left" id="waitinfo">
                <div class="col-md-12">
                    <p class="text-left">
                        <font color="#eb6864">门诊处方</font>
                    </p>
                </div>

                <form role="form" action="addprescription" method="post" class="login-form">
                    <div class="form-group col-xs-12">
                        <label class="sr-only" for="patientId">病人id</label>病人id(*):<input
                            type="password" name="patientId" class="form-username form-control"
                            id="patientId2" required style="font-weight: bold"/></span>
                    </div>
                    <div class="form-group col-xs-12">
                        <!-- 输入密码-->
                        <label class="sr-only" for="doctorId">医生id</label>医生id(*):
                        <input type="password" name="doctorId"
                               class="form-password form-control" id="doctorId2"
                               style="font-weight: bold" required >
                    </div>
                    <div class="form-group col-xs-12">
                        药品(*): <select class="form-control input-control "
                                       name="drugid">
                        <option value="1">药品1</option>
                        <option value="2">药品2</option>
                        <option value="3">药品3</option>
                        <option value="4">药品4</option>
                    </select>
                    </div>
                    <div class="form-group col-xs-12">
                        <button type="submit" class="btn">添加处方单</button>
                    </div>
                </form>
            </div>
            <div class="tab-pane fade text-left" id="chufanginfo">
                <div class="col-md-12">
                    <p class="text-left">
                        <font color="#eb6864">历史病历查询</font>
                    </p>
                </div>

                <form role="form" action="getAllrecoderBypatientid" method="post" class="login-form">
                    <div class="form-group col-xs-12">
                        <!-- 输入密码-->
                        <label class="sr-only" for="patientId">patientId</label>密码(*):
                        <input type="password" name="patientId"
                               class="form-password form-control" id="patientId3"
                               style="font-weight: bold" required >
                    </div>
                    <div class="form-group col-xs-12">
                        <button type="submit" class="btn">立即查询</button>
                    </div>
                </form>
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