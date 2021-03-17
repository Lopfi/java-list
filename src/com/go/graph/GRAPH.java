package com.go.graph;

import com.go.daten.STATION;

public class GRAPH {
    private int [][] matrix;
    private KNOTEN[] knotenliste;
    private int anzahlKnoten;
    private int maxAnzahl;

    public GRAPH(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
        anzahlKnoten = 0;
        knotenliste = new KNOTEN[this.maxAnzahl];
        matrix = new int[this.maxAnzahl][this.maxAnzahl];

        for (int i = 0; i < maxAnzahl; i++) {
            for (int j = 0; j < maxAnzahl; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public void knotenEinfuegen(String bez) {
        STATION daten = new STATION(bez);
        KNOTEN knoten = new KNOTEN(daten, anzahlKnoten);

        if (this.nameZuKnoten(bez) == null && anzahlKnoten != maxAnzahl) {
            knotenliste[anzahlKnoten] = knoten;
            anzahlKnoten ++;
            matrix[anzahlKnoten][anzahlKnoten] = 0;
        }

    }

    public void kanteEinfuegen(String von, String nach, int gewichtung) {
        KNOTEN vonK = nameZuKnoten(von);
        KNOTEN nachK = nameZuKnoten(nach);
        if (vonK != null && nachK != null) {
            matrix[vonK.getNummer()][nachK.getNummer()] = gewichtung;
        }
    }

    private KNOTEN nameZuKnoten(String name) {
        for (KNOTEN k:
                knotenliste) {
            if (k.getInhalt().schluesselIstGleich(name)) return k;
        }
        return null;
    }
}
