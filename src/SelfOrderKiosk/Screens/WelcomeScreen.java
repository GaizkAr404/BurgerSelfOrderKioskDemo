package SelfOrderKiosk.Screens;

import SelfOrderKiosk.Manager.SimpleKiosk;
import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.Manager.TranslatorManager;

//Esta clase representa la pantalla de bienvenida
public class WelcomeScreen implements KioskScreen {

    //Shows the welcome screen
    @Override
    public KioskScreen show(Context context) {
        context.initialize();
        SimpleKiosk kiosk = context.getKiosk();
        configureScreenButtons(kiosk, context);
        char option = kiosk.waitEvent(60);

        if (option == 'A') {
            return new OrderScreen();
        } else if (option == 'B') {
            return new IdiomScreen();
        } else {
            return this;
        }
    }

    //Sets the buttons for the welcome screen
    private void configureScreenButtons(SimpleKiosk kiosk, Context context) {
        TranslatorManager translator = context.getTranslator();
        kiosk.setMenuMode();
        kiosk.clearScreen();
        kiosk.setTitle(translator.translate("SelfOrderKiosk"));
        kiosk.setOption('A', translator.translate("Iniciar pedido"));
        kiosk.setOption('B', translator.translate("Cambiar idioma"));

        
    }


}
