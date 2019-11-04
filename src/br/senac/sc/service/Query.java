package br.senac.sc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/query")
public class Query {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendQuery(@QueryParam("url") String url) {
		//control text processor => 
		
		
		return Response.ok("{ 'Query' : '"+ url+"' }").build();
	}
	
	
}
