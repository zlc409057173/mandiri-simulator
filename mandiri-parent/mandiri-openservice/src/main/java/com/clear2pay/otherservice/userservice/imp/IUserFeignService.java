package com.clear2pay.otherservice.userservice.imp;

import com.clear2pay.entity.vo.User;
import com.clear2pay.otherservice.userservice.UserFeignService;
import com.clear2pay.response.CommonReturnType;
import com.clear2pay.response.error.EnumBusinessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IUserFeignService implements UserFeignService {

    private static final Logger log = LoggerFactory.getLogger(IUserFeignService.class);

    @Override
    public CommonReturnType getUserById(Integer id) {
        log.debug("调用USER服务失败，熔断处理，请稍后再试！");
        return CommonReturnType.fail(EnumBusinessError.INTERNAL_SERVER_ERROR);
    }

    @Override
    public CommonReturnType getAllUser() {
        log.debug("调用USER服务失败，熔断处理，请稍后再试！");
        return CommonReturnType.fail(EnumBusinessError.INTERNAL_SERVER_ERROR);
    }

    @Override
    public CommonReturnType addUser(User user) {
        log.debug("调用USER服务失败，熔断处理，请稍后再试！");
        return CommonReturnType.fail(EnumBusinessError.INTERNAL_SERVER_ERROR);
    }

    @Override
    public CommonReturnType updateUser(Integer id, User user) {
        log.debug("调用USER服务失败，熔断处理，请稍后再试！");
        return CommonReturnType.fail(EnumBusinessError.INTERNAL_SERVER_ERROR);
    }

    @Override
    public CommonReturnType deleteUser(Integer id) {
        log.debug("调用USER服务失败，熔断处理，请稍后再试！");
        return CommonReturnType.fail(EnumBusinessError.INTERNAL_SERVER_ERROR);
    }

}
