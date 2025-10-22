package hw9;

import java.net.http.HttpResponse;
import java.net.HttpURLConnection;

import hw9.exception.NoCodeException;
import hw9.service.HttpService;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws NoCodeException{
        String url = String.format("https://http.cat/%d.jpg", code);
        HttpResponse response = new HttpService().get(url);
        if (response.statusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new NoCodeException(String.format("There is not image for HTTP status %d", code));
        }
        return url;
    }
}
