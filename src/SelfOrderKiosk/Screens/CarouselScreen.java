package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.Screens.KioskScreen;

public class CarouselScreen implements KioskScreen{
    protected void adjustCarruselButtons(int currentElement, int numberOfElements, SimpleKiosk kiosk) {
            if (currentElement == 0) {
                kiosk.setOption('G',null);
                kiosk.setOption('H', "Siguiente");
            } else if (currentElement == numberOfElements - 1) {
                kiosk.setOption('H',null);
                kiosk.setOption('G', "Anterior");
            } else {
                kiosk.setOption('G', "Anterior");
                kiosk.setOption('H', "Siguiente");
                
            }
    }
    

    protected void configureScreenButtons() {

    }

    @Override
    public KioskScreen show(Context context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

}
