<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/loginAndRegister.css" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="container" id="login">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" id="registerForm">
                <span class="heading">用户注册</span>
                <div class="form-group">
                    <input type="email" class="form-control" id="name" name="name" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" id="Email" name="email" placeholder="电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>                <div class="form-group help">
                <input type="password" class="form-control" id="surePassword" name="surePassword" placeholder="再次验证密码">
                <i class="fa fa-lock"></i>
                <a href="#" class="fa fa-question-circle"></a>
            </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default" onclick="register()">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    // setTimeout(function () {
    //     let password = document.getElementById("password");
    //     let surePassword = document.getElementById("surePassword");
    //     if(password !== surePassword){
    //
    //     }
    // },1000);
    function register() {
        document.getElementById("registerForm").submit();
    }
</script>
</html>
