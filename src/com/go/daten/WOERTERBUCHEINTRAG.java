package com.go.daten;

public class WOERTERBUCHEINTRAG implements DATENELEMENT{
    String wort;

    public WOERTERBUCHEINTRAG(String wort) {
        this.wort = wort;
    }

    public void informationGeben() {
        System.out.print(wort);
    }

    public String getKey() {
        return wort;
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return wort == vergleichswert;
    }
}
