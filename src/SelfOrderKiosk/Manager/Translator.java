package SelfOrderKiosk.Manager;

import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Translator {
    private Map<String, String> palabras;
    //Translates a text
    public String translate(String text) {
        return palabras.get(text);

    }
    //Constructor from dictionary
    public Translator(String idiom) {
        palabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Dictionaries/" + idiom + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    palabras.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

    }
}
