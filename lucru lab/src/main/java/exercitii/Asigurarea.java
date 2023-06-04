package main.java.exercitii;

import java.util.Objects;

public class Asigurarea {
    private String tip;
    private String titular;
    private double valoare;
    private String localitate;

    // Constructor
    public Asigurarea(String tip, String titular, double valoare, String localitate) {
        this.tip = tip;
        this.titular = titular;
        this.valoare = valoare;
        this.localitate = localitate;
    }

    // Metode set/get
    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public double getValoare() {
        return valoare;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getLocalitate() {
        return localitate;
    }

    // Metodele toString, hashCode și equals
    @Override
    public String toString() {
        return "Asigurarea{" +
                "tip='" + tip + '\'' +
                ", titular='" + titular + '\'' +
                ", valoare=" + valoare +
                ", localitate='" + localitate + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip, titular, valoare, localitate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Asigurarea other = (Asigurarea) obj;

        return Objects.equals(tip, other.tip) &&
                Objects.equals(titular, other.titular) &&
                valoare == other.valoare &&
                Objects.equals(localitate, other.localitate);
    }
}
