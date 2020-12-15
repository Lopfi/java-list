package com.go;

public abstract class LISTENELEMENT {

    public abstract void nachfolgerSetzen(LISTENELEMENT nachfolgerNeu);

    public abstract void hintenEinfuegen(DATENELEMENT datenelement);

    public abstract void informationGeben();

    public abstract int restlaengeGeben();

    public abstract DATENELEMENT datenelementGeben();

    public abstract DATENELEMENT suchen(String vergleichwert);

    public abstract DATENELEMENT endeGeben();

    public abstract LISTENELEMENT endeEntfernen();

    public abstract LISTENELEMENT sortiertEinfuegen(DATENELEMENT datenelement);

    public abstract LISTENELEMENT suchen (DATENELEMENT datenelement);

    public abstract LISTENELEMENT vorgaengerSuchen(DATENELEMENT datenelement);

    public abstract LISTENELEMENT nachfolgerGeben();
}