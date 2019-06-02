package com.microservices.payment.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    private Integer account_id;
    @Column
    private String accountNumber;
    @Column
    private String customerNumber;
    @Column
    private String currency;


    @Column
    private Double balance;

    public Account() {
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getbalance() {
        return balance;
    }

    public void setbalance(Double balance) {
        this.balance = balance;
    }

    public Account(Integer account_id, String accountNumber, String customerNumber, String currency, Double balance) {
        this.account_id = account_id;
        this.accountNumber = accountNumber;
        this.customerNumber = customerNumber;
        this.currency = currency;
        this.balance = balance;
    }
}
