<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GoTrip</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<<<<<<< HEAD
<%@include file="page/model/nav.jsp"%>
=======
<h2>Hello World!</h2>
<%@include file="js/request.jsp"%>
<script>
    data = {
        action: "getOrder",
        column: "id",
        value: "1"
    }
    restful('login', data).then(show);

    回调函数
    function show(res）{
        return res.data;
    }
</script>
>>>>>>> 3fa779951f390e6711013d031d07c31d004e8275
</body>
</html>
