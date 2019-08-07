$(function () {

    //点击搜索
    $("#search").click(function () {
        searchDate();
    });
});

function searchDate() {
    var type = $(".divType").text();
    var typeId;
    if (type == "全站内容"){
        typeId = 0;
    } else if (type == "医生查找"){
        typeId = 1;
    } else if (type == "科室查找"){
        typeId = 2;
    }
    $(".divType").text($("#typeId").val());
    $.post("searchDate",{typeId:typeId},function (data) {
        if (data != null){
            for (var i = 0; i < data.length; i++) {

            }
        }
    },"json");
}