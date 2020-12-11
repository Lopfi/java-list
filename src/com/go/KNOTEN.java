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

    public void NachfolgerSetzen(KNOTEN nachfolgerNeu) {
        nachfolger = nachfolgerNeu;
    }

    public KNOTEN NachfolgerGeben() {
        return nachfolger;
    }

    public DATENELEMENT DatenelementGeben() {
        return daten;
    }

    public void InformationGeben() {
        daten.InformationGeben();
    }

    public int RestlaengeGeben() {
        if (nachfolger == null) return nachfolger.RestlaengeGeben() + 1;
        else return 1;
    }

    public DATENELEMENT Suchen(String vergleichwert) {
        if (daten.SchluesselIstGleich(vergleichwert)) return daten;
        else if (nachfolger != null) return nachfolger.Suchen(vergleichwert);
        else return null;
    }

    public KNOTEN sortiertEinfuegen(DATENELEMENT datenelement) {
        if (datenelement.istKleinerAls(this.daten) == false) {
            KNOTEN knoten = new KNOTEN(datenelement, this);
            return knoten;
        }
        else {
            if (nachfolger == null) {
                HintenEinfuegen(datenelement);
            } else {
                nachfolger = nachfolger.sortiertEinfuegen(datenelement);
            }
            return this;
        }
    }

    public void HintenEinfuegen(DATENELEMENT datenelement) {
        KNOTEN knoten = new KNOTEN(datenelement);
        this.nachfolger = knoten;
    }

    public KNOTEN Suchen (DATENELEMENT datenelement) {
        if (datenelement == this) return this;
        else if (nachfolger != null) return nachfolger.Suchen(datenelement);
        else return null;
    }

    public KNOTEN VorgaengerSuchen(DATENELEMENT datenelement) {
        if (nachfolger != null) {
            if (datenelement == nachfolger.DatenelementGeben()) return this;
            else return nachfolger.VorgaengerSuchen(datenelement);
        }
        else return null;
    }
}