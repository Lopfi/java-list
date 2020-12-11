package com.go;

public class LISTE {
    private KNOTEN anfang;

    public LISTE() {
        anfang = null;
    }

    public void vorneEinfuegen(DATENELEMENT datenelement) {
        KNOTEN k = new KNOTEN(datenelement, anfang);
        anfang = k;
    }

    public void hintenEinfuegen(DATENELEMENT datenelement) {
        KNOTEN k = new KNOTEN(datenelement);
        if (anfang == null) anfang = k;
        else {
            KNOTEN k2 = anfang;
            while (k2.NachfolgerGeben() != null) k2 = k2.NachfolgerGeben();
            k2.NachfolgerSetzen(k);
        }
    }

    public  void hintenEinguegenRec(DATENELEMENT datenelement, KNOTEN knoten) {
        KNOTEN k = new KNOTEN(datenelement);
        if (anfang == null) anfang = k;
        else if (knoten.NachfolgerGeben() == null) knoten.NachfolgerSetzen(k);
        else this.hintenEinguegenRec(datenelement, knoten.NachfolgerGeben());
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT datenelement) {
        KNOTEN k1 = anfang;
        KNOTEN k2 = null;
        while (k1.DatenelementGeben() != datenelement) {
            k2 = k1;
            k1 = k2.NachfolgerGeben();
        }
        if (k2 != null) {
            KNOTEN k = new KNOTEN(dNeu, k1);
            k2.NachfolgerSetzen(k);
        } else {
            k2 = anfang;
            anfang = new KNOTEN(dNeu, k2);
        }
    }

    public void sortiertEinfuegen(DATENELEMENT datenelement) {
        if (anfang ==null) vorneEinfuegen(datenelement);
        else anfang = anfang.sortiertEinfuegen(datenelement);
    }

    public DATENELEMENT anfangEntfernen() {
        if (anfang == null) return null;
        else {
            DATENELEMENT daten = anfang.DatenelementGeben();
            anfang = anfang.NachfolgerGeben();
            return daten;
        }
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        KNOTEN k1 = this.Suchen(datenelement);
        KNOTEN k2 = this.VorgaengerSuchen(datenelement);
        k2.NachfolgerSetzen(k1.NachfolgerGeben());
    }

    public DATENELEMENT vorneEntnehmen() {
        DATENELEMENT datenelement = null;

        if (anfang != null) {
            datenelement = anfang.DatenelementGeben();
            anfang = anfang.NachfolgerGeben();
        }
        return datenelement;
    }

    public void InformationGeben() {
        KNOTEN knoten;
        knoten = anfang;

        while (knoten != null) {
            knoten.DatenelementGeben().InformationGeben();
            knoten = knoten.NachfolgerGeben();
        }
    }

    public int LaengeGeben() {
        if (anfang == null) return 0;
        else return anfang.RestlaengeGeben() + 1;
    }

    public DATENELEMENT Suchen(String vergleichwert) {
        if (anfang != null) return anfang.Suchen(vergleichwert);
        else return null;
    }

    public KNOTEN Suchen(DATENELEMENT datenelement) {
        if (anfang != null) return anfang.Suchen(datenelement);
        else return null;
    }

    public KNOTEN VorgaengerSuchen(DATENELEMENT datenelement) {
        if (anfang != null) {
            if (anfang.NachfolgerGeben() != null)
                return anfang.VorgaengerSuchen(datenelement);
            else return null;
        }
        else return null;
    }
}