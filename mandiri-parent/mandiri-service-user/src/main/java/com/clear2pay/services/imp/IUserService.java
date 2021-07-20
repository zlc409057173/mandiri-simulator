package com.clear2pay.services.imp;

import com.alibaba.fastjson.JSON;
import com.clear2pay.entity.vo.User;
import com.clear2pay.response.error.EnumBusinessError;
import com.clear2pay.response.exceptions.BusinessException;
import com.clear2pay.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IUserService implements UserService {

    private static final Logger log = LoggerFactory.getLogger(IUserService.class);
    private static List<User> users = null;

    static{
        users = new ArrayList<>(10);
        User user = null;
        for (int i = 0; i < 10; i++) {
            user = new User(i, "张"+i, 20+i, new BigDecimal(68.25), new Date());
            users.add(user);
        }
        log.debug("User list : {}", JSON.toJSONString(users));
    }

    @Override
    public User getUserById(Integer id) {
        User user = users.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        return user;
    }

    @Override
    public void addUser(User user){
        log.debug("User list : {}", JSON.toJSONString(users));
        users.add(user);
        log.debug("User list : {}", JSON.toJSONString(users));
    }

    @Override
    public void updateUser(User user) throws BusinessException{
        //去除user,得到一个新的集合
//        List<User> collect = users.stream().filter(p -> !p.getId().equals(user.getId())).collect(Collectors.toList());
        User oldUser = this.getUserById(user.getId());
        if(oldUser == null){
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        log.debug("old User : {}", JSON.toJSONString(oldUser));
        oldUser.setAge(user.getAge());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setName(user.getName());
        oldUser.setWeight(user.getWeight());
        User newUser = this.getUserById(user.getId());
        log.debug("new User : {}", JSON.toJSONString(newUser));
    }

    @Override
    public void deleteUser(Integer id) throws BusinessException {
        User oldUser = this.getUserById(id);
        if(oldUser == null){
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        users.remove(oldUser);
        log.debug("User list : {}", JSON.toJSONString(users));
    }

    @Override
    public List<User> getAllUser() {
        return users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }
}
