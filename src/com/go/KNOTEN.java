package com.go;

public class KNOTEN {
    private DATENELEMENT daten;
    private KNOTEN nachfolger;

    public KNOTEN(DATENELEMENT daten, KNOTEN nachfolger) {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    public KNOTEN(DATENELEMENT daten) {
        this.daten = daten;
        nachfolger = null;
    }

    public void nachfolgerSetzen(KNOTEN nachfolgerNeu) {
        nachfolger = nachfolgerNeu;
    }

    public KNOTEN nachfolgerGeben() {
        return nachfolger;
    }

    public DATENELEMENT datenelementGeben() {
        return daten;
    }

    public void informationGeben() {
        daten.InformationGeben();
    }

    public int restlaengeGeben() {
        if (nachfolger == null) return nachfolger.restlaengeGeben() + 1;
        else return 1;
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (daten.SchluesselIstGleich(vergleichwert)) return daten;
        else if (nachfolger != null) return nachfolger.suchen(vergleichwert);
        else return null;
    }

    public KNOTEN sortiertEinfuegen(DATENELEMENT datenelement) {
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

    public KNOTEN suchen(DATENELEMENT datenelement) {
        if (datenelement == this) return this;
        else if (nachfolger != null) return nachfolger.suchen(datenelement);
        else return null;
    }

    public KNOTEN vorgaengerSuchen(DATENELEMENT datenelement) {
        if (nachfolger != null) {
            if (datenelement == nachfolger.datenelementGeben()) return this;
            else return nachfolger.vorgaengerSuchen(datenelement);
        }
        else return null;
    }

    public DATENELEMENT endeGeben() {
        if (nachfolger == null) return daten;
        else return nachfolger.endeGeben();
    }

    public KNOTEN endeEntfernen() {
        if (nachfolger == null) return null;
        else {
            nachfolger = nachfolger.endeEntfernen();
            return this;
        }
    }
}