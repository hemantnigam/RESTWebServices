package com.api;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.io.File;

@Path("/customers/")
public class RESTHelloWorld {

	@GET
	@Produces("text/html")
	public Response getLocalCust() {
		String output="Local Constructor";
		return Response.status(200).entity(output).build();
	}
	@GET
	@Produces("text/html")
	@Path("/nri")
	public Response getNriCust() {
		return Response.status(200).entity("Local Method").build();
	}
	@GET
	@Produces("text/html")
	@Path("/{name}/{country}")
	public Response getURLParameterValue(@PathParam("name") String name,@PathParam("country") String country) {
	return Response.status(200).entity("Name ="+name+"Country"+country).build(); 
	}
	@GET
	@Produces("text/html")
	@Path("/details/")
	public Response getURLQueryValue(@QueryParam("name") String name,@QueryParam("country") String country) {
		return Response.status(200).entity("Name ="+name+"\tCountry="+country).build(); 
	}
	@GET
	@Produces("text/html")
	@Path("/values/")
	public Response getURLmatrixValue(@MatrixParam("name") String name,@MatrixParam("country") String country) {
		return Response.status(200).entity("Name ="+name+"\tCountry="+country).build(); 
	}
	@POST
	@Produces("text/html")
	@Path("/addCustomer")
	public Response getFormValue(@FormParam("name") String name,@FormParam("country") String country) {
		return Response.status(200).entity("Name ="+name+"\tCountry="+country).build(); 
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------
	//code for download file
	
	@GET
	@Path("/download/")
	@Produces("text/html")
	public Response downloadFile() {
		File file=new File("C:\\Users\\nigamh\\Desktop\\details.txt");
		ResponseBuilder rb=Response.ok((Object)file);
		rb.header("Content-Disposition", "attachment;filename=MagicFile.txt");
		return rb.build();
	}
}
