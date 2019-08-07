package cn.bdqn.controller;

import cn.bdqn.entity.User;
import cn.bdqn.service.SmsService;
import cn.bdqn.service.SmsServiceImpl;
import cn.bdqn.service.user.UserService;
import cn.bdqn.utils.MD5Util;
import cn.bdqn.utils.RedisAPI;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    private SmsService smsService = new SmsServiceImpl();

    //登录校验
    @RequestMapping("/dologin")
    @ResponseBody
    public Object doLogin(String phone,String password,Map<String,Object> loginMap) {
        User user = userService.findUser(phone);
        loginMap.put("user",user);
        loginMap.put("md5Password", MD5Util.md5Password(password));
        return JSON.toJSONString(loginMap);
    }

    //注册校验
    @RequestMapping("/doregist")
    @ResponseBody
    public Object doRegist(User user, String msgCode){
        user.setPassword(MD5Util.md5Password(user.getPassword()));
        int result = 1;
        List<User> u = userService.findAllUser();
        for (int i = 0; i < u.size(); i++){
            if (u.get(i).getPhone().equals(user.getPhone())){
                result = 0; //手机号已被注册
            } else if (u.get(i).getUserName().equals(user.getUserName())){
                result = 2; //用户名重复
            } else if (u.get(i).getIdentityId().equals(user.getIdentityId())){
                result = 7; //身份证重复
            }
        }
        RedisAPI redisAPI = new RedisAPI();
        //设定key
        String key = "active:" + user.getPhone();
        //判断key是否存在，验证用户输入的短信验证码
        boolean flag = false;
        if (redisAPI.exist(key)) {
            if (redisAPI.get(key).equals(msgCode)) {
                flag = true;
            }
        }
        if (result == 1&&flag){
            userService.addUser(user);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        map.put("flag",flag);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/msgCode")
    @ResponseBody
    public Object msgCode(String phone){
        // 1:生成短信验证码
        int code= MD5Util.getRandomCode();
        // 2:发送短信验证码
        if(phone!=null&&!"".equals(phone)){
            smsService.send(phone, "1", new String[]{String.valueOf(code),"2"});
        }
        // 3:缓存短信验证码
        RedisAPI redis=new RedisAPI();
        String key="active:"+phone;
        redis.set(key, 120, String.valueOf(code));
        Map<String,Object> msgMap = new HashMap<>();
        if(SmsServiceImpl.smsMassage!=null&&SmsServiceImpl.msgStatics!=0){
            msgMap.put("smsMassage",SmsServiceImpl.smsMassage);
            msgMap.put("msgStatics",SmsServiceImpl.msgStatics);
        }
        return JSON.toJSONString(msgMap);
    }


    //退出登录
    @RequestMapping(value = ("logout"))
    public String logout(HttpSession session) {
        session.setMaxInactiveInterval(1);
        return "redirect:index";
    }

}
