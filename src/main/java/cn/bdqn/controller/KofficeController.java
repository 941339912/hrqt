package cn.bdqn.controller;

import cn.bdqn.entity.Doctor;
import cn.bdqn.entity.Koffice;
import cn.bdqn.entity.Medical;
import cn.bdqn.service.doctor.DoctorService;
import cn.bdqn.service.koffice.KofficeService;
import cn.bdqn.service.koffice.MedicalService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
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

    /**
         * 医药部下拉框
         * @param map
         * @return
         */
    @RequestMapping(value = "/navigation/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String navigation(@PathVariable("id") Long id, Long medicalId,Map<String,Object> map){
        List<Medical> medicals=medicalService.selectMedicals(id);
        List<Koffice> koffices=kofficeService.selectKoffices(medicalId);
        map.put("koffices",koffices);
        map.put("medicals",medicals);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/doctor",method = RequestMethod.POST)
    @ResponseBody
    public String doctor(String kId,Map<String,Object> map){
        List<Doctor> doctors=doctorService.selectDoctors(Long.parseLong(kId));
        map.put("doctors",doctors);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/department",method = RequestMethod.POST)
    @ResponseBody
    public String department(String medicalId,Map<String,Object> map){
        List<Koffice> koffices=kofficeService.selectKoffices(Long.parseLong(medicalId));
        map.put("koffices",koffices);
        return JSON.toJSONString(map);
    }

    /**
     * 科室简介
     */
    @RequestMapping("/resume")
    public String resume(Integer id,Model model){
        Koffice koffice = kofficeService.findKofficeById(id);
        model.addAttribute("office",koffice);
        return "officejianjie";
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/selectMedical")
    @ResponseBody
    public String selectMedical(){
        Map<String,Object> map = new HashMap<>();
        List<Medical> medicalList = medicalService.findMedicalList();
        List<Koffice> officeList = kofficeService.findOfficeList();
        map.put("medicalList",medicalList);
        map.put("officeList",officeList);
        return JSON.toJSONString(map);
    }
}