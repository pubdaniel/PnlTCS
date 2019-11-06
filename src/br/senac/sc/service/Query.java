package br.senac.sc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	@Produces(MediaType.TEXT_PLAIN)
	public Response sendQuery(@QueryParam("text") String text) throws IOException {
		
		Runtime rt = Runtime.getRuntime();
	    rt.exec(new String[]{"cmd.exe","/c","java -jar D:\\Aluno\\workspace\\TestePLN\\pln.jar "+text});
	    File f = new File("D:\\Aluno\\workspace\\TestePLN\\saida.txt");
	    while(!f.exists()) {}
	   String saida= new String( Files.readAllBytes( Paths.get("D:\\Aluno\\workspace\\TestePLN\\saida.txt")));
		//ler o arquivo saida.txt (aguardar o mesmo existir)
		QueryControl control = new QueryControl();
		QueryObject queryObject;
		try {
			queryObject = control.processQuery(text); 
			return Response.ok(saida).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
		
	}
	
	
}
