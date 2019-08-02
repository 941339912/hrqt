$(function () {

    $("#OSearchSwitch").click(function () {

        $.post("selectMedical",function (data) {
            var medicalList = data.medicalList;
            var officeList = data.officeList;
            var $div = $(".OListBase");
            for (var i = 0; i < medicalList.length; i++) {
                var $chirend = $("<div class=\"OList\"><h6>"+medicalList[i].name+"</h6></div>");
                    for (var j = 0; j < officeList.length; j++) {
                        if (medicalList[i].id == officeList[j].medicalId) {
                            var $item = $("<div class=\"item\"><span>> </span><a href=\"kofficeById?id="+officeList[j].id+"\">"+officeList[j].kName+"</a></div>");
                            $chirend.append($item);
                        }
                    }
                $div.append($chirend);
            }
        },"json");
    });

});

//显示重点科室
showEmphasisKoffice();

function showEmphasisKoffice() {
    $.post("emphasisKoffice",function (data) {
        var $ul = $("#officeEmphasis");
        for( var i = 0;i<data.length;i++ ){
            var $li = $("<li><i class=\"ico01\"></i>\n" +
                "                <div class=\"img animated\"><img alt=\""+data[i].kName+"\" src=\"pic/pic_007.png\" width=\"80\" height=\"80\"/></div>\n" +
                "                <a href=\"kofficeById?id="+data[i].id+"\" title=\"'"+data[i].kName+"'\" class=\"office\">"+data[i].kName+"</a>\n" +
                "                <p style=\"display:-webkit-box; -webkit-line-clamp:3; -webkit-box-orient:vertical; overflow:hidden;\">"+data[i].resume+"</p>\n" +
                "                <a href=\"kofficeById?id="+data[i].id+"\" title=\""+data[i].kName+"\" class=\"btn more\" >查看详细</a>\n" +
                "                <a href=\"doctorByKId?id="+data[i].id+"\" title=\""+data[i].kName+"\" class=\"btn doctor\">科室专家</a></li>\n");
            $ul.append($li);
        }
    },"json");
}