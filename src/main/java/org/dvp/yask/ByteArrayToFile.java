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
            Cloud cloud = new Cloud("AQAAAABdFFmvAATuwctpwUq2xE8An_FqMKFw2rE", "b1geknbdvkfbpm5ab40k"); // Обращение в облако  через передачу токена и ID индефикатора облака


            //// Модель распознания речи (на данный момент возврощает пустую строку по идее должен принимать аудио файлы форматов .ogg .mp3 .wav
            // Text это задача по распознованию речи которая передается в  метод облока в задачу передается адрес по которому находится файл
//            Text text = new Text("C:\\Users\\ASUS\\Desktop\\Проги для работы\\SpeechToText\\YandexSpeechKIT\\Yandex-SpeechKit-Java-SDK меняем код\\yandex-speech-kit-java\\RecognitionSound.mp3");
//            text.setLang(Lang.RU);
//            text.setTopic(Topic.GENERAL);
//            text.setFilter(Filter.FALSE);
//            text.setFormat(Format.LPCM);
//            /// получение байт кода после обращения по ссылке  и получения байт кода
//            byte[] textFile = cloud.request(text);
////          расшифровка результата в текстовый файл ( при распозновании получаею пустой байт масив)
//            ByteArrayToFile.save("Recognition.txt", textFile);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//          Модуль сервиса синтеза речи ( все работает нормально и синтез разпознает текст)
  //           в Speech передаем строку с текстом который бдет синтезироватся
            Speech speech = new Speech("Сюдаа передается предложение которое конвертируется в речь");
            speech.setVoice(Voice.ALYSS); // выбор голоса для синтеза на данный момент выбрана Алиса
            byte[] oggFile = cloud.request(speech); // получаем массив данных для конвертации в файл
            ByteArrayToFile.save("test.ogg", oggFile); // конвертируем байт массив в звуковой файл
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


