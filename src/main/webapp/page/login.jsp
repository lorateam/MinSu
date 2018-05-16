<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
                <div class="form-group">
                    <span class="text" style="font-size: 15px"><span class="text">未注册？</span>
                        <button class="btn btn-default"><a href="register.jsp">立即注册</a></button></span>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
