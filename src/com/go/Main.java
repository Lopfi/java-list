package com.go;

public class Main {

    public static void main(String[] args) {
        int count = 10;
        LISTE liste = new LISTE();
        for (int i = 0; i < count; i++) {
            PATIENT p = new PATIENT(Integer.toString(i));
            liste.vorneEinfuegen(p);
        }
        System.out.println(liste.Suchen("5"));
    }
}
