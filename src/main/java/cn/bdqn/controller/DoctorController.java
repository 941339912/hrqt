package cn.bdqn.controller;

import cn.bdqn.entity.Doctor;
import cn.bdqn.service.doctor.DoctorService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DoctorController {

    @Resource
    private DoctorService doctorService;

    @RequestMapping("/queryDoc")
    @ResponseBody
    public Object queryDoc(String dname,String dpinyin){
        List<Doctor> doctorList = doctorService.getQueryDoctor(dname,dpinyin);
        Map<String,Object> docMap = new HashMap<String, Object>();
        docMap.put("doctorList",doctorList);
        return JSON.toJSONString(docMap);
    }

    @RequestMapping("/ys")
    public String ys(int did, Model model){
        Doctor doctor = doctorService.getByIdDoctor(did);
        model.addAttribute("doctor",doctor);
        return "ys";
    }

}
