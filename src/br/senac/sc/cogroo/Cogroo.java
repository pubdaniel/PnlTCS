package br.senac.sc.cogroo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.text.Chunk;
import org.cogroo.text.Document;
import org.cogroo.text.Sentence;
import org.cogroo.text.SyntacticChunk;
import org.cogroo.text.Token;
import org.cogroo.text.impl.DocumentImpl;


public class Cogroo {
	
	Analyzer cogroo;
	
	public Cogroo() throws IOException {
//		InputStream in = new FileInputStream("C:\\Users\\Aluno\\git\\PnlTCS\\resources\\models_pt_BR.xml");
//	    ComponentFactory factory = ComponentFactory.create(in);
//	    cogroo = factory.createPipe();
		
	    ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
	    cogroo = factory.createPipe();

//	    in.close();
	}
	
	public List<Sentence> extractSentences(String text) {
		
		Document document = new DocumentImpl();
		document.setText(text);
		
	    cogroo.analyze(document);
	    
	    for (Sentence sentence : document.getSentences()) { // lista de sentenças
	  	  sentence.getStart(); sentence.getEnd(); // caracteres onde a sentença começa e termina
	  	  sentence.getText(); // texto da sentença

	  	  // Tokens
	  	  for (Token token : sentence.getTokens()) { // lista de tokens
	  	    token.getStart(); token.getEnd(); // caracteres onde o token começa e termina
	  	    token.getLexeme(); // o texto do token
	  	    token.getLemmas(); // um array com os possíveis lemas para o par lexeme+postag
	  	    token.getPOSTag(); // classe morfológica de acordo com o contexto
	  	    token.getFeatures(); // gênero, número, tempo etc
	  	  }

	  	  // Chunks
	  	  for (Chunk chunk : sentence.getChunks()) { // lista de chunks
	  	    chunk.getStart(); chunk.getEnd(); // índice do token onde o chunk começa e do token onde ele termina
	  	    chunk.getTag(); // the chunk tag
	  	    chunk.getTokens(); // a list with the covered tokens
	  	  }

	  	  // Structure
	  	  for (SyntacticChunk structure : sentence.getSyntacticChunks()) { // lista de SyntacticChunks
	  	    structure.getStart(); structure.getEnd(); // índice do token onde o structure começa e do token onde ele termina
	  	    structure.getTag(); // the structure tag
	  	    structure.getTokens(); // a list with the covered tokens
	  	  }
	  	  
	  	}
	    return document.getSentences();
		
	}
	
	public static void main(String[] args) throws IOException {
		Cogroo c = new Cogroo();
		System.out.println(c.extractSentences("Olá mundo, como vai você?"));
	}
}
