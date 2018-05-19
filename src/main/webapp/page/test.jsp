<%--
  Created by IntelliJ IDEA.
  User: Bolvvv
  Date: 2018/5/18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script id="portraitUpload" type="text/html">
    <div style="padding: 10px 20px">
        <form role="form" enctype="multipart/form-data" method="post">
            <div class="embed-responsive embed-responsive-16by9">
                <div class="embed-responsive-item pre-scrollable">
                    <img alt="" src="${pageContext.request.contextPath}/img/showings.jpg" id="cut-img"
                         class="img-responsive img-thumbnail"/>
                </div>
            </div>
            <div class="white-divider-md"></div>
            <input type="file" name="imgFile" id="fileUpload"/>
            <div class="white-divider-md"></div>
            <div id="alert" class="alert alert-danger hidden" role="alert"></div>
            <input type="hidden" id="x" name="x"/>
            <input type="hidden" id="y" name="y"/>
            <input type="hidden" id="w" name="w"/>
            <input type="hidden" id="h" name="h"/>
        </form>
    </div>
</script>
<body>
<form method="post" action="/test">
    <div><input name="action"></div>
    <input type="submit" value="提交">
</form>
</body>
</html>
