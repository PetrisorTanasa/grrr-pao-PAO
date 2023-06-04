package main.java.exercitii;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CitireThread extends Thread{
    static ArrayList<String> cuvinte = new ArrayList<>();
    String fisier;
    CitireThread(String fisier){
        this.fisier = fisier;
    }
    @Override
    public void run(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.fisier));
            String linie;
            while((linie = reader.readLine()) != null){
                String[] info = linie.split("[^\\w]");
                for(String inf : info){
                    cuvinte.add(inf);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //RESTANTA 2017
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(this.fisier));
//            String linie;
//            while((linie = reader.readLine()) != null){
//                String[] info = linie.split(",");
//                asigurari.add(new Asigurarea(info[0],info[1],Double.parseDouble(info[2]),info[3]));
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
