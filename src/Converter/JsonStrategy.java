package Converter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonStrategy implements Strategy{
    String[] text;
    String json = "";
    Path path;

    public JsonStrategy(String[] text){
        this.text = text;
        this.path = Paths.get(
                "C:\\Users\\Hp\\Desktop\\Programming\\Java Fx\\Design Pattern\\Strategy (Text Converter)\\Output.txt");
    }

    public void convert(){
        String[] temp;
        json += "{\n";

        for (int i=0; i<text.length; i++){
            temp = text[i].split(" ", 0);

            json += "\t{\n";
            json += "\t\troll: " + temp[0];
            json += ",\n\t\tname: " + temp[1];
            json += ",\n\t\tinstitution: " + temp[2];
            json += "\n\t}";

            if(i != text.length-1) json += ",\n";
        }
        json += "\n}";

        try {
            Files.writeString(path, json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
