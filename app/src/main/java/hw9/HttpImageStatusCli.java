package hw9;

import java.util.InputMismatchException;
import java.util.Scanner;

import hw9.exception.NoCodeException;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.println("Enter HTTP status code");
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (true) {
            try {
                input = scan.nextInt();    
                new HttpStatusImageDownloader().downloadStatusImage(input);
                break;
            } catch (NoCodeException e) {
                System.out.printf("There is not image for HTTP status %d%n", input);
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
                scan.nextLine();
            }
        }
    }
}
