package org.dvp.yask.speechkit;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * Request Web-запрос
 */
public class Request {

    protected byte[] send(String url, String data, Map<String, String> headers) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Класс Request / функция send/ строка 20 начало работы");
        System.out.println("Класс Request / функция send/ строка 21 получил " + url);
        System.out.println("Класс Request / функция send/ строка 22 получил " + data);
        System.out.println("Класс Request / функция send/ строка 23 получил " + headers);
        System.out.println("Класс Request / функция send/ строка 23 ночало развертывания мапы  " + headers);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        System.out.println("Класс Request / функция send/ строка 23 развертка мапы закончина  " + headers);
        System.out.println("Класс Request / функция send/ строка 23 создан HttpClient  ");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        if (headers != null) {
            headers.forEach((k, v) -> builder.header(k, v));

        }


        HttpRequest request = builder.uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();


        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        return response.body();
    }

    protected byte[] send(String url, String data) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Класс Request/ метод send/ строка 43: " + url);
        System.out.println("Класс Request/ метод send/ строка 44: " + data);
        return send(url, data, null);
    }
}
