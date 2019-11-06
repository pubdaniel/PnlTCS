package br.senac.sc.opennlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class OpenNlp {
	
	private static LanguageDetectorModel languageModel;
	private static SentenceModel sentenceModel;

	
	public OpenNlp() throws IOException {
		languageModel = new LanguageDetectorModel(new File("resources\\models\\langdetect-183.bin"));
		sentenceModel = new SentenceModel(new File("resources\\models\\pt-sent.bin"));
	}
	
	public Language detectLanguage(String text) {
		LanguageDetector detector = new LanguageDetectorME(languageModel);
		return detector.predictLanguage(text);
	}
	
	public Language[] detectLanguages(String text) {
		LanguageDetector detector = new LanguageDetectorME(languageModel);
		return detector.predictLanguages(text);
	}
	
	public List<String> getSentences(String text) {
		SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentenceModel);
		String sentences[] = sentenceDetector.sentDetect(text);
		return Arrays.asList(sentences);

	}
	
	public static void main(String[] args) throws IOException {
		String text = "Bolsonaro armas descriminação";
		OpenNlp nlp = new OpenNlp();
		System.out.println(nlp.detectLanguage(text));
		System.out.println(nlp.getSentences(text));
	}
	
}
