package com.gupta.shanu.advanced_jaxrs_01;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "paramExample" path)
 */
@Path("{pathParam}/paramExample")
//@Singleton
public class ParamExample {

	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	return "PathParam: " + pathParamExample + " QueryParam: " + queryParamExample;
    }
}
