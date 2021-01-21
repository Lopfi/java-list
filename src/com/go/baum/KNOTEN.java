package com.go.baum;

import com.go.daten.DATENELEMENT;

public class KNOTEN extends BAUMELEMENT {
    private DATENELEMENT daten;
    private BAUMELEMENT nachfolger_l;
    private BAUMELEMENT nachfolger_r;

    public KNOTEN(DATENELEMENT daten, BAUMELEMENT nachfolger_l, BAUMELEMENT nachfolger_r) {
        this.daten = daten;
        this.nachfolger_l = nachfolger_l;
        this.nachfolger_r = nachfolger_r;
    }

    public KNOTEN(DATENELEMENT daten) {
        this.daten = daten;
        nachfolger_l = null;
        nachfolger_r = null;
    }

    public BAUMELEMENT nachfolgerLGeben() {
        return nachfolger_l;
    }

    public BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement) {
        if(daten == datenelement) return nachfolger_l;
        else {
            nachfolger_l = nachfolger_l.knotenEntfernen(datenelement);
            return this;
        }
    }

    public void nachfolgerSetzen(BAUMELEMENT nachfolgerNeu) {
        nachfolger_l = nachfolgerNeu;
    }

    public DATENELEMENT datenGeben() {
        return daten;
    }

    public void informationGeben() {
        daten.informationGeben();
    }

    public int resthoeheGeben() {
        return nachfolger_l.resthoeheGeben() + 1;
    }

    public DATENELEMENT endeGeben() {
        if (nachfolger_l.endeGeben() == null) return daten;
        else return nachfolger_l.endeGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (daten.schluesselIstGleich(vergleichwert)) return daten;
        else return nachfolger_l.suchen(vergleichwert);
    }

    public BAUMELEMENT einfuegenVor(DATENELEMENT dneu, DATENELEMENT dvergleich) {
        if (this.daten.schluesselIstGleich(dvergleich.getKey())) {
            KNOTEN k = new KNOTEN(dneu, this);
            return k;
        } else nachfolger_l = nachfolger_l.einfuegenVor(dneu, dvergleich);
        return this;
    }

    public BAUMELEMENT sortiertEinfuegen(DATENELEMENT datenelement) {
        if (!datenelement.istKleinerAls(this.daten)) {
            KNOTEN knoten = new KNOTEN(datenelement, this);
            return knoten;
        }
        else {
            nachfolger_l = nachfolger_l.sortiertEinfuegen(datenelement);
            return this;
        }
    }

    public BAUMELEMENT hintenEinfuegen(DATENELEMENT datenelement) {
        nachfolger_l = nachfolger_l.hintenEinfuegen(datenelement);
        return this;
    }

    public BAUMELEMENT suchen(DATENELEMENT datenelement) {
        if (datenelement == this.daten) return this;
        else return nachfolger_l.suchen(datenelement);
    }

    public BAUMELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        if (datenelement == nachfolger_l.datenGeben()) return this;
        else return nachfolger_l.vorgaengerSuchen(datenelement);
    }

    public BAUMELEMENT endeEntfernen() {
        nachfolger_l = nachfolger_l.endeEntfernen();
        return this;
    }
}
