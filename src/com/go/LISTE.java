package com.go;

public class    LISTE {
    private KNOTEN anfang;

    public LISTE() {
        anfang = null;
    }

    public void vorneEinfuegen(DATENELEMENT datenelement) {
        KNOTEN k = new KNOTEN(datenelement, anfang);
        anfang = k;
    }

    public void hintenEinfuegenWhile(DATENELEMENT datenelement) {
        KNOTEN k = new KNOTEN(datenelement);
        if (anfang == null) anfang = k;
        else {
            KNOTEN k2 = anfang;
            while (k2.nachfolgerGeben() != null) k2 = k2.nachfolgerGeben();
            k2.nachfolgerSetzen(k);
        }
    }

    public  void hintenEinguegen(DATENELEMENT datenelement, KNOTEN knoten) {
        KNOTEN k = new KNOTEN(datenelement);
        if (anfang == null) anfang = k;
        else if (knoten.nachfolgerGeben() == null) knoten.nachfolgerSetzen(k);
        else this.hintenEinguegen(datenelement, knoten.nachfolgerGeben());
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT datenelement) {
        KNOTEN k1 = anfang;
        KNOTEN k2 = null;
        while (k1.datenelementGeben() != datenelement) {
            k2 = k1;
            k1 = k2.nachfolgerGeben();
        }
        if (k2 != null) {
            KNOTEN k = new KNOTEN(dNeu, k1);
            k2.nachfolgerSetzen(k);
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
            DATENELEMENT daten = anfang.datenelementGeben();
            anfang = anfang.nachfolgerGeben();
            return daten;
        }
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        KNOTEN k1 = this.suchen(datenelement);
        KNOTEN k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerSetzen(k1.nachfolgerGeben());
    }

    public DATENELEMENT endeEntfernen() {
        if (anfang == null) return null;
        else {
            DATENELEMENT ende = anfang.endeGeben();
            return anfang.endeEntfernen().datenelementGeben();
        }

    }

    public DATENELEMENT vorneEntnehmen() {
        DATENELEMENT datenelement = null;

        if (anfang != null) {
            datenelement = anfang.datenelementGeben();
            anfang = anfang.nachfolgerGeben();
        }
        return datenelement;
    }

    public void informationGeben() {
        KNOTEN knoten;
        knoten = anfang;

        while (knoten != null) {
            knoten.datenelementGeben().InformationGeben();
            knoten = knoten.nachfolgerGeben();
        }
    }

    public int laengeGeben() {
        if (anfang == null) return 0;
        else return anfang.restlaengeGeben() + 1;
    }

    public DATENELEMENT suchen(String vergleichwert) {
        if (anfang != null) return anfang.suchen(vergleichwert);
        else return null;
    }

    public KNOTEN suchen(DATENELEMENT datenelement) {
        if (anfang != null) return anfang.suchen(datenelement);
        else return null;
    }

    public KNOTEN vorgaengerSuchen(DATENELEMENT datenelement) {
        if (anfang != null) {
            if (anfang.nachfolgerGeben() != null)
                return anfang.vorgaengerSuchen(datenelement);
            else return null;
        }
        else return null;
    }
}