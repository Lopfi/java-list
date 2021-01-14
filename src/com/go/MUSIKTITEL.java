package com.go;

class MUSIKTITEL implements DATENELEMENT {
    String titel;
    String interpret;
    int dauerInSec;

    MUSIKTITEL(String titel, String interpret, int dauerInSec) {
        this.titel = titel;
        this.interpret = interpret;
        this.dauerInSec = dauerInSec;
    }

    public String getKey() {
        return titel;
    }

    public void informationGeben() {
        System.out.println(titel + ", " + interpret + ", " + dauerInSec / 60 + ":" + dauerInSec % 60);
    }

    public boolean schluesselIstGleich(String vergleichswert) {
        return titel.equals(vergleichswert);
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }
}


