package com.go;

public interface DATENELEMENT {
    void InformationGeben();

    String getKey();

    boolean SchluesselIstGleich(String vergleichswert);

    boolean istKleinerAls(DATENELEMENT datenelement);
}




