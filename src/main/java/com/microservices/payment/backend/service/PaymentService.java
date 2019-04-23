package com.microservices.payment.backend.service;

import com.microservices.payment.backend.dao.DbConnect;
import com.microservices.payment.backend.dao.PaymentDao;
import com.microservices.payment.backend.dao.PaymentDb;
import com.microservices.payment.backend.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentService {
    private DbConnect dbConnect = new DbConnect();
    private Connection connection = dbConnect.getConnection();
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
    private Timestamp getTimeStamp() {

        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    public Payment getByReferenceNumber(String referenceNumber)  {
        Payment payment=paymentDao.findByReferenceNumber(referenceNumber);
        payment.setAccountNumberFrom(sequrityService.CryptoAccountNumber(payment.getAccountNumberFrom()));
        payment.setAccountNumberTo(sequrityService.CryptoAccountNumber(payment.getAccountNumberTo()));
        return payment;
    }

    public Payment createPayment(String requestId,
                              Double amount,
                              String currency,
                              String operatingType,
                              String remark,
                              String accountNumberFrom,
                              String accountNumberTo,
                              String status)  {
        Payment payment = new Payment(requestId,
                                      amount,
                                      currency,
                                      operatingType,
                                      remark,
                                      accountNumberFrom,
                                      accountNumberTo,
                                      status,
                                      referenceNumberGenerator(),
                                      getTimeStamp());
        paymentDao.createPayment(payment);
return payment;
    }


//    public void createPayment(String requestId,
//                              Double amount,
//                              String currency,
//                              String operatingType,
//                              String remark,
//                              String accountNumberFrom,
//                              String accountNumberTo,
//                              String status) throws SQLException {
//
//        Statement statement;
//        String query = "INSERT INTO payment " +
//                "(requestId, " +
//                "amount," +
//                "currency," +
//                "operatingType," +
//                "remark, " +
//                "accountNumberFrom," +
//                "accountNumberTo, " +
//                "status," +
//                "referenceNumber," +
//                "dateStamp) " +
//                "VALUES(" +
//                requestId + ',' +
//                amount + ',' +
//                currency + ',' +
//                operatingType + ',' +
//                remark + ',' +
//                accountNumberFrom + ',' +
//                accountNumberTo + ',' +
//                status + ',' +
//                referenceNumGen.referenceNumberGenerator() + ',' +
//                "CURRENT_TIMESTAMP());";
//        try {
//            statement = dbConnect.getConnection().createStatement();
//            statement.execute(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if (statement!= null) {
////                statement.close();
////            }
////            if (connection!= null) {
////                connection.close();
////            }
////        }
//
//    }

    //Вывод всех записей, нужно будет доделать реализацию под нужды

    public List<Payment> getAll()  {
        List<Payment> paymentList = new ArrayList<>();
        String query = "SELECT  requestId, dateStamp, amount, currency, accountNumberFrom, accountNumberTo FROM payment";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setRequestId(resultSet.getString("requestId"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setCurrency(resultSet.getString("currency"));
                // payment.setOperatingType(resultSet.getString("operatingType"));
                // payment.setRemark(resultSet.getString("remark"));
                payment.setAccountNumberFrom(sequrityService.CryptoAccountNumber(resultSet.getString("accountNumberFrom")));
                payment.setAccountNumberTo(sequrityService.CryptoAccountNumber(resultSet.getString("accountNumberTo")));
                // payment.setStatus(resultSet.getString("status"));
                // payment.setReferenceNumber(resultSet.getString("referenceNumber"));
                payment.setDateStamp(resultSet.getTimestamp("dateStamp"));
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection!= null) {
//                connection.close();
//            }
//        }

        return paymentList;
    }


    // Вывод информации о платеже на основе его referenceNumber
//    @Override
//    public Payment getByReferenceNumber(String referenceNumber) throws SQLException {
//        String query = "SELECT referenceNumber, requestId, " +
//                "dateStamp, operatingType, " +
//                "status, amount, currency, " +
//                "accountNumberFrom, accountNumberTo, " +
//                "remark  " +
//                "FROM payment WHERE referenceNumber='" + referenceNumber + "'";
//        Statement statement = null;
//        Payment payment = new Payment();
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            if (resultSet.next()) {
//                payment.setRequestId(resultSet.getString("requestId"));
//                payment.setAmount(resultSet.getDouble("amount"));
//                payment.setCurrency(resultSet.getString("currency"));
//                payment.setOperatingType(resultSet.getString("operatingType"));
//                payment.setRemark(resultSet.getString("remark"));
//                payment.setAccountNumberFrom(sequrityService.CryptoAccountNumber(resultSet.getString("accountNumberFrom")));
//                payment.setAccountNumberTo(sequrityService.CryptoAccountNumber(resultSet.getString("accountNumberTo")));
//                payment.setStatus(resultSet.getString("status"));
//                payment.setReferenceNumber(resultSet.getString("referenceNumber"));
//                payment.setDateStamp(resultSet.getTimestamp("dateStamp"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if (statement != null) {
////                statement.close();
////            }
////            if (connection!= null) {
////                connection.close();
////            }
////        }
//
//        return payment;
//    }


    public void refund(String referenceNumber)  {
    paymentDao.deleteByReferenceNumebr(referenceNumber);

//        Statement statement;
//
//        String query = "DELETE FROM payment WHERE referenceNumber='" + referenceNumber + "'";
//
//        try {
//            statement = connection.createStatement();
//
//
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if (statement != null) {
////                statement.close();
////            }
////            if (connection != null) {
////                connection.close();
////            }
////        }
    }


}
