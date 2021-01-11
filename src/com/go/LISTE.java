package com.go;

public class    LISTE {
    private LISTENELEMENT anfang;

    public LISTE() {
        anfang = new ABSCHLUSS();
    }

    public void vorneEinfuegen(DATENELEMENT datenelement) {
        anfang = new KNOTEN(datenelement, anfang);
    }

    public void hintenEinfuegenWhile(DATENELEMENT datenelement) {
        LISTENELEMENT k2 = anfang;
        while (k2.nachfolgerGeben() != null) k2 = k2.nachfolgerGeben();
        k2.nachfolgerSetzen(new KNOTEN(datenelement));
    }

    public  void hintenEinfuegen(DATENELEMENT datenelement) {
        anfang = anfang.hintenEinfuegen(datenelement);
    }

    public void einfuegenVor(DATENELEMENT dNeu, DATENELEMENT dvergleich) {
        anfang = anfang.einfuegenVor(dNeu, dvergleich);
    }

    public void sortiertEinfuegen(DATENELEMENT datenelement) {
        anfang = anfang.sortiertEinfuegen(datenelement);
    }

    public DATENELEMENT anfangEntfernen() {
        DATENELEMENT daten = anfang.datenGeben();
        anfang = anfang.nachfolgerGeben();
        return daten;
    }

    public void knotenEntfernen(DATENELEMENT datenelement) {
        LISTENELEMENT k1 = this.suchen(datenelement);
        LISTENELEMENT k2 = this.vorgaengerSuchen(datenelement);
        k2.nachfolgerSetzen(k1.nachfolgerGeben());
    }

    public DATENELEMENT endeEntfernen() {
        DATENELEMENT ende = anfang.endeGeben();
        return anfang.endeEntfernen().datenGeben();
    }

    public void informationGeben() {
        LISTENELEMENT knoten;
        knoten = anfang;
        while (!(knoten instanceof ABSCHLUSS)) {
            knoten.informationGeben();
            System.out.print("; ");
            knoten = knoten.nachfolgerGeben();
        }
        System.out.println();
    }

    public int laengeGeben() {
        return anfang.restlaengeGeben() + 1;
    }

    public DATENELEMENT suchen(String vergleichwert) {
        return anfang.suchen(vergleichwert);
    }

    public LISTENELEMENT suchen(DATENELEMENT datenelement) {
        return anfang.suchen(datenelement);
    }

    public LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement) {
            if (anfang.nachfolgerGeben() != null)
                return anfang.vorgaengerSuchen(datenelement);
            else return null;
    }
}