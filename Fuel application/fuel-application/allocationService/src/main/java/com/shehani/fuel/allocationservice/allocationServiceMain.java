package com.shehani.fuel.allocationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Service;

import com.shehani.fuel.allocationservice.model.Order;



@SpringBootApplication
//@EnableBinding(Processor.class)
@EnableKafka
@EnableConfigurationProperties
public class allocationServiceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(allocationServiceMain.class, args);

		//System.out.println("Allocation Service Started");
	}
	
	//@StreamListener/*(Processor.INPUT)
    /*public void receivedEmail(String message) {
		
		System.out.println(message);
		
        //System.out.println("Received employee details: " +order.getFuelStationName());
        ///System.out.println("Sending email and sms: ");
        
		
    }*/

}
