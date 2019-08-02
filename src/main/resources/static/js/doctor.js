
$(function () {
    //首页默认加载
    $.post("queryDoc",{},function (data) {
        var doctorList = data.doctorList;
        var $ul = $(".ul_doctor");
        for (var i=0;i<doctorList.length;i++){
            $li = $("<li><a href=\"ys\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"img\"><img alt=\""+doctorList[i].dName+"\" title=\""+doctorList[i].dName+"\"\n" +
                "src=\"doctorImages/"+doctorList[i].photopath+"\" width=\"120\" height=\"162\"/></a>\n" +
                "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"name\">"+doctorList[i].dName+"</a>\n" +
                "<a href=\"keshi\" title=\""+doctorList[i].graduate+"\" target=\"_blank\" class=\"office\">"+doctorList[i].graduate+"</a>\n" +
                "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].postion+"\" target=\"_blank\" class=\"post\">"+doctorList[i].postion+"</a>\n" +
                "<a href=\"ys?did="+doctorList[i].id+"\" title=\"详细\" target=\"_blank\" class=\"btn more\">详细</a>\n" +
                "<a href=\"#\" target=\"_blank\" class=\"btn date\">预约</a></li>");
            $ul.append($li);
        }
    },"JSON");
    //搜索医生
    $("#btn_docQuery").click(function () {
        var text_doctor = $("#text_doctor").val();
        $.post("queryDoc",{dname:text_doctor},function (data) {
            var doctorList = data.doctorList;
            var $ul = $(".ul_doctor");
            $ul.html("");
            if(doctorList.length==0){
                $ul.html("<h1>不存在该医生</h1>")
            }
            for (var i=0;i<doctorList.length;i++){
                $li = $("<li><a href=\"ys\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"img\"><img alt=\""+doctorList[i].dName+"\" title=\""+doctorList[i].dName+"\"\n" +
                    "src=\"doctorImages/"+doctorList[i].photopath+"\" width=\"120\" height=\"162\"/></a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"name\">"+doctorList[i].dName+"</a>\n" +
                    "<a href=\"keshi\" title=\""+doctorList[i].graduate+"\" target=\"_blank\" class=\"office\">"+doctorList[i].graduate+"</a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].postion+"\" target=\"_blank\" class=\"post\">"+doctorList[i].postion+"</a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\"详细\" target=\"_blank\" class=\"btn more\">详细</a>\n" +
                    "<a href=\"#\" target=\"_blank\" class=\"btn date\">预约</a></li>");
                $ul.append($li);
            }
        },"JSON");
    });

    var pyli = $(".IndexWords ul li");
    var ziText ="";
    pyli.click(function () {
        // alert($(this).text());
        if($(this).text()==""||$(this).text()==null){
            ziText=$(this).text();
        }else {
            ziText=ziText+$(this).text();
        }
        $("#zimuId").val(ziText.toLowerCase());
        $.post("queryDoc",{dpinyin:$("#zimuId").val()},function (data) {
            var doctorList = data.doctorList;
            var $ul = $(".ul_zimu");
            $ul.html("");
            if(doctorList.length==0){
                $ul.html("<h1>不存在该医生</h1>")
            }
            for (var i=0;i<doctorList.length;i++){
                $li = $("<li><a href=\"ys\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"img\"><img alt=\""+doctorList[i].dName+"\" title=\""+doctorList[i].dName+"\"\n" +
                    "src=\"doctorImages/"+doctorList[i].photopath+"\" width=\"120\" height=\"162\"/></a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"name\">"+doctorList[i].dName+"</a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].graduate+"\" target=\"_blank\" class=\"office\">"+doctorList[i].graduate+"</a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\""+doctorList[i].postion+"\" target=\"_blank\" class=\"post\">"+doctorList[i].postion+"</a>\n" +
                    "<a href=\"ys?did="+doctorList[i].id+"\" title=\"详细\" target=\"_blank\" class=\"btn more\">详细</a>\n" +
                    "<a href=\"#\" target=\"_blank\" class=\"btn date\">预约</a></li>");
                $ul.append($li);
            }
        },"JSON");
    });

    $("#zimuDel").click(function () {
        ziText = $("#zimuId").val();
        ziText=ziText.substring(0,ziText.length-1);
        $("#zimuId").val(ziText);
        if($("#zimuId").val()==""){
            $(".ul_zimu").html("");
            return;
        }
        $.post("queryDoc",{dpinyin:$("#zimuId").val()},function (data) {
            var doctorList = data.doctorList;
            var $ul = $(".ul_zimu");
            $ul.html("");
            if(doctorList.length==0){
                $ul.html("<h1>不存在该医生</h1>")
            }
            for (var i=0;i<doctorList.length;i++){
                $li = $("<li><a href=\"ys\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"img\"><img alt=\""+doctorList[i].dName+"\" title=\""+doctorList[i].dName+"\"\n" +
                    "src=\"doctorImages/"+doctorList[i].photopath+"\" width=\"120\" height=\"162\"/></a>\n" +
                    "<a href=\"ys\" title=\""+doctorList[i].dName+"\" target=\"_blank\" class=\"name\">"+doctorList[i].dName+"</a>\n" +
                    "<a href=\"keshi\" title=\""+doctorList[i].graduate+"\" target=\"_blank\" class=\"office\">"+doctorList[i].graduate+"</a>\n" +
                    "<a href=\"ys\" title=\""+doctorList[i].postion+"\" target=\"_blank\" class=\"post\">"+doctorList[i].postion+"</a>\n" +
                    "<a href=\"ys\" title=\"详细\" target=\"_blank\" class=\"btn more\">详细</a>\n" +
                    "<a href=\"#\" target=\"_blank\" class=\"btn date\">预约</a></li>");
                $ul.append($li);
            }
        },"JSON");
    });
})
