<<<<<<< HEAD
<%@page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>

=======
<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
>>>>>>> 6c9fa60c78f9ac160aace9c4e1a466d6050dcb52
<html>
<head>
    <title>GoTrip</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="page/model/nav.jsp"%>
<h2>Hello World!</h2>
<%@include file="js/request.jsp"%>

<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
    data = {
        action:'getOrder',
        column:'id',
        value:1
    };
    $.post("/minsu", data);
</script>
</body>
</html>
