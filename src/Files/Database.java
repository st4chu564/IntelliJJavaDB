package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Database {
    private String fileName;
    private BufferedReader read = null;
    private List<String> list = new ArrayList<>();
    public Database(String fileName){
        this.fileName = fileName;
        try {
            File file = new File(fileName);
            read = new BufferedReader(new FileReader(file));
            String text;
            while ((text = read.readLine()) != null) {
                list.add(text);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException e) {
            }
        }
    }
    public Database(){
        this.fileName = "";
    }
    public void printContent(){
        for(String value: list){
            System.out.println(value);
        }
    }
    public static void main (String []args){

    }

}
