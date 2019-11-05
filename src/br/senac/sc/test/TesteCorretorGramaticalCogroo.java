package br.senac.sc.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.checker.CheckDocument;
import org.cogroo.checker.GrammarChecker;
import org.cogroo.text.Token;

public class TesteCorretorGramaticalCogroo {

	public static void main(String[] args) throws IllegalArgumentException, IOException {

		InputStream in = new FileInputStream("C:\\Users\\Daniel\\git\\PnlTCS\\resources\\models_pt_BR.xml");
	    ComponentFactory factory = ComponentFactory.create(in);
	    Analyzer cogroo = factory.createPipe();
	    in.close();
		
//	    ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
//	    Analyzer pipe = factory.createPipe();
	    
	    GrammarChecker gc = new GrammarChecker(cogroo);
	    
	    CheckDocument document = new CheckDocument("João casou com Maria em São Paulo");

	    gc.analyze(document);
	    
	    
	    // obtenha os resultados em document.getMistakes(), ou simplesmente imprima o documento
//	    System.out.println(document);
	    
	    List<String> verbos = new ArrayList<>();
	    List<String> adjetivos = new ArrayList<>();
	    List<String> numeros = new ArrayList<>();

	    List<String> nomesProprios = new ArrayList<>();
	    List<String> artigos = new ArrayList<>();
	    List<String> substantivos = new ArrayList<>();
	    
	    for (Token t: document.getSentences().get(0).getTokens()) {
	    	
	    	switch (t.getPOSTag()) {
			case "adj":
				adjetivos.add(t.getLexeme());
				break;
			case "prop":
				nomesProprios.add(t.getLexeme());
				break;
			case "num":
				numeros.add(t.getLexeme());
				break;
			case "n":
				substantivos.add(t.getLexeme());
				break;
			case "art":
				artigos.add(t.getLexeme());
				break;

			default:
				break;
			}
	    	
	    	
	    	
	    	
	    	List<String> lexemas = Arrays.asList(t.getLemmas());
	    	System.out.println("LEXEME: " + t.getLexeme() +  (!lexemas.isEmpty() ? lexemas.toString() : "") + " FEATURE: "  +t.getFeatures() + " - CHUNK: " + t.getChunkTag()+ " - POSTAG: " + t.getPOSTag()) ;
	    	
	    	
	    	
	    
	    }
	    
	    
	    for (int i = 0; i < substantivos.size(); i++) {
	    	if(substantivos.get(i).contains("postagens")) {
	    		System.out.println("BD: posts" );
	    		substantivos.remove(i);
	    	}
	    }
	    
	    
	    StringBuilder p = new StringBuilder("%");
    	for (String s: substantivos) {
    		p.append(s).append("%");
    	}
    	
    	
    	System.out.println(p.toString());
    	
    	
    	String query = "select * from posts where lower(text) like '"+p.toString()+"'";
    	
    	
    	System.out.println(query);
//    	jdbc.query(query);
    	
    	
	    System.out.println("Adjetivos: " +adjetivos);
    	System.out.println("Nomes: " +nomesProprios);
    	System.out.println("N�meros: " +numeros);
    	System.out.println("Substantivo: " +substantivos);
    	System.out.println("Artigo: " +artigos);
	}

}























