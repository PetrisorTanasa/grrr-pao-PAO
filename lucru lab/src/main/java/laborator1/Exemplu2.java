package main.java.laborator1;

public class Exemplu2 {
    public static void main(String[] args) {
        Exemplu1.main(null);
        Exemplu1 exemplu1 = new Exemplu1();
        exemplu1.setNumarLaborator(1);
        System.out.println(exemplu1.getNumarLaborator());

        Exemplu1 exemplu2 = new Exemplu1();
        exemplu2.setNumarLaborator(2);
    }
}