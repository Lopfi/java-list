package com.go.baum;

import com.go.daten.DATENELEMENT;

public abstract class BAUMELEMENT {

    public abstract void nachfolgerLSetzten(BAUMELEMENT nachfolgerNeu);

    public abstract void nachfolgerRSetzten(BAUMELEMENT nachfolgerNeu);

    public abstract void informationGeben();

    public abstract int resthoeheGeben();

    public abstract void inorderAusgeben();

    public abstract void preorderAusgeben(int tiefe);

    public abstract void postorderAusgeben(int tiefe);

    public abstract DATENELEMENT datenGeben();

    public abstract DATENELEMENT suchen(String vergleichwert);

    public abstract BAUMELEMENT einfuegen(DATENELEMENT datenelement);

    public abstract BAUMELEMENT suchen (DATENELEMENT datenelement);

    public abstract BAUMELEMENT nachfolgerLGeben();

    public abstract BAUMELEMENT nachfolgerRGeben();

    public abstract BAUMELEMENT knotenEntfernen(DATENELEMENT datenelement);
}
