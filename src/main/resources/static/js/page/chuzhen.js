$(function () {
    <!-- 医药部 -->
    $.post('navigation/1',function (data) {
        var medicals=data.medicals;
        var $p=$("#p");
        var $DepName=$("#DepName");
        for (var i=0;i<medicals.length;i++){
            var $str=$("<a href='javascript:;' aid='"+medicals[i].id+"' title=\'"+medicals[i].name+"\'>"+medicals[i].name+"</a>");
            $p.append($str);
            $("#p a:eq(0)").attr("class","current");

        }
        <!-- 大科室标题 -->
        var depName=$("#p a:eq(0)").attr("title");
        $DepName.html(depName);

        <!-- 默认医学部的下属科室 -->
        var aid=$("#p a:eq(0)").attr("aid");
        $.post('department',{medicalId:aid},function (data) {
            var koffices=data.koffices;
            var $pk=$("#pk");
            var $visitList=$("#visitList");
            for (var j=0;j<koffices.length;j++){
                var $str=$("<a href='javascript:;' kid='"+koffices[j].id+"' title=\'"+koffices[j].kName+"\'>"+koffices[j].kName+"</a>");
                $pk.append($str);
            }

            <!-- 默认医学部的大标题下的下属科室 -->
            for (var k=0;k<koffices.length;k++){
                /*$DIVWeekday.after(" <div class=\"visitList\">" +
                    "                <div class=\"namelist\"><h3>"+koffices[k].kName+"</h3><div class=\"clear\"></div>\n" +
                    "                </div></div>");*/

                var $str1=$("<div class=\"visitList\">" +
                    "                <div class=\"namelist\"><h3 id='kd' did='"+koffices[k].id+"'>"+koffices[k].kName+"</h3><div id='ys'></div><div class=\"clear\"></div>\n" +
                    "                </div></div>");
                $visitList.append($str1);
            }

            <!-- 获取默认科室下医生 -->
            var kid=$("#pk a:eq(0)").attr("kid");
            $.post('doctor',{kId:kid},function (data) {
                var doctors=data.doctors;
                var $ys=$("#ys");
                for (var i=0;i<doctors.length;i++){
                    var $str=$("<div class=\"list01 first\"><a target=\"_blank\" href=\"#\">"+doctors[i].dName+"</a></div>");
                    $ys.append($str);
                }
            },'json');
        },'json');
    },'json');

    <!-- 科室下的医生 -->
    $(document).on('click', '#kd', function() {
        var did=$(this).attr("did");
        $.post('doctor',{kId:did},function (data) {
            var doctors=data.doctors;
            var $ys=$("#ys");
            for (var i=0;i<doctors.length;i++){
                /*var $str=$("<div class=\"list01 first\"><a target=\"_blank\" href=\"Doctor-122\">"+doctors[i].dName+"</a></div>");
                $ys.append($str);*/
                did.after("<div class=\"list01 first\"><a target=\"_blank\" href=\"#\">"+doctors[i].dName+"</a></div>");
            }
        },'json');
    });

    <!-- 下属科室 -->
    $(document).on('click', '#p a', function() {
        $("#p a").attr("class","");
        $(this).attr("class","current");
        var id=$(this).attr("aid");
        <!--大标题-->
        var $title=$(this).attr("title");
        $("#DepName").html($title);
        $.post('department',{medicalId:id},function (data) {
            var koffices=data.koffices;
            var $pk=$("#pk");
            var $visitList=$("#visitList");
            $pk.html("");
            for (var j=0;j<koffices.length;j++){
                var $str=$("<a href='javascript:;' title=\'"+koffices[j].kName+"\'>"+koffices[j].kName+"</a>");
                $pk.append($str);
            }
            <!-- 清空 -->
            $visitList.html("");
            for (var k=0;k<koffices.length;k++){
                var $str1=$("<div class=\"visitList\">" +
                    "                <div class=\"namelist\"><h3>"+koffices[k].kName+"</h3><div id='ys'></div><div class=\"clear\"></div>\n" +
                    "                </div></div>");
                $visitList.append($str1);
            }
        },'json');
    });

    <!-- 日期 -->
    date();
});

function date() {
    var date=new Date();
    var week = '('+['星期天','星期一','星期二','星期三','星期四','星期五','星期六'][date.getDay()]+')';
    var year=date.getFullYear()+'/';
    var month = (date.getMonth()+1)+'/';
    var day = date.getDate();
    var rq= (year+month+day);

    var $title=$("#title");
    for (var i=0;i<7;i++){
        var $str=$("<div class=\"wide\">"+week+" <em>"+rq+"</em><span class=\"green\">上午</span><span\n" +
            "class=\"blue\">下午</span></div>");
        $title.append($str);
    }
}
