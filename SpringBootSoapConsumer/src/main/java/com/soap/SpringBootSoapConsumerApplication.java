package com.soap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soap.consumingwebservice.wsdl.GetUserResponse;
import com.soap.service.UserClient;

@SpringBootApplication
public class SpringBootSoapConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(UserClient quoteClient) {
		return args -> {
			String country = "Sam";

			if (args.length > 0) {
				country = args[0];
			}
			GetUserResponse response = quoteClient.getUser(country);
			System.err.println(response.getUser().getEmpId());
		};
	}

}
