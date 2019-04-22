package com.microservices.payment.backend.service;


public class SequrityService {


    // шифровка номера счета
    //мы берем середину строки, и делаем сдвиг с четверти влево и вправа от центра и заменяем попавшие в радиус символы
    String CryptoAccountNumber(String accountNumber) {
        StringBuilder buf = new StringBuilder(accountNumber);
        String star = "";
        for (int i = 0; i < accountNumber.length() * 3 / 4 - accountNumber.length() / 4; i++) {
            star = star + "*";
        }
        return buf.replace(accountNumber.length() / 4, accountNumber.length() * 3 / 4, star).toString();
    }
}
