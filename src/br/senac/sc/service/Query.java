package br.senac.sc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senac.sc.control.QueryControl;
import br.senac.sc.model.QueryObject;

@Path("/query")
public class Query {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendQuery(@QueryParam("text") String text) {
		
		QueryControl control = new QueryControl();
		QueryObject queryObject = control.processQuery(text);
		//control text processor =>
		
		
		return Response.ok(queryObject).build();
	}
	
	
}
