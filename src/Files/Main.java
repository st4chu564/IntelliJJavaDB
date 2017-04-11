package Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database base;
        Scanner read = new Scanner(System.in);
        BaseOperations[] mainBase;
        int choice, currentFileIndex = 0, numberOfFiles;
        do {
            System.out.println("1. Open existing file");
            System.out.println("2. Create new file");
            choice = read.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice == 1) {
            System.out.print("Give file name: ");
            String fileToOpen = read.next();
            base = new Database(fileToOpen);
            base.printContent();
        }
        else {
            base = new Database();
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
        mainBase = new BaseOperations[base.getNumberOfFiles()];
        List<String> tempStorage = base.giveNames();
        for (String name : tempStorage) {
            mainBase[currentFileIndex] = new BaseOperations(name);
        }
        currentFileIndex = 0;
        mainBase[currentFileIndex].printBase();

        }
}
