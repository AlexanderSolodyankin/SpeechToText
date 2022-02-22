package org.dvp.yask.speechkit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Комплект
 */
public abstract class Kit implements Task {

    /**
     * Наименования параметра "Язык"
     */
    protected final static String LANG = "lang";

    /**
     * Наименования параметра "Формат аудио"
     */
    protected final static String FORMAT = "format";

    /**
     * Наименования параметра "Темп"
     */
    protected final static String RATE = "sampleRateHertz";

    /**
     * Параметры задачи
     */
    protected Map<String, String> task;

    public Kit()
    {
        System.out.println("Класс Kit/ Конструктор/ строка 36 конструктор начал работу");
        task = new HashMap<>();
        System.out.println("Класс Kit/ Конструктор/ строка 36 конструктор завершен");
    }

    public Kit setLang(String lang)
    {
        System.out.println("Класс Kit/  метод setLang/ строка 41 принял значение: " + lang);
        System.out.println("Класс Kit/  метод setLang/ строка 42 отработал task.put(LANG, lang);: ");
        task.put(LANG, lang);
        System.out.println("Класс Kit/  метод setLang/ строка 44 вернул this " + this.getClass());
        System.out.println("Класс Kit/  метод setLang/ строка 45 метод завершен");
        return this;
    }

    public Kit setFormat(String format)
    {
        System.out.println("Класс Kit/  функция setFormat/ строка 51 принял: " + format);
        task.put(RATE, !format.equals(Format.OGGOPUS) ? Rate.HIGH : null);
        task.put(FORMAT, format);
        System.out.println("Класс Kit/  функция setFormat/ строка 54 вернул this " + this.getClass());
        System.out.println("Класс Kit/  функция setFormat/ строка 55 метод завершен");
        return this;
    }


    @Override
    public void addParam(Map<String, String> param) {
        System.out.println("Класс Kit/  метод addParam/ строка 62 начало метода получил " + param);
        System.out.println("Класс Kit/  метод addParam/ строка 63 размотка ");
        //  тут хочу развернуть мапу
        System.out.println("Класс Kit/  метод addParam/ строка 67 размотка завершена ");
        System.out.println("Класс Kit/  метод addParam/ строка 68 вложил зночение в таск ");
        task.putAll(param);
        System.out.println("Класс Kit/  метод addParam/ строка 62 завершение метода ");
    }

    @Override
    public abstract String getParam();

    @Override
    public abstract String getURL();

    @Override
    public String toString() {
        return "Kit{" +
                "task=" + getStringMap() +
                '}';
    }
    public String getStringMap(){
        String write ="";
        for (Map.Entry<String, String> entry : task.entrySet()) {
            write = write + entry.getKey() + ":" + entry.getValue().toString();
        }
        return write;
    }
}
