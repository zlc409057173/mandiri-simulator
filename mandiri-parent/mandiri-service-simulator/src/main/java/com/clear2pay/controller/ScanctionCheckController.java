package com.clear2pay.controller;

import com.alibaba.fastjson.JSON;
import com.clear2pay.entity.Commons;
import com.clear2pay.entity.vo.request.BlockRequest;
import com.clear2pay.entity.vo.request.DetectionRequest;
import com.clear2pay.entity.vo.request.ReleaseRequest;
import com.clear2pay.entity.vo.request.ScanRequest;
import com.clear2pay.entity.vo.response.BlockResponse;
import com.clear2pay.entity.vo.response.DetectionResponse;
import com.clear2pay.entity.vo.response.ReleaseResponse;
import com.clear2pay.entity.vo.response.ScanResponse;
import com.clear2pay.response.controller.BaseController;
import com.clear2pay.services.ScanctionCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zlc
 * @Date 2021/7/19 - 17:00
 * @Descriptions 说点什么
 */
@RestController
@RequestMapping("/WebserviceSWF/rest")
public class ScanctionCheckController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ScanctionCheckController.class);

    private static AtomicInteger activeRequestBeingServedCounter = new AtomicInteger(0);

    @Autowired
    @Qualifier("IScanctionCheckService")
    private ScanctionCheckService service;

    @PostMapping(value = "/ScanService/xmlscan", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ScanResponse scanService(@RequestBody ScanRequest request){
        activeRequestBeingServedCounter.incrementAndGet();
        log.debug("Total Active Request being Served = {},  {}", activeRequestBeingServedCounter, JSON.toJSONString(request));
        try {
            Object o = service.handlerRequest(Commons.SCANSERVICE_FLAG, request);
            if(o instanceof ScanResponse){
                return (ScanResponse)o;
            }
        } catch (JAXBException e) {
            log.error("scanService 类型转换异常 : {}", e.getMessage());
        }finally {
            activeRequestBeingServedCounter.decrementAndGet();
        }
        log.info("the repsonse type is error");
        return null;
    }

    @PostMapping(value = "/DetectionService/xmldetection", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public DetectionResponse detectionRequest(@RequestBody DetectionRequest request){
        activeRequestBeingServedCounter.incrementAndGet();
        log.debug("Total Active Request being Served = {},  {}", activeRequestBeingServedCounter, JSON.toJSONString(request));
        try {
            Object o = service.handlerRequest(Commons.DETECTIONSERVICE_FLAG, request);
            if(o instanceof DetectionResponse){
                return (DetectionResponse)o;
            }
        } catch (JAXBException e) {
            log.error("scanService 类型转换异常 : {}", e.getMessage());
        }finally {
            activeRequestBeingServedCounter.decrementAndGet();
        }
        log.info("the repsonse type is error");
        return null;
    }

    @PostMapping(value = "/BlockService/xmlblock", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public BlockResponse blockService(@RequestBody BlockRequest request){
        activeRequestBeingServedCounter.incrementAndGet();
        log.debug("Total Active Request being Served = {},  {}", activeRequestBeingServedCounter, JSON.toJSONString(request));
        try {
            Object o = service.handlerRequest(Commons.BLOCKSERVICE_FLAG, request);
            if(o instanceof BlockResponse){
                return (BlockResponse)o;
            }
        } catch (JAXBException e) {
            log.error("scanService 类型转换异常 : {}", e.getMessage());
        }finally {
            activeRequestBeingServedCounter.decrementAndGet();
        }
        log.info("the repsonse type is error");
        return null;
    }

    @PostMapping(value = "/ReleaseService/xmlblock", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ReleaseResponse releaseService(@RequestBody ReleaseRequest request){
        activeRequestBeingServedCounter.incrementAndGet();
        log.debug("Total Active Request being Served = {},  {}", activeRequestBeingServedCounter, JSON.toJSONString(request));
        try {
            Object o = service.handlerRequest(Commons.RELEASESERVICE_FLAG, request);
            if(o instanceof ReleaseResponse){
                return (ReleaseResponse)o;
            }
        } catch (JAXBException e) {
            log.error("scanService 类型转换异常 : {}", e.getMessage());
        }finally {
            activeRequestBeingServedCounter.decrementAndGet();
        }
        log.info("the repsonse type is error");
        return null;
    }

//    public static void main(String[] args) {
//        //http://192.168.210.22:8081/WebserviceSWF/rest/ScanService/xmlscan
//        //<ScanRequest><mt>103</mt><rank>85</rank><reference>sadsajd</reference><datetime>10-07-2021 10.31</datetime><key>s1Ew2XRMXiScEbmtzU+A8TUzBtdUJojfEqhj6TElAB4=</key><content>{1:F01BMRIIDJAAXXX.SS..SEQ..}{2:I103EBATBEBBXXX XN}{4: :20:12AB34519 :23B:CRED :32A:200407EUR910.00 :50F:/12345678 1/SANTOSO SEJAHTERA 2/JL SUDIRMAN 3/INDONESIA :57A:JCAEBE9A :59:/123456 TONY ADI NEW JOHAR, JAKARTA :71A:BEN -}</content></ScanRequest>
//        //http://192.168.210.22:8081/WebserviceSWF/rest/DetectionService/xmldetection
//        //<DetectionRequest><datetime>2021-01-08 17:15:03</datetime><key>E4OFInjSFCitrrrLS5kRTmKVkHp+pnNZMfER91kHOKg=</key><detectionID>6470</detectionID><reference>S06SMJTM00013020</reference></DetectionRequest>
//        //http://192.168.210.22:8081/WebserviceSWF/rest/BlockService/xmlblock
//        //<blockRequest><datetime>2021-01-08 17:15:03</datetime><key>E4OFInjSFCitrrrLS5kRTmKVkHp+pnNZMfER91kHOKg=</key><detectionID>6470</detectionID><reference>S06SMJTM00013020</reference></blockRequest>
//        //http://192.168.210.22:8081/WebserviceSWF/rest/ReleaseService/xmlblock
//        //<releaseRequest><datetime>2021-01-08 17:15:03</datetime><key>E4OFInjSFCitrrrLS5kRTmKVkHp+pnNZMfER91kHOKg=</key><detectionID>6470</detectionID><reference>S06SMJTM00013020</reference></releaseRequest>
//        String url = "http://192.168.210.22:8081/WebserviceSWF/rest/BlockService/xmlblock";
//        String requestContent = "<blockRequest><datetime>2021-01-08 17:15:03</datetime><key>E4OFInjSFCitrrrLS5kRTmKVkHp+pnNZMfER91kHOKg=</key><detectionID>6470</detectionID><reference>S06SMJTM00013020</reference></blockRequest>"; //request content
//        try {
//            String responseContent = service.handlerRequest(url, requestContent); //handler request
//            //noinspection deprecation
//            LOGGER.info("responseContent : \r\n" + responseContent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
