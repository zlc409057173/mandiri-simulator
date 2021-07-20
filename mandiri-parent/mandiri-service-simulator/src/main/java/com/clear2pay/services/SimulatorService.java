package com.clear2pay.services;

import com.clear2pay.entity.vo.User;
import com.clear2pay.response.CommonReturnType;

public interface SimulatorService {

    CommonReturnType getUserById(Integer id);

    CommonReturnType getAllUser();

    CommonReturnType addUser(User user);

    CommonReturnType updateUser(Integer id, User user);

    CommonReturnType deleteUser(Integer id);

}
