package com.microservices.payment.backend.service;



public class SequrityService {


    // шифровка номера счета
    String CryptoAccountNumber(String accountNumber){
        StringBuffer buf = new StringBuffer(accountNumber);
      //  System.out.println(buf.replace(2,8,"******").toString());
        return buf.replace(2,8,"******").toString();
    }
}
