package cn.bdqn.service.user;

import cn.bdqn.entity.User;

import java.util.List;

public interface UserService {
    //登录方法
    public User findUser(String phone);

    //注册
    public int addUser(User user);

    //获取所有用户
    public List<User> findAllUser();
}
