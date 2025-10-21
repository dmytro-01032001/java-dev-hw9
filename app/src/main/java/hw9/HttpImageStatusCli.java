package hw9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.println("Enter HTTP status code");
        try (Scanner scan = new Scanner(System.in)) {
            int input;
            input = scan.nextInt();
            try {

                new HttpStatusImageDownloader().downloadStatusImage(input);
            } catch (Exception e) {
                System.out.println(String.format("There is not image for HTTP status %d", input));
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
    }
}
