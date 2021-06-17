package com.hcr.service;

import com.hcr.model.User;

public interface UserService {
    User getUser(Integer id);
    User add(User user) throws Exception;
    void update(User user);
    void delete(Integer id);
}
