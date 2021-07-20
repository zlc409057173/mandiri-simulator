package com.clear2pay.services;

import com.clear2pay.entity.vo.User;
import com.clear2pay.response.exceptions.BusinessException;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    void addUser(User user);

    void updateUser(User user) throws BusinessException;

    void deleteUser(Integer id) throws BusinessException;

    List<User> getAllUser();
}
