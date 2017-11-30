package com.gupta.shanu.advanced_jaxrs_01.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains("secured")){
			List<String> basicTokens = requestContext.getHeaders().get("Authorization");
			if(basicTokens != null && !basicTokens.isEmpty()){
				String token = basicTokens.get(0);
				token = token.replaceFirst("Basic ", "");
				String decodedToken = Base64.decodeAsString(token);
				StringTokenizer tokens = new StringTokenizer(decodedToken,":");
				String username = tokens.nextToken();
				String password = tokens.nextToken();
				if(username.equals("shanu") && password.equals("gupta")){
					return;
				}
			}
			Response response = Response.status(Status.UNAUTHORIZED).entity("User can't access the resource").build();
			requestContext.abortWith(response);
		}
	}
}
