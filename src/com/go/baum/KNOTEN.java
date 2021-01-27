package com.go.baum;

import com.go.daten.DATENELEMENT;

public class KNOTEN extends BAUMELEMENT {
    private DATENELEMENT daten;
    private BAUMELEMENT nachfolgerR;
    private BAUMELEMENT nachfolgerL;

    public KNOTEN(DATENELEMENT daten, BAUMELEMENT nachfolgerL, BAUMELEMENT nachfolgerR) {
        this.daten = daten;
        this.nachfolgerR = nachfolgerR;
        this.nachfolgerL = nachfolgerL;
    }

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
        return ((nachfolgerL.resthoeheGeben() > nachfolgerR.resthoeheGeben()) ? nachfolgerL.resthoeheGeben() : nachfolgerR.resthoeheGeben()) + 1;
    }

    public DATENELEMENT datenGeben() {
        return daten;
    }

    public DATENELEMENT endeGeben() {
        if (nachfolgerL.endeGeben() == null) return daten;
        else return nachfolgerL.endeGeben();
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
        else return nachfolgerL.suchen(vergleichwert);
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

    public BAUMELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        if (datenelement == nachfolgerL.datenGeben()) return this;
        else return nachfolgerL.vorgaengerSuchen(datenelement);
    }

    public BAUMELEMENT endeEntfernen() {
        nachfolgerL = nachfolgerL.endeEntfernen();
        return this;
    }
}
