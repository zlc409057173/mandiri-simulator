package com.clear2pay.entity.vo.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/6/21 - 1:06 PM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ScanRequest")
public class ScanRequest {

    @XmlElement(name = "mt")      // 子节点名称
    private String mt;

    @XmlElement(name = "rank")      // 子节点名称
    private Integer rank;

    @XmlElement(name = "reference")      // 子节点名称
    private String reference;

    @XmlElement(name = "datetime")      // 子节点名称
    private String datetime;

    @XmlElement(name = "key")      // 子节点名称
    private String key;

    @XmlElement(name = "content")      // 子节点名称
    private String content;

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
