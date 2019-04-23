package com.microservices.payment;

import com.microservices.payment.backend.dao.PaymentDao;
import com.microservices.payment.backend.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);


//		PaymentService p=new PaymentService();
//
//		System.out.println("__________________________________\n"+p.getByReferenceNumber("nj3f48pdpb3kpkbmoh890qhpkic7grr4"));


	//DbConnect d = new DbConnect();
		//p.createPayment("qqf",85.0, "eur", "CA", "GOOD", "88fg5553535", "Ayfgana", "ood");
//d.refund("221jbpdxgcshj5owntg82jcsfpugbrc6");
	//	System.out.println(d.getAll());




	}
}
