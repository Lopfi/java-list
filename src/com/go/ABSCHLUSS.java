package com.go;

public class ABSCHLUSS extends LISTENELEMENT{


    public LISTENELEMENT nachfolgerGeben() {
        return null;
    }

    public LISTENELEMENT knotenEntfernen(DATENELEMENT datenelement) {
            return null;
    }

    public void nachfolgerSetzen(LISTENELEMENT nachfolgerNeu) {}

    public DATENELEMENT datenGeben() {
        return null;
    }

    public void informationGeben() {}

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
        hintenEinfuegen(datenelement);
        return this;
    }

    public LISTENELEMENT hintenEinfuegen(DATENELEMENT datenelement) {
        this.einfuegenVor(datenelement, null);
        return this;
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
