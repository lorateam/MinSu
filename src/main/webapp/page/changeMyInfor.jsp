<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 6:30
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
            修改个人信息
        </div>
    </div>
    <div class="bodyInfo">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="id"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="account" class="col-sm-2 control-label">account</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="account" name="account"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">password</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email"
                           placeholder="">
                </div>
            </div>
            <button type="button" class="btn btn-primary btn-lg" style="float: right;" onclick="changeInfor()">修改信息</button>
        </form>
    </div>
</div>
<script>
    function changeInfor() {
        let formData = new FormData();
        formData.append("action","changeMyInfor");
        formData.append("id", $("#id").val());
        formData.append("account", $("#account").val());
        formData.append("name", $("#name").val());
        formData.append("password", $("#password").val());
        formData.append("email", $("#email").val());
        $.ajax({
            type:"post",
            url:"/gotrip",
            data:formData,
            processData:false,
            contentType:false,
            success: function (data) {
                let json = eval("("+data+")");
                if(json.status === "success")
                {
                    alert("修改信息成功");
                    window.location.href='myInformation.jsp';
                }
                else {
                    alert("修改信息失败!");
                }
            }
        })
    }
</script>
</body>
</html>
