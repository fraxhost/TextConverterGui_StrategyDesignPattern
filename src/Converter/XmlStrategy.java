package Converter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlStrategy implements Strategy{
    String[] text;
    String xml = "";
    Path path;

    public XmlStrategy(String[] text){
        this.text = text;
        this.path = Paths.get(
                "C:\\Users\\Hp\\Desktop\\Programming\\Java Fx\\Design Pattern\\Strategy (Text Converter)\\Output.txt");
    }

    public void convert(){
        String[] temp;

        for (int i=0; i<text.length; i++){
            temp = text[i].split(" ", 0);

            //ASCII 13 is creating an error which I am not aware of
            String temp2 = temp[2].substring(0, temp[2].length()-1);

            xml += "<student>\n";
            xml += "\t<roll> " + temp[0] + " </roll>\n";
            xml += "\t<name> " + temp[1] + " </name>\n";
            xml += "\t<institution> " + temp2 + " </institution>\n";
            xml += "</student>\n";
        }

        try {
            Files.writeString(path, xml, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
