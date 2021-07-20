package com.clear2pay.response.controller;

import com.clear2pay.response.CommonReturnType;
import com.clear2pay.response.error.EnumBusinessError;
import com.clear2pay.response.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 熔断处理失败方法实现类
 */
//@ControllerAdvice
public class BaseController {

    /**
     * Spring boot 全局异常捕捉
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> map = new HashMap<>(2);
        map.put("errCode", EnumBusinessError.UNKNOW_ERROR.getErrCode());
        map.put("errMsg", EnumBusinessError.UNKNOW_ERROR.getErrMsg());
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            map.put("errCode", businessException.getErrCode());
            map.put("errMsg", businessException.getErrMsg());
        }
        return CommonReturnType.fail(map);
    }

    /**
     * 指定熔断处理返回
     * @param id
     * @return
     */
    public CommonReturnType getFailBack(Integer id){
        Map<String, Object> map = new HashMap<>(2);
        map.put("errCode", EnumBusinessError.INTERNAL_SERVER_ERROR.getErrCode());
        map.put("errMsg", EnumBusinessError.INTERNAL_SERVER_ERROR.getErrMsg());
        return CommonReturnType.fail(map);
    }

    /**
     * 默认熔断处理返回
     * @return
     */
    public CommonReturnType defaultFailBack(){
        Map<String, Object> map = new HashMap<>(2);
        map.put("errCode", EnumBusinessError.INTERNAL_SERVER_ERROR.getErrCode());
        map.put("errMsg", EnumBusinessError.INTERNAL_SERVER_ERROR.getErrMsg());
        return CommonReturnType.fail(map);
    }
}
