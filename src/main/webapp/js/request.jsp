<%@page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>
<script>
    function loadXMLDoc()
    {
        var xmlhttp;
        var data = {
            action : 'getOrder',
            column : 'id',
            value : '1'
        };
        if (window.XMLHttpRequest)
        {
            // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST","/try/ajax/demo_post.php",true);
        xmlhttp.send(data);
    }
</script>

<!--
调用方式
restful('login', data).then(show);
restful('login', data).then(() => {

});

回调函数
function show(res）{
     return res.data;
}
-->


