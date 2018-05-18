<%--
  Created by IntelliJ IDEA.
  User: chanchan
  Date: 18-5-18
  Time: 上午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <title>房源管理</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../../css/loginAndRegister.css" rel="stylesheet">
</head>

<div>
    <%@include file="../model/nav.jsp"%>
</div>

<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("room_type","房屋类型"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_room_list">所有房间</a></li>
        <li class="active">编辑房间</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑房间</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_room_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>房屋类型</td>
                        <td><input  id="room_type" name="room_type" value="${r.room_type}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>房屋图片</td>
                        <td>
                            <input id="roomPic" accept="image/*" type="file" name="filepath" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${r.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>