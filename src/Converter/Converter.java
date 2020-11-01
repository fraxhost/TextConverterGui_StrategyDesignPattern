package Converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Converter {
    private Strategy myStrategy;
    private BufferedReader myBufferedReader;
    private String[] myStringArray;

    public void setMyStrategy(Strategy strategy) {
        this.myStrategy = strategy;
    }

    public void setFile(File myFile) {
        try {
            myBufferedReader = new BufferedReader(new FileReader(myFile));

            int n = 0;
            char c;
            String data = "";

            while ((n = myBufferedReader.read()) != -1){
                c = (char) n;
                data += c;
            }

            myStringArray = data.split("\n", 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convert() {
        try {
            myStrategy.convert();

            myBufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public String[] getMyStringArray() {
        return myStringArray;
    }

}
