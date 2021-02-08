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

    public int hoeheGeben() {
        return wurzel.resthoeheGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return wurzel.suchen(vergleichwert);
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        return wurzel.suchen(datenelement);
    }

    public void inorderAusgeben() {
        wurzel.inorderAusgeben();
    }

    public void preorderAusgeben() {
        wurzel.preorderAusgeben(this.hoeheGeben());
    }

    public void postorderAusgeben() {
        wurzel.postorderAusgeben(this.hoeheGeben());
    }
}
