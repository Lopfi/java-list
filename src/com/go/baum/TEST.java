package com.go.baum;

import com.go.daten.WOERTERBUCHEINTRAG;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.testEinfuegen();
    }

    private BINBAUM baum;
    private int anzahl;
    private BAUMDRUCKER baumdrucker;
    private String[] woerter;

    public TEST() {
        this.baum = new BINBAUM();
        this.anzahl = 10;
        this.baumdrucker = new BAUMDRUCKER(this.baum);
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void einfuegen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            WOERTERBUCHEINTRAG w = new WOERTERBUCHEINTRAG(Integer.toString(i));
            baum.einfuegen(w);
        }
    }

    public void testEinfuegen() {
        System.out.println("Testing hintenEinfuegen * " + this.anzahl + ": ");
        this.baum = new BINBAUM();
        baumdrucker.print(this.baum);
        this.einfuegen(anzahl);
        baumdrucker.print(this.baum);
    }

    public void testAll() {
        this.baum = new BINBAUM();
        WOERTERBUCHEINTRAG p0 = new WOERTERBUCHEINTRAG("p0");
        WOERTERBUCHEINTRAG p1 = new WOERTERBUCHEINTRAG("p1");

        System.out.println("Leere baum:");
        baum.informationGeben();

        System.out.println("HintenEinfuegen * " + this.anzahl + ":");
        this.einfuegen(this.anzahl);
        baum.informationGeben();

        System.out.println("Laenge geben:");
        System.out.println(baum.laengeGeben());

        System.out.println("EndeEntfernen:");
        baum.endeEntfernen();
        baum.informationGeben();

        System.out.println("p0 entfernen:");
        baum.knotenEntfernen(p0);
        baum.informationGeben();

        System.out.println("p1 suchen");
        System.out.println(baum.suchen("p1").getKey());

    }
}
