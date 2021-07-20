package com.clear2pay.response;

import com.clear2pay.response.error.CommonError;

import java.util.HashMap;
import java.util.Map;

public class CommonReturnType {

    //表明对应请求的返回处理结果"success" 和 "fail"
    private String status;

    //若status=success,则data内返回前端需要的json数据
    //若status=fail,则data内使用的错误码格式
    private Object data;

    public static CommonReturnType success(Object data){
        return CommonReturnType.create(data, "success");
    }

    public static CommonReturnType fail(Object data){
        Map<String,Object> map = null;
        if(data instanceof CommonError){
            map = new HashMap<>(2);
            CommonError error = (CommonError)data;
            map.put("errCode",error.getErrCode());
            map.put("errMsg",error.getErrMsg());
            return CommonReturnType.create(map, "fail");
        }
        return CommonReturnType.create(data, "fail");
    }

    public static CommonReturnType create(Object data, String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(data);
        return type;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
