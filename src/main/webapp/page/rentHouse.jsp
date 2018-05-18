<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>rentHouse</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/myInformation" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="head">
    <div class="headInfo">
        发布房源
    </div>
    <div class="bodyInfo">
        <form class="form-horizontal" role="form" action="" method="post">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">民宿名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="firstname"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">地理位置</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lastname"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">具体描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="description"
                           placeholder="">
                </div>
            </div>
            <button type="submit" class="btn btn-primary btn-lg" style="float: right;">发布房源</button>
        </form>
    </div>
</div>
</body>
</html>
