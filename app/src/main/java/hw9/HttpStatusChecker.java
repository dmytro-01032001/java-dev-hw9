package hw9;

import java.net.http.HttpResponse;

import hw9.service.HttpService;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception{
        String url = String.format("https://http.cat/%d.jpg", code);
        HttpResponse response = new HttpService().get(url);
        if (response.statusCode() == 404) {
            throw new Exception(String.format("Для коду %d картинки немає", code));
        }
        return url;
    }
}
