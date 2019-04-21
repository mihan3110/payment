package com.microservices.payment.backend.service;

import java.util.Random;

public class SequrityService {
    private static final String EXAMPLE = "0123456789qwertyuioplkjhgfdsazxcvbnm";
    // Генерация referenceNumber
    String referenceNumberGenerator(){
        Random rng = new Random();
        char[] text = new char[32];
        for (int i = 0; i < text.length; i++)
        {
            text[i] = EXAMPLE.charAt(rng.nextInt(EXAMPLE.length()));
        }
        String refNum= "'"+new String(text)+"'";
        return refNum;
    }

    // шифровка номера счета
    String CryptoAccountNumber(String accountNumber){
        StringBuffer buf = new StringBuffer(accountNumber);
      //  System.out.println(buf.replace(2,8,"******").toString());
        return buf.replace(2,8,"******").toString();
    }
}
