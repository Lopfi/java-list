package com.go.liste;

import com.go.daten.DATENELEMENT;

public class    LISTE {
    private LISTENELEMENT anfang;

    public LISTE() {
        anfang = new ABSCHLUSS();
    }

    public void vorneEinfuegen(DATENELEMENT datenelement) {
        anfang = new KNOTEN(datenelement, anfang);
    }

    public  void hintenEinfuegen(DATENELEMENT datenelement) {
        anfang = anfang.hintenEinfuegen(datenelement);
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT dvergleich) {
        anfang = anfang.einfuegenVor(dNeu, dvergleich);
    }

    public void sortiertEinfuegen(DATENELEMENT datenelement) {
        anfang = anfang.sortiertEinfuegen(datenelement);
    }

    public DATENELEMENT anfangEntfernen() {
        DATENELEMENT daten = anfang.datenGeben();
        anfang = anfang.nachfolgerGeben();
        return daten;
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        LISTENELEMENT k1 = this.suchen(datenelement);
        LISTENELEMENT k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerSetzen(k1.nachfolgerGeben());
    }

    public DATENELEMENT endeEntfernen() {
        DATENELEMENT ende = anfang.endeGeben();
        return anfang.endeEntfernen().datenGeben();
    }

    public void informationGeben() {
        LISTENELEMENT knoten;
        knoten = anfang;
        while (!(knoten instanceof ABSCHLUSS)) {
            knoten.informationGeben();
            System.out.print("; ");
            knoten = knoten.nachfolgerGeben();
        }
        System.out.println();
    }

    public int laengeGeben() {
        return anfang.restlaengeGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return anfang.suchen(vergleichwert);
    }

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        return anfang.suchen(datenelement);
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        return anfang.vorgaengerSuchen(datenelement);
    }
}