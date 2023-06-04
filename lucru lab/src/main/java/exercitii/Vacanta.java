package main.java.exercitii;

import java.util.Objects;

public class Vacanta {
    private String destinatie;
    private int nrPersoane;
    private double valoare;
    private String perioada;

    // Constructor
    public Vacanta(String destinatie, int nrPersoane, double valoare, String perioada) {
        this.destinatie = destinatie;
        this.nrPersoane = nrPersoane;
        this.valoare = valoare;
        this.perioada = perioada;
    }

    // Getters and Setters
    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public String getPerioada() {
        return perioada;
    }

    public void setPerioada(String perioada) {
        this.perioada = perioada;
    }

    // toString, equals, and hashCode methods
    @Override
    public String toString() {
        return "Vacanta{" +
                "destinatie='" + destinatie + '\'' +
                ", nrPersoane=" + nrPersoane +
                ", valoare=" + valoare +
                ", perioada='" + perioada + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vacanta other = (Vacanta) obj;

        return nrPersoane == other.nrPersoane &&
                Double.compare(other.valoare, valoare) == 0 &&
                Objects.equals(destinatie, other.destinatie) &&
                Objects.equals(perioada, other.perioada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinatie, nrPersoane, valoare, perioada);
    }
}
