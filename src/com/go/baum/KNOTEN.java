package com.go.baum;

import com.go.daten.DATENELEMENT;

public class KNOTEN extends BAUMELEMENT {
    private DATENELEMENT daten;
    private BAUMELEMENT nachfolgerR;
    private BAUMELEMENT nachfolgerL;

    public KNOTEN(DATENELEMENT daten) {
        this.daten = daten;
        nachfolgerR = new ASCHLUSS();
        nachfolgerL = new ASCHLUSS();
    }

    public BAUMELEMENT nachfolgerLGeben() {
        return nachfolgerL;
    }

    public BAUMELEMENT nachfolgerRGeben() {
        return nachfolgerR;
    }

    public void nachfolgerLSetzten(BAUMELEMENT nachfolgerNeu) {
        nachfolgerL = nachfolgerNeu;
    }

    public void nachfolgerRSetzten(BAUMELEMENT nachfolgerNeu) {
        nachfolgerR = nachfolgerNeu;
    }

    public void informationGeben() {
        daten.informationGeben();
    }

    public int resthoeheGeben() {
        int l = nachfolgerL.resthoeheGeben();
        int r = nachfolgerR.resthoeheGeben();
        return ((l > r) ? l : r) + 1;
    }

    public void inorderAusgeben() {
        nachfolgerL.inorderAusgeben();
        daten.informationGeben();
        nachfolgerR.inorderAusgeben();
    }

    public void preorderAusgeben(int tiefe) {
        System.out.format("%" + tiefe + "s", daten.getKey() + "\n");
        nachfolgerL.preorderAusgeben(tiefe);
        nachfolgerR.preorderAusgeben(tiefe);
    }

    public void postorderAusgeben(int tiefe) {
        System.out.format("%" + tiefe + "s", daten.getKey() + "\n");
        nachfolgerR.preorderAusgeben(tiefe);
        nachfolgerL.preorderAusgeben(tiefe);
    }

    public DATENELEMENT datenGeben() {
        return daten;
    }

    public BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement) {
        if(daten == datenelement) return nachfolgerL;
        else {
            nachfolgerL = nachfolgerL.knotenEntfernen(datenelement);
            return this;
        }
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (daten.schluesselIstGleich(vergleichwert)) return daten;
        else if(nachfolgerL.suchen(vergleichwert) != null) return nachfolgerL.suchen(vergleichwert);
        else return nachfolgerR.suchen(vergleichwert);
    }

    public BAUMELEMENT einfuegen(DATENELEMENT datenelement) {
        if (this.daten.schluesselIstGleich(datenelement.getKey())) {
            return this;
        }
        if (datenelement.istKleinerAls(this.daten)) {
            this.nachfolgerL = this.nachfolgerL.einfuegen(datenelement);
        }
        else {
            this.nachfolgerR = this.nachfolgerR.einfuegen(datenelement);
        }
        return this;
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        if (datenelement == this.daten) return this;
        else return nachfolgerL.suchen(datenelement);
    }

}
