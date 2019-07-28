$(function () {

    //单击科室简介
    $("#officejianjie").click(function () {
        alert("aaaa");
    });

});

//显示重点科室
showEmphasisKoffice();

function showEmphasisKoffice() {
    $.post("emphasisKoffice",function (data) {
        var $ul = $("#officeEmphasis");
        for( var i = 0;i<data.length;i++ ){
            var $li = $("<li><i class=\"ico01\"></i>\n" +
                "                <div class=\"img animated\"><img alt=\'"+data[i].kName+"'\" src=\"pic/pic_007.png\" width=\"80\" height=\"80\"/></div>\n" +
                "                <a href=\"kofficeById?id="+data[i].id+"\" title=\"'"+data[i].kName+"'\" class=\"office\">"+data[i].kName+"</a>\n" +
                "                <p style=\"display:-webkit-box; -webkit-line-clamp:3; -webkit-box-orient:vertical; overflow:hidden;\">"+data[i].resume+"</p>\n" +
                "                <a href=\"kofficeById?id="+data[i].id+"\" title=\"'"+data[i].kName+"'\" class=\"btn more\" >查看详细</a>\n" +
                "                <a href=\"doctorByKId?id="+data[i].id+"\" title=\"'"+data[i].kName+"'\" class=\"btn doctor\">科室专家</a></li>\n");
            $ul.append($li);
        }
    },"json");
}