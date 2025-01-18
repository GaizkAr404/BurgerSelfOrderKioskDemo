package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Screens.CarouselScreen;
import SelfOrderKiosk.products.IndividualProduct;
import SelfOrderKiosk.products.Menu;
import SelfOrderKiosk.products.Order;
import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;

public class MenuScreen extends CarouselScreen {
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        int section = 0;
        Menu menu = new Menu();
        IndividualProduct product;
        int i = 0;

        while (section <= 2){
            kiosk.setMenuMode();
            kiosk.clearScreen();
            kiosk.setOption('A', context.getTranslator().translate("Añadir producto"));
            kiosk.setOption('B', context.getTranslator().translate("Volver"));
            product = context.getMenuCard().getSection(section).getProduct(i);
            kiosk.setTitle(context.getTranslator().translate(product.getName()));
            kiosk.setDescription(product.getPrice() + "€" + "\n" + context.getTranslator().translate(product.getDescription()));
            kiosk.setImage(product.getImageFileName());
            adjustCarruselButtons(i, context.getMenuCard().getSection(section).getNumberOfProducts(), kiosk);
            char option = kiosk.waitEvent(60);

            if (option == 'A') {
                menu.addProduct(product);
                section++;
            } else if (option == 'G') {
                i--;
            } else if (option == 'H') {
                i++;
            } else if (option == 'B') {
                return new OrderScreen();
            } else {
                return new OrderScreen();
                
            }
        }

        Order order = context.getOrder();
        order.addMenu(menu);
        context.setOrder(order);
        return new OrderScreen();
   }
}
