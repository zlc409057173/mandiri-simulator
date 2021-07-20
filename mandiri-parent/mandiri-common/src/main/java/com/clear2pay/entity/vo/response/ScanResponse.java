package com.clear2pay.entity.vo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/7/21 - 11:50 AM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ScanResponse")
public class ScanResponse {
    @XmlElement(name = "reference")      // 子节点名称
    private String reference;
    @XmlElement(name = "datetime")      // 子节点名称
    private String datetime;
    @XmlElement(name = "violationsCount")      // 子节点名称
    private Integer violationsCount;
    @XmlElement(name = "accepted")      // 子节点名称
    private Integer accepted;
    @XmlElement(name = "externalCount")      // 子节点名称
    private Integer externalCount;
    @XmlElement(name = "detectionId")      // 子节点名称
    private Integer detectionId;
    @XmlElement(name = "ScanStatus")      // 子节点名称
    private String scanStatus;
    @XmlElement(name = "ScanInfo")      // 子节点名称
    private String scanInfo;
//    @XmlElement(name = "alert")      // 子节点名称
    private AlertResponse alert;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getViolationsCount() {
        return violationsCount;
    }

    public void setViolationsCount(Integer violationsCount) {
        this.violationsCount = violationsCount;
    }

    public Integer getAccepted() {
        return accepted;
    }

    public void setAccepted(Integer accepted) {
        this.accepted = accepted;
    }

    public Integer getExternalCount() {
        return externalCount;
    }

    public void setExternalCount(Integer externalCount) {
        this.externalCount = externalCount;
    }

    public Integer getDetectionId() {
        return detectionId;
    }

    public void setDetectionId(Integer detectionId) {
        this.detectionId = detectionId;
    }

    public String getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }

    public String getScanInfo() {
        return scanInfo;
    }

    public void setScanInfo(String scanInfo) {
        this.scanInfo = scanInfo;
    }

    public AlertResponse getAlert() {
        return alert;
    }

    public void setAlert(AlertResponse alert) {
        this.alert = alert;
    }
}
