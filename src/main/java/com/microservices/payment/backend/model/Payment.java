package com.microservices.payment.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "payment")
public class Payment {
    public Payment() {
    }

    @Id
    @Column(name = "requestId")
    private String requestId;
    @Column
    private Double amount;
    @Column
    private String currency;
    @Column
    private String operatingType;
    @Column
    private String remark;
    @Column
    private String accountNumberFrom;
    @Column
    private String accountNumberTo;
    @Column
    private String status;
    @Column
    private String referenceNumber;
    @Column
    private Timestamp dateStamp;

    @Override
    public String toString() {
        return "Payment{" +
                "requestId='" + requestId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", operatingType='" + operatingType + '\'' +
                ", remark='" + remark + '\'' +
                ", accountNumberFrom='" + accountNumberFrom + '\'' +
                ", accountNumberTo='" + accountNumberTo + '\'' +
                ", status='" + status + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", dateStamp=" + dateStamp +
                '}';
    }


    public Payment(String requestId,
                   Double amount,
                   String currency,
                   String operatingType,
                   String remark,
                   String accountNumberFrom,
                   String accountNumberTo,
                   String status,
                   String referenceNumber,
                   Timestamp dateStamp) {
        this.requestId = requestId;
        this.amount = amount;
        this.currency = currency;
        this.operatingType = operatingType;
        this.remark = remark;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.status = status;
        this.referenceNumber = referenceNumber;
        this.dateStamp = dateStamp;
    }

    public Payment(String requestId, Double amount, String currency, String operatingType, String remark, String accountNumberFrom, String accountNumberTo, String status, String referenceNumber) {
        this.requestId = requestId;
        this.amount = amount;
        this.currency = currency;
        this.operatingType = operatingType;
        this.remark = remark;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.status = status;
        this.referenceNumber = referenceNumber;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperatingType() {
        return operatingType;
    }

    public void setOperatingType(String operatingType) {
        this.operatingType = operatingType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(String accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public String getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(String accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Timestamp getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Timestamp dateStamp) {
        this.dateStamp = dateStamp;
    }
}
