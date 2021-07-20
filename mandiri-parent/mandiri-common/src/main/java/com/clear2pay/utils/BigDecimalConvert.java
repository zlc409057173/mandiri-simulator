package com.clear2pay.utils;

import com.alibaba.fastjson.serializer.*;

import java.text.DecimalFormat;

/**
 * @author zlc
 * @Date 2021/7/16 - 10:13
 * @Descriptions javaBean BigDecimal格式化类
 */
public class BigDecimalConvert extends BigDecimalCodec implements ContextObjectSerializer {

    public final static BigDecimalConvert instance = new BigDecimalConvert();

    @Override
    public void write(JSONSerializer serializer, Object object, BeanContext context) {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeString("0.00");
            return;
        }
        String format = context.getFormat();
        DecimalFormat decimalFormat = new DecimalFormat(format);
        out.writeString(decimalFormat.format(object));
    }
}
