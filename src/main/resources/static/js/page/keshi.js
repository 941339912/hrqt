$(function () {
    <!--一级菜单-->
    $.post('navigation/0',function (data) {
        var medicals=data.medicals;
        var $ddlDepartment=$("#ddlDepartment");
        for (var i=0;i<medicals.length;i++){
            var $str=$("<option value='"+medicals[i].id+"'>"+medicals[i].name+"</option>");
            $ddlDepartment.append($str);
        }
    },'json');
    <!--二级菜单-->
    $('#ddlDepartment').change(function () {
        var medicalId=$("#ddlDepartment").val();
        $.post('department',{medicalId:medicalId},function (data) {
            var koffices=data.koffices;
            var $ddlOffices=$("#ddlOffices");
            $ddlOffices.find("option:not(:first)").remove();
            for (var i=0;i<koffices.length;i++){
                var $str=$("<option value='"+koffices[i].id+"'>"+koffices[i].kName+"</option>");
                $ddlOffices.append($str);
            }

        },'json');
    });

    part();
});

function part() {
    $.post('navigation/0',function (data) {
        var medicals=data.medicals;
        var $part=$("#part");
        var $str;
        var $str2;
        for (var i=0;i<medicals.length;i++){
            $str=$("<div class=\"part01\" id=\"Department1\"><div class=\"partTitle\"><div class=\"left\">"+medicals[i].name+"</div><div class=\"right\">" +
                "<a class='green' href='DutyTime-1'>出诊安排</a></div></div>");
            $part.append($str);

            $.post('department',{medicalId:medicals[i].id},function (data) {
                var koffices=data.koffices;
                for (var j=0;j<koffices.length;j++){
                    $str2=$("<ul><li><span class='import1'></span><h3>"+koffices[j].kName+"</h3><p>"+koffices[j].resume.slice(0,40)+'...'+"</p>" +
                        "<div><a class=\"coffee\" href=\"keshimx\" title=\"呼吸内科\">查看详细</a><a class='green' href='keshiys' title='呼吸内科医生'>科室医生</a></div></li></ul>");
                    $str.append($str2);
                }
            },'json');
        }
    },'json');
}