package hw9;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import hw9.exception.NoCodeException;
import hw9.service.HttpService;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws NoCodeException {
        String url = new HttpStatusChecker().getStatusImage(code);
        HttpResponse<byte[]> response = new HttpService().get(url);
        if (response.statusCode() == 200) {
            byte[] imageBytes = response.body();
            Path outputPath = Paths.get(String.format("cat_%d.jpg", code));
            try {
                Files.write(outputPath, imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
