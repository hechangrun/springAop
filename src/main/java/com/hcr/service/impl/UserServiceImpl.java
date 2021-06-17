package com.hcr.service.impl;

import com.hcr.model.User;
import com.hcr.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Integer id) {
        return new User(1,"hcr");
    }

    @Override
    public User add(User user) throws Exception {
        if("".equals(user.getName())){
            throw new Exception("名字为空！");
        }
        System.out.println("新增用户");
        return  user;
    }

    @Override
    public void update(User user) {
        System.out.println("修改用户");
    }

    @Override
    public void delete(Integer id) {

    }
}
