/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SelfOrderKiosk;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gaizka
 */
public class TranslatorManager {
    private Translator currentDicionary;
    private Map<String, Translator> dictionaries;
    
    public void setCurrentIdiom(String idiom){
        currentDicionary.Translator(idiom);
    }

    public List getIdioms(){
        
    }

    public String translate(String text){
        currentDicionary.translate(text);
    }
    
}
