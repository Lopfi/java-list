package com.go;

interface DATENELEMENT {
    void InformationGeben();

    String getKey();

    boolean SchluesselIstGleich(String vergleichswert);

    boolean istKleinerAls(DATENELEMENT datenelement);
}




