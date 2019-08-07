package cn.bdqn.service.user;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //登录方法
    @Override
    public User findUser(String phone) {
        return userMapper.findUser(phone);
    }

    //注册
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    //获取所有用户
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }
}
