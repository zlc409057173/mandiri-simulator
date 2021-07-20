package com.clear2pay.entity.vo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/8/21 - 5:29 AM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="DetectionResponse")
public class DetectionResponse {
    @XmlElement(name = "datetime")      // 子节点名称
    private String datetime;
    @XmlElement(name = "detectionID")      // 子节点名称
    private Integer detectionID;
    @XmlElement(name = "detectionStatus")      // 子节点名称
    private String detectionStatus;
    @XmlElement(name = "detectionInfo")      // 子节点名称
    private String detectionInfo;
    @XmlElement(name = "reference")      // 子节点名称
    private String reference;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getDetectionID() {
        return detectionID;
    }

    public void setDetectionID(Integer detectionID) {
        this.detectionID = detectionID;
    }

    public String getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(String detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    public String getDetectionInfo() {
        return detectionInfo;
    }

    public void setDetectionInfo(String detectionInfo) {
        this.detectionInfo = detectionInfo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
