package com.clear2pay.entity.vo.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/8/21 - 5:38 AM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="releaseRequest")
public class ReleaseRequest {
    @XmlElement(name = "datetime")      // 子节点名称
    private String datetime;
    @XmlElement(name = "key")      // 子节点名称
    private String key;
    @XmlElement(name = "detectionID")      // 子节点名称
    private Integer detectionID;
    @XmlElement(name = "reference")      // 子节点名称
    private String reference;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getDetectionID() {
        return detectionID;
    }

    public void setDetectionID(Integer detectionID) {
        this.detectionID = detectionID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
