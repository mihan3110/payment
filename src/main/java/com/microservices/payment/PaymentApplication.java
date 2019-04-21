package com.microservices.payment;

import com.microservices.payment.backend.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(PaymentApplication.class, args);
		//PaymentService p=new PaymentService();
		//System.out.println(p.getByReferenceNumber("ndyib31jgr0kl2ple7unqbyscumgwgdx"));

	//DbConnect d = new DbConnect();
	//	d.create("'qq1'",85.0, "'eur'", "'CA'", "'GOOD'", "'88005553535'", "'Aynana'", "'ood'");
//d.refund("221jbpdxgcshj5owntg82jcsfpugbrc6");
	//	System.out.println(d.getAll());




	}
}
