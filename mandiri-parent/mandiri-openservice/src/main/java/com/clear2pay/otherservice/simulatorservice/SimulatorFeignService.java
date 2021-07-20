package com.clear2pay.otherservice.simulatorservice;

import com.clear2pay.otherservice.simulatorservice.imp.ISimulatorFeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author zlc
 * @Date 2021/7/15 - 16:39
 * @Descriptions 说点什么
 */
@Component
@FeignClient(value = "SIMULATOR", fallback = ISimulatorFeignService.class)
public interface SimulatorFeignService {
}
