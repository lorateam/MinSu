<html>
<body>
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
</body>
</html>
