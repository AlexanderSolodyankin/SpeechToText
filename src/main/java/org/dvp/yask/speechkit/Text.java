package org.dvp.yask.speechkit;

import java.util.Map;

public class Text extends Kit {

    /**
     * Наименования параметра "Языковая модель"
     */
    private final static String TOPIC = "topic";

    /**
     * Наименования параметра "Фильтр ненормативной лексики"
     */
    private final static String FILTER = "profanityFilter";

    private String filePath;

    public Text(String filePath)
    {
        System.out.println("Класс Text/ конструктор Text/ строка 21 начало работы ");
        System.out.println("Класс Text/ конструктор Text/ строка 22 нпринял параметр  " + filePath);
        System.out.println("Класс Text/ конструктор Text/ строка 23 вложил параметр в поле  " + filePath);
        this.filePath = filePath;
        System.out.println("Класс Text/ конструктор Text/ строка 25 конструктор конец работы  " );

    }

    public Text setTopic(String topic)
    {
        System.out.println("Класс Text/ функции setTopic/ строка 31 начало функции ");
        System.out.println("Класс Text/ функции setTopic/ строка 32 принял параметр " + topic);
        task.put(TOPIC, topic);
        System.out.println("Класс Text/ функции setTopic/ строка 34 создана мапа ");
        System.out.println("Класс Text/ функции setTopic/ строка 35  размотка мапы ");
        //  тут хочу развернуть мапу
        System.out.println("Класс Text/ функции setTopic/ строка 37  размотка мапы  завершена");
        System.out.println("Класс Text/ функции setTopic/ строка 38  конец функции и возврощение this" + this);
        return this;
    }

    public Text setFilter(String filter)
    {
        System.out.println("Класс Text/ функции setFilter/ строка 44 начало функции ");
        System.out.println("Класс Text/ функции setFilter/ строка 45 принял параметр " + filter);
        task.put(FILTER, filter);
        System.out.println("Класс Text/ функции setFilter/ строка 47 создана мапа ");
        System.out.println("Класс Text/ функции setFilter/ строка 48  размотка мапы ");
        //  тут хочу развернуть мапу
        System.out.println("Класс Text/ функции setFilter/ строка 50  размотка мапы  завершена");
        System.out.println("Класс Text/ функции setFilter/ строка 51  конец функции и возвращение this " + this);
        return this;
    }

    @Override
    public String getParam() {
        System.out.println("Класс Text/ функции getParam/ строка 57 начало функции ");
        System.out.println("Класс Text/ функции getParam/ строка 58  конец функции и возвращение filePath " + filePath);
        return filePath;
    }

    @Override
    public String getURL() {
        System.out.println("Класс Text/ функции getURL/ строка 64 начало функции ");
        System.out.println("Класс Text/ функции getURL/ строка 65 формирования URL запроса ");
        StringBuilder sb = new StringBuilder();
        sb.append(URL.RECOGNIZE).append("?");
        task.forEach((k, v) -> {
            if (sb.length() > 0)
            {
                sb.append("&");
            }
            sb.append(k).append("=").append(v);
        });
        System.out.println("Класс Text/ функции getURL/ строка 75  конец функции и возвращение sb.toString()" + sb.toString());
        return sb.toString() ;
    }
}
