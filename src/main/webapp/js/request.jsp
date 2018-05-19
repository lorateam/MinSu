<script>
     data = { action : 'listOrder'};
    $.post("/gotrip", data, function (res) {
        console.log(res);
    });
</script>
