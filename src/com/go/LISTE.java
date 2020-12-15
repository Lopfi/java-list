package com.go;

public class    LISTE {
    private LISTENELEMENT anfang;

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
            LISTENELEMENT k2 = anfang;
            while (k2.nachfolgerGeben() != null) k2 = k2.nachfolgerGeben();
            k2.nachfolgerSetzen(k);
        }
    }

    public  void hintenEinguegen(DATENELEMENT datenelement, LISTENELEMENT knoten) {
        KNOTEN k = new KNOTEN(datenelement);
        if (anfang == null) anfang = k;
        else if (knoten.nachfolgerGeben() == null) knoten.nachfolgerSetzen(k);
        else this.hintenEinguegen(datenelement, knoten.nachfolgerGeben());
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT datenelement) {
        LISTENELEMENT k1 = anfang;
        LISTENELEMENT k2 = null;
        while (k1.datenGeben() != datenelement) {
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
            DATENELEMENT daten = anfang.datenGeben();
            anfang = anfang.nachfolgerGeben();
            return daten;
        }
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        LISTENELEMENT k1 = this.suchen(datenelement);
        LISTENELEMENT k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerSetzen(k1.nachfolgerGeben());
    }

    public DATENELEMENT endeEntfernen() {
        if (anfang == null) return null;
        else {
            DATENELEMENT ende = anfang.endeGeben();
            return anfang.endeEntfernen().datenGeben();
        }

    }

    public DATENELEMENT vorneEntnehmen() {
        DATENELEMENT datenelement = null;

        if (anfang != null) {
            datenelement = anfang.datenGeben();
            anfang = anfang.nachfolgerGeben();
        }
        return datenelement;
    }

    public void informationGeben() {
        LISTENELEMENT knoten;
        knoten = anfang;

        while (knoten != null) {
            knoten.datenGeben().InformationGeben();
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

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        if (anfang != null) return anfang.suchen(datenelement);
        else return null;
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
        if (anfang != null) {
            if (anfang.nachfolgerGeben() != null)
                return anfang.vorgaengerSuchen(datenelement);
            else return null;
        }
        else return null;
    }
}