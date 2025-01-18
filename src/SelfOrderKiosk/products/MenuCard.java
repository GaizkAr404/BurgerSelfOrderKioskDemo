package SelfOrderKiosk.products;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class MenuCard {
    private List<MenuCardSection> sectionList;

    public MenuCardSection getSection(int i){
        return sectionList.get(i);
    }

    public int getNumberOfSections(){
        return sectionList.size();
        
    }

    public static MenuCard loadfromDisk() {
        try (InputStream is = new FileInputStream(new File("Catalog.xml"))) {
            XMLDecoder decoder = new XMLDecoder(is);
            return (MenuCard) decoder.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MenuCard(List<MenuCardSection> sectionList){
        this.sectionList = sectionList;
    }

}
