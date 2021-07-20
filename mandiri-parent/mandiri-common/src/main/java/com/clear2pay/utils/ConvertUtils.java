package com.clear2pay.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author
 * @Date 7/6/21 - 12:35 PM
 */
public class ConvertUtils {

    /**
     * 将自定义数据对象转化为XML字符串
     *
     * @param object 自定义数据对象
     * @return XML字符串
     * @throws JAXBException 异常
     */
    public static String objectToXML(Object object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Writer w = new StringWriter();
        m.marshal(object, w);
        return w.toString();
    }

    /**
     * 将XML字符串转化为自定义数据对象
     *
     * @param clazz 自定义数据类型
     * @param xml   XML字符串
     * @return 自定义数据对象
     * @throws JAXBException 异常
     */
    public static Object xmlToObject(Class clazz, String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();
        return um.unmarshal(new StringReader(xml));
    }

}
