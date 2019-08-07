$(function () {

    //默认选中第一个
    $(".dSourse>ul>li:eq(0)").addClass("current");

    //选择号源
    $(".dSourse>ul>li").click(function () {
        $(this).addClass("current");
        $(this).siblings("li").removeClass("current");
    });

    //点击提交
    $("#btnPostOrder").click(function () {
        $.post("",{},function (data) {

        },"json");
    });
});