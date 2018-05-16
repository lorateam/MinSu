<%@page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="js/axios.min.js"></script>
<script>
    const service = axios.create({
        timeout: 5000
    });



    function restful(url, data){
        console.log("test");
        return service({
            url:url,
            method: 'post',
            data:data,
        });
    }
</script>

<!--
调用方式
restful('login', data).then(show);

回调函数
function show(res）{
     return res.data;
}
-->


