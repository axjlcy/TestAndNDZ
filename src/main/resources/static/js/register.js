//注册禁止输入空格
verifyBlank = function (el) {
    el.value = el.value.replace(/\s/g, "");
}

register = function () {
    $.ajax({
        type: "POST",
        url: "/register/ajax",
        data: JSON.stringify({userName: $('#userName').val(), passWord: $('#passWord').val()}),
        dataType: "json",
        async: false,
        contentType: "application/json;charset=utf-8",
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#btn-register').attr({"readonly": true, "disabled": true});
        },
        success: function (data) {
            console.log(data);
            if (data.resp_code === '1112') {
                alert(data.resp_desc);
                window.location.href = "login.html";
            } else {
                alert(data.resp_desc);
                $('#btn-register').attr({"readonly": false, "disabled": false});
            }
        },
        error: function (XMLHttpResponse, textStatus, errorThrown) {
            console.log("1 异步调用返回失败,XMLHttpResponse.readyState:" + XMLHttpResponse.readyState);
            console.log("2 异步调用返回失败,XMLHttpResponse.status:" + XMLHttpResponse.status);
            console.log("3 异步调用返回失败,textStatus:" + textStatus);
            console.log("4 异步调用返回失败,errorThrown:" + errorThrown);
            alert("系统异常,请稍候再试!");
            $('#btn-register').attr({"readonly": false, "disabled": false});
        }

    });

}

