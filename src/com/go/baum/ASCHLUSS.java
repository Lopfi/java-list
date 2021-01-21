package com.go.baum;

import com.go.daten.DATENELEMENT;

public class ASCHLUSS extends BAUMELEMENT {
    public BAUMELEMENT nachfolgerLGeben() {
        return this;
    }

    public BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement) {
        return null;
    }

    public void nachfolgerSetzen(BAUMELEMENT nachfolgerNeu) {}

    public DATENELEMENT datenGeben() {
        return null;
    }

    public void informationGeben() {
        System.out.print("Abschluss");
    }

    public int resthoeheGeben() {
        return 0;
    }

    public DATENELEMENT endeGeben() {
        return null;
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return null;
    }

    public BAUMELEMENT sortiertEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement, this);
        return knoten;
    }

    public BAUMELEMENT einfuegenVor(DATENELEMENT datenelement, DATENELEMENT vergleich) {
        return hintenEinfuegen(datenelement);
    }

    public BAUMELEMENT hintenEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement, this);
        return knoten;
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        return null;
    }

    public BAUMELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        return null;
    }

    public BAUMELEMENT endeEntfernen() {
        return this;
    }
}
