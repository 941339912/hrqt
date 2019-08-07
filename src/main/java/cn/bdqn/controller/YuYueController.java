package cn.bdqn.controller;

import cn.bdqn.entity.Doctor;
import cn.bdqn.entity.Koffice;
import cn.bdqn.entity.ZuoZhen;
import cn.bdqn.service.doctor.DoctorService;
import cn.bdqn.service.koffice.KofficeService;
import cn.bdqn.service.yuyue.ZuoZhenService;
import cn.bdqn.utils.AddDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class YuYueController {

    @Resource
    private KofficeService kofficeService;
    @Resource
    private DoctorService doctorService;
    @Resource
    private ZuoZhenService zuoZhenService;

    @RequestMapping("/goYuYue")
    public String goYuYue(Integer dId, Model model){
        Doctor doctor = doctorService.getByIdDoctor(dId);
        Koffice koffice = kofficeService.findKofficeById((int) doctor.getkId());
        ZuoZhen zuoZhen = zuoZhenService.getZuoZhenBydId(dId);
        String rq = (AddDate.dateToStr(zuoZhen.getsTime())).substring(0,AddDate.dateToStr(zuoZhen.getsTime()).indexOf(" "));
        String sd = AddDate.getAMAndPMByDate(AddDate.dateToStr(zuoZhen.getsTime()),AddDate.dateToStr(zuoZhen.geteTime()));
        List<String> dateList = AddDate.TimeAdd(AddDate.dateToStr(zuoZhen.getsTime()),AddDate.dateToStr(zuoZhen.geteTime()));
        model.addAttribute("doctor",doctor);
        model.addAttribute("office",koffice);
        model.addAttribute("rq",rq+sd);
        model.addAttribute("dateList",dateList);
        return "yuyue";
    }
}
