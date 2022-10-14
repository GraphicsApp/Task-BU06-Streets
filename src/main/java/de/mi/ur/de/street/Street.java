package de.mi.ur.de.street;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;
import de.ur.mi.bouncer.world.fields.FieldColor;

public class Street extends BouncerApp {

    @Override
    public void bounce() {
        loadMap("Strasse");
        checkStreet();
    }

    private void checkStreet() {
        repairField();
        while (bouncer.canMoveForward()) {
            bouncer.move();
            repairField();
        }
    }

    /*
     * Bouncer repariert bei Bedarf das Feld auf dem er aktuell steht
     *
     * Vorbedingung: Bouncer steht auf einem Feld
     * Ergebnis: Bouncer steht auf einem grünen Feld
     */
    private void repairField() {
        if (bouncer.isOnFieldWithColor(FieldColor.RED)) {
            bouncer.paintField(FieldColor.GREEN);
        }
    }

    public static void main (String[] args) {
        BouncerLauncher.launch();
    }
}
