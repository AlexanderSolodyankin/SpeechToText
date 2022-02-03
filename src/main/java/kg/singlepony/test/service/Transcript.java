package kg.singlepony.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Transcript {
    public static void main(String[] args) {
        String url = "C:\\Users\\ASUS\\Desktop\\SpeechToText\\secondTry\\ПересборкаПроекта\\src\\main\\resources\\edu\\cmu\\sphinx\\demo\\aligner\\10001-90210-01803.wav";
        String write = startTranscript();



    }

    public static String startTranscript() {
        String write = "Пустая строка Значит что то пошло не так";
        try {
            Configuration configuration = new Configuration();

            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

//            StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
//            InputStream stream = new FileInputStream(new File(url));
//            recognizer.startRecognition(stream);
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);
            SpeechResult result = recognizer.getResult();

            write = "";
            while ((result = recognizer.getResult()) != null) {
                System.out.format("Hypothesis: %s\n", result.getHypothesis());
                write += result.getHypothesis() + "\n";
            }


            recognizer.stopRecognition();


        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());

        }
        return write;
    }
}
