$(function () {
    $.post("indexNews",{currPage:0, NewOrGongGao:1,ydcs:0},function (data) {
        var newsList = data.newsList;
        var $div_gonggao = $("#div_gonggao");
        for (var i = 0; i < newsList.length; i++) {
            if (i == 0) {
                $str = $("<div class=\"first\"><a href=\"newslist?id="+newsList[i].id+"\" id=\"ANoticeFirst\" target=\"_blank\"\n" +
                    "title=\"" + newsList[i].title + "\"><img src=\"pic/pic_005.jpg\" class=\"load\" width=\"126\"\n" +
                    "height=\"76\"/></a>\n" +
                    "<div><span>" + newsList[i].createDate + "</span><a href='newslist?id="+newsList[i].id+"' title='" + newsList[i].title + "' target='_blank'>" + newsList[i].title + "</a>\n" +
                    " </div>\n" +
                    "<div class=\"clear\"></div>\n" +
                    "</div><ul id='ul_gonggao'></ul>");
                $div_gonggao.append($str);
            } else {
                $str2 = $("<li><span>" + newsList[i].createDate + "</span> <a target=\"_blank\" href=\"newslist?id="+newsList[i].id+"\" title=\"" + newsList[i].title + "\">" + newsList[i].title + "</a></li>");
                $("#ul_gonggao").append($str2);
            }
        }
    },"JSON");

    $.post("indexNews",{currPage:0, NewOrGongGao:2,ydcs:0},function (data) {
        var newsList = data.newsList;
        var $div_new = $("#div_new");
        for (var i = 0; i < newsList.length; i++) {
            if (i == 0) {
                $str = $("<div class=\"first\"><a href=\"newslist?id="+newsList[i].id+"\" id=\"ANoticeFirst\" target=\"_blank\"\n" +
                    "title=\"" + newsList[i].title + "\"><img src=\"pic/pic_005.jpg\" class=\"load\" width=\"126\"\n" +
                    "height=\"76\"/></a>\n" +
                    "<div><span>" + newsList[i].createDate + "</span><a href='newslist?id="+newsList[i].id+"' title='" + newsList[i].title + "' target='_blank'>" + newsList[i].title + "</a>\n" +
                    " </div>\n" +
                    "<div class=\"clear\"></div>\n" +
                    "</div><ul id='ul_news'></ul>");
                $div_new.append($str);
            } else {
                $str2 = $("<li><span>" + newsList[i].createDate + "</span> <a target=\"_blank\" href=\"newslist?id="+newsList[i].id+"\" title=\"" + newsList[i].title + "\">" + newsList[i].title + "</a></li>");
                $("#ul_news").append($str2);
            }
        }
    },"JSON");
});