package com.gupta.shanu.advanced_jaxrs_01;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Singleton
public class MyResource {

	private int count;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	count++;
        return "this method is called by " + count + " times";
    }
}
