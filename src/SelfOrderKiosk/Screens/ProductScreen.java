package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.products.IndividualProduct;
import SelfOrderKiosk.products.Order;

public class ProductScreen extends CarouselScreen {
    private int section;

    @Override
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        int i = 0;
        IndividualProduct product;
        configureScreenButtons();



        while (true) {
            
        
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
                Order order = context.getOrder();
                order.addProduct(product);
                context.setOrder(order);
                return new OrderScreen();
            } else if (option == 'G') {
                i--;
            } else if (option == 'H') {
                i++;
            } else if (option == 'B') {
                return new SectionScreen();
                
            } else {
                return new OrderScreen();
            }
        }
    }


    public ProductScreen(int section) {
        this.section = section;
    }

}
