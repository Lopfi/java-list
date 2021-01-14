package com.go;

public class KNOTEN extends LISTENELEMENT {
    private DATENELEMENT daten;
    private LISTENELEMENT nachfolger;

    public KNOTEN(DATENELEMENT daten, LISTENELEMENT nachfolger) {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    public KNOTEN(DATENELEMENT daten) {
        this.daten = daten;
        nachfolger = null;
    }

    public LISTENELEMENT nachfolgerGeben() {
        return nachfolger;
    }

    public LISTENELEMENT knotenEntfernen(DATENELEMENT datenelement) {
        if(daten == datenelement) return nachfolger;
        else {
            nachfolger = nachfolger.knotenEntfernen(datenelement);
            return this;
        }
    }

    public void nachfolgerSetzen(LISTENELEMENT nachfolgerNeu) {
        nachfolger = nachfolgerNeu;
    }

    public DATENELEMENT datenGeben() {
        return daten;
    }

    public void informationGeben() {
        daten.informationGeben();
    }

    public int restlaengeGeben() {
        return nachfolger.restlaengeGeben() + 1;
    }

    public DATENELEMENT endeGeben() {
        if (nachfolger.endeGeben() == null) return daten;
        else return nachfolger.endeGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (daten.schluesselIstGleich(vergleichwert)) return daten;
        else return nachfolger.suchen(vergleichwert);
    }

    public LISTENELEMENT einfuegenVor(DATENELEMENT dneu, DATENELEMENT dvergleich) {
        if (this.daten.schluesselIstGleich(dvergleich.getKey())) {
            KNOTEN k = new KNOTEN(dneu, this);
            return k;
        } else nachfolger = nachfolger.einfuegenVor(dneu, dvergleich);
        return this;
    }

    public LISTENELEMENT sortiertEinfuegen(DATENELEMENT datenelement) {
        if (!datenelement.istKleinerAls(this.daten)) {
            KNOTEN knoten = new KNOTEN(datenelement, this);
            return knoten;
        }
        else {
            nachfolger = nachfolger.sortiertEinfuegen(datenelement);
            return this;
        }
    }

    public LISTENELEMENT hintenEinfuegen(DATENELEMENT datenelement) {
        nachfolger = nachfolger.hintenEinfuegen(datenelement);
        return this;
    }

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        if (datenelement == this.daten) return this;
        else return nachfolger.suchen(datenelement);
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        if (datenelement == nachfolger.datenGeben()) return this;
        else return nachfolger.vorgaengerSuchen(datenelement);
    }

    public LISTENELEMENT endeEntfernen() {
        nachfolger = nachfolger.endeEntfernen();
        return this;
    }
}