package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/logi")
    public String login1(){
        return "余佳俊大傻逼+20";
    }

}

