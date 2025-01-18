package SelfOrderKiosk;

import java.util.List;

public class Order{
    private int orderNumber;
    private List<Product> products;

    public int getTotalAmount(){
        int totalAmount = 0;
        for(Product product : products){
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    public String getOrderText(){

    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void addProduct(Product product){
        products.add(product);
    }

}
