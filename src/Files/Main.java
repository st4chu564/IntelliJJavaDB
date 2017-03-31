package Files;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Give file name: ");
        String fileToOpen = read.next();
        Database base = new Database(fileToOpen);
        base.printContent();
    }
}
