package br.senac.sc.control;

import java.io.IOException;

import br.senac.sc.model.QueryObject;
import br.senac.sc.opennlp.OpenNlp;

public class QueryControl {

	OpenNlp nlp;
	
	public QueryControl() {
		try {
			nlp = new OpenNlp();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public QueryObject processQuery(String text) {
		QueryObject queryObject = new QueryObject();
		queryObject.setLanguage(nlp.detectLanguage(text));
		
		
		//=>
		//language detector
		//Entitys
		
		
		//<= 
		return queryObject;
	}
	
	
}
