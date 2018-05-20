<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/myInformation.css" rel="stylesheet">
</head>
<body>
<div>
    <%@include file="model/nav.jsp"%>
    <div class="head">
        <div class="headInfo">
            个人信息
        </div>
    </div>
    <div class="bodyInfo">
        <table class="table">
            <caption>基本信息</caption>
            <thead>
            <tr>
                <th>项目</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td >账户</td>
                <td id="account">Bangalore</td>
            </tr>
            <tr>
                <td >名称</td>
                <td id="name">Mumbai</td>
            </tr>
            <tr>
                <td >email</td>
                <td id="email">Mumbai</td>
            </tr>
            </tbody>
        </table>
        <button type="button" class="btn btn-primary btn-lg" style="float: right;" onclick="window.location.href='changeMyInfor.jsp'">修改信息</button>
    </div>
</div>
</body>
<script>
    $(document).ready(function(){
        let formData = new FormData();
        formData.append("action","showMyInfor");
        formData.append("id","41");
        $.ajax({
            type:"post",
            url:"/gotrip",
            data:formData,
            processData:false,
            contentType:false,
            success: function (data) {
                let json = eval("("+data+")");
                $("#account").html(json.account);
                $("#name").html(json.name);
                $("#email").html(json.email);
            }
        })
    });
</script>
</html>
