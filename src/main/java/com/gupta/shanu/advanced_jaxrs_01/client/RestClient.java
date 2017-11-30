package com.gupta.shanu.advanced_jaxrs_01.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gupta.shanu.advanced_jaxrs_01.messenger.model.Message;

public class RestClient {

	public static void main(String args[]) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message1.getMessage());
		Message data = new Message(4, "client message", "ShanuGupta");
		Response postResponse = messageTarget.request().post(Entity.json(data));
		if (postResponse.getStatus() != 201) {
			System.out.println("message didn't create");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
	}

}
