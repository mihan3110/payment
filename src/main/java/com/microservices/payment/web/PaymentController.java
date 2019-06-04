package com.microservices.payment.web;

import com.microservices.payment.backend.model.Payment;
import com.microservices.payment.backend.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@Api(value = "Payment")
public class PaymentController {
    private PaymentService paymentDb;

    public PaymentController() {
        paymentDb = new PaymentService();

    }

    //Создание нового платежа
//    @PostMapping("/payments/new")
//    public Payment createPayment(@RequestHeader("requestId") String requestId,
//                              @RequestParam("amount") Double amount,
//                              @RequestParam("currency") String currency,
//                              @RequestParam("operatingType") String operatingType,
//                              @RequestParam("remark") String remark,
//                              @RequestParam("accountNumberFrom") String accountNumberFrom,
//                              @RequestParam("accountNumberTo") String accountNumberTo) {
//
//        Payment payment=paymentDb.createPayment(requestId, amount, currency, operatingType, remark, accountNumberFrom, accountNumberTo);
//        return payment;
//    }


    @PostMapping("/payments/new")
    public Payment createPayment(@RequestHeader("requestId") String requestId,
                                 @RequestBody Payment payment) {

        Payment paymentt=paymentDb.createPayment(payment);
        return payment;
    }


    //Вывод информации о платеже
    @GetMapping("/payments/info/{referenceNumber}")
    public ResponseEntity<Payment> findByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) {
        return (ResponseEntity.ok(paymentDb.getByReferenceNumber(referenceNumber)));
    }

    //Вывод истории платежей в указанный период
    @GetMapping("/payments/history")
    public ResponseEntity<List<Payment>> getRestricted(@RequestParam("startDate format: YYYY-MM-DD") Timestamp startDate,
                                                       @RequestParam("endDate format: YYYY-MM-DD") Timestamp endDate) {
        return (ResponseEntity.ok(paymentDb.getRestricted(startDate, endDate)));
    }

    //Отмена платежа
    @PutMapping("/payments/refund/{referenceNumber}")
    public void removeByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) {
        paymentDb.refund(referenceNumber);
    }
}
