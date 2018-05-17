<script>
     data = { action : 'getOrder', column : 'id', value : '1' };
    $.post("/minsu", data, function (res) {
        console.log(res);
    });
</script>
