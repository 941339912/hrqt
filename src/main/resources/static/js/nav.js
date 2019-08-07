$(function () {

    //加载菜单
    $.post("menuList",function (data) {
        var menuList = data.menuList;
        var twoMenuList = data.twoMenuList;
        var $ul = $(".firstUl");
        var $ul_dh = $("#ul_dh");
        for (var i = 0; i < menuList.length; i++) {
            var $li =$("<li class=\"first\"><a href=\""+menuList[i].menuPath+"\" class=\"firstA\"><em>"+menuList[i].menuName+"</em><i class=\"style01\"></i><span></span></a></li>");
            var $div = $("<div class=\"QMSub QMSubMenus\"><ul></ul><div class=\"clear\"></div></div>");
            var $lidh = $("<li class=\"PMenu\" style='width:120px'><a href=\""+menuList[i].menuPath+"\" class=\"PAMenu\">"+menuList[i].menuName+"</a></li>");
            for (var j = 0; j < twoMenuList.length; j++) {
                if (menuList[i].id == twoMenuList[j].parentId) {
                    $li.append($div);
                    var $towLi = $("<li><a href=\""+menuList[i].menuPath+"\" title=\""+twoMenuList[j].menuName+"\">"+twoMenuList[j].menuName+"<span>进入</span></a></li>");
                    $li.children("div").children("ul").append($towLi);
                }
            }
            $ul_dh.append($lidh);
            $ul.append($li);
        }
    },"json");

    //鼠标移入事件
    $("nav .quickMenus").on("mouseenter","li.first",function () {
        $t=$(this);
        $obj=$t.find(".QMSub");
        if($obj.length>0){
            $obj.css("top",-(12+$t.index()*61)+"px");
            $obj.show();
        }
    });
    //鼠标移出事件
    $("nav .quickMenus").on("mouseleave","li.first",function () {
        $t=$(this);
        $obj=$t.find(".QMSub");
        if($obj.length>0){
            $obj.hide();
        }
    });
});