package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.products.Order;

public class OrderScreen implements KioskScreen {

    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        
        if (context.getOrder() == null) {
            context.setOrder(new Order());
        }

        configureScreenButtons(context, kiosk);
        char option = kiosk.waitEvent(60);

        if (option == 'A') {
            return new SectionScreen();
        } else if (option == 'B') {
            return new MenuScreen();
        } else if (option == 'C') {
           return new DeleteProductScreen();
        } else if (option == 'D') {
            return new PurchaseScreen();
        } else if (option == 'E') {
            context.setOrder(null);
            return new WelcomeScreen();
        } else {
            return this;
        }
    }

    private void configureScreenButtons(Context context, SimpleKiosk kiosk) {
        kiosk.setMenuMode();
        kiosk.clearScreen();
        kiosk.setTitle(context.getTranslator().translate("Pedido"));
        kiosk.setOption('A', context.getTranslator().translate("Añadir producto individual"));
        kiosk.setOption('B', context.getTranslator().translate("Añadir menu"));
        kiosk.setOption('C', context.getTranslator().translate("Eliminar producto"));
        kiosk.setOption('D', context.getTranslator().translate("Finalizar pedido"));
        kiosk.setOption('E', context.getTranslator().translate("Cancelar pedido"));
        
    }


}
