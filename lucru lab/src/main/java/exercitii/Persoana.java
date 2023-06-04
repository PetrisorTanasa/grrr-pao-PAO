package main.java.exercitii;

import java.io.Serializable;

public class Persoana implements Serializable {
    String nume;
    int varsta;

    public Persoana(String nume, int varsta){
        this.nume = nume;
        this.varsta = varsta;
        System.out.println("Constructor");
    }
}
