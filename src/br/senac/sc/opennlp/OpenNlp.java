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
	
	public void detectLanguage(String text) {
		LanguageDetector detector = new LanguageDetectorME(languageModel);
		Language language = detector.predictLanguage(text);
		System.out.println(language.getLang() + " predict: " + language.getConfidence());
		
	}
	
	public static void main(String[] args) throws IOException {
		OpenNlp nlp = new OpenNlp();
		nlp.detectLanguage("Bolsonaro armas descriminação");

	}
	
}
