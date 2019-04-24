package com.microservices.payment.backend.dao;

import com.microservices.payment.backend.model.Payment;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface PaymentDb {
    //Создание платежа
    void createPayment(Payment payment) throws SQLException;

    //История платажей
    List<Payment> getRestricted(Timestamp startDate, Timestamp endDate) throws SQLException;

    //Данные об указанном платеже
    Payment findByReferenceNumber(String referenceNumber) throws SQLException;

    //Отмена платежа
    void deleteByReferenceNumebr(String referenceNumber) throws SQLException;

}
