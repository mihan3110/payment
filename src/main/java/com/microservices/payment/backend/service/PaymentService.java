package com.microservices.payment.backend.service;

import com.microservices.payment.backend.dao.PaymentDao;
import com.microservices.payment.backend.model.Payment;

import java.sql.*;
import java.util.List;
import java.util.Random;

public class PaymentService {
    private SequrityService sequrityService = new SequrityService();
    private PaymentDao paymentDao = new PaymentDao();

    private static final String EXAMPLE = "0123456789qwertyuioplkjhgfdsazxcvbnm";

    // Генерация referenceNumber
    private String referenceNumberGenerator() {
        Random rng = new Random();
        char[] text = new char[32];
        for (int i = 0; i < text.length; i++) {
            text[i] = EXAMPLE.charAt(rng.nextInt(EXAMPLE.length()));
        }
        return new String(text);
    }

    //Получение временной метки
    private Timestamp getTimeStamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    //Поиск платежа по referenceNumber и шифровка номера счета
    public Payment getByReferenceNumber(String referenceNumber) {
        Payment payment = paymentDao.findByReferenceNumber(referenceNumber);
        payment.setAccountNumberFrom(sequrityService.CryptoAccountNumber(payment.getAccountNumberFrom()));
        payment.setAccountNumberTo(sequrityService.CryptoAccountNumber(payment.getAccountNumberTo()));
        return payment;
    }

    //Создание платежа
    public void createPayment(String requestId,
                              Double amount,
                              String currency,
                              String operatingType,
                              String remark,
                              String accountNumberFrom,
                              String accountNumberTo) {
        Payment payment = new Payment(requestId,
                amount,
                currency,
                operatingType,
                remark,
                accountNumberFrom,
                accountNumberTo,
                referenceNumberGenerator(),
                getTimeStamp());
        payment.setStatus("successful");
        paymentDao.createPayment(payment);
    }

    //Вывод истории платежей с ограничением по времени
    public List<Payment> getRestricted(Timestamp startDate, Timestamp endDate) {
        return paymentDao.getRestricted(startDate, endDate);
    }

    //Отмена платежа
    public void refund(String referenceNumber) {
        paymentDao.deleteByReferenceNumebr(referenceNumber);
    }
}
