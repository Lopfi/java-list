package com.go.baum;

import com.go.daten.WOERTERBUCHEINTRAG;
import com.go.daten.DATENGENERATOR;
import java.util.*;
import java.io.File;

public class TEST {
    public static void main(String[] args) throws Exception {
        TEST test = new TEST(DATENGENERATOR.dictionaryRead("./woerter.txt"));
        test.testEinfuegen();
    }

    private BINBAUM baum;
    private BAUMDRUCKER baumdrucker;
    private String[] woerter;

    public TEST(String[] woerter) {
        this.baum = new BINBAUM();
        this.baumdrucker = new BAUMDRUCKER(this.baum);
        this.woerter = woerter;
    }

    public void einfuegen() {
        for (int i = 0; i < woerter.length; i++) {
            WOERTERBUCHEINTRAG w = new WOERTERBUCHEINTRAG(woerter[i]);
            baum.einfuegen(w);
        }
    }

    public void testEinfuegen() {
        System.out.println("Testing Einfuegen: ");
        this.baum = new BINBAUM();
        this.einfuegen();
        baumdrucker.print(this.baum);
    }

    public void testAll() {
        this.baum = new BINBAUM();
        WOERTERBUCHEINTRAG p0 = new WOERTERBUCHEINTRAG("p0");
        WOERTERBUCHEINTRAG p1 = new WOERTERBUCHEINTRAG("p1");

        System.out.println("Leere baum:");
        baum.informationGeben();

        System.out.println("Einfuegen:");
        this.einfuegen();
        baum.informationGeben();

        System.out.println("Hoehe geben:");
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
