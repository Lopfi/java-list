package com.go;

public interface DATENELEMENT {
    void informationGeben();

    String getKey();

    boolean schluesselIstGleich(String vergleichswert);

    boolean istKleinerAls(DATENELEMENT datenelement);
}




