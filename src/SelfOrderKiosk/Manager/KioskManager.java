package SelfOrderKiosk.Manager;

import SelfOrderKiosk.Manager.Context;
import SelfOrderKiosk.Screens.KioskScreen;
import SelfOrderKiosk.Screens.WelcomeScreen;

public class KioskManager {
    public void start() {
        //Crea un xontexto y muestra la pantalla de bienvenida
        Context context = new Context();
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        KioskScreen nextScreen = welcomeScreen.show(context);
        
        while (true) {
            //Muestra la siguiente pantalla y actualiza la variable nextScreen
            nextScreen = nextScreen.show(context);
        }
    }
}
