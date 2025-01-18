package SelfOrderKiosk.Screens;


import urjc.UrjcBankServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.Manager.SimpleKiosk;

public class PurchaseScreen implements KioskScreen {
    //Shows the purchase screen
    public KioskScreen show(Context context) {

        //Check if there are products in the order
        if (context.getOrder().getProducts() == null) {
            return new OrderScreen();
        }
        //Show the purchase screen with the option to introduce card
        SimpleKiosk kiosk = context.getKiosk();
        kiosk.setMessageMode();
        kiosk.clearScreen();
        kiosk.setTitle(context.getTranslator().translate("Introduce la tarjeta de credito"));
        kiosk.setDescription(context.getOrder().getOrderText());
        configureScreenButtons(kiosk, context);
        char option = kiosk.waitEvent(60);

        if (option == 'A') {
            return new OrderScreen();
        } else if (option == 'B') {
            return new WelcomeScreen();
        } else if (option == '1'){
            kiosk.retainCard(false);
            long cardNumber = kiosk.getCardNumber();
            if (cardNumber == 0) {
                kiosk.expelCreditCard(5);
                return this;  
            } else {

                //Check if the bank is available
                UrjcBankServer bank = new UrjcBankServer();
                boolean connected = bank.comunicationAvaiable();
                if (connected == false) {
                    kiosk.expelCreditCard(5);
                    return this;
                }
                boolean pay = false;
                //Do the payment
                try{
                    pay = bank.doOperation(cardNumber, context.getOrder().getTotalAmount());
                } catch (Exception e) {
                    kiosk.expelCreditCard(5);
                    return this;
                }

                if (pay == true) {
                    kiosk.expelCreditCard(10);
                    writeOrderToFile(context, kiosk);
                    context.setOrder(null);
                    return new WelcomeScreen();
                } else {
                    kiosk.expelCreditCard(5);
                    return this;
                }
            }
        }else{
            return this;
        }
        
    }

    private void configureScreenButtons(SimpleKiosk kiosk, Context context) {
        kiosk.setOption('A', context.getTranslator().translate("Modificar pedido"));
        kiosk.setOption('B', context.getTranslator().translate("Cancelar pedido"));
        
    }
    //Write the order to a file and prints the ticket
    private void writeOrderToFile(Context context, SimpleKiosk kiosk) {

        int id = 0;
        try {
            File file = new File("HistoricoPedidos.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                id = incrementOrderNumber();
                writer.write("ID:" + id);
                writer.newLine();
                writer.write(context.getOrder().getOrderText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> text = new ArrayList<String>();
        text.add("ID: " + id);
        text.add(context.getOrder().getOrderText());
        kiosk.print(text);
    }   
    //Increment the order number to set the id using the previous orders from file
    private int incrementOrderNumber() {
        int id = 1; // Default ID if the file is empty or no ID is found
        try (BufferedReader reader = new BufferedReader(new FileReader("HistoricoPedidos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID:")) {
                    try {
                        id = Integer.parseInt(line.substring(3).trim())+1;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
        
    }


}
