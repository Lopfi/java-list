package com.go.baum;

import com.go.daten.WOERTERBUCHEINTRAG;
import com.go.daten.DATENGENERATOR;

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
        baumdrucker.printVertikal(this.baum);
        System.out.println(baum.hoeheGeben());
        System.out.println("inorder Ausgabe:");
        baum.inorderAusgeben();
        System.out.println("preorder Ausgabe:");
        baum.preorderAusgeben();
        System.out.println("postorder Ausgabe:");
        baum.postorderAusgeben();
        System.out.println("\n\n\n\n\n");
        baumdrucker.printHorizontal(this.baum);
    }
}
