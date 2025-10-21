package hw9;

import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import hw9.service.HttpService;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        String url = new HttpStatusChecker().getStatusImage(code);
        HttpResponse<byte[]> response = new HttpService().get(url);
        if (response.statusCode() == 200) {
            byte[] imageBytes = response.body();
            Path outputPath = Paths.get(String.format("cat_%d.jpg", code));
            Files.write(outputPath, imageBytes);
        }
    }
}
