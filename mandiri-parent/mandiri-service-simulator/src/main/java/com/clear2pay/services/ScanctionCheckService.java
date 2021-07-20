package com.clear2pay.services;

import javax.xml.bind.JAXBException;

/**
 * @author zlc
 * @Date 2021/7/19 - 16:42
 * @Descriptions 说点什么
 */
public interface ScanctionCheckService {

    Object handlerRequest(Integer flag, Object req) throws JAXBException;
}
