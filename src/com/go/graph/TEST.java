package com.go.graph;

public class TEST {
    public static void main(String[] args) {
        GRAPH g = new GRAPH(10);
        g.knotenEinfuegen("Ottobrunn");
        g.knotenEinfuegen("Neubiberg");
        g.kanteEinfuegen("Ottobrunn", "Neubiberg", 10);
    }
}
