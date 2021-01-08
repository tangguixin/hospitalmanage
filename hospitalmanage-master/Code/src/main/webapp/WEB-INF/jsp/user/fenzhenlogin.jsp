<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>医生登录</title>
    <jsp:include page="../include/headtag.jsp" />
    <!-- CSS -->

    <link rel="stylesheet"
          href="${mybasePath}assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${mybasePath}assets/css/form-elements.css">
    <link rel="stylesheet" href="${mybasePath}assets/css/style.css">

    <style>
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset;
            border: 1px solid #CCC !important;
        }
    </style>
</head>

<body>
<jsp:include page="../include/head.jsp" />
<jsp:include page="../include/menu.jsp" />
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3 style="color: #969696;">医生登录</h3>
                            <p>请输入密码</p>
                        </div>
                        <div class="pull-right-bottom">
                            <p class="text-danger"
                               style="position: absolute; right: 60px; bottom: 300px"
                               id="errorTip">${error}</p>
                        </div>

                    </div>

                    <div class="form-bottom">
                        <!-- 验证医生信息的函数，正确则去往门诊处理界面-->
                        <form role="form" action="fenzhenlogin1" method="post" class="login-form">
                            <div class="form-group col-xs-12">
                                <!-- 输入密码-->
                                <label class="sr-only" for="userPassword">Password</label>密码(*):
                                <input type="text" name="userPassword" placeholder="密码"
                                       class="form-password form-control" id="userPassword"
                                       style="font-weight: bold" required onkeyup="isClearTip()">
                            </div>
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn">立即登录</button>
                            </div>
                        </form>
                        <span><a href="index">放回主页</a></span>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


<!-- Javascript -->
<script src="${mybasePath}assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${mybasePath}assets/js/jquery.backstretch.min.js"></script>
<script src="${mybasePath}assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="assets/js/placeholder.js"></script>
<![endif]-->

<script type="text/javascript">
    function isClearTip() {
        document.getElementById("errorTip").innerHTML = "";
    }
</script>

</body>

</html>