package com.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soap.service.UserClient;

@Configuration
public class CountryConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.soap.consumingwebservice.wsdl");
		return marshaller;
	}

	@Bean
	public UserClient countryClient(Jaxb2Marshaller marshaller) {
		UserClient client = new UserClient();
		client.setDefaultUri("http://localhost:8080/soapWS");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
