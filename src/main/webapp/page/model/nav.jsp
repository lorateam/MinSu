<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/17
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="../index.jsp" style="font-size: 25px">GoTrip</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right" style="font-size: 25px">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        发布/体验
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="../page/rentHouse.jsp" style="font-size: 25px">发布</a></li>
                        <li><a href="../myRoom.jsp" style="font-size: 25px">体验</a></li>
                    </ul>
                </li>
                <li><a href="#">故事</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        登陆/注册
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="../page/login.jsp" style="font-size: 25px">登陆</a></li>
                        <li><a href="../page/register.jsp" style="font-size: 25px">注册</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                欢迎您，Bolvvv
                <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                <li><a href="../page/myInformation.jsp" style="font-size: 25px">个人信息</a></li>
                <li><a href="../page/myRoom.jsp" style="font-size: 25px">MyRoom</a></li>
                </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
