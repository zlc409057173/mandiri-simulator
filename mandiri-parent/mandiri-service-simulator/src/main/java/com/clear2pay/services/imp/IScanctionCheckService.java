package com.clear2pay.services.imp;

import com.alibaba.fastjson.JSON;
import com.clear2pay.entity.vo.request.BlockRequest;
import com.clear2pay.entity.vo.request.DetectionRequest;
import com.clear2pay.entity.vo.request.ReleaseRequest;
import com.clear2pay.entity.vo.request.ScanRequest;
import com.clear2pay.entity.vo.response.BlockResponse;
import com.clear2pay.entity.vo.response.DetectionResponse;
import com.clear2pay.entity.vo.response.ReleaseResponse;
import com.clear2pay.entity.vo.response.ScanResponse;
import com.clear2pay.services.ScanctionCheckService;
import com.clear2pay.utils.ConvertUtils;
import com.clear2pay.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBException;

/**
 * @author zlc
 * @Date 2021/7/19 - 16:39
 * @Descriptions 说点什么
 */
@Service
public class IScanctionCheckService implements ScanctionCheckService {

    private static final Logger log = LoggerFactory.getLogger(IScanctionCheckService.class);

    @Override
    public Object handlerRequest(Integer flag, Object req) throws JAXBException {
        String requestContent = ConvertUtils.objectToXML(req);
        String responseContent = "";
        try {
            switch (flag){
                case 1:
                    //handler request  url:/WebserviceSWF/rest/ScanService/xmlscan
                    if(req instanceof ScanRequest){
                        ScanRequest request = (ScanRequest)req;
                        responseContent = this.scanService(request);
                        if(StringUtils.isEmpty(responseContent)){
                            log.debug("get the response str is empty");
                            return responseContent;
                        }
                        return ConvertUtils.xmlToObject(ScanResponse.class, responseContent);
                    }
                    break;
                case 2:
                    //handler request  url:/WebserviceSWF/rest/DetectionService/xmldetection
                    if(req instanceof DetectionRequest) {
                        DetectionRequest request = (DetectionRequest)req;
                        responseContent = this.detectionService(request);
                        if(StringUtils.isEmpty(responseContent)){
                            log.debug("get the response str is empty");
                            return responseContent;
                        }
                        return ConvertUtils.xmlToObject(DetectionResponse.class, responseContent);
                    }
                    break;
                case 3:
                    //handler request  url:/WebserviceSWF/rest/BlockService/xmlblock
                    if(req instanceof BlockRequest){
                        BlockRequest request = (BlockRequest)req;
                        responseContent = this.blockService(request);
                        if(StringUtils.isEmpty(responseContent)){
                            log.debug("get the response str is empty");
                            return responseContent;
                        }
                        return ConvertUtils.xmlToObject(BlockResponse.class, responseContent);
                    }
                    break;
                case 4:
                    //handler request  url:/WebserviceSWF/rest/ReleaseService/xmlblock
                    if(req instanceof ReleaseRequest){
                        ReleaseRequest request = (ReleaseRequest)req;
                        responseContent = this.releaseService(request);
                        if(StringUtils.isEmpty(responseContent)){
                            log.debug("get the response str is empty");
                            return responseContent;
                        }
                        return ConvertUtils.xmlToObject(ReleaseResponse.class, responseContent);
                    }
                    break;
            }
        }finally {
            // log print
            this.printInfo(requestContent, responseContent);
        }
        log.debug("the flag can not format the request object, flag={}, Request={}", flag, JSON.toJSONString(req));
        return responseContent;
    }

    /**
     * handler request  url:/WebserviceSWF/rest/ReleaseService/xmlblock
     * @param req
     * @return
     */
    private String releaseService(ReleaseRequest req){
        return FileUtils.readFile("C:\\ZLC\\File\\scan", "releaseResponse");
    }

    /**
     * handler request  url:/WebserviceSWF/rest/BlockService/xmlblock
     * @param req
     * @return
     */
    private String blockService(BlockRequest req){
        return FileUtils.readFile("C:\\ZLC\\File\\scan", "blockResponse");
    }

    /**
     * handler request  url:/WebserviceSWF/rest/DetectionService/xmldetection
     * @param req
     * @return
     */
    private String detectionService(DetectionRequest req){
        return FileUtils.readFile("C:\\ZLC\\File\\scan", "DetectionResponse");
    }

    /**
     * handler request  url:/WebserviceSWF/rest/ScanService/xmlscan
     * @param req
     * @return
     */
    private String scanService(ScanRequest req){
        return FileUtils.readFile("C:\\ZLC\\File\\scan", "ScanResponse");
    }

    /**
     * print request and response
     * @param requestContent
     * @param responseContent
     */
    private void printInfo(String requestContent, String responseContent) {
        log.debug("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        log.debug("|                  Scanction Check Simulator Message Handling Started                               |");
        log.debug("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        log.debug("Request Payload >>>>>>>>>> \n" + requestContent);
        log.debug("Response Payload >>>>>>>>>> \n" + responseContent);
        log.debug("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        log.debug("|                  Scanction Check Simulator Message Handling Complete                              |");
        log.debug("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
    }


}
