package SelfOrderKiosk.Screens;

import SelfOrderKiosk.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;

public class SectionScreen implements KioskScreen {
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        configureScreenButtons(kiosk, context);
        char option = kiosk.waitEvent(60);
        if (option == 'A') {
            return new ProductScreen(0);
        } else if (option == 'B') {
            return new ProductScreen(1);
        } else if (option == 'C') {
            return new ProductScreen(2);
        } else if (option == 'D') {
            return new OrderScreen();
        } else {
            return this;
            
        }
    }

    public void configureScreenButtons(SimpleKiosk kiosk, Context context) {
        kiosk.setMenuMode();
        kiosk.clearScreen();
        kiosk.setTitle(context.getTranslator().translate("Secciones"));
        kiosk.setOption('A', context.getTranslator().translate("Hamburguesas"));
        kiosk.setOption('B', context.getTranslator().translate("Bebidas"));
        kiosk.setOption('C', context.getTranslator().translate("Complementos"));
        kiosk.setOption('D', context.getTranslator().translate("Volver"));
        kiosk.setOption('E', null);
        
    }

}
