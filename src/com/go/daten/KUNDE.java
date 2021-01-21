package com.go.daten;

class KUNDE implements DATENELEMENT {
    String name;
    int kundennummer;

    KUNDE(String nameNeu, int kundennummerNeu) {
        name = nameNeu;
        kundennummer = kundennummerNeu;
    }

    public String getKey() {
        return name;
    }

    public void informationGeben() {
        System.out.println(name + " Knr.:" + kundennummer);
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return name.equals(vergleichswert);
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }

}
