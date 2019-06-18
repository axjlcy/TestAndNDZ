//初始化变量
var loginButton = $("#btn-login"),
    userName = $("#userName"),
    passWord = $("#passWord");

//登录禁止输入空格
function verifyBlank(el){
    el.value = el.value.replace(/^\s/g,"");
}

login = function () {
    var date;
    date = {
        "userName" : userName.val(),
        "passWord" : passWord.val()
    };
    $.ajax({
            type: "POST",
            url: "login.action",
            data: JSON.stringify(date),
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            beforeSend: function () {
                // 禁用按钮防止重复提交
                loginButton.attr({"readonly": "readonly", "disabled": "disabled"});
            },
            error: function () {
                alert("系统异常,请稍候再试!");
                loginButton.attr({"readonly": false, "disabled": false});
            },
            success: function (data) {
                if (data.resp_code === '0000') {
                    window.location.href = "";
                }
                else {
                    alert(data.resp_desc);
                }
            }
    }
    )
    
}

