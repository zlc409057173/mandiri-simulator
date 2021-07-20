package com.clear2pay.otherservice.userservice;

import com.clear2pay.entity.vo.User;
import com.clear2pay.otherservice.userservice.imp.IUserFeignService;
import com.clear2pay.response.CommonReturnType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "USER", fallback = IUserFeignService.class)
public interface UserFeignService {

    @GetMapping(value = "/user/{id}")
    CommonReturnType getUserById(@PathVariable Integer id);

    @GetMapping("/user")
    CommonReturnType getAllUser();

    @PostMapping("/user")
    CommonReturnType addUser(@RequestBody User user);

    @PutMapping(value = "/user/{id}")
    CommonReturnType updateUser(@PathVariable Integer id, @RequestBody User user);

    @DeleteMapping(value = "/user/{id}")
    CommonReturnType deleteUser(@PathVariable Integer id);

}
