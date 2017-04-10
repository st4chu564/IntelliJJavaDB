package Files;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Open existing file");
            System.out.println("2. Create new file");
            choice = read.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice == 1) {
            System.out.print("Give file name: ");
            String fileToOpen = read.next();
            Database base = new Database(fileToOpen);
            base.printContent();
        }
        else if(choice == 2){
            Database base = new Database();
            String name;
            int result;
            do {
                System.out.print("Enter file name: ");
                 name = read.next();
                if (name.toLowerCase().contains("."))
                    name = name.substring(0, name.indexOf(".")) + ".dbm";
                else
                    name += ".dbm";
                result = base.createNew(name);
            }while(result != 0);
            base.printContent();
        }
        }
}
