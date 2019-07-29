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
    var medId =0;
    $.post('navigation/0',{medicalId:medId},function (data) {
        var medicals=data.medicals;
        var koffices=data.koffices;
        var $part=$("#part");
        var $str;
        var $str2;
        for (var i=0;i<medicals.length;i++) {
            medId = medicals[i].id;
            $str = $("<div class=\"part01\" style='margin-top:50px;'><div class=\"partTitle\" style=' height:35px;'><div class=\"left\" style='width:auto; display:inline-block; font-size:18px; color:#333; line-height:18px; padding-bottom:12px; border-bottom:5px #6bcbca solid;'>" + medicals[i].name + "</div><div class=\"right\" style='float:right;'>" +
                "<a class='green' href='DutyTime-1' style='width:116px; height:33px; border:1px #dddddd solid; display:inline-block; text-align:center; line-height:35px; margin-left:5px; color:#fff;'>出诊安排</a></div></div>");
            $part.append($str);
            for (var j = 0; j < koffices.length; j++) {
                 // alert(medicals[0].id + "-----" + koffices[j].medicalId);
                if ((medicals[i].id) == (koffices[j].medicalId)) {
                    $str2 = $("<ul style='width:103%; height:auto; position:relative;'><li style='width:184px; height:170px; padding:40px 20px; background:#f4f4f4; float:left; margin-right:13px; margin-top:15px; text-align:center; line-height:22px; position:relative;'><span class='import1' style='width:20px; height:34px; display:block;position:absolute; top:2px; right:12px;background:url(../images/import.png) no-repeat;'></span><h3 style='color:#978571; font-size:16px; height:40px; line-height:18px;'>" + koffices[j].kName + "</h3><p>" + koffices[j].resume.slice(0, 40) + '...' + "</p>" +
                        "<div style='width:184px; height:30px; position:absolute; bottom:43px;'><a class=\"coffee\" href=\"keshimx\" title=\"呼吸内科\" style='left:13px;width:76px; height:30px; text-align:center; line-height:30px; position:absolute; bottom:0px; color:#fff;'>查看详细</a><a class='green' href='keshiys' title='呼吸内科医生' style='right:13px;'>科室医生</a></div></li></ul>");
                    $part.append($str2);
                }
            }
        }
    },'json');
}


// function part() {
//     $.post('navigation/0',function (data) {
//         var medicals=data.medicals;
//         var $part=$("#part");
//         var $str;
//         var $str2;
//         for (var i=0;i<medicals.length;i++){
//             $str=$("<div class=\"part01\" id=\"Department1\"><div class=\"partTitle\"><div class=\"left\">"+medicals[i].name+"</div><div class=\"right\">" +
//                 "<a class='green' href='DutyTime-1'>出诊安排</a></div></div>");
//             $.post('department',{medicalId:medicals[i].id},function (data) {
//                 var koffices=data.koffices;
//                 for (var j=0;j<koffices.length;j++){
//                     alert(medicals[0].id+"-----"+koffices[j].medicalId);
//                     if((medicals[i].id)==(koffices[j].medicalId)){
//                         $part.append($str);
//                     }
//                     $str2=$("<ul><li><span class='import1'></span><h3>"+koffices[j].kName+"</h3><p>"+koffices[j].resume.slice(0,40)+'...'+"</p>" +
//                         "<div><a class=\"coffee\" href=\"keshimx\" title=\"呼吸内科\">查看详细</a><a class='green' href='keshiys' title='呼吸内科医生'>科室医生</a></div></li></ul>");
//                     $str.append($str2);
//                 }
//             },'json');
//         }
//     },'json');
// }