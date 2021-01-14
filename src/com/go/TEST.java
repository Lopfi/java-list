package com.go;

public class TEST {

    private LISTE liste;
    private int anzahl;

    public TEST() {
        this.liste = new LISTE();
        this.anzahl = 10;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void hintenEinfuegenWhile(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            PATIENT p = new PATIENT(Integer.toString(i));
            liste.hintenEinfuegenWhile(p);
        }
    }

    public void hintenEinfuegen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            PATIENT p = new PATIENT(Integer.toString(i));
            liste.hintenEinfuegen(p);
        }
    }

    public void vorneEinfuegen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            PATIENT p = new PATIENT(Integer.toString(i));
            liste.vorneEinfuegen(p);
        }
    }

    public void sortiertEinfuegen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            PATIENT p = new PATIENT(Integer.toString(i));
            liste.sortiertEinfuegen(p);
        }
    }

    public void testAll() {
        this.liste = new LISTE();
        PATIENT p0 = new PATIENT("p0");
        PATIENT p1 = new PATIENT("p1");

        System.out.println("Leere Liste:");
        liste.informationGeben();

        System.out.println("HintenEinfuegen * " + this.anzahl + ":");
        this.hintenEinfuegen(this.anzahl);
        liste.informationGeben();

        System.out.println("Laenge geben:");
        System.out.println(liste.laengeGeben());

        System.out.println("VorneEinfuegen * " + this.anzahl + ":");
        this.vorneEinfuegen(this.anzahl);
        liste.informationGeben();

        System.out.println("p0 VorneEinfuegen:");
        liste.vorneEinfuegen(p0);
        liste.informationGeben();

        System.out.println("SortiertEinfuegen * " + this.anzahl + ":");
        this.sortiertEinfuegen(this.anzahl);
        liste.informationGeben();

        System.out.println("AnfangEntfernen:");
        liste.anfangEntfernen();
        liste.informationGeben();

        System.out.println("EndeEntfernen:");
        liste.endeEntfernen();
        liste.informationGeben();

        System.out.println("p1 vor p0 einfuegen:");
        liste.einfuegenVor(p1, p0);
        liste.informationGeben();

        System.out.println("p0 entfernen:");
        liste.knotenEntfernen(p0);
        liste.informationGeben();

        System.out.println("p1 suchen");
        System.out.println(liste.suchen("p1").getKey());

    }
}
