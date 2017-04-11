package Files;


import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseOperations extends Database{
    private ArrayList<List<String>> base = new ArrayList<List<String>>();
    private List<String> baseTempStore = new ArrayList<>();

    public BaseOperations(String fileName){
        this.fileName = fileName;
        readBase();
    }
    public BaseOperations(){

    }
    public int readBase(){
        try{
            File file = new File(this.fileName);
            this.read = new BufferedReader(new FileReader(file));
            String temp;
            int position;
            while((temp = this.read.readLine()) != null){
                do{
                    position = temp.indexOf(";");
                    if(position <= temp.length() - 1) {
                        baseTempStore.add(temp.substring(0, position));
                        temp = temp.substring(position + 1, temp.length());
                    }
                }while(!temp.isEmpty());
                base.add(new ArrayList<>(baseTempStore));
                baseTempStore.clear();
            }
        }catch (FileNotFoundException e) {
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
        return 0;
    }
    public void printBase(){
        for(List<String> record: base){
            for(String cell: record)
                System.out.print(cell + "\t");
            System.out.println();
        }

        }
    }

