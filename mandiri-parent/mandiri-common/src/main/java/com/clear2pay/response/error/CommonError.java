package com.clear2pay.response.error;

/**
 * @author zlc
 * @Date 2021/7/14 - 17:31
 * @Descriptions 说点什么
 */
public interface CommonError {
    int getErrCode();
    String getErrMsg();
    CommonError setErrMsg(String errMsg);
}
