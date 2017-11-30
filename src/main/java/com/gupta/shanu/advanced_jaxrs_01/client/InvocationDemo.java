package com.gupta.shanu.advanced_jaxrs_01.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForMessagesByYear(2017);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
	}

	private Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		WebTarget target =  client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages");
		return target.queryParam("year", year).request(MediaType.APPLICATION_JSON).buildGet();
	}

}
