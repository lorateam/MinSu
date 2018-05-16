<%@page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<body>
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
