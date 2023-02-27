package main.java.laborator1;

public class Exemplu1 {
/*
In Java avem 4 specificatori de acces:
    - public            = cel mai permisiv
    - private           = cel mai restrictiv
    - default-package   = accesibil doar din pachetul respectiv
    (marcat prin absenta a altceva)
    - protected         = vizibil in acelasi pachet si in alt pachet
                          prin mostenire

Membrii unei clase: campuri si metode
    ex. camp    -  private int numarLaborator;
    ex. metoda  -  private int getNumarLaborator(){...}
            Structura:
                * specificator de acces
                * tip returnat
                * optional si static

Numarul de primitive: 8
- byte
- short
- int
- long
- boolean
- char
- float, double
 */
    public int numarLaborator;
    public void setNumarLaborator(int numarLaborator){
        this.numarLaborator = numarLaborator;
    }
    public int getNumarLaborator(){
        return numarLaborator;
    }
    public static void main(String[] args) {
        System.out.println("Sa traiesti sa mil belesti");
        byte a;
        short b;
        int c;
        long d;
        char e;
        boolean f;
        float g;
        double h;
    }
}