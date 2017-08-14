package com.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/customers/")
public class JSON_Conversion {
	
	@GET
	@Produces("text/html")
	public Response getLocal() {
		return Response.status(200).entity("Local").build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerName(@PathParam("id") int no) {
		Customer c=new Customer();
		c.setId(no);
		c.setName("Hemant");
		c.setCountry("India");
		return c;
	}
	
}
