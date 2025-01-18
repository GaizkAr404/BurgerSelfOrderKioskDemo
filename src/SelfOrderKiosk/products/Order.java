package SelfOrderKiosk.products;

import java.util.ArrayList;
import java.util.List;

public class Order{
    private int orderNumber;
    private List<Product> products;

    //Calculates the total amount of the order
    public int getTotalAmount(){
        int totalAmount = 0;
        for(Product product : products){
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }
    //Returns individual product
    public Product getProduct(int i){
        return products.get(i);
    }
    //Returns all the products
    public List<Product> getProducts(){
        return products;
    }
    //Generates a string with the order
    public String getOrderText(){
        String orderText = "";
        orderText += String.valueOf(getTotalAmount())  + "€ " + "\n";
        for(Product product : products){
            orderText += product.getName() + "\n";
        }
        return orderText;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void addProduct(Product product){
        if (products == null){
            products = new ArrayList<Product>();
        }
        products.add(product);
    }

    public void addMenu(Menu menu){
        if (products == null){
            products = new ArrayList<Product>();
        }
        products.add(menu);
        
    }

    public void removeProduct(int index){
        products.remove(index);
    }

}
