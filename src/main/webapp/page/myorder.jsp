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
    <title>订单</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <%@include file="model/nav.jsp" %>
    <div class="head">
        <div class="headInfo">
            个人信息
        </div>
    </div>
    <div class="bodyInfo">

        <table class="table">
            <h3>订单列表</h3>
            <thead>
            <tr>
                <th>id</th>
                <th>商户</th>
                <th>客户</th>
                <th>金额</th>
                <th>创建时间</th>
                <th>支付状态</th>
                <th>处理状态</th>
                <th>到店时间</th>
                <th>离店时间</th>
                <th>订单操作</th>
            </tr>
            </thead>
            <tbody id="orders">
            </tbody>
        </table>
        <table class="table">
            <h3>修改订单</h3>
            <thead>
            <tr>
                <th>id</th>
                <th>客户</th>
                <th>支付状态</th>
                <th>到店时间</th>
                <th>离店时间</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><input type="text" id="id"/></th>
                <th><input type="text" id="customer" value="2"/></th>
                <th><input type="text" id="status_pay" value="paid"/></th>
                <th><input type="text" id="arrive_date" value="2018-5-16"/></th>
                <th><input type="text" id="leave_date" value="2018-5-28"/></th>
            </tr>
            </tbody>
        </table>
    </div>

    <a href="experienceRoom.jsp"><button type="button" class="btn btn-primary btn-lg" style="float: right;margin: 30px;">新建订单</button></a>
    <button type="button" onclick="updateOrder()" class="btn btn-primary btn-lg" style="float: right;margin: 30px;">修改订单</button>
    <button type="button" onclick="selectOrder()" class="btn btn-primary btn-lg" style="float: right;margin: 30px;">筛选订单</button>

</div>
<script>
    data = {action: 'listOrder'};
    opt_data = {};
    function getdata(){
        //读取输入框数据
        opt_data['id'] = $("#id").val();
        opt_data['customer'] = $("#customer").val();
        opt_data['status_pay'] = $("#status_pay").val();
        opt_data['arrive_date'] = $("#arrive_date").val();
        opt_data['leave_date'] = $("#leave_date").val();
    }

    function updateOrder() {
        //修改订单
        getdata();
        opt_data['action'] = 'updateOrder';
        $.post("/gotrip", opt_data, function () {
            window.location.reload();
        })
    }

    function selectOrder() {
        //查询订单
        opt_data['action'] = 'selectOrder';
        getdata();
        showOders(opt_data);
    }

    function showOders(datas){
        $.post("/gotrip", datas, function (res) {
            var json = JSON.parse(res);
            var orders = json['orders'];
            var table = "";
            for (i in orders) {
                order = orders[i];
                table += "            <tr>\n" +
                    "                <td>" + order['id'] + "</td>\n" +
                    "                <td>" + order['seller'] + "</td>\n" +
                    "                <td>" + order['customer'] + "</td>\n" +
                    "                <td>" + order['money'] + "</td>\n" +
                    "                <td>" + order['create_time'] + "</td>\n" +
                    "                <td>" + order['status_pay'] + "</td>\n" +
                    "                <td>" + order['status_handle'] + "</td>\n" +
                    "                <td>" + order['arrive_date'] + "</td>\n" +
                    "                <td>" + order['leave_date'] + "</td>\n" +
                    "                <td><button type=\"button\" onclick=\"deleteOrder(" + order['id'] + ")\">删除</button>\n" +
                    // "                <button type=\"button\" onclick=\'modify()\'>修改</button></td>\n" +
                    "            </tr>"
            }
            document.getElementById("orders").innerHTML = table;
        });
    }
    showOders(data);

    function deleteOrder(id) {
        console.log(id);
        $.post("/gotrip", {action: 'deleteOrder', id: id}, function (res) {
            console.log(res);
            window.location.reload()
        });
    }
</script>

</body>
</html>
