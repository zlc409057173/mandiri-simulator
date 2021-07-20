package com.clear2pay.entity.vo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/7/21 - 11:55 AM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="report")
public class ReportResponse {
    @XmlElement(name = "rank")      // 子节点名称
    private Integer rank;
    @XmlElement(name = "listName")      // 子节点名称
    private String listName;
    @XmlElement(name = "listDate")      // 子节点名称
    private String listDate;
    @XmlElement(name = "line")      // 子节点名称
    private Integer line;
    @XmlElement(name = "remarks")      // 子节点名称
    private String remarks;
    @XmlElement(name = "beginPosition")      // 子节点名称
    private Integer beginPosition;
    @XmlElement(name = "endPosition")      // 子节点名称
    private Integer endPosition;
    @XmlElement(name = "entityId")      // 子节点名称
    private Integer entityId;
    @XmlElement(name = "data")      // 子节点名称
    private String data;
    @XmlElement(name = "dateofbirth")      // 子节点名称
    private String dateofbirth;
    @XmlElement(name = "placeOfBirth")      // 子节点名称
    private String placeOfBirth;
    @XmlElement(name = "category")      // 子节点名称
    private String category;
    @XmlElement(name = "gender")      // 子节点名称
    private String gender;
    @XmlElement(name = "externalId")      // 子节点名称
    private String externalId;
    @XmlElement(name = "dataSources")      // 子节点名称
    private String dataSources;
    @XmlElement(name = "dateTime")      // 子节点名称
    private String dateTime;
    @XmlElement(name = "program")      // 子节点名称
    private String program;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDate() {
        return listDate;
    }

    public void setListDate(String listDate) {
        this.listDate = listDate;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBeginPosition() {
        return beginPosition;
    }

    public void setBeginPosition(Integer beginPosition) {
        this.beginPosition = beginPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
