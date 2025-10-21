package hw9.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class HttpService {
    public HttpResponse<byte[]> get(String url) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET();
        HttpRequest request = builder.build();
            
        try (HttpClient client = HttpClient.newHttpClient()) {
            return client.send(request, BodyHandlers.ofByteArray());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
       }
    }
}
