package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.Manager.SimpleKiosk;

public class IdiomScreen extends CarouselScreen {

    //Shows the screen to select the idiom
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        kiosk.setMenuMode();
        kiosk.clearScreen();
        kiosk.setTitle(context.getTranslator().translate("Idiomas"));
        kiosk.setOption('A', "Español"  );
        kiosk.setOption('B', "English"  );
        kiosk.setOption('C', "Euskera" );
        kiosk.setOption('D', context.getTranslator().translate("Volver"));

        char option = kiosk.waitEvent(60);
        switch (option) {
            case 'A':
                context.changeIdiom("es");
                break;
            case 'B':
                context.changeIdiom("en");
                break;
            case 'C':
                context.changeIdiom("eus");
                break;
        }
        return new WelcomeScreen();

    }

}
