package com.go.liste;

import com.go.daten.DATENELEMENT;

public class ABSCHLUSS extends LISTENELEMENT{

    public LISTENELEMENT nachfolgerGeben() {
        return this;
    }

    public LISTENELEMENT knotenEntfernen(DATENELEMENT datenelement) {
            return null;
    }

    public void nachfolgerSetzen(LISTENELEMENT nachfolgerNeu) {}

    public DATENELEMENT datenGeben() {
        return null;
    }

    public void informationGeben() {
        System.out.print("Abschluss");
    }

    public int restlaengeGeben() {
        return 0;
    }

    public DATENELEMENT endeGeben() {
        return null;
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return null;
    }

    public LISTENELEMENT sortiertEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement, this);
        return knoten;
    }

    public LISTENELEMENT einfuegenVor(DATENELEMENT datenelement, DATENELEMENT vergleich) {
        return hintenEinfuegen(datenelement);
    }

    public LISTENELEMENT hintenEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement, this);
        return knoten;
    }

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        return null;
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        return null;
    }

    public LISTENELEMENT endeEntfernen() {
        return this;
    }
}
