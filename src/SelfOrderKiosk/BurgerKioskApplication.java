package SelfOrderKiosk;

import SelfOrderKiosk.Manager.KioskManager;

public class BurgerKioskApplication {

    public static void main(String[] args) {
        KioskManager kioskManager = new KioskManager();
        kioskManager.start();
    }

}
