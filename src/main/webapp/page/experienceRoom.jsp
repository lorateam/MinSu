<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>experienceRoom</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <link href="../css/myInformation.css" rel="stylesheet">
</head>
<body>
<%@include file="model/nav.jsp"%>
<div class="head">
    <div class="headInfo">
        体验民宿
    </div>
    <div class="bodyInfo">
        <form class="form-horizontal" role="form" action="/gotrip" method="post">
            <input class="form-control" id="action" name="action" value="addOrder" type="hidden"
                   placeholder="">
            <div class="form-group">
                <label for="seller" class="col-sm-2 control-label">卖家ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="seller" name="seller"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="customer" class="col-sm-2 control-label">买家ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customer" name="customer"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="money" class="col-sm-2 control-label">价格</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="money"  name="money"
                           placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="arrive_date" class="col-sm-2 control-label">到店时间</label>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" id="arrive_date" name="arrive_date"/>
                    <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                </div>
            </div>
            <div class="form-group">
                <label for="leave_date" class="col-sm-2 control-label">离店时间</label>
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" id="leave_date" name="leave_date"/>
                    <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                </div>
            </div>
            <button type="submit" class="btn btn-primary btn-lg" style="float: right;">下订单</button>
        </form>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            picker1.data('DateTimePicker').maxDate(e.date);
        });
    });
</script>