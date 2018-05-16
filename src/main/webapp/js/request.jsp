<script src="axios.min.js"></script>
<script>
    const service = axios.create({
        timeout: 5000,
    });
    const restful = (url, data) => {
        service({
            url,
            method: 'post',
            data,
        });
    };
</script>

<!--
调用方式
restful('login', data).then(show);

回调函数
function show(res）{
     return res.data;
}
-->


