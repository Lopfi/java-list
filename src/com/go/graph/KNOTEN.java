package com.go.graph;

import com.go.daten.DATENELEMENT;

public class KNOTEN {
    private DATENELEMENT inhalt;
    private int nummer;

    public KNOTEN(DATENELEMENT inhalt, int nummer) {
        this.inhalt = inhalt;
        this.nummer = nummer;
    }

    public DATENELEMENT getInhalt() {
        return inhalt;
    }

    public int getNummer() {
        return nummer;
    }
}
