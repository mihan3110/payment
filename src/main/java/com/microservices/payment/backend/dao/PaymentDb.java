package com.microservices.payment.backend.dao;

import com.microservices.payment.backend.model.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDb {
    //Создание платежа
    void createPayment(String requestId,
                Double amount,
                String currency,
                String operatingType,
                String remark,
                String accountNumberFrom,
                String accountNumberTo,
                String status) throws SQLException;
    //История платажей
    List<Payment> getAll() throws SQLException;
    //Данные об указанном платеже
    Payment getByReferenceNumber(String referenceNumber) throws SQLException;
    //Отмена платежа
    void refund (String referenceNumber) throws SQLException;

}
