package SelfOrderKiosk.Manager;

import SelfOrderKiosk.products.Menu;
import SelfOrderKiosk.products.MenuCard;
import SelfOrderKiosk.Manager.TranslatorManager;
import SelfOrderKiosk.products.Order;
import SelfOrderKiosk.SimpleKiosk;

public class Context {
    private SimpleKiosk kiosk;
    private TranslatorManager translator;
    private Order order;
    private MenuCard menuCard;
    private int orderNumber;
    private int kioskNumber;
    private int numberofKiosks;

    public TranslatorManager getTranslator() {
        return translator;
    }

    public SimpleKiosk getKiosk() {
        return kiosk;
        
    }

    public Order getOrder() {
        return order;
    }

    public MenuCard getMenuCard() {
        return menuCard;
        
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void initialize(){
        TranslatorManager translator = new TranslatorManager();
        this.translator = translator;
        SimpleKiosk kiosk = new SimpleKiosk();
        this.kiosk = kiosk;
        Order order = new Order();
        this.order = order;
        MenuCard menuCard = MenuCard.loadfromDisk();
        this.menuCard = menuCard;

    }
}
