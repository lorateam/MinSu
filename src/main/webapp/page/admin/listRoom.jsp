<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: chanchan--%>
  <%--Date: 18-5-18--%>
  <%--Time: 上午3:38--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"--%>
    <%--pageEncoding="UTF-8" import="java.util.*" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--&lt;%&ndash;<%@include file="../include/admin/adminHeader.jsp"%>&ndash;%&gt;--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>房源管理</title>--%>
    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<link href="../../css/loginAndRegister.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
    <%--<%@include file="../model/nav.jsp"%>--%>
<%--</div>--%>
<%--<div class="workingArea">--%>
    <%--<h1 class="label label-info" >房源管理</h1>--%>
    <%--<br>--%>
    <%--<br>--%>

    <%--<div class="listDataTableDiv">--%>
        <%--<table class="table table-striped table-bordered table-hover  table-condensed">--%>
            <%--<thead>--%>
            <%--<tr class="success">--%>
                <%--<th>ID</th>--%>
                <%--<th>图片</th>--%>
                <%--<th>房间类型</th>--%>
                <%--<th>编辑</th>--%>
                <%--<th>删除</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach items="${thers}" var="r">--%>

                <%--<tr>--%>
                    <%--<td>${r.id}</td>--%>
                    <%--<td><img height="40px" src="../../img/room/${r.id}.jpg"></td>--%>
                    <%--<td>${r.room_type}</td>--%>

                    <%--<td><a href="admin_room_edit?id=${r.id}"><span class="glyphicon glyphicon-edit"></span></a></td>--%>
                    <%--<td><a deleteLink="true" href="admin_room_delete?id=${r.id}"><span class=" 	glyphicon glyphicon-trash"></span></a></td>--%>

                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>

    <%--&lt;%&ndash;<div class="pageDiv">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<%@include file="../include/admin/adminPage.jsp" %>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--<div class="panel panel-warning addDiv">--%>
        <%--<div class="panel-heading">新增分类</div>--%>
        <%--<div class="panel-body">--%>
            <%--<form method="post" id="addForm" action="admin_room_add" enctype="multipart/form-data">--%>
                <%--<table class="addTable">--%>
                    <%--<tr>--%>
                        <%--<td>房屋类型</td>--%>
                        <%--<td><input  id="room_type" name="room_type" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>房屋图片</td>--%>
                        <%--<td>--%>
                            <%--<input id="roomPic" accept="image/*" type="file" name="filepath" />--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr class="submitTR">--%>
                        <%--<td colspan="2" align="center">--%>
                            <%--<button type="submit" class="btn btn-success">提 交</button>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>

