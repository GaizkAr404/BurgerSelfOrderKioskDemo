package SelfOrderKiosk.products;

public class IndividualProduct implements Product {
    private String name;
    private String description;
    private String imageFileName;
    private int price;

    //Constructor
    public IndividualProduct(String name, String description, String imageFileName, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
