package com.go.baum;

import com.go.daten.DATENELEMENT;

public class BINBAUM {
    private BAUMELEMENT wurzel;

    public BINBAUM() {
        wurzel = new ASCHLUSS();
    }

    public BAUMELEMENT getWurzel() {
        return wurzel;
    }

    public  void einfuegen(DATENELEMENT datenelement) {
        wurzel = wurzel.einfuegen(datenelement);
    }

    public DATENELEMENT wurzelEntfernen() {
        DATENELEMENT daten = wurzel.datenGeben();
        wurzel = wurzel.nachfolgerLGeben();
        return daten;
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        BAUMELEMENT k1 = this.suchen(datenelement);
        BAUMELEMENT k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerLSetzten(k1.nachfolgerLGeben());
        k2.nachfolgerLSetzten(k1.nachfolgerLGeben());
    }

    public void informationGeben() {
        BAUMELEMENT knoten;
        knoten = wurzel;
        while (!(knoten instanceof ASCHLUSS)) {
            knoten.informationGeben();
            System.out.print("; ");
            knoten = knoten.nachfolgerLGeben();
        }
        System.out.println();
    }

    public int hoeheGeben() {
        return wurzel.resthoeheGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return wurzel.suchen(vergleichwert);
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        return wurzel.suchen(datenelement);
    }

    public BAUMELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        return wurzel.vorgaengerSuchen(datenelement);
    }

}
