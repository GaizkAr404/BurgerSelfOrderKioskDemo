package SelfOrderKiosk.products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Product{
    private int discount;
    private List<IndividualProduct> products;

    //Returns the price of the menu
    public int getPrice() {
        int price = 0;
        for (IndividualProduct product : products) {
            price += product.getPrice();
        }
        price -= price * discount / 100;
        return price;
    }


    public int getNumberOfProducts() {
        return products.size();
    }

    //Rerturns the name of the menu being the names of the products separated by ;
    public String getName() {
        String name = "";
        for (IndividualProduct product : products) {
            name += product.getName() + ";";
        }
        return name;
    }

    //Get the discount of the menu from the file Discount.txt
    public void loadDiscount() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Discount.txt"));
            discount = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(IndividualProduct product) {
        if (products == null){
            products = new ArrayList<IndividualProduct>();
        }
        products.add(product);
    }

    public String getImage() {
        return products.get(0).getImageFileName();
    }

}
