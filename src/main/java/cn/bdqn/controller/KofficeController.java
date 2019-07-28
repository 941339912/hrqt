package cn.bdqn.controller;

import cn.bdqn.entity.Doctor;
import cn.bdqn.entity.Koffice;
import cn.bdqn.service.doctor.DoctorService;
import cn.bdqn.service.koffice.KofficeService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class KofficeController {

    @Resource
    private KofficeService kofficeService;
    @Resource
    private DoctorService doctorService;

    @RequestMapping("/emphasisKoffice")
    @ResponseBody
    public String getEmphasisKoffice(){
        List<Koffice> list = kofficeService.findEmphasisList();
        return JSON.toJSONString(list);
    }

    @RequestMapping("/kofficeById")
    public String getKofficeById(Integer id, Model model){
        Koffice koffice = kofficeService.findKofficeById(id);
        List<Doctor> list = doctorService.findListByKId(id);
        model.addAttribute("doctorList",list);
        model.addAttribute("koffice",koffice);
        return "keshimx";
    }

    @RequestMapping("/doctorByKId")
    public String doctorByKId(Integer id, Model model){
        List<Doctor> list = doctorService.findListByKId(id);
        model.addAttribute("doctorList",list);
        return "keshiys";
    }

}
