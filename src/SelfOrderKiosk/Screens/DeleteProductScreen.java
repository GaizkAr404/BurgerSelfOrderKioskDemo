package SelfOrderKiosk.Screens;

import java.util.ArrayList;
import java.util.List;

import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.products.IndividualProduct;
import SelfOrderKiosk.products.Menu;
import SelfOrderKiosk.products.Order;

public class DeleteProductScreen extends CarouselScreen {
    public KioskScreen show(Context context){
            SimpleKiosk kiosk = context.getKiosk();
            int i = 0;
            Order order = context.getOrder();
            if (order.getProducts() == null || order.getProducts().isEmpty()) {
                return new OrderScreen();
                
            }

            //loop to select the product to delete
            while (true) {
                
                order = context.getOrder();
                kiosk.setMenuMode();
                kiosk.clearScreen();
                kiosk.setOption('A', context.getTranslator().translate("Eliminar producto"));
                kiosk.setOption('B', context.getTranslator().translate("Volver"));
                if (order.getProduct(i) instanceof IndividualProduct){
                    IndividualProduct product = (IndividualProduct) order.getProduct(i);
                    kiosk.setTitle(context.getTranslator().translate(product.getName()));
                    kiosk.setDescription(product.getPrice() + "€" + "\n" + context.getTranslator().translate(product.getDescription()));
                    kiosk.setImage(product.getImageFileName());
                } else {
                    Menu menu = (Menu) order.getProduct(i);
                    kiosk.setTitle("Menu");
                    List<String> products = new ArrayList<String>();
                    for (String productName : menu.getName().split(";")) {
                        products.add(productName);
                    }
                    kiosk.setDescription(menu.getPrice() + "€" + "\n" + context.getTranslator().translate(products.get(0)) + "\n" + context.getTranslator().translate(products.get(1)) + "\n" + context.getTranslator().translate(products.get(2)));
                    kiosk.setImage(menu.getImage());
                }

                adjustCarruselButtons(i, order.getProducts().size(), kiosk);

                char option = kiosk.waitEvent(60);

                if (option == 'A') {
                    order.removeProduct(i);
                    context.setOrder(order);
                    return new OrderScreen();
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
    }

    
}
