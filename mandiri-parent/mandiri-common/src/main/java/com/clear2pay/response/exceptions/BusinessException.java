package com.clear2pay.response.exceptions;

import com.clear2pay.response.error.CommonError;

/**
 * @author zlc
 * @Date 2021/7/14 - 17:41
 * @Descriptions 说点什么
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收EnumBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(String message, CommonError commonError) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(message);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
