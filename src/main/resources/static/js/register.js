createCode();
$(function () {
    var layer = layui.layer,
        form = layui.form;
    $("#reg").addClass("layui-btn-disabled");
    $("#reg").prop("disabled", "disabled");

//当勾选不同意协议按钮后禁止注册
    form.on("checkbox(agreen-checkbox)", function (data) {
        if (!data.elem.checked) {
            $("#reg").addClass("layui-btn-disabled");
            $("#reg").prop("disabled", "disabled");
        } else {
            $("#reg").removeClass("layui-btn-disabled");
            $("#reg").removeAttr("disabled");
        }
    });

    var InterValObj; // 定时器变量
    var count = 60; // 间隔函数，1秒执行
    var curCount; // 当前剩余秒数
    var msg_send_count = 0;
    // 发送验证码
    $("#getSmsCode").on("click", function() {
        var phone = $("#phone").val();
        if (phone == "") {
            layer.msg("手机号不能为空", {
                icon: 2,
                time: 1500
            });
            return;
        }
        if($(this).prop("disabled") != "disabled") {
            dx();
            msg_send_count++;
            curCount = count;
            // 设置button效果，开始计时
            $("#getSmsCode").addClass("layui-btn-disabled");
            $("#getSmsCode").prop("disabled", "disabled"); // 设置按钮为禁用状态
            $("#getSmsCode").text("正在发送..."); // 更改按钮文字
            // 向后台发送处理数据
            if(curCount==count) {
                $("#getSmsCode").text(curCount + "秒后再次获取"); // 更改按钮文字
                InterValObj = setInterval(SetRemainTime,1000); // 启动计时器timer处理函数，1秒执行一次
            } else {
                layui.msg(result.msg);
                $("#getSmsCode").text("重新发送验证码");
                $("#getSmsCode").removeClass("layui-btn-disabled");
                $("#getSmsCode").removeAttr("disabled"); // 移除禁用状态改为可用
            }
        }
    });
    function SetRemainTime() {
        if(curCount == 0) {
            clearInterval(InterValObj); // 停止计时器
            $("#getSmsCode").removeClass("layui-btn-disabled");
            $("#getSmsCode").removeAttr("disabled"); // 移除禁用状态改为可用
            $("#getSmsCode").text("重新发送验证码");
        } else {
            curCount--;
            $("#getSmsCode").text(curCount + "秒后再次获取");
        }
    }

});


$("#phone").blur(function () {
    if (!/^1[34578]\d{9}$/.test($("#phone").val())) {
        layer.msg("请先输入正确的手机号", {
            icon: 5,
            time:1500
        });
        return false;
    }
});

$("#password").attr("placeholder", "请输入密码");
$("#password").focus(function () {
    $("#password").attr("placeholder", "以字母开头的6-18位字符、数字和下划线");
});

$("#password").blur(function () {
    if ($("#password").val() == "" || $("#password").val() == null) {
        $("#password").attr("placeholder", "请输入密码");
    }
    if (!/^[a-zA-Z]\w{5,17}$/.test($("#password").val())) {
        layer.msg("密码格式不正确", {
            icon: 5,
            time:1500
        });
        return false;
    }
});


$("#password2").blur(function () {
    if ($("#password2").val() != "" && $("#password2").val() != null && $("#password").val() != $("#password2").val()) {
        layer.msg("两次密码必须一致", {
            icon: 5,
            time:1500
        });
    }
});

$("#identityId").blur(function () {
    if (!/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test($("#identityId").val())) {
        layer.msg("身份证号格式不正确", {
            icon: 5,
            time:1500
        });
        return false;
    }
});

function jump() {
    var phone = $("#phone").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();
    var userName = $("#userName").val();
    var identityId = $("#identityId").val();
    var roleId = 4;
    var msg_code = $("#msg_code").val();

    var inputCode = document.getElementById("code").value.toUpperCase(); //取得输入的验证码并转化为大写
    if (userName == "") {
        layer.msg("用户名不能为空", {
            icon: 2,
            time:1500
        });
        createCode();
        $("#code").val("");
        msg_code = "";
        return false;
    }

    if (password == "") {
        layer.msg("密码不能为空", {
            icon: 2,
            time:1500
        });
        createCode();
        $("#code").val("");
        msg_code = "";
        return false;
    }

    if ($("#password").val() !="" && $("#password").val() != null && $("#password2").val() == "" || $("#password2").val() == null) {
        layer.msg("请再次输入密码", {
            icon: 7,
            time:1500
        });
        return false;
    }

    if (identityId == "") {
        layer.msg("身份证号不能为空", {
            icon: 2,
            time:1500
        });
        createCode();
        $("#code").val("");
        msg_code = "";
        return false;
    }

    if (phone == "") {
        layer.msg("手机号不能为空", {
            icon: 2,
            time:1500
        });
        createCode();
        $("#code").val("");
        msg_code = "";
        return false;
    }

    if ($("#msg_code").val() == "" || $("#msg_code").val() == null){
        layer.msg("短信验证码不能为空", {
            icon: 7,
            time:1500
        });
        return false;
    }
    if ($("#code").val() == "" || $("#code").val() == null){
        layer.msg("验证码不能为空", {
            icon: 7,
            time:1500
        });
        return false;
    }
    if (inputCode != code) {
        layer.msg("验证码输入错误！@_@", {
            icon: 2,
            time:1500
        });
        createCode();//刷新验证码
        $("#code").val("");//清空文本框
        $("#code").focus();//重新聚焦验证码框
        return false;
    }
    $.ajax({
        url: "doregist",
        data: {phone: phone, password: password, userName: userName, identityId: identityId, roleId: roleId,msgCode:msg_code},
        type: "POST",
        dataType: "json",
        success: function(data) {
            var result = data.result;
            var flag = data.flag;
            if (flag == false) {
                layer.msg("短信验证码错误", {
                    icon: 2,
                    time:1500
                });
                $("#msg_code").val("");
                return false;
            }
            if (result == 1&&flag) {
                layer.msg("注册成功", {
                    icon: 6,
                    time:1500
                });
                setTimeout(function () {
                    location.href = "index?userName=" + userName;
                }, 1500);
            } else if (result == 0) {
                layer.msg("该手机号已被注册", {
                    icon: 2,
                    time:1500
                });
                createCode();
                phone = "";
                password = "";
                password2 = "";
                $("#code").val("");
                msg_code = "";
                return false;
            } else if (result == 2) {
                layer.msg("该用户名已被使用", {
                    icon: 2,
                    time:1500
                });
                createCode();
                userName = "";
                $("#code").val("");
                msg_code = "";
                return false;
            } else if (result == 7) {
                layer.msg("该身份证已被使用", {
                    icon: 2,
                    time:1500
                });
                createCode();
                $("#code").val("");
                msg_code = "";
                identityId = "";
                return false;
            }
        }
    });

}

function dx(){
    var phone=$("#phone").val();
    $.post("msgCode",{"phone":phone},function (data) {
        var msg = data.smsMassage;
        var msgStatics = data.msgStatics;
        if(msgStatics==1){
            layer.msg(""+msg+"", {
                icon: 6,
                time:1500
            });
        }else if(msgStatics==2){
            layer.msg(""+msg+"", {
                icon: 2,
                time:1500
            });
        }
    },"json");
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
    checkCode.value = code.toUpperCase();//把code值赋给验证码
    // var Code = checkCode.value.toUpperCase(); //取得输入的验证码并转化为大写
    // alert(code);
}