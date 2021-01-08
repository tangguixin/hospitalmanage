<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>预约挂号</title>
    <!-- CSS -->
    <jsp:include page="../include/headtag.jsp" />
    <!-- <link rel="stylesheet"
        href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"> -->
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
                <h3 class="text-left">结算界面</h3>
            </div>
        </div>
        <div class="panel panel-primary text-left">
            <div class="panel-heading">
                <h3 class="panel-title">就诊人信息</h3>
            </div>
            <div class="panel-body">
                <div class="col-md-12">
                    <div class="col-md-4">
                        <h3>姓名：${commonUser.userName }&nbsp;</h3>
                    </div>
                    <div class="col-md-4">
                        <h3>性别：${commonUser.userSex }&nbsp;</h3>
                    </div>
                    <div class="col-md-4">
                        <h3>&nbsp;身份证：${commonUser.userIdenf }</h3>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-4">
                        <h3>年龄：${commonUser.userMobile }</h3>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-4">
                        <h3>退款金额：${退款金额}</h3>
                    </div>
                </div>

            </div>
        </div>
        <form class="form-search form-horizontal" id="orderInfo"
              action="<c:url value='/index1' />" method="post">
            <div class="form-group">
                <label for="diseaseInfo" class="col-lg-1 control-label">注释</label>
                <div class="col-lg-10">
                    <textarea class="form-control" rows="3" id="diseaseInfo" name="diseaseInfo"
                              style="margin: 0px -6.8375px 0px 0px; width: 424px; height: 80px;"
                              placeholder="可以填写注释"></textarea>
                </div>
            </div>
        </form>
        <div class="text-left">
            <label><input id="check_yuyue_rule" type="checkbox"
                          name="check_yuyue_rule" value="1"
                          style="border: none; margin: 4px 5px 0 0;" class="must_choose fl">
                我已经确认我的个人信息</label>
        </div>
        <div class="text-left">
            <button onclick="submitOrder()" class="btn btn-primary btn-lg"
                    id="submitOrder">提交订单</button>
        </div>
    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

</body>
<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/bootstrap/js/jquery.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
    function submitOrder() {
        var $check_yuyue_rule = $("#check_yuyue_rule");
        if ($check_yuyue_rule.is(":checked")) {
            $("#orderInfo").submit();
            return false;
        }
        alert("请确认您的基本信息！")
    }
</script>
</html>