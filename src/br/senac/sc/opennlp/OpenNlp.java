package br.senac.sc.opennlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

public class OpenNlp {
	
	private static LanguageDetectorModel languageModel;
	
	public OpenNlp() throws IOException {
		languageModel = new LanguageDetectorModel(new File("C:\\Users\\Daniel\\git\\PnlTCS\\resources\\models\\langdetect-183.bin"));
	}
	 
	public Language detectLanguage(String text) {
		LanguageDetector detector = new LanguageDetectorME(languageModel);
		return detector.predictLanguage(text);
	}
	
	public Language[] detectLanguages(String text) {
		LanguageDetector detector = new LanguageDetectorME(languageModel);
		return detector.predictLanguages(text);
	}
	
	public static void main(String[] args) throws IOException {
		OpenNlp nlp = new OpenNlp();
		nlp.detectLanguage("Bolsonaro armas descriminação");

	}
	
}
