package cn.bdqn.controller;

import cn.bdqn.entity.Doctor;
import cn.bdqn.entity.Koffice;
import cn.bdqn.entity.Medical;
import cn.bdqn.service.doctor.DoctorService;
import cn.bdqn.service.koffice.KofficeService;
import cn.bdqn.service.koffice.MedicalService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

/**
 * 医学部、科室
 */

@Controller
public class KofficeController {

    @Resource
    private KofficeService kofficeService;
    @Resource
    private DoctorService doctorService;
    @Resource
    private MedicalService medicalService;

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
        model.addAttribute("kName",list.get(0).getkName());
        return "keshiys";
    }

    /*@RequestMapping("/officeList")
    public String officeList(Model model) {
        List<Koffice> officeList = kofficeService.findOfficeList();
        List<Medical> medicalList = medicalService.findMedicalList();
        model.addAttribute("officeList", officeList);
        model.addAttribute("medicalList", medicalList);
        return "keshi";
    }*/
    /**
         * 医药部下拉框
         * @param map
         * @return
         */
    @RequestMapping(value = "/navigation/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String navigation(@PathVariable("id") Long id, Map<String,Object> map){
        List<Medical> medicals=medicalService.selectMedicals(id);
        map.put("medicals",medicals);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/department",method = RequestMethod.POST)
    @ResponseBody
    public String department(String medicalId,Map<String,Object> map){
        List<Koffice> koffices=kofficeService.selectKoffices(Long.parseLong(medicalId));
        map.put("koffices",koffices);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/doctor",method = RequestMethod.POST)
    @ResponseBody
    public String doctor(String kId,Map<String,Object> map){
        List<Doctor> doctors=doctorService.selectDoctors(Long.parseLong(kId));
        map.put("doctors",doctors);
        return JSON.toJSONString(map);
    }
}
