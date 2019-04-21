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
        try {
            paymentDb = new PaymentService();
            payments = paymentDb.getAll();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
//    @PostMapping("/payments/new")
//    public ResponseEntity<Object> createPayment(@RequestBody() Payment payment){
//        try {
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{requestId}")
//                    .buildAndExpand(paymentDb.create(payment.getRequestId(),
//                                                     payment.getAmount(),
//                                                     payment.getCurrency(),
//                                                     payment.getOperatingType(),
//                                                     payment.getRemark(),
//                                                     payment.getAccountNumberFrom(),
//                                                     payment.getAccountNumberTo(),
//                                                     payment.getStatus());
//            return ResponseEntity.ok(location);
//        } catch (Exception e) {
//            return ResponseEntity.ok("Payment already registered");
//        }
//    }
    @GetMapping("/payments/info/{referenceNumber}")
    public ResponseEntity<Payment> findByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) throws SQLException{
            return(ResponseEntity.ok(paymentDb.getByReferenceNumber(referenceNumber)));
    }

    @GetMapping("/payments/history")
    public ResponseEntity<List<Payment>> showAll() throws SQLException{
        return(ResponseEntity.ok(paymentDb.getAll()));
    }

    @PutMapping("/payments/refund/{referenceNumber}")
    public void removeByReferenceNumber(@PathVariable("referenceNumber") String referenceNumber) throws SQLException{
        paymentDb.refund(referenceNumber);
    }
}
