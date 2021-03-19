package com.go.daten;

public class STATION implements DATENELEMENT{
    String name;

    public STATION(String name) {
        this.name = name;
    }

    public void informationGeben() {
        System.out.println(name);
    }

    public String getKey() {
        return name;
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return name.equals(vergleichswert);
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }
}
