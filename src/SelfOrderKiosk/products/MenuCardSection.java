package SelfOrderKiosk.products;

import java.util.List;

public class MenuCardSection {
    private String sectionName;
    private String imageFileName;
    private List<IndividualProduct> productList;

    public IndividualProduct getProduct(int i){
        return productList.get(i);   
    }

    public String getSectionName(){
        return sectionName;
    }

    public int getNumberOfProducts(){
        return productList.size();
    }

    public String getImageFileName(){
        return imageFileName;
    }

    public MenuCardSection(String sectionName, String imageFileName, List<IndividualProduct> productList){
        this.sectionName = sectionName;
        this.imageFileName = imageFileName;
        this.productList = productList;
    }
}
