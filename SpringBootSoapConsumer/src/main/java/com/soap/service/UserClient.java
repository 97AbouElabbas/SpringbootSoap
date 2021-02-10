package com.soap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soap.consumingwebservice.wsdl.GetUserRequest;
import com.soap.consumingwebservice.wsdl.GetUserResponse;

public class UserClient extends WebServiceGatewaySupport {

	  private static final Logger log = LoggerFactory.getLogger(UserClient.class);

	  public GetUserResponse getUser(String user) {

	    GetUserRequest request = new GetUserRequest();
	    request.setName(user);

	    log.info("Requesting location for " + user);

	    GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
	        .marshalSendAndReceive("http://localhost:8080/soapWS/users", request,
	            new SoapActionCallback(
	                "http://soap.com/xml/GetCountryRequest"));

	    return response;
	  }

	}
