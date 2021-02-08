package com.go.daten;

public class WOERTERBUCHEINTRAG implements DATENELEMENT{

    String wort;
    String uebersetztung;

    public WOERTERBUCHEINTRAG(String wort) {
        this.wort = wort;
        this.uebersetztung = "uebersetzung";
    }

    public void informationGeben() {
        System.out.println(wort);
    }

    public String getKey() {
        return wort;
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return wort.equals(vergleichswert);
    }
}
