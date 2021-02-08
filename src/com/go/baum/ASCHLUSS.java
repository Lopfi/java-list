package com.go.baum;

import com.go.daten.DATENELEMENT;

public class ASCHLUSS extends BAUMELEMENT {
    public BAUMELEMENT nachfolgerLGeben() {
        return null;
    }

    public BAUMELEMENT nachfolgerRGeben() {
        return null;
    }

    public BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement) {
        return null;
    }

    public void nachfolgerLSetzten(BAUMELEMENT nachfolgerNeu) {}

    public void nachfolgerRSetzten(BAUMELEMENT nachfolgerNeu) {}

    public DATENELEMENT datenGeben() {
        return null;
    }

    public void informationGeben() {
        System.out.print("Abschluss");
    }

    public int resthoeheGeben() {
        return 0;
    }

    public void inorderAusgeben() {}

    public void preorderAusgeben(int tiefe) {}

    public void postorderAusgeben(int tiefe) {}

    public DATENELEMENT suchen(String vergleichwert) {
        return null;
    }

    public BAUMELEMENT einfuegen(DATENELEMENT datenelement) {
        return new KNOTEN(datenelement);
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        return null;
    }

}
