package com.go.baum;

import com.go.daten.DATENELEMENT;

public class BINBAUM {
    private BAUMELEMENT wurzel;

    public BINBAUM() {
        wurzel = new ASCHLUSS();
    }

    public void vorneEinfuegen(DATENELEMENT datenelement) {
        wurzel = new KNOTEN(datenelement, wurzel);
    }

    public  void hintenEinfuegen(DATENELEMENT datenelement) {
        wurzel = wurzel.hintenEinfuegen(datenelement);
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT dvergleich) {
        wurzel = wurzel.einfuegenVor(dNeu, dvergleich);
    }

    public void sortiertEinfuegen(DATENELEMENT datenelement) {
        wurzel = wurzel.sortiertEinfuegen(datenelement);
    }

    public DATENELEMENT wurzelEntfernen() {
        DATENELEMENT daten = wurzel.datenGeben();
        wurzel = wurzel.nachfolgerLGeben();
        return daten;
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        BAUMELEMENT k1 = this.suchen(datenelement);
        BAUMELEMENT k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerSetzen(k1.nachfolgerLGeben());
    }

    public DATENELEMENT endeEntfernen() {
        DATENELEMENT ende = wurzel.endeGeben();
        return wurzel.endeEntfernen().datenGeben();
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

    public int laengeGeben() {
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
