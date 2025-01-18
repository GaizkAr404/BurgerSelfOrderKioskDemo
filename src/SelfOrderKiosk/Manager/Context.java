package SelfOrderKiosk.Manager;

import SelfOrderKiosk.products.MenuCard;
import SelfOrderKiosk.products.Order;

public class Context {
    private SimpleKiosk kiosk;
    private TranslatorManager translator;
    private Order order;
    private MenuCard menuCard;

    //Returns the tranlator
    public TranslatorManager getTranslator() {
        return translator;
    }
    //Changes the idiom of the translator
    public void changeIdiom(String idiom){
        translator.setCurrentIdiom(idiom);
        
    }
    //Returns the kiosk
    public SimpleKiosk getKiosk() {
        return kiosk;
        
    }
    //Returns the order
    public Order getOrder() {
        return order;
    }
    //Returns the menu card
    public MenuCard getMenuCard() {
        return menuCard;
        
    }
    //Sets the order
    public void setOrder(Order order){
        this.order = order;
    }
    //Initializes the context
    public void initialize(){
        
        SimpleKiosk kiosk = new SimpleKiosk();
        this.kiosk = kiosk;
        Order order = new Order();
        this.order = order;
        MenuCard menuCard = MenuCard.loadfromDisk();
        this.menuCard = menuCard;

    }
    //Constructor
    public Context(){
        this.translator = new TranslatorManager();
    }
}
