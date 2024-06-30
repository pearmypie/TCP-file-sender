package Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("data.txt");
        Scanner scanner = new Scanner(f);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }

        scanner.close();
    }
}