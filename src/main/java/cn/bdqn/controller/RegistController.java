package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {

    @RequestMapping("/reg")
    public Object reg(String phone,String password,String msg_code){
        System.out.println("phone:"+phone+"--password:"+password+"--msg_code:"+msg_code);
        return "";
    }
}
