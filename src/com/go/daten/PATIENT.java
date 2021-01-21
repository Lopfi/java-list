package com.go.daten;

public class PATIENT implements DATENELEMENT {
    String name;

    public PATIENT(String nameNeu) {
        name = nameNeu;
    }

    public void informationGeben() {
        System.out.print(name);
    }

    public String getKey() {
        return name;
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return name == vergleichswert;
    }
}


