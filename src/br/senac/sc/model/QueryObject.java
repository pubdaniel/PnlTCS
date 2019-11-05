package br.senac.sc.model;

import java.util.List;

import org.cogroo.text.Sentence;

import opennlp.tools.langdetect.Language;

public class QueryObject {

	Language language;
	List<String> sentences;

	public QueryObject() {
		super();
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public List<String> getSentences() {
		return sentences;
	}
	
	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}
	
	
	
}
