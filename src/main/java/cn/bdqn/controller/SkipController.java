package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class SkipController {

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    @RequestMapping("/chuzhen")
    public String chuzhen(){
        return "chuzhen";
    }

    @RequestMapping("/jianjie")
    public String jianjie(){
        return "jianjie";
    }

    @RequestMapping("/jiuzhen")
    public String jiuzhen(){
        return "jiuzhen";
    }

    @RequestMapping("/keshi")
    public String keshi(){
        return "keshi";
    }

    @RequestMapping("/keshimx")
    public String keshimx(){
        return "keshimx";
    }

    @RequestMapping("/keshiys")
    public String keshiys(){
        return "keshiys";
    }

    @RequestMapping("/kexue")
    public String kexue(){
        return "kexue";
    }

    @RequestMapping("/kexuelist")
    public String kexuelist(){
        return "kexuelist";
    }

    @RequestMapping("/news")
    public String news(){
        return "news";
    }

    @RequestMapping("/newslist")
    public String newslist(){
        return "newslist";
    }

    @RequestMapping("/rongyu")
    public String rongyu(){
        return "rongyu";
    }

//    @RequestMapping("/ys")
//    public String ys(){
//        return "ys";
//    }

    @RequestMapping("/zhuanjia")
    public String zhuanjia(){
        return "zhuanjia";
    }

//    跳转登录页
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    跳转注册页
    @RequestMapping("/regist")
    public String regist(){
        return "register";
    }
}
