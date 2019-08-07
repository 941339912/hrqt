package cn.bdqn.controller;

import cn.bdqn.entity.Menu;
import cn.bdqn.service.doctor.DoctorService;
import cn.bdqn.service.koffice.KofficeService;
import cn.bdqn.service.menu.MenuService;
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
public class HomeController {

    @Resource
    private DoctorService doctorService;
    @Resource
    private KofficeService kofficeService;
    @Resource
    private MenuService menuService;

    @RequestMapping("/searchDate")
    @ResponseBody
    public String searchDate(Integer typeId){
        Map<String,Object> map = new HashMap<>();
        if (typeId == 0){

        } else if (typeId == 1){

        } else if (typeId == 2){

        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public String getMenuList(){
        Map<String,Object> map = new HashMap<>();
        List<Menu> menuList = menuService.getMenuList(1);
        List<Menu> twoMenuList = menuService.getTwoMenuList(1);
        map.put("menuList",menuList);
        map.put("twoMenuList",twoMenuList);
        return JSON.toJSONString(map);
    }
}
