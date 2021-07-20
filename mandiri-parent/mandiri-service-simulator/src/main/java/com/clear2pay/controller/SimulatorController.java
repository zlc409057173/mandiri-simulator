package com.clear2pay.controller;

import com.clear2pay.entity.vo.User;
import com.clear2pay.response.CommonReturnType;
import com.clear2pay.response.controller.BaseController;
import com.clear2pay.services.SimulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("simulator")
public class SimulatorController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SimulatorController.class);

    @Autowired
    private SimulatorService iSimulatorServie;


    @GetMapping
    public CommonReturnType getAllUser(){
        return iSimulatorServie.getAllUser();
    }

    @GetMapping("/{id}")
    public CommonReturnType getUser(@PathVariable Integer id){
        log.debug("request Id : {}", id);
        return iSimulatorServie.getUserById(id);
    }

    @PostMapping
    public CommonReturnType post(@RequestBody User user){
        return iSimulatorServie.addUser(user);
    }

    @PatchMapping("/{id}")
    public CommonReturnType put(@PathVariable Integer id, @RequestBody User user){
        return iSimulatorServie.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public CommonReturnType delete(@PathVariable Integer id){
        return iSimulatorServie.deleteUser(id);
    }
}
