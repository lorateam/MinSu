<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/loginAndRegister.css" rel="stylesheet">
    <link href="../css/myRoom.css" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="chooseInfor">
    <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
            type="button"> 已发布房源
    </button>
    <button id="someRoomRent" class="btn btn-primary" data-loading-text="Loading..."
            type="button"> 已租房间
    </button>
</div>
<div class="showInformationDiv">
    <div>
        <%@include file="model/sellerHouseInforModel.jsp"%>
    </div>
</div>
</body>
</html>
