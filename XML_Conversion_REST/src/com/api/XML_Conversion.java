package com.api;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers/")
public class XML_Conversion {
	
	@GET
	@Produces("text/html")
	public Response getResponse() {
		return Response.status(200).entity("Local").build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("id")int no) {
		Customer c=new Customer();
		c.setId(no);
		c.setName("Hemant");
		c.setCountry("India");
		return c;
	}
}
