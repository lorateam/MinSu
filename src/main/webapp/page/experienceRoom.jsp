<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>experienceRoom</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/myInformation" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="head">
    <div class="headInfo">
        体验民宿
    </div>
    <div class="bodyInfo">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">卖家ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="firstname"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">买家ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lastname"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">价格</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="description"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">到店时间</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="arriveDate"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">离店时间</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="leaveDate"
                           placeholder="">
                </div>
            </div>
            <button type="submit" class="btn btn-primary btn-lg" style="float: right;">下订单</button>
        </form>
    </div>
</div>
</body>
</html>
