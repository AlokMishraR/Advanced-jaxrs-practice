package com.gupta.shanu.advanced_jaxrs_01.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.gupta.shanu.advanced_jaxrs_01.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target =  client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages");
		List<Message> messages = target.queryParam("year", 2017)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>(){ });
		System.out.println(messages);
	}

}
