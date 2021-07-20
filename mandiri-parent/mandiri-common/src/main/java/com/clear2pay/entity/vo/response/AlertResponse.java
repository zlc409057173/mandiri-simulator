package com.clear2pay.entity.vo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author
 * @Date 7/7/21 - 11:55 AM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="alert")
public class AlertResponse {

    private ReportResponse report;

    public ReportResponse getReport() {
        return report;
    }

    public void setReport(ReportResponse report) {
        this.report = report;
    }
}
