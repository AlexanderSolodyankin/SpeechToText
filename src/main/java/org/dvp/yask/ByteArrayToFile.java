package org.dvp.yask;

import org.dvp.yask.speechkit.*;
import org.dvp.yask.speechkit.exception.ClientException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class ByteArrayToFile {

    public static void main(String[] args) {
        try {
            Cloud cloud = new Cloud("AQAAAABdFFmvAATuwctpwUq2xE8An_FqMKFw2rE", "b1geknbdvkfbpm5ab40k");
//            Text text = new Text("C:\\Users\\ASUS\\Desktop\\Проги для работы\\SpeechToText\\YandexSpeechKIT\\Yandex-SpeechKit-Java-SDK меняем код\\yandex-speech-kit-java\\decoder-test.wav");
//            text.setLang(Lang.RU);
////            text.setTopic(Topic.GENERAL);
////            text.setFilter(Filter.FALSE);
////            text.setFormat(Format.LPCM);
//
//
//            byte[] textFile = cloud.request(text);
//            ByteArrayToFile.save("Recognition.txt", textFile);
            Speech speech = new Speech("Мирлан привет это саня привет из приложения которое ты скачал ");
            speech.setVoice(Voice.random());
            byte[] oggFile = cloud.request(speech);
            ByteArrayToFile.save("test.ogg", oggFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void save(String filepath, byte[] data) throws IOException {
        File file = new File(filepath);
        OutputStream os = new FileOutputStream(file);
        os.write(data);
        os.close();
    }
}
