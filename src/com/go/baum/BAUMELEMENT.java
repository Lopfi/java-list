package com.go.baum;

import com.go.daten.DATENELEMENT;

public abstract class BAUMELEMENT {

    public abstract void nachfolgerLSetzten(BAUMELEMENT nachfolgerNeu);

    public abstract void nachfolgerRSetzten(BAUMELEMENT nachfolgerNeu);

    public abstract void informationGeben();

    public abstract int resthoeheGeben();

    public abstract DATENELEMENT datenGeben();

    public abstract DATENELEMENT suchen(String vergleichwert);

    public abstract DATENELEMENT endeGeben();

    public abstract BAUMELEMENT einfuegen(DATENELEMENT datenelement);

    public abstract BAUMELEMENT endeEntfernen();

    public abstract BAUMELEMENT suchen (DATENELEMENT datenelement);

    public abstract BAUMELEMENT vorgaengerSuchen(DATENELEMENT datenelement);

    public abstract BAUMELEMENT nachfolgerLGeben();

    public abstract BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement);
}
