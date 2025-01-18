package SelfOrderKiosk.Manager;

import SelfOrderKiosk.Manager.TranslatorManager;
import java.util.List;
import sienens.BurgerSelfOrderKiosk;

public class SimpleKiosk {
    private BurgerSelfOrderKiosk kiosk;

    public SimpleKiosk() {
        kiosk = new BurgerSelfOrderKiosk();
    }

    public void setOption(char option, String description) {
        kiosk.setOption(option, description);
    }

    public void setTitle(String title) {
        kiosk.setTitle(title);
    }

    public void setDescription(String description) {
        kiosk.setDescription(description);
    }

    public void setMenuMode() {
        kiosk.setMenuMode();
    }

    public char waitEvent(int timeout) {
        return kiosk.waitEvent(timeout);
    }

    public void print(List<String> text) {
        kiosk.print(text);
    }

    public void retainCard(boolean retain) {
        kiosk.retainCreditCard(retain);
    }
    
    public void expelCreditCard(int n){
        kiosk.expelCreditCard(n);
    }
    
    public void clearScreen(){
        this.kiosk.setTitle(null);
        this.kiosk.setImage(null);
        this.kiosk.setDescription(null);
        for (char option = 'A'; option <= 'H'; option++) {   // Limpia las opciones de menú
            this.kiosk.setOption(option, null);
        }
    }
        
    
    
    public void setImage(String img){
        kiosk.setImage(img);
    }
    
    public long getCardNumber(){
        return kiosk.getCardNumber();
    }
    
    public void setMessageMode(){
        kiosk.setMessageMode();
    }
    
    public void SimpleKiosk(TranslatorManager translator){
        
    }
}
