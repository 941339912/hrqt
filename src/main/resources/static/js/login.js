createCode();
!function () {
    var layer = layui.layer,
        form = layui.form,
        carousel = layui.carousel;
    // 背景图片轮播
    carousel.render({
        elem: '#login_carousel',
        width: '100%',
        height: '100%',
        interval: 3000,
        arrow: 'none',
        anim: 'fade',
        indicator: 'none'
    });
}();


//登录
function jump() {
    var phone = $("#account").val();
    var password = $("#password").val();
    if (phone == "" || phone == null || password == "" || password == null || $("#code").val() == "" || $("#code").val() == null) {
        layer.msg("必填项不能为空", {
            icon: 7
        });
        window.event.returnValue = false;
        return false;
    }

    $.post("dologin", {phone: phone,password:password}, function (data) {
        var user = data.user;
        var md5Password = data.md5Password;
        var inputCode = document.getElementById("code").value.toUpperCase(); //取得输入的验证码并转化为大写
        if (user != null) {
            if(md5Password != user.password){
                layer.msg("密码输入错误！@_@", {
                    icon: 2
                });
                $("#password").val("");
                $("#code").val("");
                createCode();//刷新验证码
                return;
            }else if (inputCode != code){
                layer.msg("验证码输入错误！@_@", {
                    icon: 2
                });
                createCode();//刷新验证码
                $("#code").val("");//清空文本框
                $("#code").focus();//重新聚焦验证码框
                YZM = false;
                return;
            } else {
                layer.msg("登录成功", {
                    icon: 6
                });
                YZM = true;
                setTimeout(function () {
                    location.href = "index?userName=" + user.userName;
                }, 2000);
            }
        } else {
            layer.msg("该手机号尚未注册", {
                icon: 2
            });
            $("#account").val("");
            $("#password").val("");
            $("#code").val("");
            createCode();
            return;
        }
    }, "json");
    window.event.returnValue = false;
};


//验证码
var code; //在全局定义验证码
//产生验证码
function createCode() {
    code = "";
    var codeLength = 4;//验证码的长度
    var checkCode = document.getElementById("yzm");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//随机数
    for (var i = 0; i < codeLength; i++) {//循环操作
        var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）
        code += random[index];//根据索引取得随机数加到code上
    }
    checkCode.value = code;//把code值赋给验证码
    // alert(code);
}

