package org.dvp.yask.speechkit;

import org.dvp.yask.speechkit.exception.ClientException;

/**
 * Speech Формирование задачи для синтеза речи (Text-To-Speech, TTS)
 */
public class Speech extends Kit implements Task {

    /**
     * Наименования параметра "Текст"
     */
    private final static String TEXT = "text";

    /**
     * Наименования параметра "SSML"
     */
    private final static String SSML = "ssml";

    /**
     * Наименования параметра "Голос"
     */
    private final static String VOICE = "voice";

    /**
     * Наименования параметра "Эмоциональная окраска"
     */
    private final static String EMOTION = "emotion";

    /**
     * Наименования параметра "Темп"
     */
    private final static String SPEED = "speed";

    public Speech(String text) throws ClientException {
        System.out.println("Класс Speech/ Конструктор Speech/ строка 36 Пришло: " + text );
        if (text.length() > Limit.SYNTHESIZE_TEXT_LENGTH) {
            throw new ClientException(Message.LENGTH_ERROR);
        }
        System.out.println("Класс Speech/ Конструктор Speech/ строка 40 Пришло: " + text );
        task.put(TEXT, text);
        System.out.println("Класс Speech/ Конструктор Speech/ строка 42 задан таск: " + task );
        System.out.println("Класс Speech/ Конструктор Speech/ строка 43 конструктор завершон ");
    }

    public Speech setSSML() {
        System.out.println("Класс Speech/ Функция setSSML/ строка 47 ночало функции ");
        String text = task.containsKey(SSML) ? task.get(SSML) : task.get(TEXT);
        System.out.println("Класс Speech/ Функция setSSML/ строка 49 вывод text  " + text);
        task.put(SSML, text);
        System.out.println("Класс Speech/ Функция setSSML/ строка 51 вывод таска  " + task);
        task.remove(TEXT);
        System.out.println("Класс Speech/ Функция setSSML/ строка 53 вывод таска  " + task);
        System.out.println("Класс Speech/ Функция setSSML/ строка 54 вывод this  " + this);
        System.out.println("Класс Speech/ Функция setSSML/ строка 55 завершение метода   ");
        return this;
    }

    public Speech setVoice(String voice) {

        System.out.println("Класс Speech/ Функция setVoice/ строка 61 ночало функции ");
        task.put(VOICE, voice);
        System.out.println("Класс Speech/ Функция setVoice/ строка 63 вывод таска  " + task);
        System.out.println("Класс Speech/ Функция setVoice/ строка 64 вывод this  " + this);
        System.out.println("Класс Speech/ Функция setVoice/ строка 65 завершение метода   ");
        return this;
    }

    public Speech setEmotion(String emotion) {
        System.out.println("Класс Speech/ Функция setEmotion/ строка 70 ночало функции ");
        task.put(EMOTION, emotion);
        System.out.println("Класс Speech/ Функция setEmotion/ строка 72 вывод таска  " + task);
        System.out.println("Класс Speech/ Функция setEmotion/ строка 73 вывод this  " + this);
        System.out.println("Класс Speech/ Функция setEmotion/ строка 74 завершение метода   ");
        return this;
    }

    public Speech setSpeed(String speed) {
        System.out.println("Класс Speech/ Функция setSpeed/ строка 79 ночало функции ");
        task.put(SPEED, speed);
        System.out.println("Класс Speech/ Функция setSpeed/ строка 81 вывод таска  " + task);
        System.out.println("Класс Speech/ Функция setSpeed/ строка 82 вывод this  " + this);
        System.out.println("Класс Speech/ Функция setSpeed/ строка 83 завершение метода   ");
        return this;
    }

    @Override
    public String getParam() {
        System.out.println("Класс Speech/ Функция getParam/ строка 89 ночало функции ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        task.forEach((k, v) -> {
            if (sb.length() > 0)
            {
                sb.append("&");
            }
            sb.append(k).append("=").append(v);
        });
        System.out.println("Класс Speech/ функции getParam/ строка 99 : " + sb.toString());
        System.out.println("Класс Speech/ функции getParam/ строка 100 конец функции");
        return sb.toString();
    }

    @Override
    public String getURL() {
        System.out.println("Класс Speech/ Функция getURL/ строка 106 ночало функции ");
        System.out.println("Класс Speech/ метод getURL/ строка 107: " + URL.SYNTHESIZE);
        System.out.println("Класс Speech/ функции getURL/ строка 108 конец функции");
        return URL.SYNTHESIZE;
    }
}
