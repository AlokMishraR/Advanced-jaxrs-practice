package com.gupta.shanu.advanced_jaxrs_01;

import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gupta.shanu.advanced_jaxrs_01.model.MyDate;

@Path("datetest")
public class MyDateResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{dateString}")
    public String getIt(@PathParam("dateString") MyDate dateString ) {
    	return "Date: " + dateString.toString();
    }
    
    @GET
    @Produces(value = {MediaType.TEXT_PLAIN, "text/shortDate"})
    @Path("/mediaTypeExample")
    public Date getShortDate(){
    	return Calendar.getInstance().getTime();
    }
}