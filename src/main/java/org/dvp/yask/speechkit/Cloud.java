package org.dvp.yask.speechkit;

import com.google.gson.Gson;
import org.dvp.yask.speechkit.auth.Token;
import org.dvp.yask.speechkit.exception.ClientException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Cloud Аутентификация в облаке и выполнение задачи
 */
public class Cloud extends Request {
    /**
     * Наименование параметра "OAUTH-токен"
     */
    private final static String OAUTH_TOKEN = "yandexPassportOauthToken";

    /**
     * Наименование параметра "ID каталога"
     */
    private final static String FOLDER_ID = "folderId";

    /**
     * Заголовки web-запроса
     */
    private Map<String, String> headers;

    /**
     * Параметры задачи
     */
    private Map<String, String> task;

    public Cloud(String oAuthToken, String folderId) throws ClientException, InterruptedException, IOException, URISyntaxException {
        /**
         * Конструктор принимает строки токена и ID облака с возможностью вызова ошибок (исключения 3 вида)
         * ошибка связанная с клиентом, Ошибка прерывания, ошибка ввода вывода и ошибка связанная с адресом
         */
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 43 Принял: " + oAuthToken);
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 44 Принял: " + folderId);
        if (folderId.length() > Limit.FOLDER_ID_LENGTH) { // если длина сроки облака больше лимита длины строки облака
            System.out.println("Класс Cloud/ Конструктор Cloud/ строка 46 зашол в условие и выбросил ошибку: ");
            throw new ClientException(Message.LENGTH_ERROR); // выбросить ошибку клиента
        }
        headers = new HashMap<>();
        task = new HashMap<>();
        String iamToken = getIAMToken(oAuthToken);
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 52 присвоил: " + iamToken);
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 53 зашол в метод: " );
        setAuthHeaders(iamToken);
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 55 вышел из метода: " );

        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 57 выполнил : task.put(FOLDER_ID, folderId);" );
        task.put(FOLDER_ID, folderId);
        System.out.println("Класс Cloud/ Конструктор Cloud/ строка 59 конструктор закончен" );
    }

    private String getIAMToken(String oAuthToken) throws InterruptedException, IOException, URISyntaxException {
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 63 принял: " + oAuthToken );
        String s = new String(send(URL.IAM_TOKEN, String.format("{'%s':'%s'}", OAUTH_TOKEN, oAuthToken)));
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 65 назначил: " + s );
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 66 : создал new Gson();");
        Gson gson = new Gson();
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 68 : создал Token");
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 69 : зашол в функцию: gson.fromJson(s, Token.class);");
        Token token = gson.fromJson(s, Token.class);
        System.out.println("Класс Cloud/ метод getIAMToken/ строка 71 созданный токен " + token);
        System.out.println("Класс cloud/ метод getAIMToken/ строка 72 вернул:  "+token.getIamToken());
        System.out.println("Класс cloud/ метод getAIMToken/ строка 73 метод завершен:  ");
        return token.getIamToken();
    }

    private void setAuthHeaders(String iamToken) {
        System.out.println("Класс Cloud/ метод setAuthHeaders/ строка 78 Получил: " + iamToken);
        System.out.println("Класс Cloud/ метод setAuthHeaders/ строка 79 Внес значение в мапу headers: ");
        System.out.println("Класс Cloud/ метод setAuthHeaders/ строка 80 Внес значение в первое значение: " + "Authorization");
        System.out.println("Класс Cloud/ метод setAuthHeaders/ строка 81 Внес значение в второе значение: " + ("Bearer " + iamToken));
        headers.put("Authorization",
                (new StringBuilder().append("Bearer ").append(iamToken).toString()));
        System.out.println("Класс Cloud/ метод setAuthHeaders/ строка 84 метод завершен: ");
    }

    public byte[] request(Task task) throws InterruptedException, IOException, URISyntaxException {
        System.out.println("Класс Cloud/ метод request/ строка 88 получил класс Таск: " + task);
        task.addParam(this.task);
        System.out.println("Класс Cloud/ метод request/ строка 90 отработал task.addParam(this.task);: ");
        System.out.println("Класс Cloud/ метод request/ строка 91 передача параметра : "+task.getURL());
        System.out.println("Класс Cloud/ метод request/ строка 92 передача параметра : "+task.getParam());
       byte[] sen = send(task.getURL(), task.getParam(), headers);
        System.out.println("Класс Cloud/ метод request/ строка 94 завершение функции ");
       return sen;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "headers=" + headers +
                ", task=" + task +
                '}';
    }
}
