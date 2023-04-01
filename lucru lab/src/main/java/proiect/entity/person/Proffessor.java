package main.java.proiect.entity.person;

public class Proffessor extends Person {
    private String department;
    private String title;

    public Proffessor(String cnp, String name, String surname, String address, String phoneNumber, String department, String title) {
        super(cnp, name, surname, address, phoneNumber);
        this.department = department;
        this.title = title;
    }

    public Proffessor(){
        super();
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return super.toString() + ", Department: " + department + ", Title: " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Proffessor) {
            Proffessor proffessor = (Proffessor) obj;
            return super.equals(proffessor) && department.equals(proffessor.department) && title.equals(proffessor.title);
        }
        return false;
    }
}
