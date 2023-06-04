package main.java.exercitii;

import java.util.Objects;

public class Student {
    private double serie;
    private String absolvent;
    private double an;
    private String facultate;
    private String specializare;
    private double medie;

    // Constructor
    public Student(double serie, String absolvent, double an, String facultate, String specializare, double medie) {
        this.serie = serie;
        this.absolvent = absolvent;
        this.an = an;
        this.facultate = facultate;
        this.specializare = specializare;
        this.medie = medie;
    }

    // Getters and Setters
    public double getSerie() {
        return serie;
    }

    public void setSerie(double serie) {
        this.serie = serie;
    }

    public String getAbsolvent() {
        return absolvent;
    }

    public void setAbsolvent(String absolvent) {
        this.absolvent = absolvent;
    }

    public double getAn() {
        return an;
    }

    public void setAn(double an) {
        this.an = an;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    // toString, equals, and hashCode methods
    @Override
    public String toString() {
        return "Student{" +
                "serie=" + serie +
                ", absolvent='" + absolvent + '\'' +
                ", an=" + an +
                ", facultate='" + facultate + '\'' +
                ", specializare='" + specializare + '\'' +
                ", medie=" + medie +
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

        Student other = (Student) obj;

        return Double.compare(other.serie, serie) == 0 &&
                Double.compare(other.an, an) == 0 &&
                Double.compare(other.medie, medie) == 0 &&
                Objects.equals(absolvent, other.absolvent) &&
                Objects.equals(facultate, other.facultate) &&
                Objects.equals(specializare, other.specializare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, absolvent, an, facultate, specializare, medie);
    }
}
