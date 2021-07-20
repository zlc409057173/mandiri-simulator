package com.clear2pay.response.error;

/**
 * @author zlc
 * @Date 2021/7/14 - 17:33
 * @Descriptions 说点什么
 */
public enum EnumBusinessError implements CommonError {
    // 成功
    SUCCESS(200,"成功"),
    // 失败
    FAIL(400,"失败"),
    // 未认证（签名错误）
    UNAUTHORIZED(401, "签名错误"),
    // 接口不存在
    INTERFACE_NOT_FOUND(404, "接口不存在"),
    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    //未知错误10002
    UNKNOW_ERROR(10002, "未知错误"),

    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在")

    ;

    private int errCode;
    private String errMsg;

    EnumBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
