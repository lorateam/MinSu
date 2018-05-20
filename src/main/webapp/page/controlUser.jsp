<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/20
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>controlUser</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/myInformation.css" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="head">
    <div class="headInfo">
        个人信息控制台
    </div>
</div>
<div class="bodyInfo">
    <div class="head">
        <div class="headInfo" style="font-size: 25px">
            删除账号
        </div>
    </div>
    <div class="bodyInfo" style="height: auto;">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="idForDelete" class="col-sm-2 control-label">用户id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="idForDelete" name="idForDelete"
                           placeholder="">
                </div>
                <input type="button" class="btn btn-primary btn-lg" style="float:right;" value="删除" onclick="deleteUser()">
            </div>
        </form>
    </div>
    <div class="head">
        <div class="headInfo" style="font-size: 25px">
            查询账号
        </div>
    </div>
    <div class="bodyInfo" style="height: auto;">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="idForSearch" class="col-sm-2 control-label">用户id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="idForSearch" name="idForSearch"
                           placeholder="">
                </div>
                <input type="button" class="btn btn-primary btn-lg" style="float:right;" value="搜索" onclick="searchUser()">
            </div>
        </form>
        <table class="table">
            <caption>查询结果</caption>
            <thead>
            <tr>
                <th>项目</th>
                <th>值</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td >账户</td>
                <td id="account"></td>
            </tr>
            <tr>
                <td >名称</td>
                <td id="name"></td>
            </tr>
            <tr>
                <td >email</td>
                <td id="email"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    function deleteUser() {
        let formData = new FormData();
        formData.append("action","deleteUser");
        formData.append("idForDelete",$("#idForDelete").val());
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
                    alert("删除账户成功!");
                    window.location.href='controlUser.jsp';
                }
                else {
                    alert("删除账户失败!");
                }
            }
        })
    }
    function searchUser() {
        let formData = new FormData();
        formData.append("action","searchUser");
        formData.append("idForSearch",$("#idForSearch").val());
        $.ajax({
            type:"post",
            url:"/gotrip",
            data:formData,
            processData:false,
            contentType:false,
            success: function (data) {
                let json = eval("("+data+")");
                if(json.status === "true")
                {
                    $("#account").html(json.account);
                    $("#name").html(json.name);
                    $("#email").html(json.email);
                }
                else
                {
                    alert("未查询到！");
                    $("#account").html("");
                    $("#name").html("");
                    $("#email").html("");
                }
            }
        })
    }
</script>
</html>
