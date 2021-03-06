package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Database {
    protected String fileName;
    protected BufferedReader read = null;
    private List<String> list = new ArrayList<>();
    public Database(String fileName) {
        this.fileName = fileName;
        readFile(fileName);
    }
    public Database(){
        this.fileName = "";
    }
    private void readFile(String fileName){
        if (fileName == "")
            System.out.println("First, create a file");
        else {
            this.fileName = fileName;
            try {
                File file = new File(this.fileName);
                read = new BufferedReader(new FileReader(file));
                String text;
                while ((text = read.readLine()) != null) {
                    list.add(text);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (read != null) {
                        read.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }
    public int createNew(String fileName){
        this.fileName = fileName;

        try {
            File out = new File(this.fileName);
            if(out.exists()){
                System.out.println("File already exists");
                this.fileName = "";
                return 1;
            }
            out.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        /*finally{

        }*/
        return 0;
    }
    public void printContent(){
        if(list.isEmpty())
            System.out.println("List is empty");
        else
            for(String value: list){
                System.out.println(value);
            }
    }
    public List<String> giveNames(){
        return list;
    }
    public int getNumberOfFiles(){
        return list.size();
    }
    public static void main (String []args){
    }
}
