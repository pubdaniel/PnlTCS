package br.senac.sc.model;

import opennlp.tools.langdetect.Language;

public class QueryObject {

	Language language;

	public QueryObject() {
		super();
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
}
