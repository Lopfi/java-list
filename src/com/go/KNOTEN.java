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

    public void nachfolgerSetzen(LISTENELEMENT nachfolgerNeu) {
        nachfolger = nachfolgerNeu;
    }

    public DATENELEMENT datenGeben() {
        return daten;
    }

    public void informationGeben() {
        daten.InformationGeben();
    }

    public int restlaengeGeben() {
        if (nachfolger == null) return nachfolger.restlaengeGeben() + 1;
        else return 1;
    }

    public DATENELEMENT endeGeben() {
        if (nachfolger == null) return daten;
        else return nachfolger.endeGeben();
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (daten.SchluesselIstGleich(vergleichwert)) return daten;
        else if (nachfolger != null) return nachfolger.suchen(vergleichwert);
        else return null;
    }

    public LISTENELEMENT sortiertEinfuegen(DATENELEMENT datenelement) {
        if (datenelement.istKleinerAls(this.daten) == false) {
            KNOTEN knoten = new KNOTEN(datenelement, this);
            return knoten;
        }
        else {
            if (nachfolger == null) {
                hintenEinfuegen(datenelement);
            } else {
                nachfolger = nachfolger.sortiertEinfuegen(datenelement);
            }
            return this;
        }
    }

    public void hintenEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement);
        this.nachfolger = knoten;
    }

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        if (datenelement == this) return this;
        else if (nachfolger != null) return nachfolger.suchen(datenelement);
        else return null;
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        if (nachfolger != null) {
            if (datenelement == nachfolger.datenGeben()) return this;
            else return nachfolger.vorgaengerSuchen(datenelement);
        }
        else return null;
    }

    public LISTENELEMENT endeEntfernen() {
        if (nachfolger == null) return null;
        else {
            nachfolger = nachfolger.endeEntfernen();
            return this;
        }
    }
}