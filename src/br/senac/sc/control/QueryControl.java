package br.senac.sc.control;

import java.io.IOException;

import org.cogroo.analyzer.ComponentFactory;

import br.senac.sc.cogroo.Cogroo;
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
	
	public QueryObject processQuery(String text) throws IOException {
		QueryObject queryObject = new QueryObject();
		queryObject.setLanguage(nlp.detectLanguage(text));
		queryObject.setSentences(nlp.getSentences(text));
		
		
		
//		Cogroo cogroo = new Cogroo();
//		queryObject.setSentences(cogroo.extractSentences(text)); // Ver com professor como bildar projeto cogroo no projeto e usar RESOURCES (models)
		
		//=>
		//language detector
		//Entitys
		
		
		//<= 
		return queryObject;
	}
	
	
}
