package com.clear2pay.controller;

import com.alibaba.fastjson.JSON;
import com.clear2pay.entity.vo.User;
import com.clear2pay.response.CommonReturnType;
import com.clear2pay.response.controller.BaseController;
import com.clear2pay.response.error.EnumBusinessError;
import com.clear2pay.response.exceptions.BusinessException;
import com.clear2pay.services.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService iUserService;

    @GetMapping
    @HystrixCommand(defaultFallback = "defaultFailBack")
    public CommonReturnType getAllUser(){
        log.debug("come in");
        List<User> users = iUserService.getAllUser();
        if(CollectionUtils.isEmpty(users)){
            return CommonReturnType.success(null);
        }
        return CommonReturnType.success(users);
    }

    @GetMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "getFailBack", defaultFallback = "defaultFailBack")
    public CommonReturnType getUserById(@PathVariable Integer id){
        log.debug("request Id : {}", id);
        User user = iUserService.getUserById(id);
        if(user==null){
            return CommonReturnType.fail(EnumBusinessError.USER_NOT_EXIST);
        }
        return CommonReturnType.success(user);
    }

    @PostMapping
    @HystrixCommand(defaultFallback = "defaultFailBack")
    public CommonReturnType addUser(@RequestBody @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //校验结果以集合的形式返回，当然也可以获取单个。具体可以查看bindResult的API文档
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            //StringBuilder组装异常信息
            StringBuilder builder = new StringBuilder();
            //遍历拼装
            fieldErrorList.forEach(error -> builder.append(error.getDefaultMessage()).append(System.lineSeparator()));
            builder.insert(0, "use @Valid n BingdingResult :" + System.lineSeparator());
            return CommonReturnType.fail(builder);
        }
        log.debug("request User : {}", JSON.toJSONString(user));
        iUserService.addUser(user);
        return CommonReturnType.success(null);
    }

    @PutMapping(value = "/{id}")
    @HystrixCommand(defaultFallback = "defaultFailBack")
    public CommonReturnType updateUser(@PathVariable Integer id, @RequestBody User user) throws BusinessException {
        log.debug("request Id : {}, User : {}", id, JSON.toJSONString(user));
        user.setId(id);
        iUserService.updateUser(user);
        return CommonReturnType.success(null);
    }

    @DeleteMapping(value = "/{id}")
    @HystrixCommand(defaultFallback = "defaultFailBack")
    public CommonReturnType deleteUser(@PathVariable Integer id) throws BusinessException {
        log.debug("request Id : {}", id);
        iUserService.deleteUser(id);
        return CommonReturnType.success(null);
    }
}
