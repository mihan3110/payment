package com.microservices.payment.web;


import com.microservices.payment.backend.dao.DbConnect;
import com.microservices.payment.backend.model.Payment;
import com.microservices.payment.backend.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@Api(value = "Payment", description = "a list of payments")
public class PaymentController {
    private List<Payment> payments;
    private PaymentService paymentDb;

    public PaymentController() {
        paymentDb = new PaymentService();
        payments = paymentDb.getAll();
    }
/*
 URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/findById/{id}")
                .buildAndExpand(savePayment.getId()).toUri();
        return ResponseEntity.created(location).build();
*/

    @PostMapping("/payments/new")
    public void createPayment(@RequestParam("requestId") String requestId,
                                                @RequestParam("amount") Double amount,
                                                @RequestParam("currency") String currency,
                                                @RequestParam("operatingType") String operatingType,
                                                @RequestParam("remark") String remark,
                                                @RequestParam("accountNumberFrom") String accountNumberFrom,
                                                @RequestParam("accountNumberT") String accountNumberTo,
                                                @RequestParam("status") String status) {

        paymentDb.createPayment(requestId, amount, currency, operatingType, remark, accountNumberFrom, accountNumberTo, status);
    }

    @GetMapping("/payments/info/{referenceNumber}")
    public ResponseEntity<Payment> findByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) throws SQLException {
        return (ResponseEntity.ok(paymentDb.getByReferenceNumber(referenceNumber)));
    }

    @GetMapping("/payments/history")
    public ResponseEntity<List<Payment>> showAll() throws SQLException {
        return (ResponseEntity.ok(paymentDb.getAll()));
    }

    @PutMapping("/payments/refund/{referenceNumber}")
    public void removeByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) throws SQLException {
        paymentDb.refund(referenceNumber);
    }
}
