/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SelfOrderKiosk.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gaizka
 */
public class TranslatorManager {
    private Translator currentDictionary;
    private Map<String, Translator> dictionaries;
    
    public TranslatorManager(){
        dictionaries = new HashMap<String, Translator>();
        dictionaries.put("es", new Translator("es"));
        dictionaries.put("en", new Translator("en"));
        dictionaries.put("eus", new Translator("eus"));
        currentDictionary = dictionaries.get("es");
        
    }

    public void setCurrentIdiom(String idiom){
        currentDictionary = dictionaries.get(idiom);
    }

    public List getIdioms(){
        List<String> idioms = new ArrayList<String>();
        for (String idiom : dictionaries.keySet()){
            idioms.add(idiom);
        }
        return idioms;
        
    }

    public String translate(String text){
        return currentDictionary.translate(text);
    }
    
}
