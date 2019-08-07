$(function () {
    var NewOrGongGao = 1;
    var ydcs = 0;
    NewOrGongGao=$("#newsGg").val();
    $("section").html("");
    $.post("indexNews",{currPage:0, NewOrGongGao:NewOrGongGao,ydcs:ydcs},function (data) {
        // alert(data.newsList.length);
        var newsList = data.newsList;
        var pb = data.pb;
        var $section = $("section"); //获取section标签
        var $str = $("<div class=\"bread\">您所在的位置<span><a href=\"index\">首页</a>>" +
            "<a href=\"#\">新闻动态</a> > <span id='s_weizhi'></span></span></div>\n" +
            "    <div class=\"baseLeft\"><div class=\"title title05_19\">新闻动态</div>\n" +
            "        <div class=\"newsMenu\"><ul id=\"ulNews_caidan\">" +
            "<li class=\"first active\"><a href=\"news?NewOrGongGao=2\" title=\"新闻快讯\"><em>新闻快讯</em></a></li>\n" +
            "                <li><a href=\"news?NewOrGongGao=1\" title=\"最新公告\"><em>最新公告</em></a></li>\n" +
            "            </ul></div>\n" +
            "        <div class=\"tools\"><a href=\"http://www.o2omed.com.cn/\" target=\"_blank\">" +
            "<img src=\"images/ico_001.gif\" width=\"52\" height=\"52\"><em>互联智慧分诊平台</em></a><a\n" +
            "                style=\"margin-right:0;\" href=\"96195\"><img src=\"images/ico_002.gif\" width=\"52\" height=\"52\">" +
            "<em><span>96195</span>综合平台</em></a><a href=\"Hospital\"><img src=\"images/ico_003.gif\" width=\"52\" height=\"52\">" +
            "<em>名医馆</em></a><a style=\"margin-right:0;\" href=\"DrugsInfo\" class=\"last\">" +
            "<img src=\"images/ico_004.gif\" width=\"52\" height=\"52\"><em>信息查询</em></a>\n" +
            "            <div class=\"clear\"></div></div></div>");
        var $str2 = $("<div class=\"baseRight\" id=\"news_title\"><div class=\"title02\">\n" +
            "            <a href=\"#\" id=\"DateAscOrDesc\">发布时间排序</a>\n" +
            "            <a href=\"#\" id=\"HitAscOrDesc\">阅览次数排序</a>\n" +
            "            <span class=\"count\">共发布文章<em id=\"EMCount\">"+pb.totalCount+"</em>篇</span>\n" +
            "        </div><div class=\"clear\"></div><div class=\"newList\"><ul id=\"ulNews\">\n" +
            "         </ul></div><div class=\"clear\"></div><div id=\"anpNews\"></div></div>\n" +
            "    <div class=\"clear\"></div>");
        $section.append($str).append($str2);
        if(NewOrGongGao==1){
            $("#s_weizhi").text("最新公告");
            $("#news_title").prepend("<div class=\"title01\">最新公告</div>");
            $("#ulNews_caidan li:first").removeClass("first active");
            $("#ulNews_caidan li:last").addClass("first active");
        }else if(NewOrGongGao==2){
            $("#s_weizhi").text("新闻快讯");
            $("#news_title").prepend("<div class=\"title01\">新闻快讯</div>");
            $("#ulNews_caidan li:last").removeClass("first active");
            $("#ulNews_caidan li:first").addClass("first active");
        }
        for (var i=0;i<newsList.length;i++){
            $("#ulNews").append("<li>\n" +
                "<div class=\"headLines\"><a href=\"newslist?id="+newsList[i].id+"\" title=\""+newsList[i].title+"\" class=\"title\">"+newsList[i].id+"--"+newsList[i].title+"</a>\n" +
                "<p style=\"display:-webkit-box; -webkit-line-clamp:3; -webkit-box-orient:vertical; overflow:hidden;\">"+newsList[i].content+"</p>\n" +
                "</div><div class=\"date\"><h3>发布时间</h3><h4>"+newsList[i].createDate+"</h4><p>阅览次数<span>"+newsList[i].readNum+"</span></p></div>\n" +
                "<div class=\"listBtn\"><a href=\"newslist?id="+newsList[i].id+"\" title=\""+newsList[i].title+"\">进入</a></div>\n" +
                "<div class=\"clear\"></div></li>");
        }
        var $p = $("#anpNews");
        var $a_first = $("<a href=\"#\" style=\"margin-right:5px;\">首页</a>").click(function(){gengduoClick(NewOrGongGao,1,0);});
        $p.append($a_first);
        if((pb.currPage+1) > 1) {
            var $a_prev = $("<a class=\"PNBtn\" href=\"#\" style=\"margin-right:5px;\"><</a>").click(function(){gengduoClick(NewOrGongGao,pb.currPage,0);});
            $p.append("&nbsp;").append($a_prev);
        }
        for ( var i = 0; i < pb.totalPageCount; i++) {
            // $btn_sz = $("<input type='button' class='index_btn_fy' value='"+(i+1)+"'/>").click(function(){getFyStu($(this).val(),0);});
            var $a_sz = $("<a href='#' style='margin-right:5px;'>"+(i+1)+"</a>").click(function(){gengduoClick(NewOrGongGao,$(this).text(),0);});
            $p.append($a_sz);
        }
        if((pb.currPage+1) < pb.totalPageCount) {
            var $a_next = $("<a class=\"PNBtn\" href=\"#\" style=\"margin-right:5px;\">></a>").click(function(){gengduoClick(NewOrGongGao,(pb.currPage+1)+1,0);});
            $p.append($a_next);
        }
        var $last = $("<a href=\"#\" style=\"margin-right:5px;\">尾页</a>").click(function(){gengduoClick(NewOrGongGao,pb.totalPageCount,0);});
        $p.append($last);
        //阅读次数排序
        $("#HitAscOrDesc").click(function () {
            ydcs=1;
            gengduoClick(NewOrGongGao,1,ydcs);
        });
        //发布时间排序
        $("#DateAscOrDesc").click(function () {
            ydcs=0;
            gengduoClick(NewOrGongGao,1,ydcs);
        });
    },"json");

})

function gengduoClick(NewOrGongGao,currPage,ydcs) {
    $("section").html("");
    $.post("indexNews",{currPage:currPage, NewOrGongGao:NewOrGongGao,ydcs:ydcs},function (data) {
        // alert(data.newsList.length);
        var newsList = data.newsList;
        var pb = data.pb;
        var $section = $("section"); //获取section标签
        var $str = $("<div class=\"bread\">您所在的位置<span><a href=\"index\">首页</a>>" +
            "<a href=\"#\">新闻动态</a> > <span id='s_weizhi'></span></span></div>\n" +
            "    <div class=\"baseLeft\"><div class=\"title title05_19\">新闻动态</div>\n" +
            "        <div class=\"newsMenu\"><ul id=\"ulNews_caidan\">" +
            "<li class=\"first active\"><a href=\"news?NewOrGongGao=2\" title=\"新闻快讯\"><em>新闻快讯</em></a></li>\n" +
            "                <li><a href=\"news?NewOrGongGao=1\" title=\"最新公告\"><em>最新公告</em></a></li>\n" +
            "            </ul></div>\n" +
            "        <div class=\"tools\"><a href=\"http://www.o2omed.com.cn/\" target=\"_blank\">" +
            "<img src=\"images/ico_001.gif\" width=\"52\" height=\"52\"><em>互联智慧分诊平台</em></a><a\n" +
            "                style=\"margin-right:0;\" href=\"96195\"><img src=\"images/ico_002.gif\" width=\"52\" height=\"52\">" +
            "<em><span>96195</span>综合平台</em></a><a href=\"Hospital\"><img src=\"images/ico_003.gif\" width=\"52\" height=\"52\">" +
            "<em>名医馆</em></a><a style=\"margin-right:0;\" href=\"DrugsInfo\" class=\"last\">" +
            "<img src=\"images/ico_004.gif\" width=\"52\" height=\"52\"><em>信息查询</em></a>\n" +
            "            <div class=\"clear\"></div></div></div>");
        var $str2 = $("<div class=\"baseRight\" id=\"news_title\"><div class=\"title02\">\n" +
            "            <a href=\"#\" id=\"DateAscOrDesc\">发布时间排序</a>\n" +
            "            <a href=\"#\" id=\"HitAscOrDesc\">阅览次数排序</a>\n" +
            "            <span class=\"count\">共发布文章<em id=\"EMCount\">"+pb.totalCount+"</em>篇</span>\n" +
            "        </div><div class=\"clear\"></div><div class=\"newList\"><ul id=\"ulNews\">\n" +
            "         </ul></div><div class=\"clear\"></div><div id=\"anpNews\"></div></div>\n" +
            "    <div class=\"clear\"></div>");
        $section.append($str).append($str2);
        if(NewOrGongGao==1){
            $("#s_weizhi").text("最新公告");
            $("#news_title").prepend("<div class=\"title01\">最新公告</div>");
            $("#ulNews_caidan li:first").removeClass("first active");
            $("#ulNews_caidan li:last").addClass("first active");
        }else if(NewOrGongGao==2){
            $("#s_weizhi").text("新闻快讯");
            $("#news_title").prepend("<div class=\"title01\">新闻快讯</div>");
            $("#ulNews_caidan li:last").removeClass("first active");
            $("#ulNews_caidan li:first").addClass("first active");
        }

        for (var i=0;i<newsList.length;i++){
            $("#ulNews").append("<li>\n" +
                "<div class=\"headLines\"><a href=\"newslist?id="+newsList[i].id+"\" title=\""+newsList[i].title+"\"  class=\"title\">"+newsList[i].id+"--"+newsList[i].title+"</a>\n" +
                "<p style=\"display:-webkit-box; -webkit-line-clamp:3; -webkit-box-orient:vertical; overflow:hidden;\">"+newsList[i].content+"</p>\n" +
                "</div><div class=\"date\"><h3>发布时间</h3><h4>"+newsList[i].createDate+"</h4><p>阅览次数<span>"+newsList[i].readNum+"</span></p></div>\n" +
                "<div class=\"listBtn\"><a href=\"newslist?id="+newsList[i].id+"\" title=\""+newsList[i].title+"\">进入</a></div>\n" +
                "<div class=\"clear\"></div></li>");
        }
        var $p = $("#anpNews");
        var $a_first = $("<a href=\"#\" style=\"margin-right:5px;\">首页</a>").click(function(){gengduoClick(NewOrGongGao,1,ydcs);});
        $p.append($a_first);
        if((pb.currPage+1) > 1) {
            var $a_prev = $("<a class=\"PNBtn\" href=\"#\" style=\"margin-right:5px;\"><</a>").click(function(){gengduoClick(NewOrGongGao,pb.currPage,ydcs);});
            $p.append("&nbsp;").append($a_prev);
        }
        for ( var i = 0; i < pb.totalPageCount; i++) {
            // $btn_sz = $("<input type='button' class='index_btn_fy' value='"+(i+1)+"'/>").click(function(){getFyStu($(this).val(),0);});
            var $a_sz = $("<a href='#' style='margin-right:5px;'>"+(i+1)+"</a>").click(function(){gengduoClick(NewOrGongGao,$(this).text(),ydcs);});
            $p.append($a_sz);
        }
        if((pb.currPage+1) < pb.totalPageCount) {
            var $a_next = $("<a class=\"PNBtn\" href=\"#\" style=\"margin-right:5px;\">></a>").click(function(){gengduoClick(NewOrGongGao,(pb.currPage+1)+1,ydcs);});
            $p.append($a_next);
        }
        var $last = $("<a href=\"#\" style=\"margin-right:5px;\">尾页</a>").click(function(){gengduoClick(NewOrGongGao,pb.totalPageCount,ydcs);});
        $p.append($last);
        //阅读次数排序
        $("#HitAscOrDesc").click(function () {
            ydcs=1;
            gengduoClick(NewOrGongGao,1,ydcs);
        });
        //发布时间排序
        $("#DateAscOrDesc").click(function () {
            ydcs=0;
            gengduoClick(NewOrGongGao,1,ydcs);
        });
    },"json");
}
