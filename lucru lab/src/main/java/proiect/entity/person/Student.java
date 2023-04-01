package main.java.proiect.entity.person;

public class Student extends Person {
    private int year;
    private String group;
    private String specialization;

    public Student(String cnp, String name, String surname, String address, String phoneNumber, int year, String group, String specialization) {
        super(cnp, name, surname, address, phoneNumber);
        this.year = year;
        this.group = group;
        this.specialization = specialization;
    }
    public Student(){
        super();
        this.year = 0;
        this.group = "";
        this.specialization = "";
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String toString() {
        return super.toString() + ", Year: " + year + ", Group: " + group + ", Specialization: " + specialization;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return super.equals(student) && year == student.year && group.equals(student.group) && specialization.equals(student.specialization);
        }
        return false;
    }
}
