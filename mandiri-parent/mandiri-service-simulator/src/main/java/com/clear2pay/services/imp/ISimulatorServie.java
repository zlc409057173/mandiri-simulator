package com.clear2pay.services.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.clear2pay.entity.vo.User;
import com.clear2pay.otherservice.userservice.UserFeignService;
import com.clear2pay.response.CommonReturnType;
import com.clear2pay.services.SimulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISimulatorServie implements SimulatorService {

    private static final Logger log = LoggerFactory.getLogger(ISimulatorServie.class);
    @Autowired
    private UserFeignService userFeignService;

    @Override
    public CommonReturnType getUserById(Integer id){
        CommonReturnType type = userFeignService.getUserById(id);
        log.debug("response : {}", JSON.toJSONString(type));
        String status = type.getStatus();
        Object data = type.getData();
        if("fail".equals(status)){
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(data));
            return CommonReturnType.fail(jsonObject);
        }
        User user = JSON.parseObject(JSON.toJSONString(data), User.class);
        return CommonReturnType.success(user);
    }

    @Override
    public CommonReturnType getAllUser() {
        return userFeignService.getAllUser();
    }

    @Override
    public CommonReturnType addUser(User user) {
        return userFeignService.addUser(user);
    }

    @Override
    public CommonReturnType updateUser(Integer id, User user) {
        return userFeignService.updateUser(id, user);
    }

    @Override
    public CommonReturnType deleteUser(Integer id) {
        return userFeignService.deleteUser(id);
    }

}
