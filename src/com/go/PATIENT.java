package com.go;

class PATIENT implements DATENELEMENT {
    String name;

    PATIENT(String nameNeu) {
        name = nameNeu;
    }

    public void InformationGeben() {
        System.out.print(name);
    }

    public String getKey() {
        return name;
    }

    public boolean istKleinerAls(DATENELEMENT datenelement) {
        return datenelement.getKey().compareTo(this.getKey()) < 0;
    }

    public boolean SchluesselIstGleich(String vergleichswert) {
        return name.equals(vergleichswert);
    }
}


