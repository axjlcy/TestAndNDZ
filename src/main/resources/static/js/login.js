//初始化变量
var loginButton = $('#btn-login');

//登录禁止输入空格
verifyBlank = function (el) {
    el.value = el.value.replace(/\s/g, "");
}

login = function () {
    $.ajax({
        type: "POST",
        url: "/login/ajax",
        data: JSON.stringify({userName: $('#userName').val(), passWord: $('#passWord').val()}),
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        beforeSend: function () {
            // 禁用按钮防止重复提交
            loginButton.attr({"readonly": "readonly", "disabled": "disabled"});
        },
        success: function (data) {
            console.log(data);
            if (data.resp_code === '0000') {
                window.location.href = "register.html";
            } else {
                alert(data.resp_desc);
            }
        },
        error: function (XMLHttpResponse, textStatus, errorThrown) {
            console.log("1 异步调用返回失败,XMLHttpResponse.readyState:" + XMLHttpResponse.readyState);
            console.log("2 异步调用返回失败,XMLHttpResponse.status:" + XMLHttpResponse.status);
            console.log("3 异步调用返回失败,textStatus:" + textStatus);
            console.log("4 异步调用返回失败,errorThrown:" + errorThrown);
            alert("系统异常,请稍候再试!");
            //loginButton.attr({"readonly": true, "disabled": false});
        }

    });

}

